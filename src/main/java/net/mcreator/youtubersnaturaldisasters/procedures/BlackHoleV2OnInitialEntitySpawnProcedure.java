package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV2Entity;

public class BlackHoleV2OnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlackHoleV2Entity _datEntSetL)
			_datEntSetL.getEntityData().set(BlackHoleV2Entity.DATA_DisapearAnimation, false);
	}
}
