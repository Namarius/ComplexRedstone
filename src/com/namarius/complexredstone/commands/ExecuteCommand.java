package com.namarius.complexredstone.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.ComplexRedstone;

public class ExecuteCommand implements CRCommand {
	
	HashMap<Player,String> commands = new HashMap<Player,String>();

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "crcom";
	}
	
	private void addCommand(Player player, String params)
	{
		String playercommand = commands.get(player);
		if(!params.isEmpty())
		{
			if(playercommand != null)
			{
				playercommand=playercommand.concat(" ").concat(params);
			}
			else
			{
				commands.put(player, params);
			}
		}
	}
	
	private void sendCommand(CommandSender sender)
	{
		String params = commands.get((Player)sender);
		if(params != null)
		{
			//ComplexRedstone.getSelf().info("command:"+params+"/");
			ComplexRedstone.getSelf().getServer().dispatchCommand(sender, params.trim());
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
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

}
