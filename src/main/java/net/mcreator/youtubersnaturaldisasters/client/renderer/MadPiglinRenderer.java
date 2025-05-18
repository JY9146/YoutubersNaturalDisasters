
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PiglinModel;

import net.mcreator.youtubersnaturaldisasters.entity.MadPiglinEntity;

public class MadPiglinRenderer extends MobRenderer<MadPiglinEntity, PiglinModel<MadPiglinEntity>> {
	public MadPiglinRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinModel<MadPiglinEntity>(context.bakeLayer(ModelLayers.PIGLIN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MadPiglinEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/piglinbrute.png");
	}
}
