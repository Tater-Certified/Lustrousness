package com.github.CrumCreators.lustrousness;

import com.github.CrumCreators.lustrousness.item.LustItems;
import eu.pb4.polymer.api.resourcepack.PolymerRPUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

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
        PolymerRPUtils.addAssetSource(modid);
        LustItems.init();
    }

    public static void bounce(LivingEntity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (entity.fallDistance > 1.5 && vec3d.y < 0) {
            double d = 1.0, e = 0.4;
            entity.setVelocity(vec3d.x * e, -vec3d.y * d, vec3d.z * e);
            entity.velocityModified = true;
        }
    }
}