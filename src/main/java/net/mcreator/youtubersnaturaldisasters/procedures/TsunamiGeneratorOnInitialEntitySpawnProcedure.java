package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;
import net.mcreator.youtubersnaturaldisasters.entity.TsunamiGeneratorEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class TsunamiGeneratorOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean placed = false;
		if (entity.tickCount % 20 == 0 && entity instanceof TsunamiGeneratorEntity) {
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
							if ((world.getBlockState(BlockPos.containing(x + xi + entity.getPersistentData().getDouble("tagName"), y + yi + entity.getPersistentData().getDouble("tagName2"), z + zi))).getBlock() == Blocks.AIR) {
								if (!world.isClientSide()) {
									world.setBlock(BlockPos.containing(x + xi + entity.getPersistentData().getDouble("tagName"), y + yi + entity.getPersistentData().getDouble("tagName2"), z + zi),
											YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get().defaultBlockState(), 3);
								}
								placed = true;
							}
						}
					}
				}
			}
			if (placed) {
				TsunamiP2Procedure.execute(world, x, y, z, entity);
			}
			if (entity.getPersistentData().getDouble("tagName") > -8) {
				entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") - 1));
			}
			entity.getPersistentData().putDouble("tagName2", (entity.getPersistentData().getDouble("tagName2") + 1));
		}
		YoutubersNaturalDisastersMod.queueServerWork(80, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
