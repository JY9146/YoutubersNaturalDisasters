
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV2Entity;
import net.mcreator.youtubersnaturaldisasters.client.model.animations.blackholeanAnimation;
import net.mcreator.youtubersnaturaldisasters.client.model.animations.blackholeAnimation;
import net.mcreator.youtubersnaturaldisasters.client.model.Modelblackhole;

import com.mojang.blaze3d.vertex.PoseStack;

public class BlackHoleV2Renderer extends MobRenderer<BlackHoleV2Entity, Modelblackhole<BlackHoleV2Entity>> {
	public BlackHoleV2Renderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelblackhole.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(BlackHoleV2Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(10f, 10f, 10f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackHoleV2Entity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/north.png");
	}

	private static final class AnimatedModel extends Modelblackhole<BlackHoleV2Entity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BlackHoleV2Entity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BlackHoleV2Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, blackholeAnimation.animation, ageInTicks, 4.4f);
				this.animate(entity.animationState1, blackholeanAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BlackHoleV2Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
