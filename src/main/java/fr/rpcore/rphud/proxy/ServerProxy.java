package fr.rpcore.rphud.proxy;

import java.io.File;

public class ServerProxy extends CommonProxy {



    @Override
    public void preInit(File configFile)
    {

        super.preInit(configFile);

        System.out.println("salut ! Côté server c'te fois ci :)");

    }


    @Override
    public void init()
    {
        super.init();
    }




}
