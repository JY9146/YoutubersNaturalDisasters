package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

public class CoinRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		double heads = 0;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				heads = Mth.nextInt(RandomSource.create(), 0, 1);
				itemstack.getOrCreateTag().putDouble("heads", heads);
				if (heads == 0) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7eA coin flip resulted in... \u00A7l\u00A76Tails\u00A7r\u00A7e!"), false);
				}
				if (heads == 1) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7eA coin flip resulted in... \u00A7l\u00A76Heads\u00A7r\u00A7e!"), false);
				}
			}
			world = _worldorig;
		}
	}
}
