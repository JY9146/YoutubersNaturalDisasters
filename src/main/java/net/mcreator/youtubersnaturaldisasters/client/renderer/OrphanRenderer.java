
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.youtubersnaturaldisasters.entity.OrphanEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class OrphanRenderer extends MobRenderer<OrphanEntity, VillagerModel<OrphanEntity>> {
	public OrphanRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<OrphanEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	protected void scale(OrphanEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(OrphanEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/orphansquared.png");
	}
}
