package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModMobEffects;

import java.util.List;
import java.util.Comparator;

public class TubboOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player && !(entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(YoutubersNaturalDisastersModMobEffects.XRAY_POWERS.get()))) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(YoutubersNaturalDisastersModMobEffects.XRAY_POWERS.get(), 300, 1));
				}
			}
		}
	}
}
