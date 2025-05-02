package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

import java.util.List;
import java.util.Comparator;

public class TestingTestingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState Block_ = Blocks.AIR.defaultBlockState();
		double yy = 0;
		double Block_DstroyChance = 0;
		double Every__PerUptdate = 0;
		double Fall_Chance = 0;
		double Random_Number = 0;
		Entity Entity_Variable = null;
		entity.setInvulnerable(true);
		if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if (entity.getPersistentData().getDouble("BlockCount1") < 20) {
			Every__PerUptdate = 8;
			if (entity.getPersistentData().getDouble("digtick1") == 0) {
				entity.getPersistentData().putDouble("digtick1", Every__PerUptdate);
			} else {
				entity.getPersistentData().putDouble("digtick1", (entity.getPersistentData().getDouble("digtick1") - 1));
			}
			if (entity.getPersistentData().getDouble("digtick1") == 1) {
				if (!(entity.getPersistentData().getDouble("WAIT1") == 4)) {
					entity.getPersistentData().putDouble("WAIT1", (entity.getPersistentData().getDouble("WAIT1") + 1));
					int horizontalRadiusSphere = (int) (entity.getPersistentData().getDouble("SizeWidth1")) - 1;
					int verticalRadiusSphere = (int) 12 - 1;
					int yIterationsSphere = verticalRadiusSphere;
					for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
						for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
							for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
								double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
										+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
								if (distanceSq <= 1.0) {
									if (entity.getPersistentData().getDouble("BlockCount1") > 10) {
										if (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)).canOcclude() == true) {
											Block_DstroyChance = 1;
											if (Block_DstroyChance == 1) {
												world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
											}
										}
									} else {
										if (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)).canOcclude() == true) {
											Block_DstroyChance = 1;
											if (Block_DstroyChance == 1) {
												world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
											}
										}
									}
								}
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("WAIT1", 0);
					entity.getPersistentData().putDouble("BlockCount1", (entity.getPersistentData().getDouble("BlockCount1") + 1));
					entity.getPersistentData().putDouble("SizeWidth1", (entity.getPersistentData().getDouble("SizeWidth1") * 0.9));
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (Math.round(entity.getY()) - 3), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (Math.round(entity.getY()) - 3), z, _ent.getYRot(), _ent.getXRot());
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("SizeWidth1")) / 2d), e -> true).stream()
								.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Logic_Variable == true) {
									if (Math.random() < 0.5) {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2000, 5, false, false));
										YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Logic_Variable = false;
										YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
									} else {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 20, false, false));
										YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Logic_Variable = false;
										YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
									}
								}
							}
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item,distance=.." + entity.getPersistentData().getDouble("SizeWidth1") + "]"));
			}
		} else {
			YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Logic_Variable = true;
			YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
