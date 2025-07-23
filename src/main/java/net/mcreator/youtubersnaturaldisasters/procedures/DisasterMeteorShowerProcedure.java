package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModEntities;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class DisasterMeteorShowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Chance = 0;
		for (int index0 = 0; index0 < 1; index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.METEOR.get().spawn(_level, BlockPos.containing(x, y + 20, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index1 = 0; index1 < 3; index1++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = YoutubersNaturalDisastersModEntities.METEOR.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -10, 10), y + 20, z + Mth.nextInt(RandomSource.create(), -10, 10)),
						MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		YoutubersNaturalDisastersMod.queueServerWork(5, () -> {
			for (int index2 = 0; index2 < 100; index2++) {
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
		});
	}
}
