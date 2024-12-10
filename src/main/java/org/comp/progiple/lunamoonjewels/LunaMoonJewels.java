package org.comp.progiple.lunamoonjewels;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.comp.progiple.lunamoonjewels.Other.Configs.Config;
import org.comp.progiple.lunamoonjewels.Other.Configs.DataConfig;
import org.comp.progiple.lunamoonjewels.Other.Placeholders;

import java.util.Objects;

public final class LunaMoonJewels extends JavaPlugin {
    @Getter private static LunaMoonJewels plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        Config.setConfig(new Config());
        DataConfig.setDataConfig(new DataConfig());

        Command command = new Command();
        Objects.requireNonNull(getCommand("lunamoonjewels")).setTabCompleter(command);
        Objects.requireNonNull(getCommand("lunamoonjewels")).setExecutor(command);

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Placeholders placeholders = new Placeholders();
            placeholders.register();
        }
    }

    @Override
    public void onDisable() {}
}
