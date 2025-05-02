package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;

public class TechnoTrade2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof TechnobladeEntity _datEntL0 && _datEntL0.getEntityData().get(TechnobladeEntity.DATA_Hostilty)) == true) {
			return true;
		}
		return false;
	}
}
