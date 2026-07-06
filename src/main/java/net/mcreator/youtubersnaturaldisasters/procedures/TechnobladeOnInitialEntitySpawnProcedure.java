package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

public class TechnobladeOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("MusicCanPlay", true);
	}
}
