package com.rafoudiablol.medievarms.item;

import com.rafoudiablol.medievarms.entity.EntitySeekingArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSeekingArrow extends ItemArrow
{
    public ItemSeekingArrow(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        return new EntitySeekingArrow(worldIn, shooter);
    }
}
