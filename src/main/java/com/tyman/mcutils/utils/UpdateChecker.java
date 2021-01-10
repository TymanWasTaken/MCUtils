package com.tyman.mcutils.utils;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tyman.mcutils.MCUtilsMod;
import com.vdurmont.semver4j.Semver;
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
            Semver currentVersion = new Semver(MCUtilsMod.VERSION);
            String updateTitle;
            UpdateStatus returnStatus;
            Semver latestStableVer = null;
            Semver latestPreVer = null;
            Semver curVer;
            for (JsonElement release : parsed) {
                curVer = new Semver(release.getAsJsonObject().get("tag_name").getAsString());

                if (latestPreVer == null && !curVer.isStable())
                    latestPreVer = curVer;
                else if (!curVer.isStable() && curVer.isGreaterThan(latestPreVer))
                    latestPreVer = curVer;

                if (latestStableVer == null && curVer.isStable())
                    latestStableVer = curVer;
                else if (curVer.isStable() && curVer.isGreaterThan(latestStableVer))
                    latestStableVer = curVer;
            }
            Semver latestVersion;
            if (latestStableVer != null && latestStableVer.isGreaterThan(currentVersion)) {
                updateTitle = "New stable MCUtils release";
                returnStatus = UpdateStatus.NEW_STABLE;
                latestVersion = latestStableVer;
            } else if (latestPreVer != null && latestPreVer.isGreaterThan(currentVersion) && !currentVersion.isStable()) {
                updateTitle = "New MCUtils prerelease";
                returnStatus = UpdateStatus.NEW_PRE;
                latestVersion = latestPreVer;
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
