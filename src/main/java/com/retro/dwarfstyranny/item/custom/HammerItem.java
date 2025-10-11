package com.retro.dwarfstyranny.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(
                (float) attackDamage,
                attackSpeed,
                tier,
                BlockTags.MINEABLE_WITH_PICKAXE,  // Peut miner ce qu'une pioche mine
                properties
        );
    }

    // Méthode appelée quand un bloc est miné
    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
            breakBlocksInArea(stack, level, state, pos, serverPlayer);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }

    // Mine les blocs en 3x3 autour du bloc cassé
    private void breakBlocksInArea(ItemStack stack, Level level, BlockState originalState, BlockPos centerPos, ServerPlayer player) {
        // Direction du joueur
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    // Saute le bloc central (déjà cassé)
                    if (x == 0 && y == 0 && z == 0) continue;

                    if (Math.abs(z) > 1) continue;

                    BlockPos targetPos = centerPos.offset(x, y, z);
                    BlockState targetState = level.getBlockState(targetPos);

                    if (this.isCorrectToolForDrops(stack, targetState)) {
                        level.destroyBlock(targetPos, true, player);
                        stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
                    }
                }
            }
        }
    }
}
