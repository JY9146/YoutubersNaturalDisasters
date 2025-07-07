package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class VolcanoGroundMesserV2OnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setInvulnerable(true);
		YoutubersNaturalDisastersMod.queueServerWork(5, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
