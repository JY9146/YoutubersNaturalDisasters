
package net.mcreator.youtubersnaturaldisasters.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.youtubersnaturaldisasters.procedures.TimephoonSummonerRightclickedProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.RandomDisasterSummonProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterWildFireSummonerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterVolcanoV2SpawnProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterVolcanoV1SummonProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterTornadoSummonerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterTalonMeteorShowerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterTalonMeteorShowerP2Procedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterSinkholeV2SummonerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterSinkholeV1SummonerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterMeteorShowerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterMeteorShower2Procedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterGasSpawnProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterEndOfWorldMeteorSummonProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterEarthquakeSpawnProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterBlackHoleV2Procedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterBlackHoleSpawnV3Procedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterBlackHoleSpawnV1Procedure;

@Mod.EventBusSubscriber
public class DisasterCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("disaster").requires(s -> s.hasPermission(4)).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("random").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			RandomDisasterSummonProcedure.execute(world, x, y, z, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("blackholev1").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterBlackHoleSpawnV1Procedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("blackholev2").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterBlackHoleV2Procedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("blackholev3").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterBlackHoleSpawnV3Procedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("targets", EntityArgument.entities()).then(Commands.literal("earthquake").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterEarthquakeSpawnProcedure.execute(arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("endofworldmeteor").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterEndOfWorldMeteorSummonProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("gas").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterGasSpawnProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("meteorshower").then(Commands.literal("head").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterMeteorShowerProcedure.execute(world, arguments);
			return 0;
		})).then(Commands.literal("looking").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterMeteorShower2Procedure.execute(world, x, y, z, arguments);
			return 0;
		})))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("talonmeteorshower").then(Commands.literal("head").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterTalonMeteorShowerProcedure.execute(world, x, y, z, arguments);
			return 0;
		})).then(Commands.literal("looking").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterTalonMeteorShowerP2Procedure.execute(world, x, y, z, arguments);
			return 0;
		})))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("sinkholev1").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterSinkholeV1SummonerProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("sinkholev2").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterSinkholeV2SummonerProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("timephoon").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			TimephoonSummonerRightclickedProcedure.execute(world, x, y, z);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("tornado").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterTornadoSummonerProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("volcanov1").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterVolcanoV1SummonProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("volcanov2").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterVolcanoV2SpawnProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.argument("target", EntityArgument.entity()).then(Commands.literal("wildfire").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			DisasterWildFireSummonerProcedure.execute(world, arguments);
			return 0;
		}))));
	}
}
