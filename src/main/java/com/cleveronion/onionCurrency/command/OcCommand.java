package com.cleveronion.onionCurrency.command;

import com.cleveronion.onionCurrency.OnionCurrency;
import com.cleveronion.onionCurrency.command.OcCommandExecutor.*;
import com.cleveronion.onionCurrency.handler.CurrencyHandler;
import com.cleveronion.onionCurrency.model.Currency;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("§c[OnionCurrency] 输入 /oc help 查看命令列表");
            return false;
        }
        switch (strings[0]) {
            case "help":
                return OcHelpExecutor.execute(commandSender, command, s, strings);
            case "reload":
                return OcReloadExecutor.execute(commandSender, command, s, strings);
            case "new":
                return OcNewExecutor.execute(commandSender, command, s, strings);
            case "remove":
                return OcRemoveExecutor.execute(commandSender, command, s, strings);
            case "add":
                return OcAddExecutor.execute(commandSender, command, s, strings);
            case "set":
                return OcSetExecutor.execute(commandSender, command, s, strings);
            case "bal":
                return OcBalExecutor.execute(commandSender, command, s, strings);
            default:
                commandSender.sendMessage("§c[OnionCurrency] 输入 /oc help 查看命令列表");
                return false;
        }
    }
}
