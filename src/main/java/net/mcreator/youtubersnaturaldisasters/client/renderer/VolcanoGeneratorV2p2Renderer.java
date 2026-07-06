
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGeneratorV2p2Entity;

public class VolcanoGeneratorV2p2Renderer extends HumanoidMobRenderer<VolcanoGeneratorV2p2Entity, HumanoidModel<VolcanoGeneratorV2p2Entity>> {
	public VolcanoGeneratorV2p2Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<VolcanoGeneratorV2p2Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(VolcanoGeneratorV2p2Entity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/super-invisible.png");
	}
}
