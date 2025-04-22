package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModMobEffects;

import java.util.ArrayList;

public class EarthquakeSummonerRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(YoutubersNaturalDisastersModMobEffects.EARTHQUAKEEFFECT.get(), 100, 1, false, false));
		}
	}
}
