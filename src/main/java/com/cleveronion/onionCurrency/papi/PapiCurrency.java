package com.cleveronion.onionCurrency.papi;

import com.cleveronion.onionCurrency.handler.CurrencyHandler;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PapiCurrency extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "oCurrency";
    }

    @Override
    public @NotNull String getAuthor() {
        return "CleverOnion";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        // 当前玩家 货币x 的数量
        String[] papis = params.split("_");
        if (papis.length == 1) {
            // 如果货币不存在，返回NULL
            if (!CurrencyHandler.isCurrencyExist(params)) {
                return "NULL";
            }
            return String.valueOf(CurrencyHandler.getCurrencyAmount(player.getName(), params));
        }
        return null;
    }
}
