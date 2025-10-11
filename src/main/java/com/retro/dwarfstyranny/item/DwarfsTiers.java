package com.retro.dwarfstyranny.item;

import com.retro.dwarfstyranny.util.DwarfsTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class DwarfsTiers {
    // Tier Mythril (entre diamant et netherite) à changer par après
    public static final Tier MYTHRIL = new ForgeTier(
            4,                         // Niveau de minage (4 = diamant/netherite)
            2031,                           // Durabilité (diamant = 1561, netherite = 2031)
            9.0f,                           // Vitesse de minage (diamant = 8.0, netherite = 9.0)
            4.0f,                           // Dégâts de base (diamant = 3.0, netherite = 4.0)
            15,                             // Enchantabilité (diamant = 10, netherite = 15)

            DwarfsTags.Blocks.NEEDS_MYTHRIL_TOOL,  // Tag des blocs minables
            () -> Ingredient.of(DwarfsItems.MYTHRIL_INGOT.get())  // Matériau de réparation
    );
}
