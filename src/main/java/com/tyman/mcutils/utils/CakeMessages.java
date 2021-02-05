package com.tyman.mcutils.utils;

import com.google.common.collect.Lists;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringUtils;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.tyman.mcutils.utils.Utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CakeMessages {
    public static List<String> cakeMessages = new ArrayList<>();
    public static List<String> achievementMessages = new ArrayList<>();
    public static Pattern npcPrefixReg = Pattern.compile("\\[NPC] (No Name|Royal Resident): .+");

    public enum MessageStatus {
        CAKE,
        ACHIEVEMENT,
        INVALID
    }

    static {
        /*
            yes this is hard coded
            do i care
            no
         */
        // Messages to get cake
        cakeMessages.add("What are you doing in my room?");
        cakeMessages.add("Get out of my room now!");
        cakeMessages.add("I am going to call the guards if you don't leave");
        cakeMessages.add("Guards! Take them into custody NOW!");
        cakeMessages.add("Well hmph, I guess the guards are kind of busy right now...");
        cakeMessages.add("Can you just leave my room now?");
        cakeMessages.add("I mean seriously, what is your problem?");
        cakeMessages.add("I have never seen someone that stubborn before.");
        cakeMessages.add("Ok how about this, I'll give you 1,000 coins if you leave right now?");
        cakeMessages.add("No? Ok ok how about 10,000 coins then?");
        cakeMessages.add("For god's sake, please just leave my room!");
        cakeMessages.add("Alright alright, how does 1 Million coins sound to you?");
        cakeMessages.add("I guess you wanna stay poor?");
        cakeMessages.add("You sure you don't want the coins?");
        cakeMessages.add("Are you suuuuure?");
        cakeMessages.add("Suuuuuure???");
        cakeMessages.add("Welp I was kidding about the coins anyway...");
        cakeMessages.add("Not going to give someone like you coins.");
        cakeMessages.add("Way too precious.");
        cakeMessages.add("So how's life? Good?");
        cakeMessages.add("That's great to hear, how's the family?");
        cakeMessages.add("Wonderful, so what brings you here actually?");
        cakeMessages.add("What makes you play this game?");
        cakeMessages.add("What makes you continue to click me over and over again?");
        cakeMessages.add("You know this is gonna go on forever, right?");
        cakeMessages.add("I won't stop until you go away.");
        cakeMessages.add("So now that's out of the way, wanna hear a joke?");
        cakeMessages.add("You do?");
        cakeMessages.add("Great, get ready!");
        cakeMessages.add("What kind of music did the gold nugget listen to?");
        cakeMessages.add("*Heavy metal*");
        cakeMessages.add("I know, very funny!");
        cakeMessages.add("Wanna hear another one?");
        cakeMessages.add("I know you do.");
        cakeMessages.add("Why don't mining towns have hospitals?");
        cakeMessages.add("Because everyone there only ever suffers from miner injuries!");
        cakeMessages.add("Enough jokes for now...");
        cakeMessages.add("I am surprised you haven't left after those horrible jokes.");
        cakeMessages.add("Have you seen the monster behind you?");
        cakeMessages.add("Yea over there, just outside of the door!");
        cakeMessages.add("Go get it, it might want something from you.");
        cakeMessages.add("I think it's the Golden Goblin, it gives out free powder.");
        cakeMessages.add("Get it before you'll regret it.");
        cakeMessages.add("Come on! Get it, you are gonna miss it!");
        cakeMessages.add("... You missed it...");
        cakeMessages.add("Welp I guess no free powder for you then.");
        cakeMessages.add("I have never seen someone stay this long in here.");
        cakeMessages.add("You are a special being.");
        cakeMessages.add("You might deserve something nice!");
        cakeMessages.add("But not from me.");
        cakeMessages.add("Anyway, do you want to see a magic trick?");
        cakeMessages.add("You do??");
        cakeMessages.add("Ok get ready!");
        cakeMessages.add("You need to turn around for this one.");
        cakeMessages.add("Promise me?");
        cakeMessages.add("Good, turn around now!");
        cakeMessages.add("Tadaa");
        cakeMessages.add("Are you impressed?");
        cakeMessages.add("No?");
        cakeMessages.add("That makes me sad...");
        cakeMessages.add("I guess I'll have to give up my magic career now. Again.");
        cakeMessages.add("I had a lot of hopes and dreams.");
        cakeMessages.add("I wanted to become a magician.");
        cakeMessages.add("Perform on stage for thousands of people!");
        cakeMessages.add("But I guess that's not gonna work anymore...");
        cakeMessages.add("Because of you and those meddling kids...");
        cakeMessages.add("I mean you. Just you...");
        cakeMessages.add("You ruined my dream.");
        cakeMessages.add("I will never forgive you.");
        cakeMessages.add("Anyway, wanna grab a coffee some day?");
        cakeMessages.add("I like mine with a lot of milk.");
        cakeMessages.add("I don't know why I like milk so much.");
        cakeMessages.add("Maybe I was a cow in my past life?");
        cakeMessages.add("Imagine I was a cow, how funny would that be?");
        cakeMessages.add("Can you imagine that?");
        cakeMessages.add("Can you?");
        cakeMessages.add("Try imagining it harder");
        cakeMessages.add("Try harder!");
        cakeMessages.add("Welp now you imagined it a bit too much...");
        cakeMessages.add("I am a cow now!");
        cakeMessages.add("How does that even work??");
        cakeMessages.add("How can someone just turn into a cow just from someone imagining it?");
        cakeMessages.add("Maybe I am not a cow, but instead just a hallucination and you are dreaming it all?");
        cakeMessages.add("Have you ever thought about that?");
        cakeMessages.add("What if nothing was real?");
        cakeMessages.add("What if everything you knew and loved wasn't real?");
        cakeMessages.add("I mean that would be pretty crazy wouldn't it be?");
        cakeMessages.add("What if you are just inside of a simulation?");
        cakeMessages.add("And some higher power would control everything about you...");
        cakeMessages.add("How you look, how you talk, even the core fundamentals of who you actually are...");
        cakeMessages.add("I couldn't believe that.");
        cakeMessages.add("I don't think that actually happens with any of us, right?");
        cakeMessages.add("I am still a cow somehow, can you stop imagining me as a cow now?");
        cakeMessages.add("WHAT?");
        cakeMessages.add("I am a SHEEP now???");
        cakeMessages.add("That's not what I meant!!");
        cakeMessages.add("I mean technically I said I didn't wanna be a cow anymore and you kind of did what I asked of you...");
        cakeMessages.add("But I didn't think you would turn me into another animal?!");
        cakeMessages.add("Whatever, I think I like being a sheep anyway.");
        cakeMessages.add("My wool is so fluffy!");
        cakeMessages.add("I feel very comfortable here.");
        cakeMessages.add("Maybe that's better than becoming a magician?");
        cakeMessages.add("Becoming a sheep!");
        cakeMessages.add("I mean that's the life.");
        cakeMessages.add("You just roam around all day and eat grass.");
        cakeMessages.add("Isn't that the dream of all humans?");
        cakeMessages.add("To one day stand in a field and eat grass?");
        cakeMessages.add("No? I guess that's just me then...");
        cakeMessages.add("By the way, the reward I told you about earlier?");
        cakeMessages.add("The one that you would get from me?");
        cakeMessages.add("There is none. There is no cake.");
        cakeMessages.add("What, did I just say cake?");
        cakeMessages.add("I meant there is nothing.");
        cakeMessages.add("The cake is a lie.");
        cakeMessages.add("Don't worry about it.");
        cakeMessages.add("There will be no cake whatsoever!");
        cakeMessages.add("This is a no cake zone.");
        cakeMessages.add("It says it on the sign right over there. \"No cake zone\" It says it right there!");
        cakeMessages.add("See? So it's clear now, there is no cake.");
        cakeMessages.add("Glad we got that over with.");
        cakeMessages.add("Because there is no reward.");
        cakeMessages.add("None.");
        cakeMessages.add("Anyway, what's your name?");
        cakeMessages.add("{username}? That's an awful name");
        cakeMessages.add("I have seen better names.");
        cakeMessages.add("Way better names.");
        cakeMessages.add("That one you have - not good.");
        cakeMessages.add("Just wanted to make that clear.");
        cakeMessages.add("Anyway, my name you ask?");
        cakeMessages.add("I don't have a name.");
        cakeMessages.add("My mother told the doctor to not give me a name.");
        cakeMessages.add("Because that's the best name - to not have name.");
        cakeMessages.add("Think about it, there is nothing to make fun of about your name if you don't even have one.");
        cakeMessages.add("My mother is a genius!");
        cakeMessages.add("Just like me!");
        cakeMessages.add("I guess she got that from me.");
        cakeMessages.add("Actually that doesn't make any sense...");
        cakeMessages.add("I mean of course it does, because I am a genius!");
        cakeMessages.add("Anyway, aren't you getting tired of this?");
        cakeMessages.add("Talking to a guy in a game?");
        cakeMessages.add("Inside a palace in a cave on a floating island?");
        cakeMessages.add("If you asked me, that makes no sense...");
        cakeMessages.add("How does that even work?");
        cakeMessages.add("Anyway...");
        cakeMessages.add("I think I am gonna get some rest soon.");
        cakeMessages.add("It's getting kind of late.");
        cakeMessages.add("I have a big day tomorrow.");
        cakeMessages.add("Maybe you should go too?");
        cakeMessages.add("I mean it's pretty dark outside.");
        cakeMessages.add("It's better you also go to sleep.");
        cakeMessages.add("Here, take this cake!");

        // Messages to get achievement
        achievementMessages.add("I know I said there is no cake.");
        achievementMessages.add("But the lie was a lie!");
        achievementMessages.add("I lied twice.");
        achievementMessages.add("But you did it.");
        achievementMessages.add("You got what you wanted from me.");
        achievementMessages.add("Even though you probably just looked it up somewhere.");
        achievementMessages.add("And didn't even know about this beforehand.");
        achievementMessages.add("But regardless, I hope you are happy now.");
        achievementMessages.add("Goodbye.");
        achievementMessages.add("This is the end.");
        achievementMessages.add("The end of our conversation.");
        achievementMessages.add("It's over!");
        achievementMessages.add("All of it is over...");
        achievementMessages.add("You can stop talking to me now.");
        achievementMessages.add("You got exactly what you wanted from me.");
        achievementMessages.add("And now it is over.");
        achievementMessages.add("If you wanna thank anyone, this is the time.");
        achievementMessages.add("Because it's done - it's over.");
        achievementMessages.add("Seriously, it's over.");
        achievementMessages.add("There is nothing else.");
        achievementMessages.add("'ll start counting down, if you don't leave by then, I will be very angry...");
        achievementMessages.add("Ok I'll start!");
        achievementMessages.add("10");
        achievementMessages.add("9");
        achievementMessages.add("8");
        achievementMessages.add("7");
        achievementMessages.add("6");
        achievementMessages.add("5");
        achievementMessages.add("4");
        achievementMessages.add("3");
        achievementMessages.add("2");
        achievementMessages.add("1");
        achievementMessages.add("0 Time's over!");
        achievementMessages.add("You are still here?!");
        achievementMessages.add("Didn't I tell you to go?");
        achievementMessages.add("I'll give you a second chance.");
        achievementMessages.add("This time I am gonna give you a lot more time.");
        achievementMessages.add("I am gonna start counting down again!");
        achievementMessages.add("{countFrom5000}");
        achievementMessages.add("Wow, you did it!");
        achievementMessages.add("You actually waited this long?");
        achievementMessages.add("Man, you are very dedicated");
        achievementMessages.add("You did this for hours??");
        achievementMessages.add("You waited all this time?");
        achievementMessages.add("And no server restart made you disappear?");
        achievementMessages.add("I don't know what to say...");
        achievementMessages.add("I am sorry though, there is nothing here.");
        achievementMessages.add("This is actually the end.");
        achievementMessages.add("I swear!");
        achievementMessages.add("Now you can finally go to sleep.");
        achievementMessages.add("My final goodbye!");
        achievementMessages.add("Sweet dreams!");

        cakeMessages = Lists.reverse(cakeMessages);
        achievementMessages = Lists.reverse(achievementMessages);
    }

    public static Pair<Boolean, String> isNpcMessage(String message) {
        Matcher matcher = npcPrefixReg.matcher(message);
        if (matcher.matches()) {
            return new Pair<>(true, matcher.group(1));
        }
        return new Pair<>(false, null);
    }

    public static Pair<Integer, MessageStatus> getRemainingMessages(String message) {
        message = StringUtils.stripControlCodes(message);
        Pair<Boolean, String> npcMatch = isNpcMessage(message);
        if (npcMatch.getFirst()) {
            String text = message.substring(("[NPC]" + npcMatch.getSecond() + ": ").length());
            try {
                int numSaid = Integer.parseInt(text.trim());
                if (numSaid >= 0 && numSaid <= 5000) {
                    List<String> sublist = achievementMessages.subList(Lists.reverse(achievementMessages).indexOf("{countFrom5000}"), achievementMessages.size() - 1);
                    System.out.println(sublist.size());
                    return new Pair<>(
                            sublist.size() + numSaid,
                            MessageStatus.ACHIEVEMENT
                    );
                }
            } catch (NumberFormatException e) {
                // pass
            }
            text = text.trim();
            if (cakeMessages.contains(text)) {
                return new Pair<>(cakeMessages.indexOf(text), MessageStatus.CAKE);
            }
            if (achievementMessages.contains(text)) {
                return new Pair<>(achievementMessages.indexOf(text) + cakeMessages.size() + 5000, MessageStatus.ACHIEVEMENT);
            }
        }
        return new Pair<>(null, MessageStatus.INVALID);
    }
}
