
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.youtubersnaturaldisasters.entity.MeteorEntity;
import net.mcreator.youtubersnaturaldisasters.client.model.animations.MeteorAnimation;
import net.mcreator.youtubersnaturaldisasters.client.model.ModelMeteor;

public class MeteorRenderer extends MobRenderer<MeteorEntity, ModelMeteor<MeteorEntity>> {
	public MeteorRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelMeteor.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(MeteorEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/texture_1_1.png");
	}

	private static final class AnimatedModel extends ModelMeteor<MeteorEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MeteorEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MeteorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, MeteorAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MeteorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
