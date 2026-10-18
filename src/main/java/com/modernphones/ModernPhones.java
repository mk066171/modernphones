package com.modernphones;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

@Mod(ModernPhones.MODID)
public class ModernPhones {
    public static final String MODID = "modernphones";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /** registry id -> display name used in the action bar message */
    private static final String[][] PHONES = {
            {"iphone_16_pro_max", "iPhone 16 Pro Max"},
            {"iphone_17_pro", "iPhone 17 Pro"},
            {"iphone_18_pro_max", "iPhone 18 Pro Max"},
            {"xiaomi_17_pro_max", "Xiaomi 17 Pro Max"},
            {"poco_f7", "Poco F7"},
            {"pixel_10a", "Google Pixel 10a"},
    };

    public static final List<RegistryObject<Item>> PHONE_ITEMS = new ArrayList<>();

    static {
        for (String[] p : PHONES) {
            PHONE_ITEMS.add(ITEMS.register(p[0], () -> new PhoneItem(new Item.Properties().stacksTo(1), p[1])));
        }
    }

    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("phones", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.modernphones"))
                    .icon(() -> new ItemStack(PHONE_ITEMS.get(1).get()))
                    .displayItems((params, output) -> PHONE_ITEMS.forEach(o -> output.accept(o.get())))
                    .build());

    public ModernPhones() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        TABS.register(bus);
    }
}
