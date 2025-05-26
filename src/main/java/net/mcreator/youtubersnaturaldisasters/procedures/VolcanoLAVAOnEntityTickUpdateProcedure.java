package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoHollowerrEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class VolcanoLAVAOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Every__PerUptdate = 0;
		entity.setInvulnerable(true);
		if (!(!world.getEntitiesOfClass(VolcanoHollowerrEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())) {
			if (entity.getPersistentData().getDouble("BlockCount") <= 52) {
				Every__PerUptdate = 2;
				if (entity.getPersistentData().getDouble("digtick") == 0) {
					entity.getPersistentData().putDouble("digtick", Every__PerUptdate);
				} else {
					entity.getPersistentData().putDouble("digtick", (entity.getPersistentData().getDouble("digtick") - 1));
				}
				if (entity.getPersistentData().getDouble("digtick") == 1) {
					if (!(entity.getPersistentData().getDouble("WAIT") == 2)) {
						entity.getPersistentData().putDouble("WAIT", (entity.getPersistentData().getDouble("WAIT") + 1));
						if (entity.getPersistentData().getBoolean("VolcanoHollowerWork")) {
							VolcanoLavaGen2Procedure.execute(world, x, y, z, entity);
						}
					} else {
						entity.getPersistentData().putDouble("WAIT", 0);
						entity.getPersistentData().putDouble("BlockCount", (entity.getPersistentData().getDouble("BlockCount") + 1));
						entity.getPersistentData().putDouble("SizeWidthVH", (entity.getPersistentData().getDouble("SizeWidthVH") * 0.95));
						{
							Entity _ent = entity;
							_ent.teleportTo(x, (Math.round(entity.getY()) + 1), z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, (Math.round(entity.getY()) + 1), z, _ent.getYRot(), _ent.getXRot());
						}
						entity.getPersistentData().putBoolean("VolcanoHollowerWork", true);
					}
				}
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
				YoutubersNaturalDisastersMod.queueServerWork(600, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = YoutubersNaturalDisastersModEntities.LAVA_BALL_SHOOTER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			}
		}
	}
}
