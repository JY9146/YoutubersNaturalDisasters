package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class TsunamiGeneratorOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Timer1", (entity.getPersistentData().getDouble("Timer1") + 1));
		int horizontalRadiusHemiTop = (int) 70 - 1;
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
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == Blocks.AIR) {
							if (entity.getPersistentData().getDouble("Timer1") == 20) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get().defaultBlockState(), 3);
								TsunamiP2Procedure.execute(world, x, y, z);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 1, y + yi + 1, z + zi))).getBlock() == Blocks.AIR) {
							if (entity.getPersistentData().getDouble("Timer1") == 40) {
								world.setBlock(BlockPos.containing(x + xi - 1, y + yi + 1, z + zi), YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get().defaultBlockState(), 3);
								TsunamiP2Procedure.execute(world, x, y, z);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 2, y + yi + 2, z + zi))).getBlock() == Blocks.AIR) {
							if (entity.getPersistentData().getDouble("Timer1") == 60) {
								world.setBlock(BlockPos.containing(x + xi - 2, y + yi + 2, z + zi), YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get().defaultBlockState(), 3);
								TsunamiP2Procedure.execute(world, x, y, z);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 3, y + yi + 3, z + zi))).getBlock() == Blocks.AIR) {
							if (entity.getPersistentData().getDouble("Timer1") == 80) {
								world.setBlock(BlockPos.containing(x + xi - 3, y + yi + 3, z + zi), YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get().defaultBlockState(), 3);
								TsunamiP2Procedure.execute(world, x, y, z);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + xi - 4, y + yi + 4, z + zi))).getBlock() == Blocks.AIR) {
							if (entity.getPersistentData().getDouble("Timer1") == 100) {
								world.setBlock(BlockPos.containing(x + xi - 4, y + yi + 4, z + zi), YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get().defaultBlockState(), 3);
								TsunamiP2Procedure.execute(world, x, y, z);
							}
						}
					}
				}
			}
		}
	}
}
