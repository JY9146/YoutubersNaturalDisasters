
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.VolcanoLavaV2Entity;

public class VolcanoLavaV2Renderer extends HumanoidMobRenderer<VolcanoLavaV2Entity, HumanoidModel<VolcanoLavaV2Entity>> {
	public VolcanoLavaV2Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<VolcanoLavaV2Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(VolcanoLavaV2Entity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/super-invisible.png");
	}
}
