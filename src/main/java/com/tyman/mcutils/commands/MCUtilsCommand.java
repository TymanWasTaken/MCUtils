package com.tyman.mcutils.commands;

import com.tyman.mcutils.MCUtilsMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import club.sk1er.mods.core.ModCore;

public class MCUtilsCommand extends CommandBase {
    MCUtilsMod mod;

    public MCUtilsCommand(MCUtilsMod mod) {
        this.mod = mod;
    }

    @Override
    public String getCommandName() {
        return "mcutils";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "mcutils";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ModCore.getInstance().getGuiHandler().open(MCUtilsMod.INSTANCE.getConfig().gui());
    }
}
