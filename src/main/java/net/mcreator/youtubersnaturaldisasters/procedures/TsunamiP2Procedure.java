package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class TsunamiP2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int horizontalRadiusHemiTop = (int) 69 - 1;
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
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()
								|| (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()) {
							for (int index0 = 0; index0 < 3; index0++) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi - 35), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 1, y + yi + 1, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()
								|| (world.getBlockState(BlockPos.containing(x + xi - 1, y + yi + 1, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()) {
							for (int index1 = 0; index1 < 3; index1++) {
								world.setBlock(BlockPos.containing(x + xi - 1, y + yi + 1, z + zi), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x + xi - 1, y + yi + 1, z + zi - 35), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 2, y + yi + 2, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()
								|| (world.getBlockState(BlockPos.containing(x + xi - 2, y + yi + 2, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()) {
							for (int index2 = 0; index2 < 3; index2++) {
								world.setBlock(BlockPos.containing(x + xi - 2, y + yi + 2, z + zi), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x + xi - 2, y + yi + 2, z + zi - 35), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 3, y + yi + 3, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()
								|| (world.getBlockState(BlockPos.containing(x + xi - 3, y + yi + 3, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()) {
							for (int index3 = 0; index3 < 3; index3++) {
								world.setBlock(BlockPos.containing(x + xi - 3, y + yi + 3, z + zi), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x + xi - 3, y + yi + 3, z + zi - 35), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 4, y + yi + 4, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get()
								|| (world.getBlockState(BlockPos.containing(x + xi - 4, y + yi + 4, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()) {
							for (int index4 = 0; index4 < 3; index4++) {
								world.setBlock(BlockPos.containing(x + xi - 4, y + yi + 4, z + zi), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
								world.setBlock(BlockPos.containing(x + xi - 4, y + yi + 4, z + zi - 35), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
							}
						}
					}
				}
			}
		}
	}
}
