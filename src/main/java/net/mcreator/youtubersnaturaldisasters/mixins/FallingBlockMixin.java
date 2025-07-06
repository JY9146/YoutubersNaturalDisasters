package net.mcreator.youtubersnaturaldisasters.mixins;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.core.BlockPos;

@Mixin(FallingBlockEntity.class)
public abstract class FallingBlockMixin {

    @Shadow
    private BlockState blockState;
    @Shadow
    private boolean cancelDrop;
    @Shadow
    public boolean dropItem;
    @Shadow
    private int time;

    @Shadow
    public abstract void callOnBrokenAfterFall(Block block, BlockPos blockPos);

    /**
     * This method injects at the point where falling blocks decide what to do when they hit the ground.
     * It modifies the default behavior to break blocks that would normally break the falling block,
     * and then places the falling block in their place.
     */
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/FallingBlockEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V", ordinal = 1), cancellable = true)
    private void breakBlocksOnCollision(CallbackInfo ci) {
        FallingBlockEntity self = (FallingBlockEntity) (Object) this;
        Level level = self.level();

        // Only run this on the server side
        if (!level.isClientSide) {
            BlockPos blockpos = self.blockPosition();
            Block block = this.blockState.getBlock();

            // Check if we're on the ground
            if (self.onGround()) {
                BlockState existingBlockState = level.getBlockState(blockpos);
                boolean canReplace = existingBlockState
                        .canBeReplaced(new net.minecraft.world.item.context.DirectionalPlaceContext(level, blockpos, net.minecraft.core.Direction.DOWN, net.minecraft.world.item.ItemStack.EMPTY, net.minecraft.core.Direction.UP));
                boolean isFree = FallingBlock.isFree(level.getBlockState(blockpos.below()));
                boolean canSurvive = this.blockState.canSurvive(level, blockpos);

                // If we can't replace the block (like a torch) but the falling block could survive here,
                // break the existing block and drop it as an item
                if (!canReplace && canSurvive && !existingBlockState.isAir()) {
                    // Drop the existing block as an item
                    Block existingBlock = existingBlockState.getBlock();
                    if (level.getGameRules().getBoolean(net.minecraft.world.level.GameRules.RULE_DOENTITYDROPS)) {
                        level.destroyBlock(blockpos, true);
                    } else {
                        level.setBlock(blockpos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3);
                    }

                    // Now place our falling block
                    if (this.blockState.hasProperty(BlockStateProperties.WATERLOGGED) && level.getFluidState(blockpos).getType() == Fluids.WATER) {
                        this.blockState = this.blockState.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true));
                    }

                    if (level.setBlock(blockpos, this.blockState, 3)) {
                        if (level instanceof ServerLevel) {
                            ((ServerLevel) level).getChunkSource().chunkMap.broadcast(self, new ClientboundBlockUpdatePacket(blockpos, level.getBlockState(blockpos)));
                        }

                        self.remove(FallingBlockEntity.RemovalReason.DISCARDED);

                        // Call onLand callback if the block implements Fallable
                        if (block instanceof Fallable) {
                            ((Fallable) block).onLand(level, blockpos, this.blockState, existingBlockState, self);
                        }

                        // Cancel the original method to prevent default behavior
                        ci.cancel();
                        return;
                    }
                }

                // If we get here, let the vanilla behavior handle it
            }
        }
    }
}