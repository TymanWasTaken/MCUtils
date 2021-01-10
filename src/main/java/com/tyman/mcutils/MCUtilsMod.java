package com.tyman.mcutils;

import com.tyman.mcutils.gui.InventoryHud;
import com.tyman.mcutils.gui.SlayerHealthHud;
import com.tyman.mcutils.config.MCUtilsConfig;
import com.tyman.mcutils.modcore.ModCoreInstaller;
import static com.tyman.mcutils.utils.UpdateChecker.*;

import com.tyman.mcutils.utils.Utils;
import net.minecraft.client.Minecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MCUtilsMod.MODID, version = MCUtilsMod.VERSION)
public class MCUtilsMod
{
    public static final String MODID = "mcutils";
    public static final String VERSION = "1.0.2";
    public static UpdateStatus updateStatus;

    private final MCUtilsConfig config = new MCUtilsConfig();

    @Mod.Instance(MODID)
    public static MCUtilsMod INSTANCE;

    public MCUtilsConfig getConfig() {
        return config;
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Check for mod updates
        updateStatus = checkForUpdates();
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Utils.addCommands();
        MinecraftForge.EVENT_BUS.register(new SlayerHealthHud());
        MinecraftForge.EVENT_BUS.register(new InventoryHud());
        // broken features brrrrrrrr
        // MinecraftForge.EVENT_BUS.register(new HideHubPlayers());
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);
    }
}
