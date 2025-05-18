package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Technobossfight1Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TechnobladeEntity) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
				if (!(entity.getPersistentData().getDouble("MODID:TechnoPhase") == 1)) {
					entity.getPersistentData().putDouble("MODID:TechnoPhase", 1);
					if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
							&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
							&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
							&& !((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("<Technoblade> Prepare to die!"), false);
						entity.getPersistentData().putDouble("MODID:TechnoBossTick", (-12));
						entity.getPersistentData().putBoolean("MODID:TechnoAttackingMelee", true);
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
						YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.NETHERITE_BOOTS).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
							YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
								if (entity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(0, new ItemStack(Items.NETHERITE_BOOTS));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
									}
								}
								(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack = new ItemStack(Items.NETHERITE_LEGGINGS).copy();
										_setstack.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
										if (entity instanceof LivingEntity _entity)
											_entity.swing(InteractionHand.MAIN_HAND, true);
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(1, new ItemStack(Items.NETHERITE_LEGGINGS));
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
											}
										}
										(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1, false);
											}
										}
										YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
											if (entity instanceof LivingEntity _entity) {
												ItemStack _setstack = new ItemStack(Items.NETHERITE_CHESTPLATE).copy();
												_setstack.setCount(1);
												_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
												if (_entity instanceof Player _player)
													_player.getInventory().setChanged();
											}
											YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
												if (entity instanceof LivingEntity _entity)
													_entity.swing(InteractionHand.MAIN_HAND, true);
												{
													Entity _entity = entity;
													if (_entity instanceof Player _player) {
														_player.getInventory().armor.set(2, new ItemStack(Items.NETHERITE_CHESTPLATE));
														_player.getInventory().setChanged();
													} else if (_entity instanceof LivingEntity _living) {
														_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
													}
												}
												(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1, false);
													}
												}
												YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
													if (entity instanceof LivingEntity _entity) {
														ItemStack _setstack = new ItemStack(Items.NETHERITE_HELMET).copy();
														_setstack.setCount(1);
														_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
														if (_entity instanceof Player _player)
															_player.getInventory().setChanged();
													}
													YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
														if (entity instanceof LivingEntity _entity)
															_entity.swing(InteractionHand.MAIN_HAND, true);
														{
															Entity _entity = entity;
															if (_entity instanceof Player _player) {
																_player.getInventory().armor.set(3, new ItemStack(Items.NETHERITE_HELMET));
																_player.getInventory().setChanged();
															} else if (_entity instanceof LivingEntity _living) {
																_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
															}
														}
														(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite")), SoundSource.HOSTILE, 1, 1, false);
															}
														}
														YoutubersNaturalDisastersMod.queueServerWork(6, () -> {
															entity.getPersistentData().putDouble("MODID:TechnoBossTick", 0);
														});
													});
												});
											});
										});
									});
								});
							});
						});
					}
				}
			}
		}
	}
}
