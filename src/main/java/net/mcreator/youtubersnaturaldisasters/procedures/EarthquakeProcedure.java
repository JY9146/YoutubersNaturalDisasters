package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class EarthquakeProcedure {
	public static ViewportEvent.ComputeCameraAngles provider = null;

	public static void setAngles(float yaw, float pitch, float roll) {
		provider.setYaw(yaw);
		provider.setPitch(pitch);
		provider.setRoll(roll);
	}

	@SubscribeEvent
	public static void computeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
		provider = event;
		ClientLevel level = Minecraft.getInstance().level;
		Entity entity = provider.getCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 entPos = entity.getPosition((float) provider.getPartialTick());
			execute(provider, provider.getPitch(), provider.getRoll(), provider.getYaw());
		}
	}

	public static void execute(double pitch, double roll, double yaw) {
		execute(null, pitch, roll, yaw);
	}

	private static void execute(@Nullable Event event, double pitch, double roll, double yaw) {
		if (Math.random() < 0.015) {
			if (Math.random() < 0.5) {
				setAngles((float) (yaw + 8), (float) (pitch - (Math.random() * 8) / 8), (float) roll);
			} else {
				setAngles((float) (yaw - 8), (float) (pitch - (Math.random() * 8) / 8), (float) roll);
			}
		}
	}
}
