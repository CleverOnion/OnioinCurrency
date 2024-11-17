package com.cleveronion.onionCurrency.command.OcCommandExecutor;

import com.cleveronion.onionCurrency.OnionCurrency;
import com.cleveronion.onionCurrency.constants.MessageConstants;
import com.cleveronion.onionCurrency.handler.CurrencyHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OcRemoveExecutor {
    public static Boolean execute(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 2) {
            if (CurrencyHandler.isCurrencyExist(strings[1])) {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                        MessageConstants.REMOVE_CURRENCY_SUCCESS.replace("{currency}", strings[1]));
                CurrencyHandler.removeCurrency(strings[1]);
            } else {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + MessageConstants.CURRENCY_NOT_EXIST.replace("{currency}", strings[1]));
            }
        } else {
            commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + MessageConstants.REMOVE_COMMAND_TIP);
        }
        return true;
    }
}
