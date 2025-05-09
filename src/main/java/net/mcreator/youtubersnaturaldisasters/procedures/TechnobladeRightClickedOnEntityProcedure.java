package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

public class TechnobladeRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world) {
		double TechnoSaysChance = 0;
		TechnoSaysChance = Mth.nextInt(RandomSource.create(), 1, 68);
		if (TechnoSaysChance == 1) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Technoblade never dies."), false);
		} else if (TechnoSaysChance == 67) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Hello I'm here to talk to you about your car's extended warranty"), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Also SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 66) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I hope Phill learned to read while I've been gone"), false);
		} else if (TechnoSaysChance == 65) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Heloooooo."), false);
		} else if (TechnoSaysChance == 62) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Easy."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Technoblade never dies"), false);
		} else if (TechnoSaysChance == 63) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("JY, you seriously brought me back for this?"), false);
		} else if (TechnoSaysChance == 2) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Yoink."), false);
		} else if (TechnoSaysChance == 64) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("When you are strong, look weak, and when you are weak, get gud noob. - Sun Tzu, The Art of War"), false);
		} else if (TechnoSaysChance == 3) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Kill steal!!!"), false);
		} else if (TechnoSaysChance == 4) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I've been working on a hobby. Just a small one..."), false);
		} else if (TechnoSaysChance == 5) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Officer I dropkicked that child in SELF DEFENSE!"), false);
		} else if (TechnoSaysChance == 7) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("YOOOOOOOOOOOOO!"), false);
		} else if (TechnoSaysChance == 8) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Shhhhhh. I need cobblestone..."), false);
		} else if (TechnoSaysChance == 9) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I need carrot! Give me carrots."), false);
		} else if (TechnoSaysChance == 10) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Ehehehehehehehe"), false);
		} else if (TechnoSaysChance == 11) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Hehhhhh"), false);
		} else if (TechnoSaysChance == 12) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("PHILZA LOOK OUT!"), false);
		} else if (TechnoSaysChance == 13) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Subscribe to Technoblade"), false);
		} else if (TechnoSaysChance == 14) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I now realize how to make infinite money, By trading with you nerds!"), false);
		} else if (TechnoSaysChance == 15) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Your a NERD!"), false);
		} else if (TechnoSaysChance == 16) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Blood for the blood god"), false);
		} else if (TechnoSaysChance == 17) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Take that, orphans."), false);
		} else if (TechnoSaysChance == 18) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I don't believe in friendship\u2026 We tell ourselves it's real so the cogs of society can turn\u2026 The only thing that's real\u2026 is CASH!"), false);
		} else if (TechnoSaysChance == 19) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Ay caramba, donde esta la biblioteca!?"), false);
		} else if (TechnoSaysChance == 20) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I'm the second worst thing to ever happen to those orphans"), false);
		} else if (TechnoSaysChance == 21) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Your Honor in my defense it's hilarious."), false);
		} else if (TechnoSaysChance == 22) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("It's all part of my Master Plan."), false);
		} else if (TechnoSaysChance == 23) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("All men can see the tactics whereby I conquer, but what none can see is the strategy out of which victory is evolved."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 24) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("They say that history is written by the winners, but I can't help notice him writing over there"), false);
		} else if (TechnoSaysChance == 25) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Let\u2019s play a relevant game, like Grinch Simulator."), false);
		} else if (TechnoSaysChance == 26) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("The only universal language is violence."), false);
		} else if (TechnoSaysChance == 27) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Technoplane"), false);
		} else if (TechnoSaysChance == 28) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("If you wish to defeat me, train for another 100 years."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 29) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("To get a refrigerator, I immediately headed to the safest place I knew, Afghanistan"), false);
		} else if (TechnoSaysChance == 30) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Are there any millionaires in the chat?"), false);
		} else if (TechnoSaysChance == 31) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Anyone who said be yourself, hasn't met Tommyinnit"), false);
		} else if (TechnoSaysChance == 32) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("See I was actually using an advanced technique called LYING"), false);
		} else if (TechnoSaysChance == 33) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Hippity Hoppity get off my property"), false);
		} else if (TechnoSaysChance == 34) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Revolution waits for no man"), false);
		} else if (TechnoSaysChance == 35) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I think my strategy of having ten hired goons was really better than your strategy of not having ten hired goons"), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 36) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("My philosophy in life is: ignore everyone, acquire money"), false);
		} else if (TechnoSaysChance == 37) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("WE WIN THESE!"), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Technoblade never dies"), false);
		} else if (TechnoSaysChance == 38) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Let your plans be dark and impenetrable as night, and when you move fall like a thunderbolt"), false);
		} else if (TechnoSaysChance == 39) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Know your enemy and know yourself, and you need not fear the result of a hundred battles."), false);
		} else if (TechnoSaysChance == 40) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Violence is not the answer. It's a question and the answer is YES!"), false);
		} else if (TechnoSaysChance == 41) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"When you need someone to fix your sink, you call a plumber. When you need someone to fix your electricity, you call an electrician. And when you need someone to overthrow a brutal tyrant, you call an anarchist! (Otherwise known as Technoblade)"),
						false);
		} else if (TechnoSaysChance == 42) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Buy my youtooz, buy my merch, like, subscribe, do all that."), false);
		} else if (TechnoSaysChance == 43) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Having abolished all governments of men, I have ascended to heaven to take on the Kingdom of God"), false);
		} else if (TechnoSaysChance == 44) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"Skyblock teaches us that no matter how ridiculous the odds may seem, within us resides the power to overcome these challenges and achieve something beautiful. That one day, we\u2019ll look back at where we started, and be amazed by how far we\u2019ve come."),
						false);
		} else if (TechnoSaysChance == 45) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(
						"The only thing that works in this world is that you treat others as they treat you. Those that have treated me with kindness, I will repay that kindness tenfold. AND THOSE, that have treated me with injustice. That used me. That hunt me down, that hurt my friends... I will repay that injustice a thousand times over."),
						false);
		} else if (TechnoSaysChance == 46) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("GG."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 47) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Well I just killed a small child."), false);
		} else if (TechnoSaysChance == 48) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("If Hypixel has taught me something, it's that if you have a problem, the answer is slavery."), false);
		} else if (TechnoSaysChance == 49) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dream. That homeless teletubby that helped me overthrow a government."), false);
		} else if (TechnoSaysChance == 50) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Give me content."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Because Technoblade never dies"), false);
		} else if (TechnoSaysChance == 51) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("After consulting countless theologians, philosophers, and a therapist, I have finally discovered the cure to being introverted. Watch my YouTube videos."),
						false);
		} else if (TechnoSaysChance == 52) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Tommyinnit. The Theseus of the Dream SMP. Videos with him got me a lot of confetti. "), false);
		} else if (TechnoSaysChance == 53) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("I have decided that pumpkins are my least favorite vegietable. What do you mean it's a fruit?"), false);
		} else if (TechnoSaysChance == 54) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Your telling me I got in a movie? What do you mean I was only in it for two seconds?! Cringe."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 55) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Cringe"), false);
		} else if (TechnoSaysChance == 56) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("100%. DON'T YOU DARE SNEEZE ON IT"), false);
		} else if (TechnoSaysChance == 57) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Nearly 20 million people have hit a button."), false);
		} else if (TechnoSaysChance == 58) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Donate to the Sarcoma Foundation. This is a threat"), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		} else if (TechnoSaysChance == 59) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("What do you mean you don't believe me? I'm a trustworthy man."), false);
		} else if (TechnoSaysChance == 60) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You will never defeat the Techno army!"), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Technoblade never dies"), false);
		} else if (TechnoSaysChance == 61) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Floof"), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Technoblade never dies"), false);
		} else {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("The Antarctic Empire shall rise again..."), false);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("ALSO SUBSCRIBE TO TECHNOBLADE"), false);
		}
	}
}
