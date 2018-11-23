package fr.rpcore.rphud.proxy;

import java.io.File;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(File configFile) {
        super.preInit(configFile);
        System.out.println("Server side.)");

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