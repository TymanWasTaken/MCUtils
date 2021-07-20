package com.tyman.mcutils.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

@SuppressWarnings("unused")
public class MCUtilsConfig extends Vigilant {

    /*******************
            Gui
    ********************/

    // Slayers

    @Property(
            type = PropertyType.SWITCH,
            name = "Slayer Health Gui",
            description = "Shows the health of the nearest slayer on your screen",
            category = "Gui",
            subcategory = "Slayers"
    )
    public static boolean slayerHealthHud;

    @Property(
            type = PropertyType.SWITCH,
            name = "Always Show Slayer Health Gui",
            description = "Toggles weather or not to show the hud, even when there isn't a slayer around.",
            category = "Gui",
            subcategory = "Slayers"
    )
    public static boolean alwaysShowSlayerHealthHud;

    @Property(
            type = PropertyType.SLIDER,
            max = 100,
            name = "X percentage",
            description = "Percentage of X value of slayer hud",
            category = "Gui",
            subcategory = "Slayers"
    )
    public static int slayerHudX;

    @Property(
            type = PropertyType.SLIDER,
            max = 100,
            name = "Y percentage",
            description = "Percentage of Y value of slayer hud",
            category = "Gui",
            subcategory = "Slayers"
    )
    public static int slayerHudY;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Slayer Gui Color",
            category = "Gui",
            subcategory = "Slayers",
            description = "Choose what color the slayer health gui is",
            options = {"green", "yellow", "red", "blue", "orange", "black"}
    )
    public static int slayerHudColor;

    // Inventory

    @Property(
            type = PropertyType.SWITCH,
            name = "Inventory hud",
            description = "Shows how full your inventory is",
            category = "Gui",
            subcategory = "Inventory"
    )
    public static boolean invHud;

    @Property(
            type = PropertyType.SLIDER,
            max = 100,
            name = "X percentage",
            description = "Percentage of X value of inventory hud",
            category = "Gui",
            subcategory = "Inventory"
    )
    public static int invHudX;

    @Property(
            type = PropertyType.SLIDER,
            max = 100,
            name = "Y percentage",
            description = "Percentage of Y value of inventory hud",
            category = "Gui",
            subcategory = "Inventory"
    )
    public static int invHudY;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Inventory Gui Color",
            category = "Gui",
            subcategory = "Inventory",
            description = "Choose what color the inventory gui is",
            options = {"green", "yellow", "red", "blue", "orange", "black"}
    )
    public static int invHudColor;

    @Property(
         type = PropertyType.SLIDER,
         name = "Inventory Space Warning Threshold",
         category = "Gui",
         subcategory = "Inventory",
         description = "How many slots full to show the warning",
         max = 36
    )
    public static int invWarningThreshold;

    /*******************
            QOL
    ********************/

    // Render

    @Property(
            type = PropertyType.SWITCH,
            name = "Hide players in the hub",
            description = "Stops rendering all entities in the hub (Disabled because it doesn't work)",
            category = "QOL",
            subcategory = "Things"
    )
    public static boolean hideHubPlayers;

    // Inventory

    @Property(
            type = PropertyType.SWITCH,
            name = "Add colors to fairy soul quest menu",
            description = "Highlights finished areas green, not yet finished ones orange, and not started ones red.",
            category = "QOL",
            subcategory = "Inventory"
    )
    public static boolean showFairySoulQuestColors;

    @Property(
            type = PropertyType.SWITCH,
            name = "Show warning when chronomatron is at max notes",
            description = "Will highlight the round indicator red once you have hit the max amount of notes for max XP.",
            category = "QOL",
            subcategory = "Inventory"
    )
    public static boolean showChronomatronWarning;

    // Chat

    @Property(
            type = PropertyType.SWITCH,
            name = "Show messages left and time for Royal Resident",
            description = "Will send a message in your chat showing the remaining messages needed, and the approximate time to go through them all.",
            category = "QOL",
            subcategory = "Chat"
    )
    public static boolean sendRoyalResidentMessages;

    public MCUtilsConfig() {
        super(new File("./config/mcutils.toml"));
        initialize();
    }
}
