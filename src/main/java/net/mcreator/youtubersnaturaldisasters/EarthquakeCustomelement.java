package net.mcreator.youtubersnaturaldisasters;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.youtubersnaturaldisasters.procedures.EarthquakeProcedure;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Earthquake {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void CameraShake(ViewportEvent.ComputeCameraAngles event) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player != null) {
			if (EarthquakeProcedure.execute(player)) {
				if (Math.random() < 0.5) {
					{
						event.setPitch((float) (event.getPitch() + (Math.random() * 2) / 3));
						event.setRoll((float) (event.getRoll() + (Math.random() * 2) / 3));
						event.setYaw((float) (event.getYaw() + (Math.random() * 2) / 3));
					}
				} else {
					{
						event.setPitch((float) (event.getPitch() - (Math.random() * 2) / 3));
						event.setRoll((float) (event.getRoll() - (Math.random() * 2) / 3));
						event.setYaw((float) (event.getYaw() - (Math.random() * 2) / 3));
					}
				}
			}
		}
	}
}
