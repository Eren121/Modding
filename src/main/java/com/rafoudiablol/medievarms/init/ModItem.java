package com.rafoudiablol.medievarms.init;

import com.rafoudiablol.medievarms.item.ItemSeekingArrow;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("unused")
public class ModItems
{
    public Item seekingArrow;

    ModItems()
    {
        seekingArrow = new ItemSeekingArrow("seeking_arrow");
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(seekingArrow);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(seekingArrow, 0,
            new ModelResourceLocation(Items.ARROW.getRegistryName(), "inventory"));
    }
}