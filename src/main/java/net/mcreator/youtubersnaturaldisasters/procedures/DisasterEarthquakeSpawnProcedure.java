package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModMobEffects;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class DisasterEarthquakeSpawnProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(YoutubersNaturalDisastersModMobEffects.EARTHQUAKEEFFECT.get(), 100, 0, false, false));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
