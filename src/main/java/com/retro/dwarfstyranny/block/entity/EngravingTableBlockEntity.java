package com.retro.dwarfstyranny.block.entity;

import com.retro.dwarfstyranny.screen.EngravingTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.MenuProvider;
import net.minecraftforge.items.ItemStackHandler;

public class EngravingTableBlockEntity extends BlockEntity implements MenuProvider {

    // Inventaire du bloc (nombre de slots)
    private final ItemStackHandler itemHandler = new ItemStackHandler(5) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private int fusionSprite = 0;  // 0-12 (13 frames)
    private int powerSprite = 0;   // 0-4 (5 frames)

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> EngravingTableBlockEntity.this.fusionSprite;
                case 1 -> EngravingTableBlockEntity.this.powerSprite;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> EngravingTableBlockEntity.this.fusionSprite = value;
                case 1 -> EngravingTableBlockEntity.this.powerSprite = value;
            }
        }

        @Override
        public int getCount() {
            return 2;
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
        return new EngravingTableMenu(containerId, playerInventory, this, this.data);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, EngravingTableBlockEntity blockEntity) {
        if (level.isClientSide()) return;

        // Logique pour calculer fusionSprite et powerSprite selon le contenu des slots
        blockEntity.updateSprites();
        setChanged(level, pos, state);
    }

    private void updateSprites() {
        // Compte combien de slots contiennent des gemmes
        int gemCount = 0;
        for (int i = 0; i < 4; i++) {
            if (!itemHandler.getStackInSlot(i).isEmpty()) {
                gemCount++;
            }
        }

        // Calcule le sprite de fusion selon le nombre de gemmes
        fusionSprite = switch (gemCount) {
            case 0 -> 0;
            case 1 -> 3;
            case 2 -> 6;
            case 3 -> 9;
            case 4 -> 12;
            default -> 0;
        };

        // Calcule le sprite de power selon si la blank rune est présente
        boolean hasBlankRune = !itemHandler.getStackInSlot(4).isEmpty();
        powerSprite = hasBlankRune ? gemCount : 0;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("fusionSprite", fusionSprite);
        tag.putInt("powerSprite", powerSprite);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        fusionSprite = tag.getInt("fusionSprite");
        powerSprite = tag.getInt("powerSprite");
    }
}