package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV2Entity;

public class BlackHoleV2PlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof BlackHoleV2Entity _datEntL0 && _datEntL0.getEntityData().get(BlackHoleV2Entity.DATA_DisapearAnimation));
	}
}
