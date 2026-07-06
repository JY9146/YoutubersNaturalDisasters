package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModGameRules;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class DisasterVolcanoV2SpawnProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double Chance = 0;
		if (world.getLevelData().getGameRules().getBoolean(YoutubersNaturalDisastersModGameRules.NATURAL_DISASTERS_ANTI_LAG) == false) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_GROUND_MESSER_V_2.get().spawn(_level, BlockPos.containing((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getX(), (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getY(), (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_GENERATOR_V_2P_2.get().spawn(_level, BlockPos.containing((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getX(), (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getY(), (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getZ()), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_GENERATOR_V_2.get().spawn(_level, BlockPos.containing((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getX(), (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getY(), (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "target");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getZ()), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		YoutubersNaturalDisastersMod.queueServerWork(60, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.VOLCANO_LAVA_V_2.get().spawn(_level, BlockPos.containing((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getX(), (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getY(), (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "target");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		});
	}
}
