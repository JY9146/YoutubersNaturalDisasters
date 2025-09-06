package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.network.YoutubersNaturalDisastersModVariables;

import java.util.List;
import java.util.Comparator;

public class OrphanOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setInvulnerable(true);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					YoutubersNaturalDisastersModVariables.WorldVariables.get(world).Orphan = true;
					YoutubersNaturalDisastersModVariables.WorldVariables.get(world).syncData(world);
				}
			}
		}
		OrphanGiveProcedure.execute(world, x, y, z, entity);
	}
}
