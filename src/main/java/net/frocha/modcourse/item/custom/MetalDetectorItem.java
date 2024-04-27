package net.frocha.modcourse.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = context.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)) {
                    assert player != null;
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if (!foundBlock) {
                outputNoValuableFound(player);
            }
        }

        context.getItemInHand().hurtAndBreak(
                1,
                context.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand())
        );

        return InteractionResult.SUCCESS;
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.modcourse.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        String systemMessage = "Valuable found: " + I18n.get(block.getDescriptionId())
                + " at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")";

        player.sendSystemMessage(Component.literal(systemMessage));

    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE);
    }
}
