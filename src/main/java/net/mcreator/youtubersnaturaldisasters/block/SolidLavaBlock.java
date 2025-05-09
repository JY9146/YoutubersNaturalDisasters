
package net.mcreator.youtubersnaturaldisasters.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.procedures.SolidLavaOnTickUpdateProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.SolidLavaMobplayerCollidesBlockProcedure;
import net.mcreator.youtubersnaturaldisasters.init.YoutubersNaturalDisastersModFluids;

public class SolidLavaBlock extends LiquidBlock {
	public SolidLavaBlock() {
		super(() -> YoutubersNaturalDisastersModFluids.SOLID_LAVA.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100f).lightLevel(s -> 15).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 12;
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		SolidLavaOnTickUpdateProcedure.execute();
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		SolidLavaMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}
