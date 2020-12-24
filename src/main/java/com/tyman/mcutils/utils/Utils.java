package com.tyman.mcutils.utils;

import com.google.common.collect.Sets;
import com.tyman.mcutils.config.MCUtilsConfig;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static final Set<String> sb_in_langs = Sets.newHashSet("SKYBLOCK","\u7A7A\u5C9B\u751F\u5B58", "\u7A7A\u5CF6\u751F\u5B58");

    public static Pattern lobbyRegex = Pattern.compile("(mini|mega|m|M)([0-9]{1,3}[A-Z])");

    public static int getSlayerColor() throws IllegalArgumentException {
        int configValue = MCUtilsConfig.slayerHudColor;
        int realColor;
        switch (configValue) {
            case 0: {
                realColor = 0x00FF00;
                break;
            }
            case 1: {
                realColor = 0xFFFF00;
                break;
            }
            case 2: {
                realColor = 0xFF0000;
                break;
            }
            case 3: {
                realColor = 0x0000FF;
                break;
            }
            case 4: {
                realColor = 0xFFA500;
                break;
            }
            case 5: {
                realColor = 0x000000;
                break;
            }
            default: {
                realColor = 0x080808;
                break;
            }
        }
        return realColor;
    }

    // BROKEN
    public static boolean isOnSkyblock() {
        return ScoreboardUtils.hasSkyblockScoreboard(Minecraft.getMinecraft().theWorld.getScoreboard());
    }
    public static boolean isInHub() {
        Minecraft mc = Minecraft.getMinecraft();
        if (isOnSkyblock() && mc.theWorld.getScoreboard() != null) {
            List<String> scoreboard = ScoreboardUtils.getSidebarLines();
            Matcher matcher = lobbyRegex.matcher(scoreboard.get(13));
            return matcher.find();
        }
        return false;
    }
}
