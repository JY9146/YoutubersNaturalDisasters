package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class TechnobladeEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return false;
		boolean V = false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
			if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:techno_killing_dmg_type"))) || !damagesource.is(DamageTypes.GENERIC_KILL)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) Double.POSITIVE_INFINITY, 255, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) Double.POSITIVE_INFINITY, 2));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, (int) Double.POSITIVE_INFINITY, 3));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:technobladeneverdies")), SoundSource.AMBIENT, 10, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:technobladeneverdies")), SoundSource.AMBIENT, 10, 1, false);
					}
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You can never defeat me. Prepare to die. I am the final boss, and this is my final phase!"), false);
			}
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (!world.isClientSide()) {
					if (Math.random() < 0.001) {
						sourceentity.hurt(
								new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:techno_bullied_you")))),
								20000000);
					}
					if (Math.random() < 0.001) {
						sourceentity.hurt(
								new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:blood_god_kill")))),
								20000000);
					}
					if (Math.random() < 0.001) {
						sourceentity.hurt(
								new DamageSource(
										world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:orphan_obliterator_damage")))),
								20000000);
					}
					if (Math.random() < 0.001) {
						sourceentity.hurt(
								new DamageSource(
										world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:axe_of_peace_wasnt_peaceful")))),
								20000000);
					}
					if (Math.random() < 0.001) {
						sourceentity.hurt(
								new DamageSource(
										world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:tooth_pick_cleaning_teeth")))),
								20000000);
					}
				}
			}
			world = _worldorig;
		}
		return !damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:techno_killing_dmg_type")));
	}
}
