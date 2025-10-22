package com.retro.dwarfstyranny.block.entity;

import com.retro.dwarfstyranny.screen.EngravingTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.MenuProvider;
import net.minecraftforge.items.ItemStackHandler;

public class EngravingTableBlockEntity extends BlockEntity implements MenuProvider {

    // Inventaire du bloc (nombre de slots)
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public EngravingTableBlockEntity(BlockPos pos, BlockState state) {
        super(DwarfsBlockEntities.ENGRAVING_TABLE_BE.get(), pos, state);
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.dwarfstyranny.engraving_table");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new EngravingTableMenu(containerId, playerInventory, this);
    }
}