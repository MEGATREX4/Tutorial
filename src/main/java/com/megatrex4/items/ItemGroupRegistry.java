package com.megatrex4.items;

import com.megatrex4.Tutorial;
import com.megatrex4.blocks.BlockRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroupRegistry {

    public static final ItemGroup GEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tutorial.MOD_ID, "gem"),
            FabricItemGroup.builder().displayName(Text.translatable("tutorial.itemgroup.gem"))
                    .icon(() -> new ItemStack(ItemRegistry.SAPPHIRE)). entries(((displayContext, entries) -> {
                        entries.add(ItemRegistry.SAPPHIRE);

                        entries.add(Items.DIAMOND);
                        entries.add(Items.GOLD_BLOCK);

                        entries.add(BlockRegistry.SAPPHIRE_BLOCK);
                        entries.add(BlockRegistry.SAPPHIRE_ORE);
                        entries.add(BlockRegistry.MAPLE_LOG);

                    })).build());


    private static void addItemsToIngridients(FabricItemGroupEntries entries){
        entries.add(ItemRegistry.FABRIC);
    }

    public static void ItemGroupRegistry(){
        Tutorial.LOGGER.info("Registering Group for " + Tutorial.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ItemGroupRegistry::addItemsToIngridients);
    }

}
