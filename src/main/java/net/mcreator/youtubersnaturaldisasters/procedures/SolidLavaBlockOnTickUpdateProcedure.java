package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

public class SolidLavaBlockOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		YoutubersNaturalDisastersMod.queueServerWork(Mth.nextInt(RandomSource.create(), 5, 7), () -> {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		});
		YoutubersNaturalDisastersMod.queueServerWork(7, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_LAVA_BLOCK.get()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		});
	}
}
