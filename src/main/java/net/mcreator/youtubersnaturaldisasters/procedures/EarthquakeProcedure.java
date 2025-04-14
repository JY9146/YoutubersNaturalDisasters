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

import expr.Variable;

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
			execute(provider, entity, provider.getPitch(), provider.getRoll(), provider.getYaw());
		}
	}

	public static void execute(Entity entity, double pitch, double roll, double yaw) {
		execute(null, entity, pitch, roll, yaw);
	}

	private static void execute(@Nullable Event event, Entity entity, double pitch, double roll, double yaw) {
		if (entity == null)
			return;
		double Variable = 0;
		entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
		if (Math.random() < 0.0005) {
			if (Math.random() < 0.5) {
				if (entity.getPersistentData().getDouble("tagName") >= 10) {
					setAngles((float) (yaw + 8), (float) (pitch - (Math.random() * 8) / 8), (float) roll);
				}
			} else {
				if (entity.getPersistentData().getDouble("tagName") >= 10) {
					setAngles((float) (yaw - 8), (float) (pitch - (Math.random() * 8) / 8), (float) roll);
				}
			}
			entity.getPersistentData().putDouble("tagName", 0);
		}
	}
}
