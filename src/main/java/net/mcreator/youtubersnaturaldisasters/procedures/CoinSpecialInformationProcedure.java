package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.item.ItemStack;

public class CoinSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("heads") == 0) {
			return "\u00A77Tails";
		} else if (itemstack.getOrCreateTag().getDouble("heads") == 1) {
			return "\u00A77Heads";
		}
		return "\u00A77Tails";
	}
}
