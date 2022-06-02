package com.github.CrumCreators.lustrousness;


import com.github.CrumCreators.lustrousness.utils.RNG;
import net.fabricmc.api.ModInitializer;


public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        RNG.randomize();
    }
    public static void main(String[] args) {
        RNG.randomize();
    }
}