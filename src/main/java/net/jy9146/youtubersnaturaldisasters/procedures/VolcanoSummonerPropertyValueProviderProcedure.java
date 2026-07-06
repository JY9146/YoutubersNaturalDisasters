package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class VolcanoSummonerPropertyValueProviderProcedure {
	public static double execute(LevelAccessor world, ItemStack itemstack) {
		if (YoutubersNaturalDisastersModVariables.WorldVariables.get(world).VolcanoItemTexture == 1) {
			itemstack.getOrCreateTag().putDouble("tagName", 1);
		} else {
			itemstack.getOrCreateTag().putDouble("tagName", 2);
		}
		return itemstack.getOrCreateTag().getDouble("tagName");
	}
}
