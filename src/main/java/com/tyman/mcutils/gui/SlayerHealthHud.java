package com.tyman.mcutils.gui;

import com.tyman.mcutils.utils.Utils;
import com.tyman.mcutils.config.MCUtilsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlayerHealthHud {

    static int tickAmount = 1;
    private static final Pattern slayerMatch = Pattern.compile("\u2620 (Revenant Horror|Tarantula Broodfather|Sven Packmaster) ([0-9]+(?:\\.[0-9]+)?[Mk]?)\u2764");
    private String[] slayerHealth = null;
    //private static final ResourceLocation revHead = new ResourceLocation("mcutils", "revHead.png");

    @SubscribeEvent
    public void onTick(ClientTickEvent event) {
        tickAmount++; // check every 1/2 sec (yes, some of this is from dsm)
        if (tickAmount % 10 == 0 && MCUtilsConfig.slayerHealthHud) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayer player = minecraft.thePlayer;
            if (player != null) {
                double x = player.posX;
                double y = player.posY;
                double z = player.posZ;
                AxisAlignedBB scan = new AxisAlignedBB(x - 10, y - 10, z - 10, x + 10, y + 10, z + 10);
                List<EntityArmorStand> mobs = minecraft.theWorld.getEntitiesWithinAABB(EntityArmorStand.class, scan);
                String[] firstSlayer = null;
                for (EntityArmorStand armorStand : mobs) {
                    String armorStandText = StringUtils.stripControlCodes(armorStand.getName());
                    Matcher matcher = slayerMatch.matcher(armorStandText);
                    if (matcher.find(0) && matcher.groupCount() == 2) {
                        firstSlayer = new String[]{matcher.group(1), matcher.group(2)};
                        break;
                    }
                }
                slayerHealth = firstSlayer;
            }
        }
    }

    @SubscribeEvent
    public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
        if (MCUtilsConfig.slayerHealthHud) {
            Minecraft mc = Minecraft.getMinecraft();
            if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
                float realX = (float) MCUtilsConfig.slayerHudX / 100;
                float realY = (float) MCUtilsConfig.slayerHudY / 100;
                float x = mc.displayWidth * realX;
                float y = mc.displayHeight * realY;
                int color = Utils.getSlayerColor();
                //Minecraft.getMinecraft().renderEngine.bindTexture(revHead);
                if (slayerHealth != null) {
                    mc.fontRendererObj.drawString(slayerHealth[0] + ": " + slayerHealth[1], x / 2, y / 2, color, true);
                } else if (MCUtilsConfig.alwaysShowSlayerHealthHud) {
                    mc.fontRendererObj.drawString("No slayer", x / 2, y / 2, color, true);
                }
            }
        }
    }
}
