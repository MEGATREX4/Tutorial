package com.megatrex4.blocks;

import com.megatrex4.Tutorial;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockRegistry {

    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.STONE)));
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.STONE)));
    public static final Block MAPLE_LOG = registerBlock("maple_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));



    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Tutorial.MOD_ID, name.toLowerCase()), block);
    }

    private static void registerBlockItem(String name, Block block){
        Item item = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, new Identifier(Tutorial.MOD_ID, name.toLowerCase()), item);
    }

    public static void BlockRegistry(){
        Tutorial.LOGGER.info("Registering Blocks for " + Tutorial.MOD_ID);
    }
}
