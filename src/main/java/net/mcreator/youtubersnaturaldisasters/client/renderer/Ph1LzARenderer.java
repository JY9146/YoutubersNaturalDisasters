
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.Ph1LzAEntity;

public class Ph1LzARenderer extends HumanoidMobRenderer<Ph1LzAEntity, HumanoidModel<Ph1LzAEntity>> {
	public Ph1LzARenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<Ph1LzAEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(Ph1LzAEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/cf9694a1f279c04b.png");
	}
}
