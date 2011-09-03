package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.namarius.complexredstone.ComplexRedstone;

public class ForcedDisableCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crforcedisable";
	}

	@Override
	public boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		ComplexRedstone.forceDisable();
		return true;
	}

}
