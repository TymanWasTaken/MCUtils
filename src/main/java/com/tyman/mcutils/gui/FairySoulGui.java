package com.tyman.mcutils.gui;

import com.tyman.mcutils.config.MCUtilsConfig;
import com.tyman.mcutils.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Slot;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FairySoulGui {
    @SubscribeEvent
    public void onGuiRender(GuiScreenEvent.BackgroundDrawnEvent event) {
        if (MCUtilsConfig.showFairySoulQuestColors && event.gui instanceof GuiChest) {
            GuiChest inventory = (GuiChest) event.gui;
            Container containerChest = inventory.inventorySlots;
            if (containerChest instanceof ContainerChest) {
                String displayName = ((ContainerChest) containerChest).getLowerChestInventory().getDisplayName().getUnformattedText().trim();
                if (displayName.equals("Fairy Souls Guide")) {
                    List<Slot> invSlots = inventory.inventorySlots.inventorySlots;
                    EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
                    Pattern fairySoulAreaPattern = Pattern.compile("Fairy Souls: (\\d{1,2})/(\\d{1,2})");
                    for (Slot slot : invSlots) {
                        if (slot.getStack() == null) {
                            continue;
                        }
                        List<String> tooltip = slot.getStack().getTooltip(player, false);
                        String lore = StringUtils.stripControlCodes(String.join("\n", tooltip));
                        Matcher matcher = fairySoulAreaPattern.matcher(lore);
                        if (matcher.find() && matcher.groupCount() == 2) {
                            if (matcher.group(1).equals(matcher.group(2))) {
                                Utils.drawOnSlot(inventory.inventorySlots.inventorySlots.size(), slot.xDisplayPosition, slot.yDisplayPosition, Color.GREEN.getRGB());
                            } else if (matcher.group(1).equals("0")) {
                                Utils.drawOnSlot(inventory.inventorySlots.inventorySlots.size(), slot.xDisplayPosition, slot.yDisplayPosition, Color.RED.getRGB());
                            } else if (!matcher.group(1).equals("0") && !matcher.group(1).equals(matcher.group(2))) {
                                Utils.drawOnSlot(inventory.inventorySlots.inventorySlots.size(), slot.xDisplayPosition, slot.yDisplayPosition, Color.decode("#ff9100").getRGB());
                            }
                        }
                    }
                }
            }
        }
    }
}
