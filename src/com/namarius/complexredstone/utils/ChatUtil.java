package com.namarius.complexredstone.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatUtil 
{
	private static final String errorcolor = ChatColor.RED.toString();
	
	public static void sendError(CommandSender sender,String message)
	{
		sender.sendMessage(errorcolor+message);
	}
	
	public static void tooMany(int number,CommandSender sender)
	{
		sendError(sender,"Too many parameters:"+number);
	}
	
	public static void tooFew(int number,CommandSender sender)
	{
		sendError(sender,"Too few parameters:"+number);
	}
	
	public static void empty(CommandSender sender)
	{
		sendError(sender,"Parameter was emtpy");
	}
	
}
