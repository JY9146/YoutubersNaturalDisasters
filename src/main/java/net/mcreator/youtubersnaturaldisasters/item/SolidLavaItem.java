
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModFluids;

public class SolidLavaItem extends BucketItem {
	public SolidLavaItem() {
		super(YoutubersNaturalDisastersModFluids.SOLID_LAVA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
