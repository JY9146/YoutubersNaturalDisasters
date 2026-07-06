package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModBlocks;

public class SolidWaterBlockOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
		}
		if ((world.getFluidState(BlockPos.containing(x, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("falling") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:small_flowers")))
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:large_flowers")))
						&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get())) {
			world.setBlock(BlockPos.containing(x + 1, y, z), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:small_flowers")))
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:large_flowers")))
						&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get())) {
			world.setBlock(BlockPos.containing(x, y, z + 1), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:small_flowers")))
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:large_flowers")))
						&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get())) {
			world.setBlock(BlockPos.containing(x - 1, y, z), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:small_flowers")))
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:large_flowers")))
						&& (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get())
								|| !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCKK.get()))) {
			world.setBlock(BlockPos.containing(x, y - 1, z), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:small_flowers"))) || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:large_flowers")))
						&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == YoutubersNaturalDisastersModBlocks.SOLID_WATER_BLOCK.get())) {
			world.setBlock(BlockPos.containing(x, y, z - 1), YoutubersNaturalDisastersModBlocks.EMPTY.get().defaultBlockState(), 3);
		}
	}
}
