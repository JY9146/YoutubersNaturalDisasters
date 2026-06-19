package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;

public class RandomDisasterSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		double Chance = 0;
		Chance = Mth.nextInt(RandomSource.create(), 1, 15);
		if (Chance == 1) {
			DisasterBlackHoleSpawnV1Procedure.execute(world, arguments);
		} else if (Chance == 2) {
			DisasterBlackHoleV2Procedure.execute(world, arguments);
		} else if (Chance == 3) {
			DisasterBlackHoleSpawnV3Procedure.execute(world, arguments);
		} else if (Chance == 4) {
			DisasterEarthquakeSpawnProcedure.execute(arguments);
		} else if (Chance == 5) {
			DisasterEndOfWorldMeteorSummonProcedure.execute(world, arguments);
		} else if (Chance == 6) {
			DisasterGasSpawnProcedure.execute(world, arguments);
		} else if (Chance == 7) {
			DisasterMeteorShowerProcedure.execute(world, arguments);
		} else if (Chance == 8) {
			DisasterMeteorShower2Procedure.execute(world, x, y, z, arguments);
		} else if (Chance == 9) {
			DisasterSinkholeV1SummonerProcedure.execute(world, arguments);
		} else if (Chance == 10) {
			DisasterSinkholeV2SummonerProcedure.execute(world, arguments);
		} else if (Chance == 11) {
			TimephoonSummonerRightclickedProcedure.execute(world, x, y, z);
		} else if (Chance == 12) {
			DisasterTornadoSummonerProcedure.execute(world, arguments);
		} else if (Chance == 13) {
			DisasterVolcanoV1SummonProcedure.execute(world, arguments);
		} else if (Chance == 14) {
			DisasterVolcanoV2SpawnProcedure.execute(world, arguments);
		} else if (Chance == 15) {
			DisasterWildFireSummonerProcedure.execute(world, arguments);
		}
	}
}
