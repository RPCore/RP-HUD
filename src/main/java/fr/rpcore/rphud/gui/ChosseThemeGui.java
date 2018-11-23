package fr.rpcore.rphud.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import fr.rpcore.rphud.Methods;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ChosseThemeGui extends GuiScreen {


    Minecraft mc = Minecraft.getMinecraft();
    private final int ImageHeight = 250, ImageWidth = 250, ImageScale = 250;
    private GuiTextField themeField;


    public ChosseThemeGui() {
    }

    @Override
    public void initGui() {
        buttonList.clear();


        this.themeField = new GuiTextField(1, Minecraft.getMinecraft().fontRenderer, this.width / 2 + 10, 140, 137, 20);
        themeField.setMaxStringLength(23);

        File file = new File(Minecraft.getMinecraft().mcDataDir + "/config/", "rphudtheme.txt");

        themeField.setText(Methods.FileReader(file));


    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.themeField.updateCursorCounter();

    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float particle) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableColorMaterial();

        this.drawDefaultBackground();
        this.themeField.drawTextBox();

        super.drawScreen(parWidth, parHeight, particle);

        //Adjust these values to move locations of elements without individual adjustment
        int offLeft = (int) ((width - ImageWidth) / 2.0F);
        int offTop = 30;
        int topOffset = 20;


        //drawModalRectWithCustomSizedTexture(offLeft, offTop, 0, 0, ImageScale,ImageScale,ImageScale,ImageScale);

        fontRenderer.drawString(ChatFormatting.WHITE + "Thème disponibles :" , offLeft + 169 - 140, 35 + topOffset, 0X000000);
        fontRenderer.drawString(ChatFormatting.WHITE + "  0 : Thème par défaut." , offLeft + 169 - 140, 50 + topOffset, 0X000000);
        fontRenderer.drawString(ChatFormatting.WHITE + "  1 : Thème avec icones." , offLeft + 169 - 140, 60 + topOffset, 0X000000);
        fontRenderer.drawString(ChatFormatting.WHITE + "  2 : Thème avec barres." , offLeft + 169 - 140, 70 + topOffset, 0X000000);

        File file = new File(Minecraft.getMinecraft().mcDataDir + "/config/", "rphudtheme.txt");


        int x90 = Integer.parseInt(Methods.FileReader(file));

        if (x90 > 2) {
            Minecraft.getMinecraft().fontRenderer.drawString(ChatFormatting.RED + "Ce thème n'existe pas !" + ChatFormatting.WHITE, offLeft + 169 - 140, 80 + topOffset, 0X000000);

        }


        this.buttonList.add(new GuiButton(1, offLeft + 169 - 140, 140, 100, 20, "Changer le thème"));


        super.drawScreen(parWidth, parHeight, particle);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) {
        try {
            super.keyTyped(typedChar, keyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.themeField.textboxKeyTyped(typedChar, keyCode);


    }

    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) {
    }

    protected void mouseClicked(int x, int y, int btn) {
        try {
            super.mouseClicked(x, y, btn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.themeField.mouseClicked(x, y, btn);

    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {

            File file = new File(Minecraft.getMinecraft().mcDataDir + "/config/", "rphudtheme.txt");

            try (PrintWriter output = new PrintWriter(file)) {


                output.print(themeField.getText());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    static class GenericButton extends GuiButton {
        public GenericButton(int x, int y, int width, int height, String text) {
            super(1, x, y, width, height, text);
        }
    }
}
/*

    Class By Nathanael2611
    EDIT 23/11/2018 : M4TH1EU_


 */




