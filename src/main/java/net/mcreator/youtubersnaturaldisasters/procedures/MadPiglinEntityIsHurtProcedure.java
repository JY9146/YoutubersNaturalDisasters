package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class MadPiglinEntityIsHurtProcedure {
	public static boolean execute(DamageSource damagesource) {
		if (damagesource == null)
			return false;
		return !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:technos_inhailed_too_much_gas")));
	}
}
