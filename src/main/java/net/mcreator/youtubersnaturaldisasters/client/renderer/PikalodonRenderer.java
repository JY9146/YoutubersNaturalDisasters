
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.PikalodonEntity;

public class PikalodonRenderer extends HumanoidMobRenderer<PikalodonEntity, HumanoidModel<PikalodonEntity>> {
	public PikalodonRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<PikalodonEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(PikalodonEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/pikalodon.png");
	}
}
