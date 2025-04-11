package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class SinkholeGeneratorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (entity.onGround()) {
					int horizontalRadiusHemiBot = (int) 50 - 1;
					int verticalRadiusHemiBot = (int) 10;
					int yIterationsHemiBot = verticalRadiusHemiBot;
					for (int i = -yIterationsHemiBot; i <= 0; i++) {
						if (i == -verticalRadiusHemiBot) {
							continue;
						}
						for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
							for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
								double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
										+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
								if (distanceSq <= 1.0) {
									world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
									if (y < -30) {
										{
											BlockPos _bp = BlockPos.containing(x + xi, y + yi, z + zi);
											BlockState _bs = Blocks.LAVA.defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
												if (_property != null && _bs.getValue(_property) != null)
													try {
														_bs = _bs.setValue(_property, (Comparable) entry.getValue());
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
									if (y < -60) {
										if (!entity.level().isClientSide())
											entity.discard();
									}
								}
							}
						}
					}
				}
			}
			world = _worldorig;
		}
	}
}
