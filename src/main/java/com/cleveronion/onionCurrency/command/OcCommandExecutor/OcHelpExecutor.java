package com.cleveronion.onionCurrency.command.OcCommandExecutor;

import com.cleveronion.onionCurrency.constants.MessageConstants;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OcHelpExecutor {

    public static Boolean execute(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + "输入 /oc new <货币id> <货币名称> <货币描述>");
        commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + "输入 /oc remove <货币id>");
        commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + "输入 /oc add <玩家id> <货币id> <数量>");
        commandSender.sendMessage(MessageConstants.MESSAGE_PREFIX + "输入 /oc set <玩家id> <货币id> <数量>");

        return true;
    }
}
