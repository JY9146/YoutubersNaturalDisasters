package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class DrownFastOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isUnderWater()) {
			{
				double _setval = (entity.getCapability(YoutubersNaturalDisastersModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new YoutubersNaturalDisastersModVariables.PlayerVariables())).DrownFaster - 5;
				entity.getCapability(YoutubersNaturalDisastersModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DrownFaster = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.setAirSupply((int) (entity.getCapability(YoutubersNaturalDisastersModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new YoutubersNaturalDisastersModVariables.PlayerVariables())).DrownFaster);
		} else {
			{
				double _setval = entity.getAirSupply() + 1;
				entity.getCapability(YoutubersNaturalDisastersModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DrownFaster = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
