
package net.mcreator.youtubersnaturaldisasters.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.youtubersnaturaldisasters.procedures.VolcanoAirOnTickUpdateProcedure;

public class VolcanoAirBlock extends Block {
	public VolcanoAirBlock() {
		super(BlockBehaviour.Properties.of().air().sound(SoundType.EMPTY).strength(-1, 3600000).noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		return context.getItemInHand().getItem() != this.asItem();
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		VolcanoAirOnTickUpdateProcedure.execute();
		world.scheduleTick(pos, this, 1);
	}
}
