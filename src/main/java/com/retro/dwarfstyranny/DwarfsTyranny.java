package com.retro.dwarfstyranny;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DwarfsTyranny.MOD_ID)
public class DwarfsTyranny {
    public static final String MOD_ID = "dwarfstyranny";

    public DwarfsTyranny() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("DwarfsTyranny mod chargé !");
    }
}
