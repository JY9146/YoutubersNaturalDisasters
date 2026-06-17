package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VolcanoGeneratorOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Block_DstroyChance = 0;
		double Every__PerUptdate = 0;
		double Fall_Chance = 0;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		BlockState FarAwayBlock = Blocks.AIR.defaultBlockState();
		if (entity.tickCount % 10 == 0) {
			entity.setInvulnerable(true);
			if (entity.getPersistentData().getDouble("BlockCount") <= 50) {
				if (entity.getPersistentData().getBoolean("VolcanoHollowerWork")) {
					VolcanoGenerator2Procedure.execute(world, x, y, z, entity);
				}
				entity.getPersistentData().putDouble("BlockCount", (entity.getPersistentData().getDouble("BlockCount") + 1));
				entity.getPersistentData().putDouble("SizeWidthV", (entity.getPersistentData().getDouble("SizeWidthV") * 0.95));
				{
					Entity _ent = entity;
					_ent.teleportTo(x, (Math.round(entity.getY()) + 1), z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (Math.round(entity.getY()) + 1), z, _ent.getYRot(), _ent.getXRot());
				}
				entity.getPersistentData().putBoolean("VolcanoHollowerWork", true);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item,distance=.." + entity.getPersistentData().getDouble("SizeWidthV") + "]"));
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
