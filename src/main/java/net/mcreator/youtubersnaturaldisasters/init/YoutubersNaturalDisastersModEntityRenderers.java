
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.youtubersnaturaldisasters.client.renderer.Zachary95Renderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.TechnobladeRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.SinkholeEntityRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.MrCooshRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.MeteorRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.InsaneFlameRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.GasPersonRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.EndOfWorldMeteorMeteorRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.CragDynaRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.CosmicRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.CavemanFilmsRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class YoutubersNaturalDisastersModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.TECHNOBLADE.get(), TechnobladeRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.CRAG_DYNA.get(), CragDynaRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.GAS_PERSON.get(), GasPersonRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.SPLASH_POTION_OF_GAS_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.METEOR.get(), MeteorRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.END_OF_WORLD_METEOR_METEOR.get(), EndOfWorldMeteorMeteorRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.CAVEMAN_FILMS.get(), CavemanFilmsRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.INSANE_FLAME.get(), InsaneFlameRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.MR_COOSH.get(), MrCooshRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.SINKHOLE_ENTITY.get(), SinkholeEntityRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.ZACHARY_95.get(), Zachary95Renderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.COSMIC.get(), CosmicRenderer::new);
	}
}
