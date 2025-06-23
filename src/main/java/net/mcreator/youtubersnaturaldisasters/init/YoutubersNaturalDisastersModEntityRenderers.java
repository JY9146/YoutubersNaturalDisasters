
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
import net.mcreator.youtubersnaturaldisasters.client.renderer.WildFireRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.VolcanoLavaV2Renderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.VolcanoLAVARenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.VolcanoHollowerrRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.VolcanoGroundMesserRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.VolcanoGeneratorV2Renderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.VolcanoGeneratorRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.TsunamiGeneratorRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.TimephoonRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.TestOfSinkholeEntityRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.TechnosGasPersonRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.TechnobladeRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.SinkholeEntityRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.OrphanRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.MrCooshRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.MeteorRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.MadPiglinRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.LavaBallShooterRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.KnarfyRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.InsaneFlameRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.GasPersonRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.EndOfWorldMeteorMeteorRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.DapperMrTomRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.CragDynaRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.CosmicRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.CavemanFilmsRenderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.BlackHoleV3Renderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.BlackHoleV2Renderer;
import net.mcreator.youtubersnaturaldisasters.client.renderer.BlackHoleRenderer;

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
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.DAPPER_MR_TOM.get(), DapperMrTomRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.TEST_OF_SINKHOLE_ENTITY.get(), TestOfSinkholeEntityRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.LAVA_BALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.VOLCANO_GENERATOR.get(), VolcanoGeneratorRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.PIGLIN_SPAWNER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.MAD_PIGLIN.get(), MadPiglinRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.ORPHAN.get(), OrphanRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.TECHNOS_POTION_OF_GAS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.TECHNOS_GAS_PERSON.get(), TechnosGasPersonRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.KNARFY.get(), KnarfyRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.VOLCANO_HOLLOWERR.get(), VolcanoHollowerrRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.LAVA_BALL_SHOOTER.get(), LavaBallShooterRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.VOLCANO_LAVA.get(), VolcanoLAVARenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.VOLCANO_GROUND_MESSER.get(), VolcanoGroundMesserRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.WILD_FIRE.get(), WildFireRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.TSUNAMI_GENERATOR.get(), TsunamiGeneratorRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.TIMEPHOON.get(), TimephoonRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.BLACK_HOLE.get(), BlackHoleRenderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.BLACK_HOLE_V_2.get(), BlackHoleV2Renderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.BLACK_HOLE_V_3.get(), BlackHoleV3Renderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.VOLCANO_GENERATOR_V_2.get(), VolcanoGeneratorV2Renderer::new);
		event.registerEntityRenderer(YoutubersNaturalDisastersModEntities.VOLCANO_LAVA_V_2.get(), VolcanoLavaV2Renderer::new);
	}
}
