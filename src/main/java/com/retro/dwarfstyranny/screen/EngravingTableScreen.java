package com.retro.dwarfstyranny.screen;

import com.retro.dwarfstyranny.DwarfsTyranny;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class EngravingTableScreen extends AbstractContainerScreen<EngravingTableMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(DwarfsTyranny.MODID, "textures/gui/engraving_table_gui.png");

    public EngravingTableScreen(EngravingTableMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageHeight = 206;
        this.imageWidth = 176;
        this.inventoryLabelY = this.imageHeight - 94; // position de l'inv
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}