package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class VolcanoLavaFLOWProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.BASALT.get()
								|| (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.STONE.get()
								|| (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.MAGMA.get()) {
							if (Math.random() < 0.05) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x + xi, y + yi, z + zi);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("LF", true);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
