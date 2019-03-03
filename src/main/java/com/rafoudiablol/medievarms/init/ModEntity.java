package com.rafoudiablol.medievarms.init;

import com.rafoudiablol.medievarms.entity.EntitySeekingArrow;
import com.rafoudiablol.medievarms.render.RenderSeekingArrow;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class ModEntity
{
    ModEntity()
    {
        // Arrow vanilla values: 64, 20, false
    }

    @SubscribeEvent
    public void registerEntity(RegistryEvent.Register<EntityEntry> event)
    {
        EntityRegistry.registerModEntity(
                new ModelResourceLocation(EntityList.getKey(EntityTippedArrow.class), "entity"),
                EntitySeekingArrow.class,
                "seeking_arrow",
                10,
                ModMedievarms.mod,
                64,
                5,
                false
        );
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(EntitySeekingArrow.class, RenderSeekingArrow::new);
    }
}