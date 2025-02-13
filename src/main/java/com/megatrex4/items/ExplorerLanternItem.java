package com.megatrex4.items;

import net.minecraft.block.Blocks;
import net.minecraft.block.LightBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ExplorerLanternItem extends Item {
    public ExplorerLanternItem(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        if (!world.isClient){
            world.setBlockState(player.getBlockPos(), Blocks.LIGHT.getDefaultState()
                    .with(LightBlock.LEVEL_15, 15));
            player.sendMessage(Text.translatable("item.tutorial.explorer_lantern.uses"), true);
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
