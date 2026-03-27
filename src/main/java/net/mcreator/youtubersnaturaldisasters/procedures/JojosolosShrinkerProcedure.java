package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.JojosolosEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JojosolosShrinkerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean logic = false;
		entity.getPersistentData().putDouble("Shrinktimer", (entity.getPersistentData().getDouble("Shrinktimer")));
		if (entity.getPersistentData().getDouble("Shrinktimer") > 100) {
			logic = true;
			entity.getPersistentData().putDouble("Shrinktimer", 0);
		} else {
			logic = false;
		}
		if (!world.getEntitiesOfClass(JojosolosEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty() && entity instanceof Player && logic) {
			entity.refreshDimensions();
		}
	}
}
