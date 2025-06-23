package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;

public class VolcanoV2GenInitalSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double Every__PerUptdate = 0;
		double Block_DstroyChance = 0;
		double Fall_Chance = 0;
		entity.getPersistentData().putDouble("SizeWidthV", 37);
	}
}
