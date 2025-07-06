package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleEntity;

public class BlackHoleOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlackHoleEntity _datEntSetL)
			_datEntSetL.getEntityData().set(BlackHoleEntity.DATA_DisapearAnimation, false);
	}
}
