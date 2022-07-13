package com.github.CrumCreators.lustrousness.util;// Created 2022-13-07T01:12:20

import eu.pb4.polymer.api.resourcepack.PolymerModelData;
import eu.pb4.polymer.api.resourcepack.PolymerRPUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.github.CrumCreators.lustrousness.Main.modid;

/**
 * @author Ampflower
 * @since ${version}
 **/
public class PolyLustUtils {

    /**
     * Creates &amp; registers a Polymer item with a model bound for the given masking item.
     *
     * @param path The path of the item in the registry.
     * @param mask The vanilla item to act as the mask.
     * @return A registered Polymer item ready for use.
     */
    public static Item ofModelled(String path, Item mask) {
        PolymerModelData modelData = PolymerRPUtils.requestModel(mask, new Identifier(modid, "item/" + path));
        ModelledPolymerItem item = new ModelledPolymerItem(new FabricItemSettings().group(ItemGroup.MISC), modelData, mask);
        Registry.register(Registry.ITEM, new Identifier(modid, path), item);
        return item;
    }
}
