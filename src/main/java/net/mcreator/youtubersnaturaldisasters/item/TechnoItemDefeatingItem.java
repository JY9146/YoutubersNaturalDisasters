
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.youtubersnaturaldisasters.procedures.TechnoItemDefeatingLivingEntityIsHitWithItemProcedure;

public class TechnoItemDefeatingItem extends RecordItem {
	public TechnoItemDefeatingItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.toast.challenge_complete")), new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC), 100);
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TechnoItemDefeatingLivingEntityIsHitWithItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}
}
