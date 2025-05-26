package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class LavaBallWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		boolean WORKpls = false;
		boolean Workworkwork = false;
		double Number1 = 0;
		int horizontalRadiusSphere = (int) 5 - 1;
		int verticalRadiusSphere = (int) 5 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						world.setBlock(BlockPos.containing(x + xi, y + yi + 2, z + zi), YoutubersNaturalDisastersModBlocks.SOLID_LAVA_BLOCK.get().defaultBlockState(), 3);
						Workworkwork = true;
						if (Workworkwork == true) {
							if (!((world.getBlockState(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_LAVA_BLOCK.get())
									&& !((world.getBlockState(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1))).getBlock() == Blocks.AIR)
									&& !((world.getBlockState(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1))).getBlock() == Blocks.LAVA)
									&& !((world.getBlockState(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1))).getBlock() == Blocks.STONE)
									&& !((world.getBlockState(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1))).getBlock() == Blocks.DIRT)
									&& !((world.getBlockState(BlockPos.containing(x + xi + 1, y + yi + 1, z + zi + 1))).getBlock() == Blocks.LAVA)) {
								WORKpls = true;
								if (!immediatesourceentity.level().isClientSide())
									immediatesourceentity.discard();
							}
						}
					}
				}
			}
		}
		if (WORKpls == true) {
			int horizontalRadiusHemiTop = (int) 9 - 1;
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
							world.setBlock(BlockPos.containing(x + xi, y + yi - 2, z + zi), Blocks.LAVA.defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}
}
