
package net.mcreator.youtubersnaturaldisasters.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.procedures.MagmaOnTickUpdateProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.MagmaEntityWalksOnTheBlockProcedure;
import net.mcreator.youtubersnaturaldisasters.block.entity.MagmaBlockEntity;

public class MagmaBlock extends Block implements EntityBlock {
	public MagmaBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(0.5f).lightLevel(s -> 3).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(Blocks.MAGMA_BLOCK);
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.DANGER_FIRE;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		MagmaOnTickUpdateProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		MagmaEntityWalksOnTheBlockProcedure.execute(world, entity);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new MagmaBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof MagmaBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof MagmaBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
