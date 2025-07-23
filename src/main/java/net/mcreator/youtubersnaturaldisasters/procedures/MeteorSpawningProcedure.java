package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModGameRules;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MeteorSpawningProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Chance = 0;
		if (world.getLevelData().getGameRules().getBoolean(YoutubersNaturalDisastersModGameRules.NATURAL_DISASTER_SPAWNING)) {
			if (world instanceof ServerLevel _origLevel) {
				LevelAccessor _worldorig = world;
				world = _origLevel.getServer().getLevel(Level.OVERWORLD);
				if (world != null) {
					if (Math.random() < 0.0001) {
						Chance = Mth.nextInt(RandomSource.create(), 1, 2);
						if (Chance == 1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = YoutubersNaturalDisastersModEntities.METEOR.get().spawn(_level, BlockPos.containing(x, y + 20, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
						if (Chance == 2) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = YoutubersNaturalDisastersModEntities.METEOR.get().spawn(_level, BlockPos.containing(
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos()
												.getX(),
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()
												+ 20,
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos()
												.getZ()),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
					entity.getPersistentData().putDouble("tagName1", (entity.getPersistentData().getDouble("tagName1") + 1));
					if (entity.getPersistentData().getDouble("tagName1") > 5) {
						for (int index0 = 0; index0 < 100; index0++) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[type=item,nbt={Item:{id:\"youtubers_natural_disasters:hot_meteor\"}}]");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[type=item,nbt={Item:{id:\"youtubers_natural_disasters:cold_meteor\"}}]");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[type=item,nbt={Item:{id:\"minecraft:obsidian\"}}]");
						}
					}
					if (Math.random() < 0.00005) {
						Chance = Mth.nextInt(RandomSource.create(), 1, 2);
						if (Chance == 1) {
							for (int index1 = 0; index1 < 4; index1++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = YoutubersNaturalDisastersModEntities.METEOR.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -20, 20), y + 20, z + Mth.nextInt(RandomSource.create(), -20, 20)),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
						if (Chance == 2) {
							for (int index2 = 0; index2 < 4; index2++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = YoutubersNaturalDisastersModEntities.METEOR
											.get().spawn(
													_level, BlockPos
															.containing(
																	entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY,
																					entity))
																			.getBlockPos().getX() + Mth.nextInt(RandomSource.create(), -20, 20),
																	entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY,
																					entity))
																			.getBlockPos().getY() + 20,
																	entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity))
																			.getBlockPos().getZ() + Mth.nextInt(RandomSource.create(), -20, 20)),
													MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
					}
					entity.getPersistentData().putDouble("tagName2", (entity.getPersistentData().getDouble("tagName2") + 1));
					if (entity.getPersistentData().getDouble("tagName2") > 5) {
						for (int index3 = 0; index3 < 100; index3++) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[type=item,nbt={Item:{id:\"youtubers_natural_disasters:hot_meteor\"}}]");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[type=item,nbt={Item:{id:\"youtubers_natural_disasters:cold_meteor\"}}]");
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"kill @e[type=item,nbt={Item:{id:\"minecraft:obsidian\"}}]");
						}
					}
				}
				world = _worldorig;
			}
		}
	}
}
