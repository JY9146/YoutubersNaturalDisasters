
package net.mcreator.youtubersnaturaldisasters.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModItems;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModFluids;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModFluidTypes;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public abstract class SolidLavaFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> YoutubersNaturalDisastersModFluidTypes.SOLID_LAVA_TYPE.get(), () -> YoutubersNaturalDisastersModFluids.SOLID_LAVA.get(),
			() -> YoutubersNaturalDisastersModFluids.FLOWING_SOLID_LAVA.get()).explosionResistance(100f).tickRate(100000).bucket(() -> YoutubersNaturalDisastersModItems.SOLID_LAVA_BUCKET.get())
			.block(() -> (LiquidBlock) YoutubersNaturalDisastersModBlocks.SOLID_LAVA.get());

	private SolidLavaFluid() {
		super(PROPERTIES);
	}

	public static class Source extends SolidLavaFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SolidLavaFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
