package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class LavaBallShooterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity TheTargetOfDeath = null;
		boolean WAITPLS = false;
		boolean Wait = false;
		LavaBallLocateProcedure.execute(world, x, y, z, entity);
		{
			Entity _ent = entity;
			_ent.setYRot(Mth.nextInt(RandomSource.create(), 45, 360));
			_ent.setXRot(Mth.nextInt(RandomSource.create(), 1, 5));
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		YoutubersNaturalDisastersMod.queueServerWork(800, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
