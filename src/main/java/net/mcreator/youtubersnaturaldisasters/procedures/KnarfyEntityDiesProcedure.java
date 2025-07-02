package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;

public class KnarfyEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.001) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(YoutubersNaturalDisastersModItems.BRED.get()));
				entityToSpawn.setPickUpDelay(0);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
