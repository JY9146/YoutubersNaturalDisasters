package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class DisasterVolcanoV2SpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Chance = 0;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_GROUND_MESSER_V_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_GENERATOR_V_2P_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_GENERATOR_V_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		YoutubersNaturalDisastersMod.queueServerWork(60, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_LAVA_V_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		});
	}
}
