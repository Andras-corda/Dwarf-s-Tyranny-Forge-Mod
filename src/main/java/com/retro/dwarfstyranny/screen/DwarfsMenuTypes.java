package com.retro.dwarfstyranny.screen;

import com.retro.dwarfstyranny.DwarfsTyranny;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DwarfsMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, DwarfsTyranny.MODID);

    public static final RegistryObject<MenuType<EngravingTableMenu>> ENGRAVING_TABLE_MENU =
            MENUS.register("engraving_table_menu", () ->
                    IForgeMenuType.create(EngravingTableMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}