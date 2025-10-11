package com.retro.dwarfstyranny.util;

import com.retro.dwarfstyranny.DwarfsTyranny;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class DwarfsTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_MYTHRIL_TOOL = tag("needs_mythril_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DwarfsTyranny.MODID, name));
        }
    }
}
