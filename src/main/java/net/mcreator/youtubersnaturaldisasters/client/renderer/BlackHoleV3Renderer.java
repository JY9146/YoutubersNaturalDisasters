
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV3Entity;
import net.mcreator.youtubersnaturaldisasters.client.model.animations.blackholeanAnimation;
import net.mcreator.youtubersnaturaldisasters.client.model.animations.blackholeAnimation;
import net.mcreator.youtubersnaturaldisasters.client.model.Modelblackhole;

import com.mojang.blaze3d.vertex.PoseStack;

public class BlackHoleV3Renderer extends MobRenderer<BlackHoleV3Entity, Modelblackhole<BlackHoleV3Entity>> {
	public BlackHoleV3Renderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelblackhole.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(BlackHoleV3Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(3f, 3f, 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackHoleV3Entity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/north.png");
	}

	private static final class AnimatedModel extends Modelblackhole<BlackHoleV3Entity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BlackHoleV3Entity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BlackHoleV3Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, blackholeAnimation.animation, ageInTicks, 2.1053f);
				this.animate(entity.animationState1, blackholeanAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BlackHoleV3Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
