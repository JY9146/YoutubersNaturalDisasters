package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV3Entity;

public class BlackHoleV3OnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlackHoleV3Entity _datEntSetL)
			_datEntSetL.getEntityData().set(BlackHoleV3Entity.DATA_DisapearAnimation, false);
	}
}
