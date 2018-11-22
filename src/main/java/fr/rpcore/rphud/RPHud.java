package fr.rpcore.rphud;

import fr.rpcore.rphud.events.Events;
import fr.rpcore.rphud.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="rphud")
public class RPHud {




    public static final String MODID = "rastawarmod";


    @Mod.Instance(RPHud.MODID)
    public static RPHud instance;




    @SidedProxy(clientSide = "fr.rpcore.rphud.proxy.ClientProxy", serverSide = "fr.rpcore.rphud..proxy.ServerProxy")
    public static CommonProxy proxy;


    public RPHud(){
        MinecraftForge.EVENT_BUS.register(new Events());


    }


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        proxy.preInit(event.getSuggestedConfigurationFile());




    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        proxy.init();



    }


    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event)
    {

    }

}
