package com.cleveronion.onionCurrency.command.OcCommandExecutor;

import com.cleveronion.onionCurrency.OnionCurrency;
import com.cleveronion.onionCurrency.constants.MessageConstants;
import com.cleveronion.onionCurrency.handler.CurrencyHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OcAddExecutor {
    public static Boolean execute(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 4) {
            if (CurrencyHandler.isCurrencyExist(strings[2])) {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                        MessageConstants.ADD_CURRENCY_TO_PLAYER.replace("{player}", strings[1])
                                .replace("{currency}", strings[2])
                                .replace("{amount}", strings[3]));
                CurrencyHandler.addCurrencyToPlayer(strings[1], strings[2], Integer.parseInt(strings[3]));
            } else {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                        MessageConstants.CURRENCY_NOT_EXIST.replace("{currency}", strings[2]));
            }
        } else {
            commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                    MessageConstants.ADD_COMMAND_TIP);
        }
        return true;
    }
}
