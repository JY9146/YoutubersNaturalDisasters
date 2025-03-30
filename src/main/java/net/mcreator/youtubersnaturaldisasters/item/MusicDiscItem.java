
package net.mcreator.youtubersnaturaldisasters.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MusicDiscItem extends RecordItem {
	public MusicDiscItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:thatswhatilike")), new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON), 6000);
	}
}
