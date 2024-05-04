package net.frocha.modcourse.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoundBlock extends Block {
    public SoundBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos position,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            if (player.isCrouching()) {
                level.playSound(
                        null,
                        position,
                        SoundEvents.NOTE_BLOCK_BANJO.get(),
                        SoundSource.BLOCKS,
                        1f,
                        1f
                );

                return InteractionResult.CONSUME;
            } else {
                level.playSound(
                        null,
                        position,
                        SoundEvents.NOTE_BLOCK_COW_BELL.get(),
                        SoundSource.BLOCKS,
                        1f,
                        1f
                );

                return InteractionResult.CONSUME;
            }
        }

        return super.use(state, level, position, player, hand, hit);
    }
}
