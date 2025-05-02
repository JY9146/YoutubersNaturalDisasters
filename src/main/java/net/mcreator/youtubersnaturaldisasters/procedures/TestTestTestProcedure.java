package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class TestTestTestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("YtillDespawn1", (entity.getY()));
		entity.getPersistentData().putDouble("SizeWidth1", 50);
		int horizontalRadiusHemiBot = (int) 100 - 1;
		int verticalRadiusHemiBot = (int) 300;
		int yIterationsHemiBot = verticalRadiusHemiBot;
		for (int yi = -yIterationsHemiBot; yi <= 0; yi++) {
			if (yi == -verticalRadiusHemiBot) {
				continue;
			}
			for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
				for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (yi * yi) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
							+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
					if (distanceSq <= 1.0) {
						if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == Blocks.WATER) {
							{
								BlockPos _bp = BlockPos.containing(x + xi, y + yi, z + zi);
								BlockState _bs = Blocks.AIR.defaultBlockState();
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
					}
				}
			}
		}
	}
}
