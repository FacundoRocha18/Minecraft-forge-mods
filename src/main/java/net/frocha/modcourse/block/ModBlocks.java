package net.frocha.modcourse.block;

import net.frocha.modcourse.ModCourse;
import net.frocha.modcourse.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS,
            ModCourse.MOD_ID
    );

    public static final RegistryObject<Block> DURASTEEL_BLOCK = registerBlock(
            "durasteel_block",
            () -> new Block(BlockBehaviour.Properties.copy((Blocks.IRON_BLOCK)))
    );

    public static final RegistryObject<Block> DURASTEEL_ORE = registerBlock(
            "durasteel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy((Blocks.STONE))
                    .strength(5f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(2, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_DURASTEEL_ORE = registerBlock(
            "deepslate_durasteel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy((Blocks.DEEPSLATE))
                    .strength(5f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)
            )
    );

    public static final RegistryObject<Block> END_STONE_DURASTEEL_ORE = registerBlock(
            "end_stone_durasteel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy((Blocks.END_STONE))
                    .strength(5f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(5, 8)
            )
    );

    public static final RegistryObject<Block> NETHER_DURASTEEL_ORE = registerBlock(
            "nether_durasteel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy((Blocks.NETHERRACK))
                    .strength(5f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(5, 8)
            )
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(
                name,
                () -> new BlockItem(block.get(), new Item.Properties())
        );
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
