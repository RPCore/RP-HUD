package fr.rpcore.rphud.events;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {



    @SubscribeEvent
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent e){

        if(e.getType() == RenderGameOverlayEvent.ElementType.HEALTH){

            e.setCanceled(true);

        }



    }





}
