package net.kay.modfuckery.event;

import net.kay.modfuckery.ModFuckery;
import net.kay.modfuckery.entity.client.BladeeModel;
import net.kay.modfuckery.entity.client.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = ModFuckery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BLADEE_LAYER, BladeeModel::createBodyLayer);
    }
}