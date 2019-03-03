package com.rafoudiablol.medievarms.init;

import com.rafoudiablol.medievarms.examplemod.Registry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListWorldSelection;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

@Mod(modid = Medievarms.MODID, name = Medievarms.NAME, version = Medievarms.VERSION)
@Mod.EventBusSubscriber
public class Medievarms
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event)
            throws IllegalAccessException
    {
        registerClass(event, Registry.Enchants.class, Enchantment.class);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
            throws IllegalAccessException
    {
        registerClass(event, Registry.Items.class, Item.class);
    }


    //@SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event)
            throws IllegalAccessException
    {
        Registry.Entities.init();
        registerClass(event, Registry.Entities.class, EntityEntry.class);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {

    }

    //@SubscribeEvent
    public void joinWorldQuickly(GuiScreenEvent.InitGuiEvent event)
            throws IllegalAccessException
    {
        GuiScreen gui = event.getGui();

        if(gui instanceof GuiMainMenu) {

            GuiMainMenu menu = (GuiMainMenu)gui;
            GuiWorldSelection select = new GuiWorldSelection(menu);
            Minecraft.getMinecraft().displayGuiScreen(select);

            for(Field f : select.getClass().getDeclaredFields()) {

                if(GuiListWorldSelection.class.isAssignableFrom(f.getType())) {

                    f.setAccessible(true);
                    GuiListWorldSelection list = (GuiListWorldSelection)f.get(select);
                    list.selectWorld(0);
                    list.getSelectedWorld().joinWorld();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private<T extends IForgeRegistryEntry<T>>
    void registerClass(RegistryEvent.Register<T> event, Class clazz, Class<T> type)
        throws IllegalAccessException
    {
        IForgeRegistry<T> register = event.getRegistry();

        for(Field field : clazz.getDeclaredFields())
        {
            if(type.isAssignableFrom(field.getType()))
            {
                IForgeRegistryEntry<T> obj = (T)field.get(null);
                logger.info("registering " + type.getSimpleName() + ": " + obj.getRegistryName());
                register.register((T)obj);
            }
        }
    }
}
