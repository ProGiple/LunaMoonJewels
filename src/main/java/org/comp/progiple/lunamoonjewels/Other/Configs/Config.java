package org.comp.progiple.lunamoonjewels.Other.Configs;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.comp.progiple.lunamoonjewels.LunaMoonJewels;

import java.util.HashMap;
import java.util.Map;

public class Config {
    @Getter @Setter private static Config config;
    @Getter private static Map<String, String> jewelsNames = new HashMap<>();

    private final LunaMoonJewels plugin = LunaMoonJewels.getPlugin();
    private FileConfiguration fileConfig;
    public Config() {
        this.reload();
    }

    public void reload() {
        plugin.reloadConfig();
        this.fileConfig = plugin.getConfig();

        ConfigurationSection section = this.fileConfig.getConfigurationSection("jewelsSettings.names");
        if (section == null) return;
        jewelsNames.clear();
        for (String id : section.getKeys(false)) {
            jewelsNames.put(id, section.getString(id));
        }
    }

    public String getString(String path) {
        return fileConfig.getString(path);
    }

    public Sound getSound(String type) {
        return Sound.valueOf(this.getString(String.format("sounds.%s", type)));
    }
}
