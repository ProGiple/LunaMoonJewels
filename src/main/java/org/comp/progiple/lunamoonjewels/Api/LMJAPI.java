package org.comp.progiple.lunamoonjewels.Api;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.comp.progiple.lunamoonjewels.Other.Configs.Config;
import org.comp.progiple.lunamoonjewels.Other.Configs.DataConfig;

import java.util.*;

public class LMJAPI {
    private final static DataConfig cfg = DataConfig.getDataConfig();

    public static int getJewels(String nick) {
        return cfg.getValue(nick);
    }

    public static int getJewels(OfflinePlayer offlinePlayer) {
        return LMJAPI.getJewels(offlinePlayer.getName());
    }

    public static int getJewels(UUID uuid) {
        return LMJAPI.getJewels(Bukkit.getOfflinePlayer(uuid));
    }

    public static void giveJewels(String nick, int value) {
        cfg.setValue(nick, LMJAPI.getJewels(nick) + value);
    }

    public static void giveJewels(OfflinePlayer offlinePlayer, int value) {
        LMJAPI.giveJewels(offlinePlayer.getName(), value);
    }

    public static void giveJewels(UUID uuid, int value) {
        LMJAPI.giveJewels(Bukkit.getOfflinePlayer(uuid), value);
    }

    public static void removeJewels(String nick, int value) {
        cfg.setValue(nick, LMJAPI.getJewels(nick) - value);
    }

    public static void removeJewels(OfflinePlayer offlinePlayer, int value) {
        LMJAPI.removeJewels(offlinePlayer.getName(), value);
    }

    public static void removeJewels(UUID uuid, int value) {
        LMJAPI.removeJewels(Bukkit.getOfflinePlayer(uuid), value);
    }

    public static boolean payJewels(String fromPlayerNick, String toPlayerNick, int value) {
        if (LMJAPI.getJewels(fromPlayerNick) >= value) {
            LMJAPI.removeJewels(fromPlayerNick, value);
            LMJAPI.giveJewels(toPlayerNick, value);
            return true;
        }
        return false;
    }

    public static void setJewels(String nick, int value) {
        cfg.setValue(nick, value);
    }

    public static void setJewels(OfflinePlayer offlinePlayer, int value) {
        LMJAPI.setJewels(offlinePlayer.getName(), value);
    }

    public static void setJewels(UUID uuid, int value) {
        LMJAPI.setJewels(Bukkit.getOfflinePlayer(uuid), value);
    }

    public static ConfigurationSection getPlayerSection() {
        return cfg.getConfig().getConfigurationSection("players");
    }

    public static Map<String, String> getJewelNames() {
        return Config.getJewelsNames();
    }

    public static String getJewelName(String id) {
        return LMJAPI.getJewelNames().get(id);
    }
}
