package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class TsunamiP2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("RT")) - 1;
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
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi - 19))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()
								|| (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi - 19))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()) {
							for (int index0 = 0; index0 < 3; index0++) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi - 19), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
							}
						}
					}
				}
			}
		}
	}
}
