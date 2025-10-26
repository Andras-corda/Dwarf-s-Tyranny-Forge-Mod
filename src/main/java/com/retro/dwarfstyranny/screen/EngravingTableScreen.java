package com.retro.dwarfstyranny.screen;

import com.retro.dwarfstyranny.DwarfsTyranny;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class EngravingTableScreen extends AbstractContainerScreen<EngravingTableMenu> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(DwarfsTyranny.MODID, "textures/gui/engraving_table.png");
    private static final ResourceLocation FUSION_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(DwarfsTyranny.MODID, "textures/gui/engraving_fusion.png");
    private static final ResourceLocation POWER_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(DwarfsTyranny.MODID, "textures/gui/engraving_power.png");

    public EngravingTableScreen(EngravingTableMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageHeight = 190;
        this.imageWidth = 176;
        this.inventoryLabelY = 96;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Dessine le fond principal
        guiGraphics.blit(TEXTURE, x, y - 16, 0, 0, 176, 206, 176, 206);

        // Récupère les valeurs des sprites
        int fusionSprite = menu.getFusionSprite();
        int powerSprite = menu.getPowerSprite();

        // Dessine le sprite de fusion (128x128, 13 frames verticales)
        int fusionY = fusionSprite * 128;
        guiGraphics.blit(FUSION_TEXTURE, x + 24, y - 16, 0, fusionY, 128, 128, 128, 1664);

        // Dessine le sprite de power (128x128, 5 frames verticales)
        int powerY = powerSprite * 128;
        guiGraphics.blit(POWER_TEXTURE, x + 24, y - 22, 0, powerY, 128, 128, 128, 640);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.translatable("container.dwarfstyranny.engraving_table.inventory"),
                8, 96, 0x3F3F3F, false);
        guiGraphics.drawString(this.font, Component.translatable("container.dwarfstyranny.engraving_table.title"),
                43, 11, 0x3F3F3F, false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics); // ← CORRECTION ICI : seulement 1 paramètre
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}