package net.kay.modfuckery.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.kay.modfuckery.ModFuckery;
import net.kay.modfuckery.entity.custom.BladeeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BladeeRenderer extends MobRenderer<BladeeEntity, BladeeModel<BladeeEntity>> {
    public BladeeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BladeeModel<>(pContext.bakeLayer(ModModelLayers.BLADEE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BladeeEntity pEntity) {
        return new ResourceLocation(ModFuckery.MOD_ID, "textures/entity/bladee.png");
    }


    

    @Override
    public void render(BladeeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}