package com.retro.dwarfstyranny.screen;

import com.retro.dwarfstyranny.block.entity.EngravingTableBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class EngravingTableMenu extends AbstractContainerMenu {
    private final EngravingTableBlockEntity blockEntity;

    // Constructeur pour le client
    public EngravingTableMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory,
                (EngravingTableBlockEntity) playerInventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    // Constructeur pour le serveur
    public EngravingTableMenu(int containerId, Inventory playerInventory, EngravingTableBlockEntity blockEntity) {
        super(DwarfsMenuTypes.ENGRAVING_TABLE_MENU.get(), containerId);
        this.blockEntity = blockEntity;

        // Slots du bloc (3 slots d'exemple)
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 0, 56, 35));
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 1, 80, 35));
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 2, 104, 35));

        // Inventaire du joueur
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 124 + i * 18)); // ← Y ajusté
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 182)); // ← Y ajusté
        }
    }
}