package com.rafoudiablol.medievarms.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySeekingArrow extends EntityArrow
{
    protected Entity target;

    public EntitySeekingArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntitySeekingArrow(World worldIn, EntityLivingBase shooter, EntityLiving trg)
    {
        super(worldIn, shooter);
        //setNoGravity(true);

        if(target == this) {
            System.out.println("THIS TARGET");
        }
        else {
            target = trg;
        }
    }

    @Override
    public void onUpdate()
    {
        if(target != null)
        {
            double speed = 2.0;
            double vecX = target.posX - posX;
            double vecY = target.posY - posY;
            double vecZ = target.posZ - posZ;
            double norm = Math.sqrt(vecX * vecX + vecY * vecY + vecZ * vecZ);
            vecX /= norm;
            vecY /= norm;
            vecZ /= norm;

            motionX = vecX;
            motionY = vecY;
            motionZ = vecZ;
        }

        super.onUpdate();

    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(Registry.Items.SEEKING_ARROW, 1);
    }
}
