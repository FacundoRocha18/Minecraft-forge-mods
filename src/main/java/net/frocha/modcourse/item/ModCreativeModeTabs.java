package net.frocha.modcourse.item;

import net.frocha.modcourse.ModCourse;
import net.frocha.modcourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            ModCourse.MOD_ID
    );

    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register(
            "materials",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DURASTEEL.get()))
                    .title(Component.translatable("creativetab.materials"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.DURASTEEL.get());
                        output.accept(ModItems.RAW_DURASTEEL.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModBlocks.DURASTEEL_BLOCK.get());
                        output.accept(ModBlocks.DURASTEEL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_DURASTEEL_ORE.get());
                        output.accept(ModBlocks.END_STONE_DURASTEEL_ORE.get());
                        output.accept(ModBlocks.NETHER_DURASTEEL_ORE.get());
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
