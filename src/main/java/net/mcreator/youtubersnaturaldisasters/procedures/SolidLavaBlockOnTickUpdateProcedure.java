package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class SolidLavaBlockOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		YoutubersNaturalDisastersMod.queueServerWork(Mth.nextInt(RandomSource.create(), 5, 10), () -> {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		});
	}
}
