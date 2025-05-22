package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class KnarfyOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double BreakingMinecraft = 0;
		BreakingMinecraft = Mth.nextInt(RandomSource.create(), 1, 7);
		if (BreakingMinecraft == 1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound1")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound1")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		} else if (BreakingMinecraft == 2) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound2")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound2")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		} else if (BreakingMinecraft == 3) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound3")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound3")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		} else if (BreakingMinecraft == 4) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound4")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound4")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		} else if (BreakingMinecraft == 5) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound5")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound5")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		} else if (BreakingMinecraft == 6) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound6")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound6")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound7")), SoundSource.NEUTRAL, 10, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("youtubers_natural_disasters:knarfysound7")), SoundSource.NEUTRAL, 10, 1, false);
				}
			}
		}
	}
}
