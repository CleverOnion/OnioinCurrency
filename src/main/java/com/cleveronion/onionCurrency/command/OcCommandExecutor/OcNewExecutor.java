package com.cleveronion.onionCurrency.command.OcCommandExecutor;

import com.cleveronion.onionCurrency.OnionCurrency;
import com.cleveronion.onionCurrency.constants.MessageConstants;
import com.cleveronion.onionCurrency.handler.CurrencyHandler;
import com.cleveronion.onionCurrency.model.Currency;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OcNewExecutor {

    public static Boolean execute(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 4) {
            if (CurrencyHandler.isCurrencyExist(strings[1])) {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + MessageConstants.CURRENCY_ALREADY_EXIST.replace("{currency}", strings[1]));
            } else {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                        MessageConstants.NEW_CURRENCY_SUCCESS.replace("{currency}", strings[1])
                                .replace("{name}", strings[2])
                                .replace("{description}", strings[3]));
                CurrencyHandler.addCurrency(Currency.builder().id(strings[1]).name(strings[2]).description(strings[3]).build());
            }
        } else {
            commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + MessageConstants.NEW_CURRENCY_TIP);
        }
        return true;
    }
}
