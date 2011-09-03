package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.namarius.complexredstone.ComplexRedstone;

public class ReleaseCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crrelease";
	}

	@Override
	protected boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		ComplexRedstone.release();
		return true;
	}

}
