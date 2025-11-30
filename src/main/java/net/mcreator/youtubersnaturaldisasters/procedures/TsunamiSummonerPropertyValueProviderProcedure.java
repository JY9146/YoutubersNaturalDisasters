package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.item.ItemStack;

public class TsunamiSummonerPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("biome");
	}
}
