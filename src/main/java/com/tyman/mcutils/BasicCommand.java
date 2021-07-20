package com.tyman.mcutils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.Arrays;
import java.util.function.Supplier;

public abstract class BasicCommand extends CommandBase {
    String cmdName;
    Object[] argCount;

    public abstract void execute(ICommandSender sender, String[] args);

    public BasicCommand(String name, Object[] argCount) {
        this.cmdName = name;
        String[] argModifiers = {"eq", "lt", "gt"};
        if (Arrays.stream(argModifiers).noneMatch(argCount[0]::equals)) {
            throw new IllegalArgumentException("Invalid argument length modifier");
        }
        this.argCount = argCount;
    }

    @Override
    public String getCommandName() {
        return cmdName;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return cmdName;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        try {
            Supplier<Boolean> expr = () -> args.length == (int) argCount[1];
            if (argCount[0] == "eq") {
                expr = () -> args.length == (int) argCount[1];
            } else if (argCount[0] == "lt") {
                expr = () -> args.length < (int) argCount[1];
            } else if (argCount[0] == "gt") {
                expr = () -> args.length > (int) argCount[1];
            }
            if (expr.get()) {
                this.execute(sender, args);
            } else {
                String argModNice = "Exactly ";
                switch ((String) argCount[0]) {
                    case "eq":
                        argModNice = "Exactly ";
                        break;

                    case "gt":
                        argModNice = "More than ";
                        break;

                    case "lt":
                        argModNice = "Less than ";
                        break;
                }
                sender.addChatMessage(
                        new ChatComponentText(
                                EnumChatFormatting.RED +
                                        "Invalid amount of arguments given!\n" +
                                        "Correct: " + argModNice + argCount[1] + " " +
                                        "Given: " + args.length
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "An error occurred while executing the command:"));
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + e.getMessage()));
        }
    }
}