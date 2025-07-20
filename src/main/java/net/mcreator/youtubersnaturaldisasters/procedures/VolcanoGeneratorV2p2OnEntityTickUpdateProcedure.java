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
		entity.setInvulnerable(true);
		int horizontalRadiusSphere = (int) 200 - 1;
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
									OneoutOf12 = Mth.nextInt(RandomSource.create(), 1, 1000);
									if (OneoutOf12 == 2) {
										Blok = (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)));
										particleAmount = 2;
										for (int index0 = 0; index0 < (int) particleAmount; index0++) {
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + -1), (y + yi - 1), (z + zi + -1), 3, 0, 0, 0, 1);
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + -1), (y + yi - 1), (z + zi + 1), 3, 0, 0, 0, 1);
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + 1), (y + yi - 1), (z + zi + 1), 3, 0, 0, 0, 1);
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles(((SimpleParticleType) (YoutubersNaturalDisastersModParticleTypes.BLOCK_ASH.get())), (x + xi + 1), (y + yi - 1), (z + zi + -1), 3, 0, 0, 0, 1);
										}
										entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
										if (entity.getPersistentData().getDouble("tagName") >= Mth.nextInt(RandomSource.create(), 200, 1000)) {
											if (world instanceof ServerLevel _level)
												FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + yi, z + zi), Blok);
											world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
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
