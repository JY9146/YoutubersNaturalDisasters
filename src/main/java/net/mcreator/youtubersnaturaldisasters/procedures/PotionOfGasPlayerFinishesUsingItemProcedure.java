package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;

public class PotionOfGasPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get()) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		}
	}
}
