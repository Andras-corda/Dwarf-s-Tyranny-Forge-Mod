package com.retro.dwarfstyranny.event;

import com.retro.dwarfstyranny.DwarfsTyranny;
import com.retro.dwarfstyranny.screen.DwarfsMenuTypes;
import com.retro.dwarfstyranny.screen.EngravingTableScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DwarfsTyranny.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(DwarfsMenuTypes.ENGRAVING_TABLE_MENU.get(), EngravingTableScreen::new);
        });
    }
}