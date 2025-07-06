package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV3Entity;

public class BlackHoleV3PlaybackAniConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof BlackHoleV3Entity _datEntL0 && _datEntL0.getEntityData().get(BlackHoleV3Entity.DATA_DisapearAnimation);
	}
}
