/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.youtubersnaturaldisasters as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.youtubersnaturaldisasters;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.level.block.Blocks;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YoutubersNaturalDisastersExtendedTabs {

	@SubscribeEvent
	public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTab() == YoutubersNaturalDisastersModTabs.NATURAL_DISASTERS.get()) {
			event.accept(Blocks.BASALT);
		}
	}
}
