package org.comp.progiple.lunamoonjewels.Other.Configs;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.comp.progiple.lunamoonjewels.LunaMoonJewels;

import java.io.File;

public class DataConfig {
    @Getter @Setter
    private static DataConfig dataConfig;

    @Getter private FileConfiguration config;
    private final File file;
    public DataConfig() {
        this.file = new File(LunaMoonJewels.getPlugin().getDataFolder(), "data.yml");
        this.reload();
    }

    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public int getValue(String nick) {
        return this.config.getInt(String.format("players.%s", nick));
    }

    @SneakyThrows
    public void setValue(String nick, int value) {
        if (value < 0) value = Math.abs(value);
        this.config.set(String.format("players.%s", nick), value);
        this.config.save(this.file);
    }
}
