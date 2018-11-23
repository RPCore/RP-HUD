package fr.rpcore.rphud.events;

import com.mojang.realmsclient.gui.ChatFormatting;
import fr.rpcore.rphud.Methods;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Events {



    @SubscribeEvent
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent e) {
        if (e.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {

            e.setCanceled(true);

            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
            GuiUtils.drawTexturedModalRect(3, 100, 16, 0, 16, 16, 0);
            int l = (int)Minecraft.getMinecraft().player.getHealth();
            Minecraft.getMinecraft().fontRenderer.drawString(""+ChatFormatting.RED+Methods.toPercentage(l, 20)+"%"+ChatFormatting.WHITE, 20, 103, 000);

        }

        if(e.getType() == RenderGameOverlayEvent.ElementType.FOOD){
            e.setCanceled(true);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
            GuiUtils.drawTexturedModalRect(3, 120, 0, 0, 16, 16, 0);
            int l = (int)Minecraft.getMinecraft().player.getFoodStats().getFoodLevel();
            Minecraft.getMinecraft().fontRenderer.drawString(""+ChatFormatting.RED+Methods.toPercentage(l, 20)+"%"+ChatFormatting.WHITE, 20, 123, 000);
        }
    }




}
