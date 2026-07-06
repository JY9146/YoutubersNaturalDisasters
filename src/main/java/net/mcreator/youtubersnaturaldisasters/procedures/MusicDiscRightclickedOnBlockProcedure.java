package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class MusicDiscRightclickedOnBlockProcedure {
	public static void execute(BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == Blocks.JUKEBOX) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(YoutubersNaturalDisastersModItems.TOMMYINNIT_ITEM.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(YoutubersNaturalDisastersModBlocks.TOMMYINNIT_BLOCK.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
