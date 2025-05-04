
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.youtubersnaturaldisasters.procedures.TechnoItemDefeatingLivingEntityIsHitWithItemProcedure;

public class TechnoItemDefeatingItem extends Item {
	public TechnoItemDefeatingItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TechnoItemDefeatingLivingEntityIsHitWithItemProcedure.execute(entity.level(), entity);
		return retval;
	}
}
