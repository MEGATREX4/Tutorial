package com.megatrex4.items;


import com.megatrex4.Tutorial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {

    public static final Item SAPPHIRE = registerItems("sapphire", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item FABRIC = registerItems("Fabric", new Item(new FabricItemSettings()));

    public static final Item RECORDING_CRYSTAL = registerItems("recording_crystal",
            new RecordingCrystalItem(new FabricItemSettings().maxCount(1)));
    public static final Item EXPLORER_LANTERN = registerItems("explorer_lantern",
            new ExplorerLanternItem(new FabricItemSettings().maxCount(1)));
    public static final Item HEALING_STONE = registerItems("healing_stone",
            new HealingStoneItem(new FabricItemSettings().maxCount(1)));

    public static Item registerItems(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Tutorial.MOD_ID, name.toLowerCase()), item
        );
    }

    public static void ItemRegistry() {
        Tutorial.LOGGER.info("Registering Items for " + Tutorial.MOD_ID);
    }
}
