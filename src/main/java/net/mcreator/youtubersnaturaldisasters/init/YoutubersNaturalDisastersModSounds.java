
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class YoutubersNaturalDisastersModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<SoundEvent> CRAGDYNASUBSCRIBE = REGISTRY.register("cragdynasubscribe", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("youtubers_natural_disasters", "cragdynasubscribe")));
	public static final RegistryObject<SoundEvent> CRAGDYNADEATH = REGISTRY.register("cragdynadeath", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("youtubers_natural_disasters", "cragdynadeath")));
	public static final RegistryObject<SoundEvent> CAVEMANFILMSWHATEVERYOUWANT = REGISTRY.register("cavemanfilmswhateveryouwant",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("youtubers_natural_disasters", "cavemanfilmswhateveryouwant")));
	public static final RegistryObject<SoundEvent> DEFNOTARICKROLLATALL = REGISTRY.register("defnotarickrollatall", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("youtubers_natural_disasters", "defnotarickrollatall")));
	public static final RegistryObject<SoundEvent> THATSWHATILIKETOMMY = REGISTRY.register("thatswhatiliketommy", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("youtubers_natural_disasters", "thatswhatiliketommy")));
}
