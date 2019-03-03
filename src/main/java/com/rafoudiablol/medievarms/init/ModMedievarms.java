package com.rafoudiablol.medievarms.init;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
@Mod(modid = Version.MODID, name = Version.NAME, version = Version.VERSION)
@Mod.EventBusSubscriber
public class ModMedievarms
{
    @Mod.Instance
    public static Object mod;

    public static ModItem item;
    public static ModEntity entity;

    private Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        item = new ModItem();
        entity = new ModEntity();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(item);
        MinecraftForge.EVENT_BUS.register(entity);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
