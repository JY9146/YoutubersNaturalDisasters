package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class SmokeBlockOnTickUpdateProcedure {
	@SubscribeEvent
	public static void updateWorldTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.START)
			return;
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 pos = entity.getPosition(minecraft.getPartialTick());
			execute(event, level, pos.x(), pos.y(), pos.z());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double XandZofs = 0;
		double Yofs = 0;
		double justzoffset = 0;
		XandZofs = Mth.nextDouble(RandomSource.create(), -0.33333, 0.33333);
		justzoffset = Mth.nextDouble(RandomSource.create(), -0.33333, 0.33333);
		Yofs = Mth.nextDouble(RandomSource.create(), 0, 2);
		int horizontalRadiusSquare = (int) 31 - 1;
		int verticalRadiusSquare = (int) 81 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int yi = -yIterationsSquare; yi <= yIterationsSquare; yi++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if ((world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi))).getBlock() == YoutubersNaturalDisastersModBlocks.SMOKE.get()) {
						if (world.isClientSide()) {
							world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + xi + 0.5 + XandZofs), (y + yi + Yofs), (z + zi + 0.5 + justzoffset), 0, 0.12, 0);
						}
					}
				}
			}
		}
	}
}
