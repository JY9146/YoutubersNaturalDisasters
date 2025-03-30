
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.youtubersnaturaldisasters.entity.EndOfWorldMeteorMeteorEntity;
import net.mcreator.youtubersnaturaldisasters.client.model.animations.meteor2Animation;
import net.mcreator.youtubersnaturaldisasters.client.model.ModelMeteor;

import com.mojang.blaze3d.vertex.PoseStack;

public class EndOfWorldMeteorMeteorRenderer extends MobRenderer<EndOfWorldMeteorMeteorEntity, ModelMeteor<EndOfWorldMeteorMeteorEntity>> {
	public EndOfWorldMeteorMeteorRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelMeteor.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(EndOfWorldMeteorMeteorEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(50f, 50f, 50f);
	}

	@Override
	public ResourceLocation getTextureLocation(EndOfWorldMeteorMeteorEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/texture_1_1.png");
	}

	private static final class AnimatedModel extends ModelMeteor<EndOfWorldMeteorMeteorEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<EndOfWorldMeteorMeteorEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(EndOfWorldMeteorMeteorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, meteor2Animation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(EndOfWorldMeteorMeteorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
