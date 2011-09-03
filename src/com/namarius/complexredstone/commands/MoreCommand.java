package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.message.MessageType;
import com.namarius.complexredstone.utils.ChatUtil;

public class MoreCommand extends AbstractCommand {
	
	static final int lines = 20;
	
	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crmore";
	}

	@Override
	protected boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		String[] lastlines=ChatUtil.getLines((Player) sender);
		if(lastlines == null)
		{
			ChatUtil.sendError(sender, MessageType.NoLastOutput.get());
			return true;
		}
		final int linescount = lastlines.length;
		switch(args.length)
		{
		case 0:
		{
			ChatUtil.note(sender, MessageType.NumberOfLines.addArg(new Integer(linescount).toString()));			
			break;
		}
		case 1: //begin as parameter till +20 or end
		{
			int start=0;
			try
			{
				start = Integer.parseInt(args[0]);
			}
			catch (NumberFormatException e) {
				ChatUtil.wrongType(sender, 1, "Number");
				return false;
			}
			for(int i=start;i<linescount;i++)
			{
				ChatUtil.rawsendout(sender, lastlines[i]);
			}
			break;
		}
		case 2://begin as parameter 1 till begin+parameter 2
		{
			int start=0;
			int add=0;
			try
			{
				start = Integer.parseInt(args[0]);
			}
			catch (NumberFormatException e) 
			{
				ChatUtil.wrongType(sender, 1, "Number");
				return false;
			}
			try
			{
				add = Integer.parseInt(args[1]);
			}
			catch (NumberFormatException e) 
			{
				ChatUtil.wrongType(sender, 2, "Number");
				return false;
			}
			int end=start+add>linescount?linescount:start+add;
			for(int i=start;i<end;i++)
			{
				ChatUtil.rawsendout(sender, lastlines[i]);
			}
			break;
		}			
		default:
			ChatUtil.tooMany(args.length-2, sender);
			return false;
		}
		return true;
	}

}
