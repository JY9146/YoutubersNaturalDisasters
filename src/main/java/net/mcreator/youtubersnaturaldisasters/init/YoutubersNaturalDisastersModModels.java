
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.youtubersnaturaldisasters.client.model.Modelmeteor2;
import net.mcreator.youtubersnaturaldisasters.client.model.Modeldappertom;
import net.mcreator.youtubersnaturaldisasters.client.model.ModelMeteor;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class YoutubersNaturalDisastersModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmeteor2.LAYER_LOCATION, Modelmeteor2::createBodyLayer);
		event.registerLayerDefinition(ModelMeteor.LAYER_LOCATION, ModelMeteor::createBodyLayer);
		event.registerLayerDefinition(Modeldappertom.LAYER_LOCATION, Modeldappertom::createBodyLayer);
	}
}
