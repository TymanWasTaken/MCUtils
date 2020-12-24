package com.tyman.mcutils.commands;

import com.tyman.mcutils.MCUtilsMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class MathCommand extends CommandBase {

    MCUtilsMod mod;

    public MathCommand(MCUtilsMod mod) {
        this.mod = mod;
    }

    @Override
    public String getCommandName() {
        return "math";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "math";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }


    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        DoubleEvaluator evaluator = new DoubleEvaluator();
        Double evaluation = evaluator.evaluate(String.join(" ",args));
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED  + "Result: " + EnumChatFormatting.AQUA + evaluation.toString()));
    }
}