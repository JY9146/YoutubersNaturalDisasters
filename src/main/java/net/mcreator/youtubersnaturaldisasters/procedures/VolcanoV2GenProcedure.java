package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class VolcanoV2GenProcedure {
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
						if (Math.random() < 0.7) {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.BASALT.defaultBlockState(), 3);
						} else if (Math.random() < 0.6) {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.STONE.defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.MAGMA_BLOCK.defaultBlockState(), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + xi, y + yi, z + zi);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("tagName", true);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		}
		VolcanoV2HollowProcedure.execute(world, x, y, z, entity);
	}
}
