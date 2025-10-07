
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

import net.mcreator.youtubersnaturaldisasters.procedures.WildFireSummonerRightclickedProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.TornadoSummonerRightclickedOnBlockProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.TimephoonSummonerRightclickedProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.TestSinkholeSummonerRIghtClickProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.SinkholeSummonerRightclickedOnBlockProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.RandomDisasterSummonProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.EndOfWorldMeteorRightclickedProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterVolcanoV2SpawnProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterVolcanoV1SummonProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterTalonMeteorShowerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterTalonMeteorShowerP2Procedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterMeteorShowerProcedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterMeteorShower2Procedure;
import net.mcreator.youtubersnaturaldisasters.procedures.DisasterGasSpawnProcedure;
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

			RandomDisasterSummonProcedure.execute(world, x, y, z, arguments, entity);
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

			DisasterBlackHoleSpawnV1Procedure.execute(world, x, y, z);
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

			DisasterBlackHoleV2Procedure.execute(world, x, y, z);
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

			DisasterBlackHoleSpawnV3Procedure.execute(world, x, y, z);
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

			EndOfWorldMeteorRightclickedProcedure.execute(world, x, y, z);
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

			DisasterGasSpawnProcedure.execute(world, x, y, z);
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

			DisasterMeteorShowerProcedure.execute(world, x, y, z);
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

			DisasterMeteorShower2Procedure.execute(world, x, y, z, entity);
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

			DisasterTalonMeteorShowerProcedure.execute(world, x, y, z);
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

			DisasterTalonMeteorShowerP2Procedure.execute(world, x, y, z, entity);
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

			SinkholeSummonerRightclickedOnBlockProcedure.execute(world, x, y, z);
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

			TestSinkholeSummonerRIghtClickProcedure.execute(world, x, y, z);
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

			TornadoSummonerRightclickedOnBlockProcedure.execute(world, x, y, z);
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

			DisasterVolcanoV1SummonProcedure.execute(world, x, y, z);
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

			DisasterVolcanoV2SpawnProcedure.execute(world, x, y, z);
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

			WildFireSummonerRightclickedProcedure.execute(world, x, y, z);
			return 0;
		}))));
	}
}
