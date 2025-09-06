package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TechnobladeEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		boolean V = false;
		if (entity instanceof TechnobladeEntity) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
				if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:techno_killing_dmg_type"))) && !damagesource.is(DamageTypes.GENERIC_KILL)) {
					if (sourceentity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("youtubers_natural_disasters:technoitemdefeating")))) {
						entity.hurt(
								new DamageSource(
										world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:techno_killing_dmg_type")))),
								20000000);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NOOOOO. It can't be! You found the only thing able to defeat me, my old cringe videos!"), false);
					} else {
						if (world instanceof Level)
							((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:technobladeneverdies")), SoundSource.AMBIENT, 10, 1);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You can never defeat me. Prepare to die. I am the final boss, and this is my final phase!"), false);
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 10) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Mr Technodad> Are you winning son?"), false);
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
		}
	}
}
