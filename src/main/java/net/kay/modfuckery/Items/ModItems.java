package net.kay.modfuckery.Items;

import java.rmi.registry.Registry;

import net.kay.modfuckery.ModFuckery;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister; //deferredregister is a long list of items that will then register into minecraft
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
                 // { final } is a variable that prevents it from being overriden/modified
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModFuckery.MOD_ID);

    public static final RegistryObject<Item> MEOW = ITEMS.register("meow",
            () -> new Item(new Item.Properties()));
    

    public static void register(IEventBus eventBus) { 
        ITEMS.register(eventBus);
}

}
