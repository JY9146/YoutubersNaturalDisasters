package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

public class InvincibilityActiveTickConditionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setInvulnerable(true);
	}
}
