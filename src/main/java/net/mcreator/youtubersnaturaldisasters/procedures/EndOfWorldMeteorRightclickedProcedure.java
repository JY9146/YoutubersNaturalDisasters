package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;

public class EndOfWorldMeteorRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = YoutubersNaturalDisastersModEntities.END_OF_WORLD_METEOR_METEOR.get().spawn(_level, BlockPos.containing(x, y + 300, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.NETHER);
			if (world != null) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = YoutubersNaturalDisastersModEntities.END_OF_WORLD_METEOR_METEOR.get().spawn(_level, BlockPos.containing(x, y + 300, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = YoutubersNaturalDisastersModEntities.END_OF_WORLD_METEOR_METEOR.get().spawn(_level, BlockPos.containing(x, y + 300, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
			world = _worldorig;
		}
	}
}
