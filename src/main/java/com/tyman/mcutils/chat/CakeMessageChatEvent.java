package com.tyman.mcutils.chat;

import com.tyman.mcutils.config.MCUtilsConfig;
import com.tyman.mcutils.utils.CakeMessages;
import com.tyman.mcutils.utils.Utils;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CakeMessageChatEvent {

    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event) {
        if (!MCUtilsConfig.sendRoyalResidentMessages) return;
        Utils.Pair<Integer, CakeMessages.MessageStatus> result = CakeMessages.getRemainingMessages(event.message.getUnformattedText());
        Integer remaining = result.getFirst();
        CakeMessages.MessageStatus status = result.getSecond();
        if (status != CakeMessages.MessageStatus.INVALID) {
            if (status == CakeMessages.MessageStatus.CAKE) {
                Utils.sendLines(
                        EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD,
                        "Messages until cake: " + (remaining - CakeMessages.achievementMessages.size()) + " (approx " + Utils.durationToString(remaining * 5.5) + "s)",
                        "Messages until achievement: " + remaining + " (approx " + Utils.durationToString(remaining * 5.5) + ")"
                );
            }
            if (status == CakeMessages.MessageStatus.ACHIEVEMENT) {
                Utils.sendLines(
                        EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD,
                        "Messages until achievement: " + remaining + " (approx " + Utils.durationToString(remaining * 5.5) + ")"
                );
            }
        }
    }
}
