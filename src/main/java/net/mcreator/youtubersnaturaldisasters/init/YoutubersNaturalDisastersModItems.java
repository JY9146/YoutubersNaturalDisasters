
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.youtubersnaturaldisasters.procedures.CoinPropertyValueProviderProcedure;
import net.mcreator.youtubersnaturaldisasters.item.WildFireSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.VolcanoSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.TornadoSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.TommyinnitItemItem;
import net.mcreator.youtubersnaturaldisasters.item.TimephoonSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.TimeStickItem;
import net.mcreator.youtubersnaturaldisasters.item.ThrowTNTItem;
import net.mcreator.youtubersnaturaldisasters.item.ThrowMeteorItem;
import net.mcreator.youtubersnaturaldisasters.item.ThrowLightningItem;
import net.mcreator.youtubersnaturaldisasters.item.TestSinkholeSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.TechnosSplashPotionOfGasItem;
import net.mcreator.youtubersnaturaldisasters.item.TechnosEndOfWorldMeteorItem;
import net.mcreator.youtubersnaturaldisasters.item.TechnoItemDefeatingItem;
import net.mcreator.youtubersnaturaldisasters.item.SmokeEmitterItem;
import net.mcreator.youtubersnaturaldisasters.item.SinkholeSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.SaturationFillerItem;
import net.mcreator.youtubersnaturaldisasters.item.PotionOfGasItem;
import net.mcreator.youtubersnaturaldisasters.item.MusicDiscItem;
import net.mcreator.youtubersnaturaldisasters.item.MaceItem;
import net.mcreator.youtubersnaturaldisasters.item.GoldenAppleGiverItem;
import net.mcreator.youtubersnaturaldisasters.item.EndOfWorldMeteorItem;
import net.mcreator.youtubersnaturaldisasters.item.EarthquakeSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.CrashErItem;
import net.mcreator.youtubersnaturaldisasters.item.CoinItem;
import net.mcreator.youtubersnaturaldisasters.item.BredItem;
import net.mcreator.youtubersnaturaldisasters.item.BlackHoleSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.AppleOfWisdomItem;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class YoutubersNaturalDisastersModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<Item> MUSIC_DISC = REGISTRY.register("music_disc", () -> new MusicDiscItem());
	public static final RegistryObject<Item> END_OF_WORLD_METEOR = REGISTRY.register("end_of_world_meteor", () -> new EndOfWorldMeteorItem());
	public static final RegistryObject<Item> TECHNOBLADE_SPAWN_EGG = REGISTRY.register("technoblade_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.TECHNOBLADE, -65281, -6750055, new Item.Properties()));
	public static final RegistryObject<Item> COLD_METEOR = block(YoutubersNaturalDisastersModBlocks.COLD_METEOR);
	public static final RegistryObject<Item> HOT_METEOR = block(YoutubersNaturalDisastersModBlocks.HOT_METEOR);
	public static final RegistryObject<Item> GOLDEN_APPLE_GIVER = REGISTRY.register("golden_apple_giver", () -> new GoldenAppleGiverItem());
	public static final RegistryObject<Item> SATURATION_FILLER = REGISTRY.register("saturation_filler", () -> new SaturationFillerItem());
	public static final RegistryObject<Item> CRAG_DYNA_SPAWN_EGG = REGISTRY.register("crag_dyna_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.CRAG_DYNA, -6750208, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> SPLASH_POTION_OF_GAS = REGISTRY.register("splash_potion_of_gas", () -> new PotionOfGasItem());
	public static final RegistryObject<Item> APPLE_OF_WISDOM = REGISTRY.register("apple_of_wisdom", () -> new AppleOfWisdomItem());
	public static final RegistryObject<Item> SMOKE_EMITTER = REGISTRY.register("smoke_emitter", () -> new SmokeEmitterItem());
	public static final RegistryObject<Item> THROW_METEOR = REGISTRY.register("throw_meteor", () -> new ThrowMeteorItem());
	public static final RegistryObject<Item> CAVEMAN_FILMS_SPAWN_EGG = REGISTRY.register("caveman_films_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.CAVEMAN_FILMS, -16777216, -14127104, new Item.Properties()));
	public static final RegistryObject<Item> INSANE_FLAME_SPAWN_EGG = REGISTRY.register("insane_flame_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.INSANE_FLAME, -65536, -39424, new Item.Properties()));
	public static final RegistryObject<Item> THROW_LIGHTNING = REGISTRY.register("throw_lightning", () -> new ThrowLightningItem());
	public static final RegistryObject<Item> THROW_TNT = REGISTRY.register("throw_tnt", () -> new ThrowTNTItem());
	public static final RegistryObject<Item> EARTHQUAKE_SUMMONER = REGISTRY.register("earthquake_summoner", () -> new EarthquakeSummonerItem());
	public static final RegistryObject<Item> MR_COOSH_SPAWN_EGG = REGISTRY.register("mr_coosh_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.MR_COOSH, -16777216, -1, new Item.Properties()));
	public static final RegistryObject<Item> ZACHARY_95_SPAWN_EGG = REGISTRY.register("zachary_95_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.ZACHARY_95, -6750208, -6737152, new Item.Properties()));
	public static final RegistryObject<Item> COSMIC_SPAWN_EGG = REGISTRY.register("cosmic_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.COSMIC, -13297295, -15202245, new Item.Properties()));
	public static final RegistryObject<Item> TORNADO_SUMMONER = REGISTRY.register("tornado_summoner", () -> new TornadoSummonerItem());
	public static final RegistryObject<Item> SINKHOLE_SUMMONER = REGISTRY.register("sinkhole_summoner", () -> new SinkholeSummonerItem());
	public static final RegistryObject<Item> VOLCANO_SUMMONER = REGISTRY.register("volcano_summoner", () -> new VolcanoSummonerItem());
	public static final RegistryObject<Item> DAPPER_MR_TOM_SPAWN_EGG = REGISTRY.register("dapper_mr_tom_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.DAPPER_MR_TOM, -16777216, -256, new Item.Properties()));
	public static final RegistryObject<Item> COIN = REGISTRY.register("coin", () -> new CoinItem());
	public static final RegistryObject<Item> TECHNOS_END_OF_WORLD_METEOR = REGISTRY.register("technos_end_of_world_meteor", () -> new TechnosEndOfWorldMeteorItem());
	public static final RegistryObject<Item> TECHNO_ITEM_DEFEATING = REGISTRY.register("techno_item_defeating", () -> new TechnoItemDefeatingItem());
	public static final RegistryObject<Item> TEST_SINKHOLE_SUMMONER = REGISTRY.register("test_sinkhole_summoner", () -> new TestSinkholeSummonerItem());
	public static final RegistryObject<Item> SOLID_LAVA_BLOCK = block(YoutubersNaturalDisastersModBlocks.SOLID_LAVA_BLOCK);
	public static final RegistryObject<Item> SOLID_WATER_BLOCK = block(YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK);
	public static final RegistryObject<Item> TECHNOS_SPLASH_POTION_OF_GAS = REGISTRY.register("technos_splash_potion_of_gas", () -> new TechnosSplashPotionOfGasItem());
	public static final RegistryObject<Item> KNARFY_SPAWN_EGG = REGISTRY.register("knarfy_spawn_egg", () -> new ForgeSpawnEggItem(YoutubersNaturalDisastersModEntities.KNARFY, -1, -11466344, new Item.Properties()));
	public static final RegistryObject<Item> TOMMYINNIT_ITEM = REGISTRY.register("tommyinnit_item", () -> new TommyinnitItemItem());
	public static final RegistryObject<Item> TOMMYINNIT_BLOCK = block(YoutubersNaturalDisastersModBlocks.TOMMYINNIT_BLOCK);
	public static final RegistryObject<Item> VOLCANO_AIR = block(YoutubersNaturalDisastersModBlocks.VOLCANO_AIR);
	public static final RegistryObject<Item> BRED = REGISTRY.register("bred", () -> new BredItem());
	public static final RegistryObject<Item> MACE = REGISTRY.register("mace", () -> new MaceItem());
	public static final RegistryObject<Item> TIME_STICK = REGISTRY.register("time_stick", () -> new TimeStickItem());
	public static final RegistryObject<Item> CRASH_ER = REGISTRY.register("crash_er", () -> new CrashErItem());
	public static final RegistryObject<Item> BLACK_HOLE_SUMMONER = REGISTRY.register("black_hole_summoner", () -> new BlackHoleSummonerItem());
	public static final RegistryObject<Item> WILD_FIRE_SUMMONER = REGISTRY.register("wild_fire_summoner", () -> new WildFireSummonerItem());
	public static final RegistryObject<Item> TIMEPHOON_SUMMONER = REGISTRY.register("timephoon_summoner", () -> new TimephoonSummonerItem());
	public static final RegistryObject<Item> BASALT = block(YoutubersNaturalDisastersModBlocks.BASALT);
	public static final RegistryObject<Item> MAGMA = block(YoutubersNaturalDisastersModBlocks.MAGMA);
	public static final RegistryObject<Item> STONE = block(YoutubersNaturalDisastersModBlocks.STONE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(COIN.get(), new ResourceLocation("youtubers_natural_disasters:coin_heads"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) CoinPropertyValueProviderProcedure.execute(itemStackToRender));
		});
	}
}
