package com.retro.dwarfstyranny.item;

import com.retro.dwarfstyranny.DwarfsTyranny;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DwarfsCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DwarfsTyranny.MODID);

    // Crée le creativeTab perso
    public static final RegistryObject<CreativeModeTab> DWARFS_TAB = CREATIVE_MODE_TABS.register("dwarfs_tab",
            () -> CreativeModeTab.builder()
                    // Icon
                    .icon(() -> new ItemStack(DwarfsItems.RAW_MYTHRIL.get()))
                    // Title
                    .title(Component.translatable("creativetab.dwarfstyranny.dwarfs_tab"))
                    // Add to tab
                    .displayItems((parameters, output) -> {
                        // Mythrils
                        output.accept(DwarfsItems.RAW_MYTHRIL.get());
                        output.accept(DwarfsItems.MYTHRIL_INGOT.get());

                        // Blocs
                        output.accept(DwarfsItems.DEEPSLATE_MYTHRIL_ORE.get());

                        // Geodes
                        output.accept(DwarfsItems.BASE_GEODE.get());
                        output.accept(DwarfsItems.DRIPSTONE_GEODE.get());
                        output.accept(DwarfsItems.LUSH_GEODE.get());

                        // Tools
                        output.accept(DwarfsItems.MYTHRIL_SWORD.get());
                        output.accept(DwarfsItems.MYTHRIL_PICKAXE.get());
                        output.accept(DwarfsItems.MYTHRIL_AXE.get());

                        // Hammers
                        output.accept(DwarfsItems.WOODEN_HAMMER.get());
                        output.accept(DwarfsItems.STONE_HAMMER.get());
                        output.accept(DwarfsItems.IRON_HAMMER.get());
                        output.accept(DwarfsItems.GOLDEN_HAMMER.get());
                        output.accept(DwarfsItems.DIAMOND_HAMMER.get());
                        output.accept(DwarfsItems.NETHERITE_HAMMER.get());

                        // Engraving Table
                        // Engraving Table
                        // Engraving Table
                        output.accept(DwarfsItems.ENGRAVING_TABLE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}