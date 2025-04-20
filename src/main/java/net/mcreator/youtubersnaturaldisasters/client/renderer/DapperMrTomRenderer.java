
package net.mcreator.youtubersnaturaldisasters.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.youtubersnaturaldisasters.entity.DapperMrTomEntity;
import net.mcreator.youtubersnaturaldisasters.client.model.Modeldappertom;

public class DapperMrTomRenderer extends MobRenderer<DapperMrTomEntity, Modeldappertom<DapperMrTomEntity>> {
	public DapperMrTomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldappertom<DapperMrTomEntity>(context.bakeLayer(Modeldappertom.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DapperMrTomEntity entity) {
		return new ResourceLocation("youtubers_natural_disasters:textures/entities/dappermrtom.png");
	}
}
