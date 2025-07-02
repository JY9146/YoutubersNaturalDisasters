package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class VolcanoV2GenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean LavaFlowing = false;
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
						if (Math.random() < 0.7) {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), YoutubersNaturalDisastersModBlocks.BASALT.get().defaultBlockState(), 3);
						} else if (Math.random() < 0.6) {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), YoutubersNaturalDisastersModBlocks.STONE.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), YoutubersNaturalDisastersModBlocks.MAGMA.get().defaultBlockState(), 3);
						}
					}
				}
			}
		}
		VolcanoV2HollowProcedure.execute(world, x, y, z, entity);
	}
}
