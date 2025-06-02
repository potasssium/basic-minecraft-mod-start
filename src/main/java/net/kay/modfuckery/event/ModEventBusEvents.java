package net.kay.modfuckery.event;

import net.kay.modfuckery.ModFuckery;
import net.kay.modfuckery.entity.ModEntities;
import net.kay.modfuckery.entity.custom.BladeeEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModFuckery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BLADEE.get(), BladeeEntity.createAttributes().build());
    }

}
