package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.item.ItemStack;

public class CoinPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("heads");
	}
}
