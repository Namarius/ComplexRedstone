package com.namarius.complexredstone.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class ChatUtil 
{
	private static final String errorcolor = ChatColor.RED.toString();
	private static final String note = ChatColor.GREEN.toString();
	private static final int maxlinelength = 61;
	
	public static void send(CommandSender sender,String color,String message)
	{
		while(message.length()>0)
		{
			message=message.trim();
			int lastspace = message.substring(0, (maxlinelength>message.length()?message.length():maxlinelength)).lastIndexOf(' ');
			if(lastspace<0)
				lastspace=(maxlinelength>message.length()?message.length():maxlinelength);
			if(message.length()<maxlinelength)
				lastspace=message.length();
			sender.sendMessage(color+message.substring(0,lastspace));
			message=message.substring(lastspace);
		}
	}
	
	public static void sendError(CommandSender sender,String message)
	{
		send(sender,errorcolor,message);
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
	
	public static void note(CommandSender sender,String message)
	{
		send(sender,note,message);
	}
	
}
