package com.github.CrumCreators.lustrousness;

import com.github.CrumCreators.lustrousness.item.Backpacks;
import com.github.CrumCreators.lustrousness.item.Parts;
import net.fabricmc.api.ModInitializer;

import java.io.IOException;

public class Main implements ModInitializer {
    //modid
    public static String modid = "lustrousness";

    @Override
    public void onInitialize() {
        // Create and load the config
        try {
            Config.reload();
        } catch (IOException ioe) {
            // We cannot continue at this point, throw an error and crash.
            throw new RuntimeException("Cannot load or create config", ioe);
        }
        //register items
        Backpacks.registerBackpacks();
        Parts.registerStencils();
    }
}