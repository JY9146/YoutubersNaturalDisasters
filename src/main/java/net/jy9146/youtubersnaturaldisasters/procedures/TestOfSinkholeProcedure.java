package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class TestOfSinkholeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double yy = 0;
		double Block_DstroyChance = 0;
		double Every__PerUptdate = 0;
		double Fall_Chance = 0;
		double Random_Number = 0;
		Entity Entity_Variable = null;
		if (entity.tickCount % 38 == 0) {
			if (entity.getPersistentData().getBoolean("Bedrockstopper") == false) {
				if (entity.onGround()) {
					int horizontalRadiusSphere = (int) 36 - 1;
					int verticalRadiusSphere = (int) 10 - 1;
					int yIterationsSphere = verticalRadiusSphere;
					for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
						for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
							for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
								double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
										+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
								if (distanceSq <= 1.0) {
									world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
									if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == Blocks.BEDROCK) {
										entity.getPersistentData().putBoolean("Bedrockstopper", true);
									}
									if (entity.getY() <= entity.getPersistentData().getDouble("YtillDespawn") - 110) {
										if (!entity.level().isClientSide())
											entity.discard();
										world.setBlock(BlockPos.containing(x, y - 10, z), Blocks.DEEPSLATE.defaultBlockState(), 3);
									}
								}
							}
						}
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("kill @e[type=item,distance=.." + 36 + "]"));
				}
			} else if (entity.getPersistentData().getBoolean("Bedrockstopper") == true) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
