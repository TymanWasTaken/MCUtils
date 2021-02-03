package com.tyman.mcutils.config;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

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

    // Things

    @Property(
            type = PropertyType.SWITCH,
            name = "Hide players in the hub",
            description = "Stops rendering all entities in the hub (KINDA BROKEN)",
            category = "QOL",
            subcategory = "Things"
    )
    public static boolean hideHubPlayers;

    // Inventory

    @Property(
            type = PropertyType.SWITCH,
            name = "Add colors to fairy soul quest menu",
            description = "Highlighs finished areas green, not yet finished ones orange, and not started ones red.",
            category = "QOL",
            subcategory = "Inventory"
    )
    public static boolean showFairySoulQuestColors;

    public MCUtilsConfig() {
        super(new File("./config/mcutils.toml"));
        initialize();
    }
}
