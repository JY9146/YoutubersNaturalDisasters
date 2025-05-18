package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VolcanoGeneratorOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double Block_DstroyChance = 0;
		double Every__PerUptdate = 0;
		double Fall_Chance = 0;
		entity.setInvulnerable(true);
		if (entity.getPersistentData().getDouble("BlockCount") <= 50) {
			Every__PerUptdate = 8;
			if (entity.getPersistentData().getDouble("digtick") == 0) {
				entity.getPersistentData().putDouble("digtick", Every__PerUptdate);
			} else {
				entity.getPersistentData().putDouble("digtick", (entity.getPersistentData().getDouble("digtick") - 1));
			}
			if (entity.getPersistentData().getDouble("digtick") == 1) {
				if (!(entity.getPersistentData().getDouble("WAIT") == 4)) {
					entity.getPersistentData().putDouble("WAIT", (entity.getPersistentData().getDouble("WAIT") + 1));
					int horizontalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("SizeWidthV")) - 1;
					int verticalRadiusHemiTop = (int) 1;
					int yIterationsHemiTop = verticalRadiusHemiTop;
					for (int yi = 0; yi < yIterationsHemiTop; yi++) {
						if (yi == verticalRadiusHemiTop) {
							continue;
						}
						for (int xi = -horizontalRadiusHemiTop; xi <= horizontalRadiusHemiTop; xi++) {
							for (int zi = -horizontalRadiusHemiTop; zi <= horizontalRadiusHemiTop; zi++) {
								double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop) + (yi * yi) / (double) (verticalRadiusHemiTop * verticalRadiusHemiTop)
										+ (zi * zi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop);
								if (distanceSq <= 1.0) {
									if (!(Blocks.BEDROCK == (world.getBlockState(BlockPos.containing(x + xi, y + yi - 1, z + zi))).getBlock())) {
										Block_ = (world.getBlockState(BlockPos.containing(x + xi, y + yi - 1, z + zi)));
									}
									world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Block_, 3);
								}
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("WAIT", 0);
					entity.getPersistentData().putDouble("BlockCount", (entity.getPersistentData().getDouble("BlockCount") + 1));
					entity.getPersistentData().putDouble("SizeWidthV", (entity.getPersistentData().getDouble("SizeWidthV") * 0.95));
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (Math.round(entity.getY()) + 1), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (Math.round(entity.getY()) + 1), z, _ent.getYRot(), _ent.getXRot());
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item,distance=.." + entity.getPersistentData().getDouble("SizeWidthV") + "]"));
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
