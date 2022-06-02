package com.github.CrumCreators.lustrousness.utils;

public class RNG {

    static int min = 10;
    static int max = 50;
    public static int rngout;

    public static void randomize() {
        rngout = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println(rngout);
    }
}
