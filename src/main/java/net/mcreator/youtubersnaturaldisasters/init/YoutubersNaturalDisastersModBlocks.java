
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.youtubersnaturaldisasters.block.VolcanoAirBlock;
import net.mcreator.youtubersnaturaldisasters.block.TommyinnitBlockBlock;
import net.mcreator.youtubersnaturaldisasters.block.StoneBlock;
import net.mcreator.youtubersnaturaldisasters.block.SolidWaterBlockBlock;
import net.mcreator.youtubersnaturaldisasters.block.SolidLavaBlockBlock;
import net.mcreator.youtubersnaturaldisasters.block.SmokeBlock;
import net.mcreator.youtubersnaturaldisasters.block.MagmaBlock;
import net.mcreator.youtubersnaturaldisasters.block.HotMeteorBlock;
import net.mcreator.youtubersnaturaldisasters.block.HotMeteor2Block;
import net.mcreator.youtubersnaturaldisasters.block.ColdMeteorBlock;
import net.mcreator.youtubersnaturaldisasters.block.ColdMeteor2Block;
import net.mcreator.youtubersnaturaldisasters.block.BasalttBlock;
import net.mcreator.youtubersnaturaldisasters.block.BasaltBlock;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class YoutubersNaturalDisastersModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<Block> COLD_METEOR = REGISTRY.register("cold_meteor", () -> new ColdMeteorBlock());
	public static final RegistryObject<Block> HOT_METEOR = REGISTRY.register("hot_meteor", () -> new HotMeteorBlock());
	public static final RegistryObject<Block> SOLID_LAVA_BLOCK = REGISTRY.register("solid_lava_block", () -> new SolidLavaBlockBlock());
	public static final RegistryObject<Block> SOLID_WATER_BLOCK = REGISTRY.register("solid_water_block", () -> new SolidWaterBlockBlock());
	public static final RegistryObject<Block> TOMMYINNIT_BLOCK = REGISTRY.register("tommyinnit_block", () -> new TommyinnitBlockBlock());
	public static final RegistryObject<Block> EMPTY = REGISTRY.register("empty", () -> new VolcanoAirBlock());
	public static final RegistryObject<Block> BASALT = REGISTRY.register("basalt", () -> new BasaltBlock());
	public static final RegistryObject<Block> MAGMA = REGISTRY.register("magma", () -> new MagmaBlock());
	public static final RegistryObject<Block> STONE = REGISTRY.register("stone", () -> new StoneBlock());
	public static final RegistryObject<Block> BASALTT = REGISTRY.register("basaltt", () -> new BasalttBlock());
	public static final RegistryObject<Block> HOT_METEOR_2 = REGISTRY.register("hot_meteor_2", () -> new HotMeteor2Block());
	public static final RegistryObject<Block> COLD_METEOR_2 = REGISTRY.register("cold_meteor_2", () -> new ColdMeteor2Block());
	public static final RegistryObject<Block> SMOKE = REGISTRY.register("smoke", () -> new SmokeBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			SolidWaterBlockBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			SolidWaterBlockBlock.itemColorLoad(event);
		}
	}
}
