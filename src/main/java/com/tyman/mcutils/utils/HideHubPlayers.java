package com.tyman.mcutils.utils;

import com.tyman.mcutils.config.MCUtilsConfig;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HideHubPlayers {
    @SubscribeEvent
    public void onRenderPlayerEventPre(RenderPlayerEvent.Pre event) {
        if (MCUtilsConfig.hideHubPlayers && Utils.isInHub() && event.isCancelable()) {
            event.setCanceled(true);
        }
    }
}
