package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class VolcanoGroundMesserOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double Block_DstroyChance = 0;
		double Fall_Chance = 0;
		entity.setInvulnerable(true);
		for (int index0 = 0; index0 < 2; index0++) {
			int horizontalRadiusSphere = (int) (120 * 0.9) - 1;
			int verticalRadiusSphere = (int) 3 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)).canOcclude() == true) {
								Block_DstroyChance = Mth.nextInt(RandomSource.create(), 1, 2);
								if (Block_DstroyChance == 1) {
									Fall_Chance = Mth.nextInt(RandomSource.create(), 1, 6);
									if (Fall_Chance == 1) {
										Block_ = (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)));
									}
									if (Fall_Chance == 2) {
										Block_ = Blocks.LAVA.defaultBlockState();
									}
									world.setBlock(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1), Block_, 3);
								}
							}
						}
					}
				}
			}
		}
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
