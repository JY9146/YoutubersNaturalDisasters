
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.InsaneFlameEntity;

public class InsaneFlameRenderer extends HumanoidMobRenderer<InsaneFlameEntity, HumanoidModel<InsaneFlameEntity>> {
	public InsaneFlameRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<InsaneFlameEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(InsaneFlameEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/insaneflame6skin.png");
	}

	@Override
	protected boolean isShaking(InsaneFlameEntity entity) {
		return true;
	}
}
