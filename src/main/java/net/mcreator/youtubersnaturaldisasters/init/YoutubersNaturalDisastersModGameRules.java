
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YoutubersNaturalDisastersModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> NATURAL_DISASTER_SPAWNING = GameRules.register("naturalDisasterSpawning", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
