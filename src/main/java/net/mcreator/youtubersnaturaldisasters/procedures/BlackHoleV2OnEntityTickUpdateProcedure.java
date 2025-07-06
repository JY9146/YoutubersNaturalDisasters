package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV2Entity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

import java.util.List;
import java.util.Comparator;

public class BlackHoleV2OnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rand = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		entity.setInvulnerable(true);
		entity.getPersistentData().putDouble("TIMER", (entity.getPersistentData().getDouble("TIMER") - 1));
		if (entity.getPersistentData().getDouble("TIMER") <= 0) {
			entity.getPersistentData().putDouble("TIMER", 5);
			if (30 >= entity.getPersistentData().getDouble("radius")) {
				entity.getPersistentData().putDouble("radius", (entity.getPersistentData().getDouble("radius") + 1));
			}
			int horizontalRadiusSphere = (int) (entity.getPersistentData().getDouble("radius")) - 1;
			int verticalRadiusSphere = (int) (entity.getPersistentData().getDouble("radius")) - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.AIR.defaultBlockState(), 3);
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entityiterator) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entityiterator))) {
						entityiterator.getPersistentData().putBoolean("path", true);
					}
				}
				if (entityiterator.getPersistentData().getBoolean("path")) {
					entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) / 50), (((entity.getY() + 2) - entityiterator.getY()) / 50), ((entity.getZ() - entityiterator.getZ()) / 50)));
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, (entity.getY() + 2), z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getPersistentData().getBoolean("path")) {
					if (!(entityiterator instanceof LivingEntity)) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					} else {
						entityiterator.hurt(
								new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("youtubers_natural_disasters:spaghettified")))), 99999);
						YoutubersNaturalDisastersMod.queueServerWork(10, () -> {
							entityiterator.kill();
						});
					}
				}
			}
		}
		YoutubersNaturalDisastersMod.queueServerWork(360, () -> {
			for (int index0 = 0; index0 < 3; index0++) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"kill @e[type=item]");
				if (entity instanceof BlackHoleV2Entity _datEntSetL)
					_datEntSetL.getEntityData().set(BlackHoleV2Entity.DATA_DisapearAnimation, true);
			}
			if (entity instanceof BlackHoleV2Entity _datEntSetL)
				_datEntSetL.getEntityData().set(BlackHoleV2Entity.DATA_DisapearAnimation, true);
			YoutubersNaturalDisastersMod.queueServerWork(60, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		});
	}
}
