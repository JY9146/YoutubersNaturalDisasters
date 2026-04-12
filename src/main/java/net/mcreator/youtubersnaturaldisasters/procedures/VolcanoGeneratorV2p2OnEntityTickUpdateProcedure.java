package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModParticleTypes;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class VolcanoGeneratorV2p2OnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Blok = Blocks.AIR.defaultBlockState();
		double OneoutOf12 = 0;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.tickCount % 200 == 0) {
			entity.setInvulnerable(true);
			for (int index0 = 0; index0 < 10; index0++) {
				int horizontalRadiusSphere = (int) 125 - 1;
				int verticalRadiusSphere = (int) 5 - 1;
				int yIterationsSphere = verticalRadiusSphere;
				for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
					for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
						for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
							double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
									+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
							if (distanceSq <= 1.0) {
								if (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)).canOcclude()) {
									if (!world.isClientSide()) {
										if (!((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.MAGMA.get())) {
											OneoutOf12 = Mth.nextInt(RandomSource.create(), 1, 10000);
											if (OneoutOf12 == 2) {
												Blok = (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)));
												particleAmount = 2;
												for (int index1 = 0; index1 < (int) particleAmount; index1++) {
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + -1), (y + yi - 1), (z + zi + -1), 3, 0, 0, 0, 1);
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + -1), (y + yi - 1), (z + zi + 1), 3, 0, 0, 0, 1);
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + 1), (y + yi - 1), (z + zi + 1), 3, 0, 0, 0, 1);
													if (world instanceof ServerLevel)
														((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + 1), (y + yi - 1), (z + zi + -1), 3, 0, 0, 0, 1);
												}
												YoutubersNaturalDisastersMod.queueServerWork(5, () -> {
													entity.setInvulnerable(true);
												});
												world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
												if (world instanceof ServerLevel _level)
													FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + yi, z + zi), Blok);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			YoutubersNaturalDisastersMod.queueServerWork(1000, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
