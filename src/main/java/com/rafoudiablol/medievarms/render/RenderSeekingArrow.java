package com.rafoudiablol.medievarms.render;

import com.rafoudiablol.medievarms.entity.EntitySeekingArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.util.ResourceLocation;

public class RenderSeekingArrow extends RenderArrow<EntitySeekingArrow>
{
    public RenderSeekingArrow(RenderManager manager)
    {
        super(manager);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntitySeekingArrow entity)
    {
        return RenderTippedArrow.RES_ARROW;
    }
}
