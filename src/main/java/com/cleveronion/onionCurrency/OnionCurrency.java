package com.cleveronion.onionCurrency;

import org.bukkit.plugin.java.JavaPlugin;

public final class OnionCurrency extends JavaPlugin {

    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }
}
