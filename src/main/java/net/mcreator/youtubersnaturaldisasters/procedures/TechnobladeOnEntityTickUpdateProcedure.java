package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;
import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

import java.util.Comparator;

public class TechnobladeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity Item_ = null;
		ItemStack Item_item = ItemStack.EMPTY;
		double Grab_Distance = 0;
		double Look_Timmer = 0;
		double Number12 = 0;
		Grab_Distance = 4;
		Look_Timmer = 20;
		if (entity instanceof Mob _mobEnt0 && _mobEnt0.isAggressive()) {
			if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
				Item_ = (Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.5, 20.5, 20.5), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
				Item_item = (Item_ instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy();
				if (Item_item.getItem() == YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get() || Item_item.getItem() == YoutubersNaturalDisastersModItems.END_OF_WORLD_METEOR.get()
						|| Item_item.getItem() == YoutubersNaturalDisastersModItems.COIN.get()) {
					if (entity instanceof TechnobladeEntity _datEntSetL)
						_datEntSetL.getEntityData().set(TechnobladeEntity.DATA_Hostilty, false);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() == 1) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = Item_item.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (!Item_.level().isClientSide())
							Item_.discard();
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						YoutubersNaturalDisastersMod.queueServerWork((int) Look_Timmer, () -> {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount(0);
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							TechnoTradeProcedure.execute(world, x, y, z);
						});
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You have earned my trust for now, since you have provided me with these important materials. But don't attack me again."), false);
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() == 0) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = Item_item.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (!Item_.level().isClientSide())
							Item_.discard();
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						YoutubersNaturalDisastersMod.queueServerWork((int) Look_Timmer, () -> {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount(0);
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							TechnoTradeProcedure.execute(world, x, y, z);
						});
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You have earned my trust for now, since you have provided me with these important materials. But don't attack me again."), false);
					}
				}
			}
			YoutubersNaturalDisastersMod.queueServerWork(40, () -> {
				if (entity instanceof TechnobladeEntity _datEntSetL)
					_datEntSetL.getEntityData().set(TechnobladeEntity.DATA_Hostilty, true);
			});
		}
		if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
			Item_ = (Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, z), 20.5, 20.5, 20.5), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			Item_item = (Item_ instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).copy();
			if (Item_item.getItem() == YoutubersNaturalDisastersModItems.SPLASH_POTION_OF_GAS.get() || Item_item.getItem() == YoutubersNaturalDisastersModItems.END_OF_WORLD_METEOR.get()
					|| Item_item.getItem() == YoutubersNaturalDisastersModItems.COIN.get()) {
				if (entity instanceof TechnobladeEntity _datEntSetL)
					_datEntSetL.getEntityData().set(TechnobladeEntity.DATA_Hostilty, false);
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() == 1) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = Item_item.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (!Item_.level().isClientSide())
						Item_.discard();
					if (entity instanceof Mob) {
						try {
							((Mob) entity).setTarget(null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					YoutubersNaturalDisastersMod.queueServerWork((int) Look_Timmer, () -> {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount(0);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						TechnoTradeProcedure.execute(world, x, y, z);
					});
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Pleasure doing buisness with you."), false);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() == 0) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = Item_item.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (!Item_.level().isClientSide())
						Item_.discard();
					if (entity instanceof Mob) {
						try {
							((Mob) entity).setTarget(null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					YoutubersNaturalDisastersMod.queueServerWork((int) Look_Timmer, () -> {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount(0);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						TechnoTradeProcedure.execute(world, x, y, z);
					});
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Pleasure doing buisness with you."), false);
				}
			}
			YoutubersNaturalDisastersMod.queueServerWork(40, () -> {
				if (entity instanceof TechnobladeEntity _datEntSetL)
					_datEntSetL.getEntityData().set(TechnobladeEntity.DATA_Hostilty, true);
			});
		}
	}
}
