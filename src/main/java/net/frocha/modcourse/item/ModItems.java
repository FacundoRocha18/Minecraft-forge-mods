package net.frocha.modcourse.item;

import net.frocha.modcourse.ModCourse;
import net.frocha.modcourse.item.custom.FuelItem;
import net.frocha.modcourse.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModCourse.MOD_ID);

    public static final RegistryObject<Item> DURASTEEL = ITEMS.register(
            "durasteel",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> RAW_DURASTEEL = ITEMS.register(
            "raw_durasteel",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register(
            "metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512))
    );

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register(
            "kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI))
    );

    public static final RegistryObject<Item> PEAT_BRICK = ITEMS.register(
            "peat_brick",
            () -> new FuelItem(new Item.Properties(), 200)
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
