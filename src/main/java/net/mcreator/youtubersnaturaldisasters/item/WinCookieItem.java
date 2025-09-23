
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class WinCookieItem extends Item {
	public WinCookieItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(5).saturationMod(10f).alwaysEat().build()));
	}
}
