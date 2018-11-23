package fr.rpcore.rphud.events;

import com.mojang.realmsclient.gui.ChatFormatting;
import fr.rpcore.rphud.Methods;
import fr.rpcore.rphud.RPHud;
import fr.rpcore.rphud.gui.ChosseThemeGui;
import fr.rpcore.rphud.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.opengl.GL11;

import java.io.File;

public class Events {



    @SubscribeEvent
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent e) {


        File file=new File(Minecraft.getMinecraft().mcDataDir+"/config/", "rphudtheme.txt");

        //THEME 1
        if(Methods.FileReader(file).equals("1")) {
            if (e.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 100, 16, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getHealth();
                Minecraft.getMinecraft().fontRenderer.drawString("" + ChatFormatting.WHITE + Methods.toPercentage(l, 20) + "%" + ChatFormatting.WHITE, 20, 103, 000);
            }
            if (e.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 120, 0, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getFoodStats().getFoodLevel();
                Minecraft.getMinecraft().fontRenderer.drawString("" + ChatFormatting.WHITE + Methods.toPercentage(l, 20) + "%" + ChatFormatting.WHITE, 20, 123, 000);
            }

            if (e.getType() == RenderGameOverlayEvent.ElementType.ARMOR) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 140, 32, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getTotalArmorValue();
                Minecraft.getMinecraft().fontRenderer.drawString("" + ChatFormatting.WHITE + Methods.toPercentage(l, 20) + "%" + ChatFormatting.WHITE, 20, 143, 000);
            }
            if (e.getType() == RenderGameOverlayEvent.ElementType.AIR) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 160, 48, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getTotalArmorValue();
                Minecraft.getMinecraft().fontRenderer.drawString("" + ChatFormatting.WHITE + Methods.toPercentage((int) Minecraft.getMinecraft().player.getAir(), 20) / 15 + "%" + ChatFormatting.WHITE, 20, 163, 000);
            }
        }

        //THEME 2
        if(Methods.FileReader(file).equals("2")) {



            if (e.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/black.png"));
                GuiUtils.drawTexturedModalRect(20, 102, 0, 0, 100,  10, 0);

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 100, 16, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getHealth();
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/lifebar.png"));
                GuiUtils.drawTexturedModalRect(20, 102, 100, 100, Methods.toPercentage((int)Minecraft.getMinecraft().player.getHealth(), 20),  10, 0);            }
            if (e.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/black.png"));
                GuiUtils.drawTexturedModalRect(20, 122, 0, 0, 100,  10, 0);

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 120, 0, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getFoodStats().getFoodLevel();
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/foodbar.png"));
                GuiUtils.drawTexturedModalRect(20, 122, 100, 100, Methods.toPercentage((int)Minecraft.getMinecraft().player.getFoodStats().getFoodLevel(), 20),  10, 0);            }

            if (e.getType() == RenderGameOverlayEvent.ElementType.ARMOR) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/black.png"));
                GuiUtils.drawTexturedModalRect(20, 142, 0, 0, 100,  10, 0);

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 140, 32, 0, 16, 16, 0);
                int l = (int) Minecraft.getMinecraft().player.getTotalArmorValue();
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/armorbar.png"));
                GuiUtils.drawTexturedModalRect(20, 142, 100, 100, Methods.toPercentage((int)Minecraft.getMinecraft().player.getTotalArmorValue(), 20),  10, 0);            }
            if (e.getType() == RenderGameOverlayEvent.ElementType.AIR) {
                e.setCanceled(true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/black.png"));
                GuiUtils.drawTexturedModalRect(20, 162, 100, 100, 100,  10, 0);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/icons.png"));
                GuiUtils.drawTexturedModalRect(3, 160, 48, 0, 16, 16, 0);
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("rphud", "content/airbar.png"));
                GuiUtils.drawTexturedModalRect(20, 162, 100, 100, Methods.toPercentage((int)Minecraft.getMinecraft().player.getAir(), 20)/15,  10, 0);

            }
        }

    }


    @SubscribeEvent
    public void onEvent(InputEvent.KeyInputEvent e)
    {


        if(ClientProxy.keyBindTest.isPressed())
        {
            keyTestTyped();
        }
    }

    private void keyTestTyped()
    {


        Minecraft.getMinecraft().displayGuiScreen(new ChosseThemeGui());


    }



}

/*

    Class By Nathanael2611

 */