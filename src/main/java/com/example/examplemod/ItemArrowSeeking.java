package com.example.examplemod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArrowSeeking extends ItemArrow
{
    @Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityLiving target = target = (EntityLiving)worldIn.findNearestEntityWithinAABB(EntityLiving.class, shooter.getEntityBoundingBox().grow(30), shooter);
        return new EntitySeekingArrow(worldIn, shooter, target);
    }
}
