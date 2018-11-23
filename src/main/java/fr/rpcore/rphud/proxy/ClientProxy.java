package fr.rpcore.rphud.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

import java.io.File;


public class ClientProxy extends CommonProxy {

    public static KeyBinding keyBindTest;

    @Override
    public void preInit(File configFile) {

        super.preInit(configFile);
        System.out.println("Client side)");

        keyBindTest = new KeyBinding("RP-HUD GUI", Keyboard.KEY_H, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(keyBindTest);
    }


    @Override
    public void init() {
        super.init();
    }
}
/*

    Class By Nathanael2611
    EDIT 23/11/2018 : M4TH1EU_

 */