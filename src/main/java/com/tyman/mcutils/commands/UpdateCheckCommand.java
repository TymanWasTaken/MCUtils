package com.tyman.mcutils.commands;

import com.tyman.mcutils.BasicCommand;
import com.tyman.mcutils.utils.UpdateChecker;
import net.minecraft.command.ICommandSender;

@SuppressWarnings("unused")
public class UpdateCheckCommand extends BasicCommand {

    public UpdateCheckCommand() {
        super("checkupdates", new Object[]{"eq", 0});
    }

    public void execute(ICommandSender sender, String[] args) {
        UpdateChecker.checkForUpdates();
    }
}
