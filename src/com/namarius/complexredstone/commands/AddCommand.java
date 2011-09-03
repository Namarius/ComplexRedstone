package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class AddCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "cradd";
	}

	@Override
	public boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		return false;
	}

}
