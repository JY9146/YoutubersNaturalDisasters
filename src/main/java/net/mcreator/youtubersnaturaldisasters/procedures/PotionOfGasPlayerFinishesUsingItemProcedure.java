package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;

public class PotionOfGasPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		{
			ItemStack _isc = itemstack;
			final ItemStack _setstack = new ItemStack(YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get()).copy();
			final int _sltid = 0;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
					itemHandlerModifiable.setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
	}
}
