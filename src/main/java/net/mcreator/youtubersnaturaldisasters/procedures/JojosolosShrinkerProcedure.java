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
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

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
		int horizontalRadiusSquare = (int) 3 - 1;
		int verticalRadiusSquare = (int) 3 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int yi = -yIterationsSquare; yi <= yIterationsSquare; yi++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if (!world.getEntitiesOfClass(JojosolosEntity.class, AABB.ofSize(new Vec3(x + xi, y + yi, z + zi), 3, 3, 3), e -> true).isEmpty() && entity instanceof Player && !entity.isShiftKeyDown()) {
						entity.getPersistentData().putDouble("Shrinktimer", (entity.getPersistentData().getDouble("Shrinktimer") + 1));
						YoutubersNaturalDisastersMod.LOGGER.info(entity.getPersistentData().getDouble("Shrinktimer"));
						if (entity.getPersistentData().getDouble("Shrinktimer") > 300) {
							entity.refreshDimensions();
							entity.getPersistentData().putDouble("Shrinktimer", 0);
						}
					}
				}
			}
		}
	}
}
