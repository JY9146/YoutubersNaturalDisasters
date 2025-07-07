package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class VolcanoV2EruptProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
		if (entity.getPersistentData().getDouble("tagName") >= 400) {
			for (int index0 = 0; index0 < 15; index0++) {
				YoutubersNaturalDisastersMod.queueServerWork(Mth.nextInt(RandomSource.create(), 5, 20), () -> {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(entity, (x + Mth.nextInt(RandomSource.create(), 10, 40)), y, (z + Mth.nextInt(RandomSource.create(), 10, 40)), 10, false, Level.ExplosionInteraction.NONE);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(entity, (x - Mth.nextInt(RandomSource.create(), 10, 40)), y, (z - Mth.nextInt(RandomSource.create(), 10, 40)), 10, false, Level.ExplosionInteraction.NONE);
				});
			}
			YoutubersNaturalDisastersMod.queueServerWork(25, () -> {
				int horizontalRadiusHemiTop = (int) 100 - 1;
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
								if (Math.random() < 0.05) {
									if (world instanceof ServerLevel _level)
										FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + yi, z + zi), Blocks.FIRE.defaultBlockState());
								}
								if (Math.random() < 0.05) {
									if (world instanceof ServerLevel _level)
										FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + yi, z + zi), YoutubersNaturalDisastersModBlocks.MAGMA.get().defaultBlockState());
								}
							}
						}
					}
				}
				entity.getPersistentData().putDouble("tagName", 0);
			});
		}
		YoutubersNaturalDisastersMod.queueServerWork(2000, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
