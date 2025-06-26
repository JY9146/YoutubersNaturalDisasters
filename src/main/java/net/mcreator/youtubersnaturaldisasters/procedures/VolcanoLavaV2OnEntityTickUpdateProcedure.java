package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VolcanoLavaV2OnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Every__PerUptdate = 0;
		entity.setInvulnerable(true);
		if (entity.getPersistentData().getDouble("BlockCount") <= 60) {
			Every__PerUptdate = 3;
			if (entity.getPersistentData().getDouble("digtick") == 0) {
				entity.getPersistentData().putDouble("digtick", Every__PerUptdate);
			} else {
				entity.getPersistentData().putDouble("digtick", (entity.getPersistentData().getDouble("digtick") - 1));
			}
			if (entity.getPersistentData().getDouble("digtick") == 1) {
				if (!(entity.getPersistentData().getDouble("WAIT") == 1)) {
					entity.getPersistentData().putDouble("WAIT", (entity.getPersistentData().getDouble("WAIT") + 1));
					if (entity.getPersistentData().getBoolean("VolcanoHollowerWork")) {
						VolcanoV2LavaProcedure.execute(world, x, y, z, entity);
					}
				} else {
					entity.getPersistentData().putDouble("WAIT", 0);
					entity.getPersistentData().putDouble("BlockCount", (entity.getPersistentData().getDouble("BlockCount") + 1));
					entity.getPersistentData().putDouble("SizeWidthV", (entity.getPersistentData().getDouble("SizeWidthV") * 0.98));
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (Math.round(entity.getY()) + 1), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (Math.round(entity.getY()) + 1), z, _ent.getYRot(), _ent.getXRot());
					}
					entity.getPersistentData().putBoolean("VolcanoHollowerWork", true);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item,distance=.." + entity.getPersistentData().getDouble("SizeWidthV") + "]"));
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
