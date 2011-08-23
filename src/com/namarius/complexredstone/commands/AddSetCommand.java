package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.ComplexRedstone;
import com.namarius.complexredstone.utils.ChatUtil;

public class AddSetCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "craddset";
	}

	@Override
	public boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length==1)
		{
			if(args[0].isEmpty())
			{
				ChatUtil.empty(sender);
			}
			else
			{
				if(ComplexRedstone.getSelf().getBlockListener().addSet((Player) sender, args[0]))
					ChatUtil.note(sender, "Set '"+args[0]+"' overwritten.");
				else
					ChatUtil.note(sender, "Set '"+args[0]+"' created.");
				return true;
			}
		}
		else if(args.length<1)
		{
			ChatUtil.tooFew(1, sender);
		}
		else
		{
			ChatUtil.tooMany(args.length-1, sender);
		}
		return false;
	}

}
