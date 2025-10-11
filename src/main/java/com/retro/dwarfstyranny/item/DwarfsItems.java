package com.retro.dwarfstyranny.item;

import com.retro.dwarfstyranny.DwarfsTyranny;
import com.retro.dwarfstyranny.block.DwarfsBlocks;
import com.retro.dwarfstyranny.item.custom.HammerItem;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DwarfsItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DwarfsTyranny.MODID);

    /// <summary>
    /// Raw Mythril
    /// Mythril ingot
    /// </summary>
    public static final RegistryObject<Item> RAW_MYTHRIL =
            ITEMS.register("raw_mythril", () -> new Item(
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> MYTHRIL_INGOT =
            ITEMS.register("mythril_ingot", () -> new Item(
                    new Item.Properties()
            ));

    /// <summary>
    /// Geode (de base)
    /// Geode (Dripstone env)
    /// Geode (Lush cave env)
    /// </summary>
    public static final RegistryObject<Item> BASE_GEODE =
            ITEMS.register("base_geode", () -> new Item(
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> DRIPSTONE_GEODE =
            ITEMS.register("dripstone_geode", () -> new Item(
                    new Item.Properties()
            ));

    public static final RegistryObject<Item> LUSH_GEODE =
            ITEMS.register("lush_geode", () -> new Item(
                    new Item.Properties()
            ));

    /// <summary>
    /// Mythril tools (
    /// Sword
    /// Pickaxe
    /// Axe
    /// )
    /// </summary>
    public static final RegistryObject<Item> MYTHRIL_SWORD =
            ITEMS.register("mythril_sword", () -> new SwordItem(
                    DwarfsTiers.MYTHRIL,
                    3,                         // Dégâts d'attaque (base + 3)
                    -2.4f,                              // Vitesse d'attaque
                    new Item.Properties()));

    public static final RegistryObject<Item> MYTHRIL_PICKAXE =
            ITEMS.register("mythril_pickaxe", () -> new PickaxeItem(
                    DwarfsTiers.MYTHRIL,
                    1,                         // Dégâts d'attaque
                    -2.8f,                              // Vitesse d'attaque
                    new Item.Properties()));

    public static final RegistryObject<Item> MYTHRIL_AXE =
            ITEMS.register("mythril_axe", () -> new AxeItem(
                    DwarfsTiers.MYTHRIL,
                    6,                         // Dégâts d'attaque
                    -3.1f,                              // Vitesse d'attaque
                    new Item.Properties()));

    /// <summary>
    /// Hammer (
    /// wood
    /// stone
    /// iron
    /// gold
    /// diamond
    /// netherite
    /// mythril
    /// )
    /// </summary>
    public static final RegistryObject<Item> WOODEN_HAMMER =
            ITEMS.register("wooden_hammer", () -> new HammerItem(
                    Tiers.WOOD,
                    5,
                    -3.2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> STONE_HAMMER =
            ITEMS.register("stone_hammer", () -> new HammerItem(
                    Tiers.STONE,
                    6,
                    -3.2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> IRON_HAMMER =
            ITEMS.register("iron_hammer", () -> new HammerItem(
                    Tiers.IRON,
                    6,
                    -3.2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_HAMMER =
            ITEMS.register("golden_hammer", () -> new HammerItem(
                    Tiers.GOLD,
                    5,
                    -3.0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_HAMMER =
            ITEMS.register("diamond_hammer", () -> new HammerItem(
                    Tiers.DIAMOND,
                    7,
                    -3.2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_HAMMER =
            ITEMS.register("netherite_hammer", () -> new HammerItem(
                    Tiers.NETHERITE,
                    8,
                    -3.2f,
                    new Item.Properties().fireResistant())); // Résistant au feu

    public static final RegistryObject<Item> MYTHRIL_HAMMER =
            ITEMS.register("mythril_hammer", () -> new HammerItem(
                    DwarfsTiers.MYTHRIL,
                    7,
                    -3.2f,
                    new Item.Properties()));

    /// <summary>
    /// Deepslate mythril ore block
    /// </summary>
    public static final RegistryObject<Item> DEEPSLATE_MYTHRIL_ORE = ITEMS.register("deepslate_mythril_ore",
            () -> new BlockItem(DwarfsBlocks.DEEPSLATE_MYTHRIL_ORE.get(), new Item.Properties()));

}