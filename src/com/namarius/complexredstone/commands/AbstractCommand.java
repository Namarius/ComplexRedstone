package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommand implements CRCommand {

	private static boolean playeronly = true;
	
	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected abstract boolean localOnCommand(CommandSender sender, Command command,String label, String[] args);

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(playeronly)
			if(sender instanceof Player)
				return localOnCommand(sender, command, label, args);
			else
				sender.sendMessage("Non player can't use this command");
		else
			return localOnCommand(sender, command, label, args);
		return true;
	}

}
