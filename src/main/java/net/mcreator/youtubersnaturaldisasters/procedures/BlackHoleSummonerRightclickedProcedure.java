package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;

public class BlackHoleSummonerRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Num = 0;
		Num = Mth.nextInt(RandomSource.create(), 1, 3);
		if (Num == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.BLACK_HOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (Num == 2) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.BLACK_HOLE_V_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (Num == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.BLACK_HOLE_V_3.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
