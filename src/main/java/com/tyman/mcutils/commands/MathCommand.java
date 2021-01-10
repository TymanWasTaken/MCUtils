package com.tyman.mcutils.commands;

import com.tyman.mcutils.BasicCommand;
import com.tyman.mcutils.utils.MathEvaluator;
import net.minecraft.command.ICommandSender;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

@SuppressWarnings("unused")
public class MathCommand extends BasicCommand {

    public MathCommand() {
        super("math", new Object[]{"gt", 0});
    }

    @Override
    public void execute(ICommandSender sender, String[] args) {
        MathEvaluator evaluator = new MathEvaluator();
        String expr = String.join(" ", args);
        try {
            Double evaluation = evaluator.evaluate(String.join(" ",args));
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED  + "Result: " + EnumChatFormatting.AQUA + evaluation.toString()));
        } catch (IllegalArgumentException e) {
            sender.addChatMessage(new ChatComponentText("Invalid expression!"));
        }
    }
}