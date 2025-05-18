package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;
import net.mcreator.youtubersnaturaldisasters.entity.TechnosPotionOfGasEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;
import net.mcreator.youtubersnaturaldisasters.entity.PiglinSpawnerEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MadPiglinEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

import java.util.List;
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
		double X = 0;
		double Z = 0;
		double Yaw = 0;
		Grab_Distance = 4;
		Look_Timmer = 20;
		if (entity instanceof Mob _mobEnt0 && _mobEnt0.isAggressive() && !((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 180)) {
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
		entity.fallDistance = 0;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if (!(entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 0)) {
				entity.getPersistentData().putDouble("MODID:TechnoBossPatternTick", (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") - 1));
			}
			if (entity.getPersistentData().getBoolean("MODID:TechnoAttackingMelee") == true) {
				if (!(entity.getPersistentData().getDouble("MODID:TechnoAttackingMeleeTimmer") == 0)) {
					entity.getPersistentData().putDouble("MODID:TechnoAttackingMeleeTimmer", (entity.getPersistentData().getDouble("MODID:TechnoAttackingMeleeTimmer") - 1));
				} else {
					entity.getPersistentData().putBoolean("MODID:TechnoAttackingMelee", false);
					if (entity instanceof Mob _entity)
						_entity.getNavigation().stop();
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), 1.2);
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 0 && entity.getPersistentData().getBoolean("MODID:TechnoAttackingMelee") == false) {
				if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 0) {
					entity.getPersistentData().putDouble("MODID:TechnoBossTick", 300);
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else {
					entity.getPersistentData().putDouble("MODID:TechnoBossTick", (entity.getPersistentData().getDouble("MODID:TechnoBossTick") - 1));
				}
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 250) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.ENDER_PEARL).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putDouble("MODID:TechnoBossTick", 249);
				entity.getPersistentData().putDouble("MODID:TechnoBossPatternTick", 42);
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 249) {
				if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") < 36 && entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") > 30) {
					{
						Entity _ent = entity;
						_ent.setYRot(entity.getYRot());
						_ent.setXRot(-90);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 24) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getProjectile(Level level, Entity shooter) {
								Projectile entityToSpawn = new ThrownEnderpearl(EntityType.ENDER_PEARL, level);
								entityToSpawn.setOwner(shooter);
								return entityToSpawn;
							}
						}.getProjectile(projectileLevel, entity);
						_entityToSpawn.setPos(x, (y + 1), z);
						_entityToSpawn.shoot(0, 2, 0, 2, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_pearl.throw")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_pearl.throw")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 18) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES,
							new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getBbHeight() / 2),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 12) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.ENDER_PEARL).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 6) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES,
							new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getBbHeight() / 2),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_pearl.throw")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_pearl.throw")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getProjectile(Level level, Entity shooter) {
									Projectile entityToSpawn = new ThrownEnderpearl(EntityType.ENDER_PEARL, level);
									entityToSpawn.setOwner(shooter);
									return entityToSpawn;
								}
							}.getProjectile(projectileLevel, entity);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.getPersistentData().putDouble("MODID:TechnoAttackingMeleeTimmer", 85);
					entity.getPersistentData().putBoolean("MODID:TechnoAttackingMelee", true);
					YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					});
				}
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 200) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.CROSSBOW).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.MULTISHOT, 0);
				entity.getPersistentData().putDouble("MODID:TechnoBossTick", 199);
				entity.getPersistentData().putDouble("MODID:TechnoBossPatternTick", 50);
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 199) {
				if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 46 || entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 30 || entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 10) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.CROSSBOW).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.MULTISHOT, 0);
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + entity.getBbHeight() + 1), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
						Yaw = entity.getYRot();
						{
							Entity _ent = entity;
							_ent.setYRot((float) (entity.getYRot() - 30));
							_ent.setXRot((float) (entity.getXRot() + 2));
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						for (int index0 = 0; index0 < 3; index0++) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new SpectralArrow(EntityType.SPECTRAL_ARROW, level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 5, 1);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 1);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							{
								Entity _ent = entity;
								_ent.setYRot((float) (entity.getYRot() + 30));
								_ent.setXRot(entity.getXRot());
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						}
						{
							Entity _ent = entity;
							_ent.setYRot((float) Yaw);
							_ent.setXRot((float) (entity.getXRot() + 2));
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(YoutubersNaturalDisastersModItems.TECHNOS_SPLASH_POTION_OF_GAS.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
								((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + entity.getBbHeight() + 1), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
						Yaw = entity.getYRot();
						{
							Entity _ent = entity;
							_ent.setYRot((float) (entity.getYRot() - 30));
							_ent.setXRot((float) (entity.getXRot() + 2));
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.splash_potion.throw")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.splash_potion.throw")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new TechnosPotionOfGasEntity(YoutubersNaturalDisastersModEntities.TECHNOS_POTION_OF_GAS.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 0, 1);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 1);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						{
							Entity _ent = entity;
							_ent.setYRot((float) (entity.getYRot() + 30));
							_ent.setXRot(entity.getXRot());
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 26) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.TNT).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 20) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1.2, (entity.getDeltaMovement().z())));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 6, 2, 1, 2, 0);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 9);
							}
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 150) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.SPLASH_POTION).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putDouble("MODID:TechnoBossTick", 149);
				entity.getPersistentData().putDouble("MODID:TechnoBossPatternTick", 55);
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 149) {
				if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 38 || entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 32 || entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 26
						|| entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 20 || entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 14) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					{
						Entity _ent = entity;
						_ent.setYRot(Mth.nextInt(RandomSource.create(), -360, 360));
						_ent.setXRot(30);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new PiglinSpawnerEntity(YoutubersNaturalDisastersModEntities.PIGLIN_SPAWNER.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.egg.throw")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.egg.throw")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					YoutubersNaturalDisastersMod.queueServerWork(5, () -> {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.PIGLIN_BRUTE_SPAWN_EGG).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					});
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 54) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon potion ~ ~1.5 ~ {Item:{id:splash_potion,tag:{CustomPotionColor:16383998}},Motion:[0d,0.3d,0d]}");
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.setNoGravity(true);
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 40) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y + 6, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.HOSTILE, 2, 1);
						} else {
							_level.playLocalSound(x, (y + 6), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.HOSTILE, 2, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.HOSTILE, 2, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.HOSTILE, 2, 1, false);
						}
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (y + 6), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (y + 6), z, _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.PIGLIN_BRUTE_SPAWN_EGG).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.SHIELD).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.setShiftKeyDown(true);
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 3) {
					if (!world.getEntitiesOfClass(MadPiglinEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
						entity.getPersistentData().putDouble("MODID:TechnoBossPatternTick", 9);
						entity.getPersistentData().putDouble("MODID:TechnoBossTick", 149);
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						entity.setShiftKeyDown(false);
						entity.setNoGravity(false);
					}
				}
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 100) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.SPLASH_POTION).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putDouble("MODID:TechnoBossTick", 99);
				entity.getPersistentData().putDouble("MODID:TechnoBossPatternTick", 70);
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 99) {
				if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 64) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon potion ~ ~1.5 ~ {Item:{id:splash_potion,tag:{CustomPotionColor:16383998}},Motion:[0d,0.3d,0d]}");
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 1, false, false));
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 55) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.SPLASH_POTION).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 50) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon potion ~ ~1.5 ~ {Item:{id:splash_potion,tag:{CustomPotionColor:16383998}},Motion:[0d,0.3d,0d]}");
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9999, 0, false, false));
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 45) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.SPLASH_POTION).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 40) {
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon potion ~ ~1.5 ~ {Item:{id:splash_potion,tag:{CustomPotionColor:16383998}},Motion:[0d,0.3d,0d]}");
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9999, 1, false, false));
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 35) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Technoblade> We're gaming"), false);
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.DIAMOND_AXE).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 30) {
					entity.getPersistentData().putDouble("MODID:TechnoAttackingMeleeTimmer", 29);
					entity.getPersistentData().putBoolean("MODID:TechnoAttackingMelee", true);
				} else if (entity.getPersistentData().getDouble("MODID:TechnoBossPatternTick") == 0) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DAMAGE_BOOST);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
				}
			}
			if (entity.getPersistentData().getDouble("MODID:TechnoBossTick") == 50) {
				entity.getPersistentData().putDouble("MODID:TechnoBossTick", 1);
				if (entity.getPersistentData().getDouble("MODID:TechnoPhase") == 1) {
					if (entity.getPersistentData().getBoolean("MODID:TechnoBossHasSpawnedOprphan") == false) {
						entity.getPersistentData().putBoolean("MODID:TechnoBossHasSpawnedOprphan", true);
						X = entity.getX() + Mth.nextInt(RandomSource.create(), -7, 7);
						Z = entity.getZ() + Mth.nextInt(RandomSource.create(), -7, 7);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(X, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) X, (int) Z), Z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = YoutubersNaturalDisastersModEntities.ORPHAN.get().spawn(_level, BlockPos.containing(X, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) X, (int) Z), Z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
			}
		}
	}
}
