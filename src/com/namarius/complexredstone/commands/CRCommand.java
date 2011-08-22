package com.namarius.complexredstone.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public interface CRCommand extends CommandExecutor 
{	
	public abstract String commandName();
	
	@Override
	public boolean onCommand(CommandSender sender,org.bukkit.command.Command command, String label, String[] args);

}
