
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;

public class TechnobladeRenderer extends HumanoidMobRenderer<TechnobladeEntity, HumanoidModel<TechnobladeEntity>> {
	public TechnobladeRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<TechnobladeEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(TechnobladeEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/2025_03_06_technoblade-23101128.png");
	}
}
