package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

public class CoinRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("heads", (Mth.nextInt(RandomSource.create(), 0, 1)));
		if (itemstack.getOrCreateTag().getDouble("heads") == 0) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7eA coin flip resulted in... \u00A7l\u00A76Tails\u00A7r\u00A7e!"), false);
		} else {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7eA coin flip resulted in... \u00A7l\u00A76Heads\u00A7r\u00A7e!"), false);
		}
	}
}
