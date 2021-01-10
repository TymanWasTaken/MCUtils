package com.tyman.mcutils.commands;

import com.tyman.mcutils.BasicCommand;
import com.tyman.mcutils.MCUtilsMod;
import net.minecraft.command.ICommandSender;

import club.sk1er.mods.core.ModCore;

@SuppressWarnings("unused")
public class MCUtilsCommand extends BasicCommand {

    public MCUtilsCommand() {
        super("mcutils", new Object[]{"eq", 0});
    }

    @Override
    public void execute(ICommandSender sender, String[] args) {
        ModCore.getInstance().getGuiHandler().open(MCUtilsMod.INSTANCE.getConfig().gui());
    }
}
