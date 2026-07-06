package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class VolcanoLavaV2OnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("SizeWidthV", YoutubersNaturalDisastersModVariables.MapVariables.get(world).Consistant);
	}
}
