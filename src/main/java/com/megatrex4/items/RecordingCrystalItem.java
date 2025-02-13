package com.megatrex4.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RecordingCrystalItem extends Item {

    public RecordingCrystalItem(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        NbtCompound nbt = stack.getOrCreateNbt();
        int uses = nbt.getInt("uses") + 1;
        nbt.putInt("uses", uses);

        player.sendMessage(Text.translatable("item.tutorial.recording_crystal.uses", uses), true);
        return  TypedActionResult.success(stack);
    }
}
