package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class MusicP2BProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Musicmusic = 0;
		if (entity.getPersistentData().getBoolean("MusicCanPlay") == false) {
			if (YoutubersNaturalDisastersModVariables.MapVariables.get(world).PleaseWorkMusic == 0) {
				Musicmusic = Mth.nextInt(RandomSource.create(), 0, 1);
				if (Musicmusic == 1) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"stopsound @a");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:technoboss")), SoundSource.NEUTRAL, 10, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:technoboss")), SoundSource.NEUTRAL, 10, 1, false);
						}
					}
					YoutubersNaturalDisastersModVariables.MapVariables.get(world).PleaseWorkMusic = 1;
					YoutubersNaturalDisastersModVariables.MapVariables.get(world).syncData(world);
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"stopsound @a");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:bossbattle2music")), SoundSource.NEUTRAL, 10, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:bossbattle2music")), SoundSource.NEUTRAL, 10, 1, false);
						}
					}
					YoutubersNaturalDisastersModVariables.MapVariables.get(world).PleaseWorkMusic = 1;
					YoutubersNaturalDisastersModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (YoutubersNaturalDisastersModVariables.MapVariables.get(world).PleaseWorkMusic == 1) {
				if (Musicmusic == 1) {
					YoutubersNaturalDisastersMod.queueServerWork(3260, () -> {
						YoutubersNaturalDisastersModVariables.MapVariables.get(world).PleaseWorkMusic = 0;
						YoutubersNaturalDisastersModVariables.MapVariables.get(world).syncData(world);
						MusicP2Procedure.execute(world, x, y, z, entity);
					});
				} else {
					YoutubersNaturalDisastersMod.queueServerWork(4200, () -> {
						YoutubersNaturalDisastersModVariables.MapVariables.get(world).PleaseWorkMusic = 0;
						YoutubersNaturalDisastersModVariables.MapVariables.get(world).syncData(world);
						MusicP2Procedure.execute(world, x, y, z, entity);
					});
				}
			}
		}
	}
}
