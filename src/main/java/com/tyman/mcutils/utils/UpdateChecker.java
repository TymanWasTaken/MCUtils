package com.tyman.mcutils.utils;

import com.github.kevinsawicki.http.HttpRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.vdurmont.semver4j.Semver;

import com.tyman.mcutils.MCUtilsMod;
import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.awt.*;

public class UpdateChecker {
    public enum UpdateStatus {
        NEW_STABLE,
        NEW_PRE,
        UP_TO_DATE,
        FAILED
    }

    public static UpdateStatus checkForUpdates() {
        try {
            String GITHUB_RELEASES_API = "https://api.github.com/repos/TymanWasTaken/MCUtils/releases";
            String apiResponse = HttpRequest.get(GITHUB_RELEASES_API).body();
            JsonArray parsed = new JsonParser().parse(apiResponse).getAsJsonArray();
            JsonObject latestRelease = parsed.get(0).getAsJsonObject();
            Semver latestVersion = new Semver(latestRelease.get("tag_name").getAsString() + (latestRelease.get("prerelease").getAsBoolean() ? "-beta" : ""));
            Semver currentVersion = new Semver(MCUtilsMod.VERSION);
            String updateTitle;
            UpdateStatus returnStatus;
            if (latestVersion.isGreaterThan(currentVersion) && latestVersion.isStable()) {
                updateTitle = "New stable MCUtils release";
                returnStatus = UpdateStatus.NEW_STABLE;
            } else if (latestVersion.isGreaterThan(currentVersion) && !latestVersion.isStable() && !currentVersion.isStable()) {
                updateTitle = "New MCUtils prerelease";
                returnStatus = UpdateStatus.NEW_PRE;
            } else {
                return UpdateStatus.UP_TO_DATE;
            }
            JOptionPane pane = new JOptionPane("MCUtils is out of date.\nCurrent version: " + currentVersion + "\nLatest version: " + latestVersion);
            JDialog dialog = pane.createDialog(updateTitle);
            dialog.setModal(false);
            dialog.setSize(new Dimension(480, dialog.getPreferredSize().height));
            dialog.setResizable(true);
            dialog.setVisible(true);
            if (Display.isActive()) dialog.toFront();
            return returnStatus;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane pane = new JOptionPane("The update checker somehow failed. If this persists, please contact the developer.");
            JDialog dialog = pane.createDialog("MCUtils update checker failure");
            dialog.setModal(false);
            dialog.setSize(new Dimension(480, dialog.getPreferredSize().height));
            dialog.setResizable(true);
            dialog.setVisible(true);
            if (Display.isActive()) dialog.toFront();
            return UpdateStatus.FAILED;
        }
    }
}
