package com.rafoudiablol.medievarms.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;

public class EnchantmentThunder extends EnchantmentBow
{
    public EnchantmentThunder() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        World world = target.getEntityWorld();
        double x = target.posX, y = target.posY, z = target.posZ;

        world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, true));
        super.onEntityDamaged(user, target, level);
    }
}
