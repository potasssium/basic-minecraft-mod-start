package net.kay.modfuckery.entity;

import javax.swing.text.html.parser.Entity;

import net.kay.modfuckery.ModFuckery;
import net.kay.modfuckery.entity.custom.BladeeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModFuckery.MOD_ID);

             public static final RegistryObject<EntityType<BladeeEntity>> BLADEE =
            ENTITY_TYPES.register("bladee", () -> EntityType.Builder.of(BladeeEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("bladee"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
