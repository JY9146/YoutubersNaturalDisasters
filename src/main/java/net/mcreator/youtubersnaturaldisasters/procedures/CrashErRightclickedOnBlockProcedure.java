package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class CrashErRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((1 / 0), (1 / 0), (1 / 0)));
		if (!world.isClientSide() && world.getServer() != null)
			ServerLifecycleHooks.getCurrentServer().stopServer();
	}
}
