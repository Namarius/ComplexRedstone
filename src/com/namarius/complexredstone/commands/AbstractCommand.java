package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.utils.ChatUtil;

public abstract class AbstractCommand implements CRCommand {

	private static boolean playeronly = true;

	@Override
	public abstract String commandName();

	protected abstract boolean localOnCommand(CommandSender sender,
			Command command, String label, String[] args);

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (playeronly)
			if (sender instanceof Player) {
				if (sender.hasPermission("complexredstone." + commandName()))
					return localOnCommand(sender, command, label, args);
				else
					ChatUtil.error(sender, "You are not allowed to use:"
							+ commandName());
			} else
				sender.sendMessage("Non player can't use this command");
		else
			return localOnCommand(sender, command, label, args);
		return true;
	}

}
