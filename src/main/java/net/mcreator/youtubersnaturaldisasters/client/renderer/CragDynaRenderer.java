
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.CragDynaEntity;

public class CragDynaRenderer extends HumanoidMobRenderer<CragDynaEntity, HumanoidModel<CragDynaEntity>> {
	public CragDynaRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<CragDynaEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(CragDynaEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/2020_06_01_diamond-armor-layer-1-14493856_1.png");
	}
}
