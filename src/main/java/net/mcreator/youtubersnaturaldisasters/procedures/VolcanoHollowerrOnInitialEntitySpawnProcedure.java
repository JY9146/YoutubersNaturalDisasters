package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

public class VolcanoHollowerrOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("SizeWidthVH", 40);
	}
}
