package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class LavaFlowNBTTrueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "LF")) == true) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Working"), false);
			world.setBlock(BlockPos.containing(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
		}
	}
}
