
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.youtubersnaturaldisasters.item.VolcanoSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.TornadoSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.ThrowTNTItem;
import net.mcreator.youtubersnaturaldisasters.item.ThrowMeteorItem;
import net.mcreator.youtubersnaturaldisasters.item.ThrowLightningItem;
import net.mcreator.youtubersnaturaldisasters.item.SolidLavaItem;
import net.mcreator.youtubersnaturaldisasters.item.SmokeEmitterItem;
import net.mcreator.youtubersnaturaldisasters.item.SinkholeSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.SaturationFillerItem;
import net.mcreator.youtubersnaturaldisasters.item.PotionOfGasItem;
import net.mcreator.youtubersnaturaldisasters.item.MusicDiscItem;
import net.mcreator.youtubersnaturaldisasters.item.GoldenAppleGiverItem;
import net.mcreator.youtubersnaturaldisasters.item.EndOfWorldMeteorItem;
import net.mcreator.youtubersnaturaldisasters.item.EarthquakeSummonerItem;
import net.mcreator.youtubersnaturaldisasters.item.AppleOfWisdomItem;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

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
	public static final RegistryObject<Item> SOLID_LAVA_BUCKET = REGISTRY.register("solid_lava_bucket", () -> new SolidLavaItem());
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

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
