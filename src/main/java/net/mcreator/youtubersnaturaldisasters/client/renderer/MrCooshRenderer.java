
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.MrCooshEntity;

public class MrCooshRenderer extends HumanoidMobRenderer<MrCooshEntity, HumanoidModel<MrCooshEntity>> {
	public MrCooshRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<MrCooshEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(MrCooshEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/mr_coosh.png");
	}
}
