
package net.mcreator.youtubersnaturaldisasters.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class DisasterCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(Commands.literal("disaster").requires(s -> s.hasPermission(4)).then(Commands.argument("random", MessageArgument.message())).then(Commands.argument("blackholev1", MessageArgument.message()))
						.then(Commands.argument("blackholev2", MessageArgument.message())).then(Commands.argument("blackholev3", MessageArgument.message())).then(Commands.argument("earthquake", MessageArgument.message()))
						.then(Commands.argument("endofworldmeteor", MessageArgument.message())).then(Commands.argument("gas", MessageArgument.message())).then(Commands.argument("meteor", MessageArgument.message()))
						.then(Commands.argument("sinkholev1", MessageArgument.message())).then(Commands.argument("sinkholev2", MessageArgument.message())).then(Commands.argument("timephoon", MessageArgument.message()))
						.then(Commands.argument("tornado", MessageArgument.message())).then(Commands.argument("volcanov1", MessageArgument.message())).then(Commands.argument("volcanov2", MessageArgument.message()))
						.then(Commands.argument("wildfire", MessageArgument.message())));
	}
}
