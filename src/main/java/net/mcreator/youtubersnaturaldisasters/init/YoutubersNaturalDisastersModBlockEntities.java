
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.youtubersnaturaldisasters.block.entity.VolcanoAirBlockEntity;
import net.mcreator.youtubersnaturaldisasters.block.entity.SolidWaterBlockBlockEntity;
import net.mcreator.youtubersnaturaldisasters.block.entity.SolidLavaBlockBlockEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class YoutubersNaturalDisastersModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SOLID_LAVA_BLOCK = register("solid_lava_block", YoutubersNaturalDisastersModBlocks.SOLID_LAVA_BLOCK, SolidLavaBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOLID_WATER_BLOCK = register("solid_water_block", YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK, SolidWaterBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VOLCANO_AIR = register("volcano_air", YoutubersNaturalDisastersModBlocks.VOLCANO_AIR, VolcanoAirBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
