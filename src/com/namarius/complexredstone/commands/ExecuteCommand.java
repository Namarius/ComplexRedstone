package com.namarius.complexredstone.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.ComplexRedstone;
import com.namarius.complexredstone.utils.ChatUtil;

public class ExecuteCommand extends AbstractCommand {
	
	HashMap<Player,String> commands = new HashMap<Player,String>();

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crcom";
	}
	
	private void addCommand(Player player, String params)
	{
		params=params.trim();
		String playercommand = commands.get(player);
		if(!params.isEmpty())
		{
			if(playercommand != null)
				params=playercommand.concat(" ").concat(params);
			commands.put(player, params);
		}
		ChatUtil.note(player, "Command:"+commands.get(player));
	}
	
	private void sendCommand(CommandSender sender)
	{
		String params = commands.get((Player)sender);
		if(params != null)
		{
			//ComplexRedstone.getSelf().info("command:"+params+"/");
			ComplexRedstone.getSelf().getServer().dispatchCommand(sender, params.trim());
		}
		commands.put((Player) sender, "");
	}

	@Override
	public boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(sender instanceof Player)
		{
			if(args.length==0)
				return false;
			String concatargs="";
			for(String string : args)
			{
				concatargs=concatargs.concat(" ").concat(string);
			}
			int pos = concatargs.indexOf("//");
			if(pos<0)
			{
				addCommand((Player) sender, concatargs);
			}
			else
			{
				addCommand((Player) sender, concatargs.substring(0,pos));
				sendCommand(sender);
			}
			return true;
		}
		else
		{
			sender.sendMessage("Non player can't use this command");
			return true;
		}
	}

}
