package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class ThrowTNTRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, (y + 1), z, 10, Level.ExplosionInteraction.NONE);
		}
	}
}
