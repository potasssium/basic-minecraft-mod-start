package net.kay.modfuckery.item;

import net.kay.modfuckery.ModFuckery;
import net.kay.modfuckery.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;



public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModFuckery.MOD_ID);

        public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MYHEART.get()))
                    .title(Component.translatable("creativetab.mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MYHEART.get());  //Items need to be added here, they will be added depending on order, only use get for custom items
                        pOutput.accept(ModItems.TANZANITE.get());
                        pOutput.accept(ModItems.RAW_TANZANITE.get());
                        pOutput.accept(ModItems.TURQUOIS.get());
                        pOutput.accept(ModItems.RAW_TURQUOIS.get());
                        pOutput.accept(ModBlocks.TANZANITE_BLOCK.get());
                    })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
