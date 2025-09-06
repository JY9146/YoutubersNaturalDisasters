package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class TsunamiP2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("RT")) - 1;
		int verticalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("HT") - 2);
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
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi - 19))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()) {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi - 19), Blocks.STRUCTURE_VOID.defaultBlockState(), 3);
						}
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi - 25, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()) {
							world.setBlock(BlockPos.containing(x + xi, y + yi - 25, z + zi), Blocks.STRUCTURE_VOID.defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}
}
