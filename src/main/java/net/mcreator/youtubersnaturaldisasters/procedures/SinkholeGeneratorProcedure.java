package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class SinkholeGeneratorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yy = 0;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (entity.onGround()) {
					entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
					if (entity.getPersistentData().getDouble("tagName") > 20) {
						entity.getPersistentData().putDouble("tagName", 0);
						int horizontalRadiusHemiBot = (int) 100 - 1;
						int verticalRadiusHemiBot = (int) 5;
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
										world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.break")), SoundSource.MUSIC, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.break")), SoundSource.MUSIC, 1, 1, false);
											}
										}
										if (y < 5) {
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
										if (y < 0) {
											if (!entity.level().isClientSide())
												entity.discard();
										}
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
