package com.cleveronion.onionCurrency.command.OcCommandExecutor;

import com.cleveronion.onionCurrency.constants.MessageConstants;
import com.cleveronion.onionCurrency.handler.CurrencyHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OcBalExecutor {
    public static Boolean execute(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 3) {
            if (CurrencyHandler.isCurrencyExist(strings[2])) {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                        MessageConstants.BAL_PLAYER_CURRENCY.replace("{player}", strings[1])
                                .replace("{amount}", String.valueOf(CurrencyHandler.getCurrencyAmount(strings[1], strings[2])))
                                .replace("{currency}", strings[2]));
            } else {
                commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                        MessageConstants.CURRENCY_NOT_EXIST.replace("{currency}", strings[2]));
            }
        } else {
            commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX +
                    MessageConstants.BAL_COMMAND_TIP);
        }
        return true;
    }
}
