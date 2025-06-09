package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

public class TimeStickRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		YoutubersNaturalDisastersModVariables.WorldVariables.get(world).JustPickONE = YoutubersNaturalDisastersModVariables.WorldVariables.get(world).JustPickONE + 1;
		YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
		TickSlowProcedure.execute(world, x, y, z);
		if (YoutubersNaturalDisastersModVariables.WorldVariables.get(world).JustPickONE > 3) {
			YoutubersNaturalDisastersModVariables.WorldVariables.get(world).JustPickONE = 0;
			YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
