package com.tyman.mcutils.config;

import com.tyman.mcutils.MCUtilsMod;
import com.tyman.mcutils.utils.Utils;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.List;

public class ItemConfig {
    public static String getCustomLoreFromUUID(String UUID) {
        try {
            String mainJson = Utils.readFile(MCUtilsMod.mainItemCfgFile);
            JsonParser jsonParser = new JsonParser();
            JsonObject json = (JsonObject) jsonParser.parse(mainJson);
            String loreFile = json.get(UUID).getAsString();
            return Utils.readFile(new File(loreFile));
        } catch (Exception e) {
            return null;
        }
    }
}
