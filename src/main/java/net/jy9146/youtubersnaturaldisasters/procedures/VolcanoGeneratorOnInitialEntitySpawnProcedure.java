package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class VolcanoGeneratorOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double Every__PerUptdate = 0;
		double Block_DstroyChance = 0;
		double Fall_Chance = 0;
		entity.getPersistentData().putDouble("SizeWidthV", 42.1052631579);
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
							if (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)).canOcclude() == true) {
								Block_DstroyChance = Mth.nextInt(RandomSource.create(), 1, 2);
								if (Block_DstroyChance == 1) {
									Fall_Chance = Mth.nextInt(RandomSource.create(), 1, 6);
									if (Fall_Chance == 1) {
										YoutubersNaturalDisastersModVariables.MapVariables.get(world).VolcanoBlock = (world.getBlockState(BlockPos.containing(x + xi, y + yi - 1, z + zi)));
										YoutubersNaturalDisastersModVariables.MapVariables.get(world).syncData(world);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
