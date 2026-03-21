package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class WinCookiePlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < 64; index0++) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
				entityToSpawn.setPickUpDelay(6);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.DIAMOND));
				entityToSpawn.setPickUpDelay(6);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.NETHERITE_INGOT));
				entityToSpawn.setPickUpDelay(6);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.AMETHYST_SHARD));
				entityToSpawn.setPickUpDelay(6);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.REDSTONE));
				entityToSpawn.setPickUpDelay(6);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLDEN_APPLE));
				entityToSpawn.setPickUpDelay(6);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("CONGRATS YOU WIN!!!!"), false);
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
	}
}
