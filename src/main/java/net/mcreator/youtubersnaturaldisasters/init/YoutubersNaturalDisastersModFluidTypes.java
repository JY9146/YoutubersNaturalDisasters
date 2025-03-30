
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.youtubersnaturaldisasters.fluid.types.SolidLavaFluidType;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class YoutubersNaturalDisastersModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<FluidType> SOLID_LAVA_TYPE = REGISTRY.register("solid_lava", () -> new SolidLavaFluidType());
}
