package com.rafoudiablol.medievarms.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.World;

public class EnchantmentThunder extends Enchantment
{
    public EnchantmentThunder()
    {
        super(Rarity.VERY_RARE, EnumEnchantmentType.BOW, new EntityEquipmentSlot[0]);
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        World world = target.getEntityWorld();
        double x = target.posX, y = target.posY, z = target.posZ;

        world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, false));
        super.onEntityDamaged(user, target, level);
    }
}
