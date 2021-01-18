package com.tyman.mcutils.gui;

import com.tyman.mcutils.config.MCUtilsConfig;
import com.tyman.mcutils.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InventoryHud {

    public static boolean warningShown = false;
    @SubscribeEvent
    public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
        if (MCUtilsConfig.invHud && event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayerSP player = mc.thePlayer;
            GuiIngame gui = Minecraft.getMinecraft().ingameGUI;
            List<ItemStack> invWithoutNull = Arrays.stream(player.inventory.mainInventory)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            int fullSlots = invWithoutNull.size();
            float realX = (float) MCUtilsConfig.invHudX / 100;
            float realY = (float) MCUtilsConfig.invHudY / 100;
            float x = mc.displayWidth * realX;
            float y = mc.displayHeight * realY;
            x /= 2;
            y /= 2;
            int color = Utils.getColorFromConfig(MCUtilsConfig.invHudColor);
            mc.fontRendererObj.drawString(fullSlots + "/36 slots filled", x, y, color, true);
            if (fullSlots >= MCUtilsConfig.invWarningThreshold && !warningShown) {
                player.playSound("random.orb", 1, 0.25F);
                // change the colors if you dont like it, i personally think the gold doesnt match with red
                // skidded from tom's solution from some mod from forums
                player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "[MCUtils] " + EnumChatFormatting.RED + "Inventory slots warning!"));
                gui.displayTitle(EnumChatFormatting.RED + "Inventory space warning", null, 0,2,1);
                gui.displayTitle(null, "Clear some space.", 0,2,1);
                warningShown = true;
            }
            if (fullSlots < MCUtilsConfig.invWarningThreshold) {
                warningShown = false;
            }
        }
    }
}
