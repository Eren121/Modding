package com.example.examplemod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class Registry
{
    public static class Enchants
    {
        public static final Enchantment THUNDER = new EnchantmentThunder().setRegistryName("thunder");
    }

    public static class Items
    {
        public static final Item SEEKING_ARROW  = new ItemArrowSeeking().setRegistryName("seeking_arrow")
                .setUnlocalizedName("seeking_arrow");
    }

    public static class Entities {

        public static EntityEntry SEEKING_ARROW;


        public static void init()
        {
             SEEKING_ARROW = EntityEntryBuilder.create()
                    .entity(EntitySeekingArrow.class)
                    .name("seeking_arrow")
                    .id("seeking_arrow", 1)
                     .tracker(64, 5, true)
                    .build();
        }
    }
}
