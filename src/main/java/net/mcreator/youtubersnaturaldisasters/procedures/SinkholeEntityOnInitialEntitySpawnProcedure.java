package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

public class SinkholeEntityOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("YtillDespawn", (entity.getY()));
		entity.getPersistentData().putDouble("SizeWidth", 100);
	}
}
