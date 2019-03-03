package com.rafoudiablol.medievarms.entity;

import com.rafoudiablol.medievarms.init.ModMedievarms;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySeekingArrow extends EntityArrow
{
    public EntitySeekingArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntitySeekingArrow(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntitySeekingArrow(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
        //setNoGravity(true);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModMedievarms.item.seekingArrow, 1);
    }
}
