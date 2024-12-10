package org.comp.progiple.lunamoonjewels.Other;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.comp.progiple.lunamoonjewels.Api.LMJAPI;
import org.comp.progiple.lunamoonjewels.Other.Configs.Config;
import org.jetbrains.annotations.NotNull;

public class Placeholders extends PlaceholderExpansion {
    private final Config config = Config.getConfig();

    @Override
    public @NotNull String getIdentifier() {
        return "lmjewels";
    }

    @Override
    public @NotNull String getAuthor() {
        return "ProGiple";
    }

    @Override
    public @NotNull String getVersion() {
        return "latest";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        String mainPath = "placeholders.autoName.%s";
        int value = LMJAPI.getJewels(player);

        if (params.equalsIgnoreCase("autoname")) {
            byte lastNum = (byte) (value % 10);
            return switch (lastNum) {
                case 0 -> LMJAPI.getJewelName(config.getString(String.format(mainPath, "0")));
                case 1 -> LMJAPI.getJewelName(config.getString(String.format(mainPath, "1")));
                case 2, 3, 4 -> LMJAPI.getJewelName(config.getString(String.format(mainPath, "2-4")));
                default -> LMJAPI.getJewelName(config.getString(String.format(mainPath, "5+")));
            };
        }
        else if (params.contains("name_")) {
            String[] massive = params.split("_");
            if (massive.length >= 2) {
                return LMJAPI.getJewelName(massive[1]);
            }
        }
        else if (params.equalsIgnoreCase("balance")) {
            return String.valueOf(value);
        }
        return null;
    }
}
