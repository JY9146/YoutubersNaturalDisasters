package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class VolcanoV2GenInitalSpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double Every__PerUptdate = 0;
		double Block_DstroyChance = 0;
		double Fall_Chance = 0;
		YoutubersNaturalDisastersModVariables.MapVariables.get(world).Consistant = Mth.nextInt(RandomSource.create(), 35, 39);
		YoutubersNaturalDisastersModVariables.MapVariables.get(world).syncData(world);
		entity.getPersistentData().putDouble("SizeWidthV", YoutubersNaturalDisastersModVariables.MapVariables.get(world).Consistant);
		YoutubersNaturalDisastersModVariables.WorldVariables.get(world).VH = Mth.nextInt(RandomSource.create(), 59, 62);
		YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
	}
}
