package com.cleveronion.onionCurrency.command.OcCommandExecutor;

import com.cleveronion.onionCurrency.OnionCurrency;
import com.cleveronion.onionCurrency.constants.MessageConstants;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OcReloadExecutor {
    public static Boolean execute(CommandSender commandSender, Command command, String s, String[] strings)
    {
        OnionCurrency.instance.reloadConfig();
        ((OnionCurrency)(OnionCurrency.instance)).loadCurrenciesData();
        OnionCurrency.log(MessageConstants.MESSAGE_PREFIX + MessageConstants.RELOAD_CONFIG);

        return true;
    }
}
