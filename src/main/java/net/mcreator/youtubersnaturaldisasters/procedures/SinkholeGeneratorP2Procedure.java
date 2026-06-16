package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.youtubersnaturaldisasters.entity.SinkholeEntityEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SinkholeGeneratorP2Procedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double Block_DstroyChance = 0;
		double Fall_Chance = 0;
		if (entity.tickCount % 60 == 0 && entity instanceof SinkholeEntityEntity && entity.getPersistentData().getBoolean("Waiter")) {
			int horizontalRadiusSphere = (int) (entity.getPersistentData().getDouble("SizeWidth")) - 1;
			int verticalRadiusSphere = (int) 5 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (entity.getPersistentData().getDouble("BlockCount") > 10) {
								if (y + yi < entity.getY()) {
									world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.LAVA.defaultBlockState(), 3);
								}
							} else {
								if (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)).canOcclude() == true) {
									for (int index0 = 0; index0 < 3; index0++) {
										Block_DstroyChance = Mth.nextInt(RandomSource.create(), 1, 2);
										if (Block_DstroyChance == 1) {
											if (Fall_Chance == 1) {
												Block_ = (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)));
											}
											Fall_Chance = Mth.nextInt(RandomSource.create(), 1, 17);
											if (!world.isClientSide()) {
												world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
											}
											if (Fall_Chance == 1) {
												if (world instanceof ServerLevel _level)
													FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + yi, z + zi), Block_);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			entity.getPersistentData().putBoolean("Waiter", false);
			entity.getPersistentData().putDouble("BlockCount", (entity.getPersistentData().getDouble("BlockCount") + 1));
			entity.getPersistentData().putDouble("SizeWidth", (entity.getPersistentData().getDouble("SizeWidth") * 0.9));
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (Math.round(entity.getY()) - 3), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (Math.round(entity.getY()) - 3), z, _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("kill @e[type=item,distance=.." + entity.getPersistentData().getDouble("SizeWidth") + "]"));
		}
	}
}
