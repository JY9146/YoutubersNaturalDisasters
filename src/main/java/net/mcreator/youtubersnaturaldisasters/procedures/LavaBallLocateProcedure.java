package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.Comparator;

public class LavaBallLocateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity TheTargetOfDeath = null;
		boolean Wait = false;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (Wait == false) {
					TheTargetOfDeath = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null);
					if (entity instanceof Mob _entity && TheTargetOfDeath instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
					Wait = true;
				}
				if (Wait == true) {
					entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
					if (entity.getPersistentData().getDouble("tagName") > 400) {
						TheTargetOfDeath = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null);
						if (entity instanceof Mob _entity && TheTargetOfDeath instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						entity.getPersistentData().putDouble("tagName", 0);
					}
				}
			}
			world = _worldorig;
		}
	}
}
