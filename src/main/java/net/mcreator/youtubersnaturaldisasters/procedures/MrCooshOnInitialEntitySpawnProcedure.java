package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class MrCooshOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("HI THERE, ARE YOU A LEGEND?!?!? THEN YOU SHOULD GET RAI-"), false);
			YoutubersNaturalDisastersMod.queueServerWork(50, () -> {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.MOB);
			});
		}
	}
}
