package fr.rpcore.rphud;

import fr.rpcore.rphud.events.Events;
import fr.rpcore.rphud.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Mod(modid = "rphud")
public class RPHud {

    public static final String MODID = "rphud";

    @Mod.Instance(RPHud.MODID)
    public static RPHud instance;


    @SidedProxy(clientSide = "fr.rpcore.rphud.proxy.ClientProxy", serverSide = "fr.rpcore.rphud.proxy.ServerProxy")
    public static CommonProxy proxy;


    public RPHud() {
        MinecraftForge.EVENT_BUS.register(new Events());
    }

    public static Configuration cfg;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        proxy.preInit(event.getSuggestedConfigurationFile());


        File file = new File(Minecraft.getMinecraft().mcDataDir + "/config/", "rphudtheme.txt");

        if (Methods.FileReader(file).equals("notexist")) {
            try (PrintWriter output = new PrintWriter(file)) {
                output.print("1");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        //Configuration

        cfg = new Configuration(event.getSuggestedConfigurationFile());

        try {
            cfg.load();
        } catch (Exception ex) {
            System.out.println("Failed to load configuration");
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }


    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
    }

}
/*

    Class By Nathanael2611
    EDIT 23/11/2018 : M4TH1EU_

 */