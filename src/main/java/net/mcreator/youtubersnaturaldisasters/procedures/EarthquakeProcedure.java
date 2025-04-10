package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class EarthquakeProcedure {
	public static void execute(LevelAccessor world) {
		if (Math.random() < 0.01) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Message"), false);
		}
	}
}
