
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.youtubersnaturaldisasters.procedures.MusicDiscRightclickedOnBlockProcedure;

public class MusicDiscItem extends RecordItem {
	public MusicDiscItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:thatswhatiliketommy")), new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON), 6000);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MusicDiscRightclickedOnBlockProcedure.execute(context.getLevel().getBlockState(context.getClickedPos()), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
