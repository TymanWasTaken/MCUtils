package com.tyman.mcutils.commands;

import com.tyman.mcutils.BasicCommand;
import com.tyman.mcutils.MCUtilsMod;
import gg.essential.api.utils.GuiUtil;
import net.minecraft.command.ICommandSender;

import java.util.Objects;

@SuppressWarnings("unused")
public class MCUtilsCommand extends BasicCommand {

    public MCUtilsCommand() {
        super("mcutils", new Object[]{"eq", 0});
    }

    @Override
    public void execute(ICommandSender sender, String[] args) {
        GuiUtil.open(Objects.requireNonNull(MCUtilsMod.INSTANCE.getConfig().gui()));
    }
}
