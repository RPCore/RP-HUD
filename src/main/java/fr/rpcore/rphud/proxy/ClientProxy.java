package fr.rpcore.rphud.proxy;

import net.minecraft.client.settings.KeyBinding;

import java.io.File;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;



public class ClientProxy extends CommonProxy{

    public static KeyBinding keyBindTest;

    @Override
    public void preInit(File configFile)
    {

        super.preInit(configFile);

        System.out.println("salut ! Côté client c'te fois ci :)");

        keyBindTest = new KeyBinding("RP-HUD GUI", Keyboard.KEY_H, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(keyBindTest);


    }


    @Override
    public void init()
    {
        super.init();
    }


}
/*

    Class By Nathanael2611

 */