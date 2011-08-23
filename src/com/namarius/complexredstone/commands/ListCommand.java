package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.namarius.complexredstone.utils.ChatUtil;

public class ListCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crlist";
	}

	@Override
	public boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length == 2)
		{
			String what = args[0];
			if(what.equalsIgnoreCase("set"))
			{
				
			}
			else if(what.equalsIgnoreCase("block"))
			{
				
			}
			ChatUtil.sendError(sender, "Set nor block wasn't present");
		}
		else if(args.length<2)
			ChatUtil.tooFew(2-args.length, sender);
		else
			ChatUtil.tooMany(args.length-2, sender);			
		return false;
	}

}
