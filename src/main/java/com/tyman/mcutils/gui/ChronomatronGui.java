package com.tyman.mcutils.gui;

import com.tyman.mcutils.config.MCUtilsConfig;
import com.tyman.mcutils.utils.Utils;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
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

public class ChronomatronGui {


    @SubscribeEvent
    public void onGuiRender(GuiScreenEvent.BackgroundDrawnEvent event) {
        if (MCUtilsConfig.showChronomatronWarning && event.gui instanceof GuiChest) {
            GuiChest inventory = (GuiChest) event.gui;
            Container containerChest = inventory.inventorySlots;
            if (containerChest instanceof ContainerChest) {
                String displayName = ((ContainerChest) containerChest).getLowerChestInventory().getDisplayName().getUnformattedText().trim();
                if (displayName.startsWith("Chronomatron (")) {
                    List<Slot> invSlots = inventory.inventorySlots.inventorySlots;
                    Pattern roundCounterPattern = Pattern.compile("Round: (\\d+)");
                    for (Slot slot : invSlots) {
                        if (slot.getStack() == null) {
                            continue;
                        }
                        String name = slot.getStack().getDisplayName();
                        name = StringUtils.stripControlCodes(name);
                        Matcher matcher = roundCounterPattern.matcher(name);
                        if (matcher.find() && matcher.groupCount() == 1) {
                            byte roundNum = Byte.parseByte(matcher.group(1));
                            if (roundNum > 15) {
                                Utils.drawOnSlot(inventory.inventorySlots.inventorySlots.size(), slot.xDisplayPosition, slot.yDisplayPosition, Color.RED.getRGB());
                            }
                        }
                    }
                }
            }
        }
    }
}
