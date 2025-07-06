// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 4.12.5 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class blackholeAnimation {
	public static final AnimationDefinition animation = AnimationDefinition.Builder.withLength(80.0F)
			.addAnimation("sphere",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.1F, 0.1F, 0.1F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(80.0F, KeyframeAnimations.scaleVec(2.0F, 2.0F, 2.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.build();
}