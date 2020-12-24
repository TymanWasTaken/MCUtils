package com.tyman.mcutils.utils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Written by Aaron1998ish on 11/12/2017.
 *
 * Useful methods for retrieving data on scoreboards on Hypixel
 *
 */
public class ScoreboardUtils {

    public static boolean hasSkyblockScoreboard(Scoreboard scoreboard) {

        ScoreObjective sidebar = scoreboard.getObjectiveInDisplaySlot(1);
        if (sidebar != null) {
            List<Score> scores = new ArrayList<>(scoreboard.getScores());

            for (Score score : scores) {
                if (StringUtils.stripControlCodes(score.getObjective().getDisplayName()).contains("SKYBLOCK")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getSidebarLines() {
        List<String> lines = new ArrayList<>();
        Scoreboard scoreboard = Minecraft.getMinecraft().theWorld.getScoreboard();
        if (scoreboard == null) {
            return lines;
        }

        ScoreObjective objective = scoreboard.getObjectiveInDisplaySlot(1);

        if (objective == null) {
            return lines;
        }

        Collection<Score> scores = scoreboard.getSortedScores(objective);
        List<Score> list = scores.stream()
                .filter(input -> input != null && input.getPlayerName() != null && !input.getPlayerName().startsWith("#")).collect(Collectors.toList());

        if (list.size() > 15) {
            scores = Lists.newArrayList(Iterables.skip(list, scores.size() - 15));
        } else {
            scores = list;
        }

        for (Score score : scores) {
            ScorePlayerTeam team = scoreboard.getPlayersTeam(score.getPlayerName());
            lines.add(ScorePlayerTeam.formatPlayerName(team, score.getPlayerName()));
        }

        return lines.stream()
                .map(StringUtils::stripControlCodes)
                .map(input -> input.replaceAll("[^\\x00-\\x7F]", ""))
                .collect(Collectors.toList());
    }
}