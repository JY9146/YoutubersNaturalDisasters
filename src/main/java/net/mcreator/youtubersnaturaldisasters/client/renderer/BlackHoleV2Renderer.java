
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV2Entity;

public class BlackHoleV2Renderer extends HumanoidMobRenderer<BlackHoleV2Entity, HumanoidModel<BlackHoleV2Entity>> {
	public BlackHoleV2Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<BlackHoleV2Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(BlackHoleV2Entity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/super-invisible.png");
	}
}
