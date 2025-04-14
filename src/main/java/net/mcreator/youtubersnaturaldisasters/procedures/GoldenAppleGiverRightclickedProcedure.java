package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;

import java.util.ArrayList;

public class GoldenAppleGiverRightclickedProcedure {
	public static void execute(LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof ServerPlayer) {
				if (entityiterator instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.GOLDEN_APPLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (Math.random() < 0.5) {
					if (entityiterator instanceof Player _player) {
						ItemStack _setstack = new ItemStack(YoutubersNaturalDisastersModItems.APPLE_OF_WISDOM.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
