package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.ComplexRedstone;
import com.namarius.complexredstone.debugger.CRPlayerDebug;
import com.namarius.complexredstone.utils.ChatUtil;

public class DeleteSetCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crdeleteset";
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
				CRPlayerDebug player = ComplexRedstone.getCRPlayerDebug((Player) sender);
				if(player!=null)
				{
					return player.removeSet(args[0]);
				}
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
