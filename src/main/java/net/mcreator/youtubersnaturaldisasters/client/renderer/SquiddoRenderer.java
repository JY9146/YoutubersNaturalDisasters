
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.youtubersnaturaldisasters.entity.SquiddoEntity;

public class SquiddoRenderer extends HumanoidMobRenderer<SquiddoEntity, HumanoidModel<SquiddoEntity>> {
	public SquiddoRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<SquiddoEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(SquiddoEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/895c87fdb34d28b4.png");
	}
}
