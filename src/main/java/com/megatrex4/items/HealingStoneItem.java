package com.megatrex4.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class HealingStoneItem extends Item {
    public HealingStoneItem(Settings settings){
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if (entity instanceof PlayerEntity player){
            if (selected && player.getHealth() < player.getMaxHealth()){
                if (!stack.hasNbt()){
                    stack.setNbt(new NbtCompound());
                }

                NbtCompound nbt = stack.getNbt();
                long lastTick = nbt.getLong("LastHealTick");
                long currentTick = world.getTime();

                if (currentTick - lastTick >= 10){
                    nbt.putLong("LastHealTick", currentTick);
                }

                if(!world.isClient){
                    player.heal(0.5f);
                }

                if (world.isClient){
                    int step = 10;
                    for (int i = 0; i < step; i++){
                        double angle = Math.PI*2*(i/(double) step);
                        double x = player.getX() + 1.2 * Math.cos(angle);
                        double y = player.getEyeY() + 0.5;
                        double z = player.getZ() + 1.2 * Math.sin(angle);

                        world.addParticle(ParticleTypes.HEART, x, y, z, 0.1, 0.1, 0);

                    }
                }
            }
            super.inventoryTick(stack, world, entity, slot, selected);
        }
    }

}
