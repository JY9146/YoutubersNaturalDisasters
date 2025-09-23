
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
				tabData.accept(YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get());
				tabData.accept(YoutubersNaturalDisastersModItems.APPLE_OF_WISDOM.get());
				tabData.accept(YoutubersNaturalDisastersModItems.SMOKE_EMITTER.get());
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
				tabData.accept(YoutubersNaturalDisastersModItems.SINKHOLE_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.VOLCANO_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.DAPPER_MR_TOM_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.COIN.get());
				tabData.accept(YoutubersNaturalDisastersModItems.TECHNO_ITEM_DEFEATING.get());
				tabData.accept(YoutubersNaturalDisastersModItems.TEST_SINKHOLE_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.KNARFY_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.BRED.get());
				tabData.accept(YoutubersNaturalDisastersModItems.MACE.get());
				tabData.accept(YoutubersNaturalDisastersModItems.TIME_STICK.get());
				tabData.accept(YoutubersNaturalDisastersModItems.CRASH_ER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.BLACK_HOLE_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.WILD_FIRE_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.TIMEPHOON_SUMMONER.get());
				tabData.accept(YoutubersNaturalDisastersModItems.CAMMAGANZA_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.PH_1_LZ_A_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.YEAH_JARON_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.THROW_METEOR_SHOWER.get());
				tabData.accept(YoutubersNaturalDisastersModBlocks.HOT_METEOR_2.get().asItem());
				tabData.accept(YoutubersNaturalDisastersModBlocks.COLD_METEOR_2.get().asItem());
				tabData.accept(YoutubersNaturalDisastersModItems.REDDOONS_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.WIN_COOKIE.get());
				tabData.accept(YoutubersNaturalDisastersModItems.JUST_KABOODLE_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.IMASQUIDKID_SPAWN_EGG.get());
				tabData.accept(YoutubersNaturalDisastersModItems.GARRETT_THE_CARROT_SPAWN_EGG.get());
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
			tabData.accept(YoutubersNaturalDisastersModItems.DAPPER_MR_TOM_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.KNARFY_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.CAMMAGANZA_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.PH_1_LZ_A_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.YEAH_JARON_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.REDDOONS_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.JUST_KABOODLE_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.IMASQUIDKID_SPAWN_EGG.get());
			tabData.accept(YoutubersNaturalDisastersModItems.GARRETT_THE_CARROT_SPAWN_EGG.get());
		}
	}
}
