package com.retro.dwarfstyranny.screen;

import com.retro.dwarfstyranny.block.entity.EngravingTableBlockEntity;
import com.retro.dwarfstyranny.item.DwarfsItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class EngravingTableMenu extends AbstractContainerMenu {
    private final EngravingTableBlockEntity blockEntity;
    private final ContainerData data;

    public EngravingTableMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory,
                (EngravingTableBlockEntity) playerInventory.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(2));
    }

    public EngravingTableMenu(int containerId, Inventory playerInventory,
                              EngravingTableBlockEntity blockEntity, ContainerData data) {
        super(DwarfsMenuTypes.ENGRAVING_TABLE_MENU.get(), containerId);
        this.blockEntity = blockEntity;
        this.data = data;

        addDataSlots(data);

        // Slot 0 : Gauche (47, 40 dans MCreator, ajusté pour ton GUI)
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 0, 47, 56) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("dwarfstyranny", "gems")));
            }
        });

        // Slot 1 : Haut (80, 7)
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 1, 80, 23) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("dwarfstyranny", "gems")));
            }
        });

        // Slot 2 : Droite (113, 40)
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 2, 113, 56) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("dwarfstyranny", "gems")));
            }
        });

        // Slot 3 : Bas (80, 73)
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 3, 80, 89) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("dwarfstyranny", "gems")));
            }
        });

        // Slot 4 : Centre (80, 40) - Blank Rune
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 4, 80, 56) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(DwarfsItems.BLANK_RUNE.get()); // Tu devras créer cet item
            }
        });

        // Inventaire du joueur (ajusté pour hauteur 206)
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public int getFusionSprite() {
        return data.get(0);
    }

    public int getPowerSprite() {
        return data.get(1);
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
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 108 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 166));
        }
    }
}