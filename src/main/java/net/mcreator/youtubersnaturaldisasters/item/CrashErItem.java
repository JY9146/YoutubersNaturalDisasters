
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.youtubersnaturaldisasters.procedures.CrashErRightclickedOnBlockProcedure;

public class CrashErItem extends Item {
	public CrashErItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		CrashErRightclickedOnBlockProcedure.execute(context.getLevel(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
