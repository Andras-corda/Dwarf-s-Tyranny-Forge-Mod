package com.retro.dwarfstyranny.block;

import com.retro.dwarfstyranny.DwarfsTyranny;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DwarfsBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DwarfsTyranny.MODID);

    // Bloc de minerai de mythril
    public static final RegistryObject<Block> MYTHRIL_ORE = BLOCKS.register("mythril_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f, 3.0f) // Dureté et résistance (comme le fer)
                    .requiresCorrectToolForDrops() // Nécessite une pioche
                    .sound(SoundType.STONE)));

    // Minerai de mythril du deepslate
    public static final RegistryObject<Block> DEEPSLATE_MYTHRIL_ORE = BLOCKS.register("deepslate_mythril_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f, 3.0f) // Plus dur que la version normale
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));
}