package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.youtubersnaturaldisasters.entity.JojosolosEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManualSizeEventProcedure {
	@SubscribeEvent
	public static void onEventTriggered(net.minecraftforge.event.entity.EntityEvent.Size event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Num = 0;
		double Num2 = 0;
		if (world == null)
			return;
		net.minecraftforge.event.entity.EntityEvent.Size _sizeEvt = (net.minecraftforge.event.entity.EntityEvent.Size) event;
		Num = Math.random();
		if (Math.random() < 0.9) {
			Num2 = Math.random();
		} else {
			Num2 = Mth.nextDouble(RandomSource.create(), 1, 4);
		}
		int horizontalRadiusSquare = (int) 3 - 1;
		int verticalRadiusSquare = (int) 3 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int yi = -yIterationsSquare; yi <= yIterationsSquare; yi++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if (!world.getEntitiesOfClass(JojosolosEntity.class, AABB.ofSize(new Vec3(x + xi, y + yi, z + zi), 3, 3, 3), e -> true).isEmpty() && !entity.isShiftKeyDown()) {
						_sizeEvt.setNewEyeHeight((float) Num);
						_sizeEvt.setNewSize(new EntityDimensions((float) Num2, (float) Num, false));
					}
					entity.getPersistentData().putDouble("Shrinktimer", 0);
				}
			}
		}
	}
}
