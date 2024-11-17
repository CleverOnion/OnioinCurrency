package com.cleveronion.onionCurrency;

import com.cleveronion.onionCurrency.command.OcCommand;
import com.cleveronion.onionCurrency.constants.MessageConstants;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Currency;

public final class OnionCurrency extends JavaPlugin {

    public static JavaPlugin instance;
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        config = getConfig();

        loadCurrenciesData();
        loadMsg();

        getCommand("oc").setExecutor(new OcCommand());
    }

    @Override
    public void onDisable() {
    }

    /**
     * 加载配置文件的msg
     */
    private void loadMsg() {
        try {
            // 获取msg下的所有key-value
            ConfigurationSection msgSection = config.getConfigurationSection("msg");
            for (String key : msgSection.getKeys(false)) {
                // 通过反射，将key-value注入到MessageConstants类中
                MessageConstants.class.getField(key).set(null, msgSection.getString(key).replace("&", "§"));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(String msg) {
        instance.getLogger().info(msg);
    }

    /**
     * 根据配置文件加载货币.yml
     */
    public void loadCurrenciesData() {
        File dataFolder = getDataFolder();
        File currencies = new File(dataFolder, "currencies");
        if (!currencies.exists()) {
            currencies.mkdir();
        }
        ConfigurationSection currenciesSection = config.getConfigurationSection("currencies");
        File currencyYml;
        for (String key : currenciesSection.getKeys(false)) {
            currencyYml = new File(currencies, key + ".yml");
            if (!currencyYml.exists()) {
                try {
                    currencyYml.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
