
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.youtubersnaturaldisasters.procedures.ThrowTalonMeteorRightClickProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.ThrowTalonMeteorRightClickOnBlockProcedure;

public class ThrowTalonMeteorItem extends Item {
	public ThrowTalonMeteorItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ThrowTalonMeteorRightClickProcedure.execute(world, entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ThrowTalonMeteorRightClickOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}
}
