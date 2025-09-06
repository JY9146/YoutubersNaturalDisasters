
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.youtubersnaturaldisasters.potion.InvincibilityMobEffect;
import net.mcreator.youtubersnaturaldisasters.potion.EarthquakeeffectMobEffect;
import net.mcreator.youtubersnaturaldisasters.potion.DrownFastMobEffect;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class YoutubersNaturalDisastersModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<MobEffect> EARTHQUAKEEFFECT = REGISTRY.register("earthquakeeffect", () -> new EarthquakeeffectMobEffect());
	public static final RegistryObject<MobEffect> DROWN_FAST = REGISTRY.register("drown_fast", () -> new DrownFastMobEffect());
	public static final RegistryObject<MobEffect> INVINCIBILITY = REGISTRY.register("invincibility", () -> new InvincibilityMobEffect());
}
