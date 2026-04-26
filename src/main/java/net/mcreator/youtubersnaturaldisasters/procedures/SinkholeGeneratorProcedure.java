package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class SinkholeGeneratorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double yy = 0;
		double Block_DstroyChance = 0;
		double Every__PerUptdate = 0;
		double Fall_Chance = 0;
		double Random_Number = 0;
		Entity Entity_Variable = null;
		if (entity.tickCount % 70 == 0) {
			entity.setInvulnerable(true);
			if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if (entity.getPersistentData().getDouble("BlockCount") < 20) {
				entity.getPersistentData().putBoolean("Waiter", true);
				SinkholeGeneratorP2Procedure.execute(world, x, y, z, entity);
			} else {
				YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Logic_Variable = true;
				YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
