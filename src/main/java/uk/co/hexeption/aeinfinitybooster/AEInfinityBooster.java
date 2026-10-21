package uk.co.hexeption.aeinfinitybooster;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import uk.co.hexeption.aeinfinitybooster.setup.ModItems;

public class AEInfinityBooster implements ModInitializer {
    public static final String ID = "aeinfinitybooster";

    @Override
    public void onInitialize() {
        ModItems.register();
        registerTab();
    }

    public static void registerTab() {
        CreativeModeTab tab = FabricItemGroup.builder()
        .icon(() -> new ItemStack(ModItems.INFINITY_CARD))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.INFINITY_CARD);
            output.accept(ModItems.DIMENSION_CARD);
        })
        .title(Component.translatable("item_group." + ID + ".tab"))
        .build();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(ID, "aeinfinitybooster"), tab);
    }

}
