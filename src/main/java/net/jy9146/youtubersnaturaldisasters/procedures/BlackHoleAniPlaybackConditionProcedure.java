package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleEntity;

public class BlackHoleAniPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof BlackHoleEntity _datEntL0 && _datEntL0.getEntityData().get(BlackHoleEntity.DATA_DisapearAnimation));
	}
}
