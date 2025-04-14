
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YoutubersNaturalDisastersModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<CreativeModeTab> NATURAL_DISASTERS = REGISTRY.register("natural_disasters", () -> CreativeModeTab.builder().title(Component.translatable("item_group.youtubers_natural_disasters.natural_disasters"))
			.icon(() -> new ItemStack(YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(YoutubersNaturalDisastersModItems.MUSIC_DISC.get());
				tabData.accept(YoutubersNaturalDisastersModItems.END_OF_WORLD_METEOR.get());
				tabData.accept(YoutubersNaturalDisastersModItems.TECHNOBLADE_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModBlocks.COLD_METEOR.get().asItem());
				tabData.accept(YoutubersNaturalDisastersModBlocks.HOT_METEOR.get().asItem());
				tabData.accept(YoutubersNaturalDisastersModItems.GOLDEN_APPLE_GIVER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.SATURATION_FILLER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.CRAG_DYNA_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.SOLID_LAVA_BUCKET.get());
				tabData.accept(YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get());
				tabData.accept(YoutubersNaturalDisastersModItems.APPLE_OF_WISDOM.get());
				tabData.accept(YoutubersNaturalDisastersModItems.THROW_METEOR.get());
				tabData.accept(YoutubersNaturalDisastersModItems.CAVEMAN_FILMS_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.INSANE_FLAME_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.THROW_LIGHTNING.get());
				tabData.accept(YoutubersNaturalDisastersModItems.THROW_TNT.get());
				tabData.accept(YoutubersNaturalDisastersModItems.EARTHQUAKE_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.MR_COOSH_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.ZACHARY_95_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.COSMIC_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.TORNADO_SUMMONER.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(YoutubersNaturalDisastersModItems.MUSIC_DISC.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(YoutubersNaturalDisastersModItems.TECHNOBLADE_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.CRAG_DYNA_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.CAVEMAN_FILMS_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.INSANE_FLAME_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.MR_COOSH_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.ZACHARY_95_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.COSMIC_SPAWN_EGG.get());
		}
	}
}
