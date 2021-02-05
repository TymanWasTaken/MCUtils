package com.tyman.mcutils.utils;

//import com.google.common.collect.Sets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.command.ICommand;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;

import java.time.Duration;
import java.util.List;
//import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.lwjgl.opengl.GL11;

public class Utils {

//    public static final Set<String> sb_in_langs = Sets.newHashSet("SKYBLOCK","\u7A7A\u5C9B\u751F\u5B58", "\u7A7A\u5CF6\u751F\u5B58");

    public static Pattern lobbyRegex = Pattern.compile("(mini|mega|m|M)([0-9]{1,3}[A-Z])");

    public static int getColorFromConfig(int configValue) {
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

    public static boolean isOnSkyblock() {
        return ScoreboardUtils.hasSkyblockScoreboard(Minecraft.getMinecraft().theWorld.getScoreboard());
    }

    public static boolean isInHub() {
        Minecraft mc = Minecraft.getMinecraft();
        if (isOnSkyblock() && mc.theWorld.getScoreboard() != null) {
            List<String> scoreboard = ScoreboardUtils.getSidebarLines();
            boolean found = false;
            for (String line : scoreboard) {
                Matcher matcher = lobbyRegex.matcher(line);
                found = matcher.find();
            }
            return found;
        }
        return false;
    }

    public static void addCommands() {
        String[] commands = {
                "Math",
                "MCUtils",
                "UpdateCheck"
        };
        for (String command : commands) {
            try {
                ClientCommandHandler.instance.registerCommand(
                        (ICommand) Class.forName("com.tyman.mcutils.commands." + command + "Command").newInstance()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void drawOnSlot(int size, int xSlotPos, int ySlotPos, int colour) {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        int guiLeft = (sr.getScaledWidth() - 176) / 2;
        int guiTop = (sr.getScaledHeight() - 222) / 2;
        int x = guiLeft + xSlotPos;
        int y = guiTop + ySlotPos;
        // Move down when chest isn't 6 rows
        if (size != 90) y += (6 - (size - 36) / 9) * 9;

        GL11.glTranslated(0, 0, 1);
        Gui.drawRect(x, y, x + 16, y + 16, colour);
        GL11.glTranslated(0, 0, -1);
    }

    public static void sendLines(String formatting, String... messages) {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        for (String message : messages) {
            player.addChatMessage(
                    new ChatComponentText(formatting + message)
            );
        }
    }

    public static class Pair<F, S> {
        private final F first;
        private final S second;
        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        public String toString() {
            return "com.tyman.mcutils.utils.Utils$Pair[" + this.first + ", " + this.second + "]";
        }
    }

    public static boolean containsItem(List<?> list, Object obj) {
//        for (Object item : list) {
//            if (item.equals(obj)) return true;
//        }
        return false;
    }

    /**
     * Nicely formats a duration
     * @param d The amount of seconds
     * @return The formatted duration
     */
    public static String durationToString(double d) {
        return DurationFormatUtils.formatDurationWords((long) (d * 1000L), true, true);
    }
}
