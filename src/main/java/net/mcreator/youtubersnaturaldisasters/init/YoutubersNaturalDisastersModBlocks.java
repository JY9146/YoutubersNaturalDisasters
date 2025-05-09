
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.youtubersnaturaldisasters.block.SolidLavaBlockBlock;
import net.mcreator.youtubersnaturaldisasters.block.SolidLavaBlock;
import net.mcreator.youtubersnaturaldisasters.block.HotMeteorBlock;
import net.mcreator.youtubersnaturaldisasters.block.ColdMeteorBlock;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class YoutubersNaturalDisastersModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<Block> COLD_METEOR = REGISTRY.register("cold_meteor", () -> new ColdMeteorBlock());
	public static final RegistryObject<Block> HOT_METEOR = REGISTRY.register("hot_meteor", () -> new HotMeteorBlock());
	public static final RegistryObject<Block> SOLID_LAVA = REGISTRY.register("solid_lava", () -> new SolidLavaBlock());
	public static final RegistryObject<Block> SOLID_LAVA_BLOCK = REGISTRY.register("solid_lava_block", () -> new SolidLavaBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
