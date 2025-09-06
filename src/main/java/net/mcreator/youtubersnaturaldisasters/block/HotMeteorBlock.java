
package net.mcreator.youtubersnaturaldisasters.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.procedures.HotMeteorEntityWalksOnTheBlockProcedure;

public class HotMeteorBlock extends Block {
	public HotMeteorBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1, 3600000).lightLevel(s -> 6).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 40;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		HotMeteorEntityWalksOnTheBlockProcedure.execute(world, entity);
	}
}
