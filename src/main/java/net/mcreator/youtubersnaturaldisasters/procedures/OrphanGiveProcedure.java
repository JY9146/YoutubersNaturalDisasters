package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class OrphanGiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Orphan) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Hey you. Technoblade made me a Orphan Squared, and you're getting me my revenge. Take this."), false);
			YoutubersNaturalDisastersMod.queueServerWork(10, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("It's the only item that can defeat him"), false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(YoutubersNaturalDisastersModItems.TECHNO_ITEM_DEFEATING.get()));
					entityToSpawn.setPickUpDelay(1);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			});
			if (!entity.level().isClientSide())
				entity.discard();
			YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Orphan = false;
			YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
