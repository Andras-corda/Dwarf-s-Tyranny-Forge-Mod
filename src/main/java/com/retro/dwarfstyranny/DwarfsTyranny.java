package com.retro.dwarfstyranny;

import com.mojang.logging.LogUtils;
import com.retro.dwarfstyranny.block.DwarfsBlocks;
import com.retro.dwarfstyranny.item.DwarfsCreativeModeTabs;
import com.retro.dwarfstyranny.item.DwarfsItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import com.retro.dwarfstyranny.block.entity.DwarfsBlockEntities;
import com.retro.dwarfstyranny.screen.DwarfsMenuTypes;

@Mod(DwarfsTyranny.MODID)
// Class principale
public class DwarfsTyranny {

    // ID
    public static final String MODID = "dwarfstyranny";
    // Log
    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")

    public DwarfsTyranny() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // blocs
        DwarfsBlocks.BLOCKS.register(modEventBus);

        // block entities
        DwarfsBlockEntities.register(modEventBus);

        //items
        DwarfsItems.ITEMS.register(modEventBus);

        // onglet crea
        DwarfsCreativeModeTabs.register(modEventBus);

        // menus
        DwarfsMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // Output
        LOGGER.info("DwarfsTyranny mod chargé !");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
