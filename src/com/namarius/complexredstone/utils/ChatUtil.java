package com.namarius.complexredstone.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class ChatUtil 
{
	public enum Symbol
	{
		Newline,DefaultColor;
	}
	private static final ChatColor errorcolor = ChatColor.RED;
	private static final ChatColor note = ChatColor.GREEN;
	private static final int maxlinelength = 50;
	private static final HashMap<Player,String[]> output = new HashMap<Player,String[]>();
	
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
	
	private static void rawsendout(CommandSender sender,String[] messages)
	{
		for(String string : messages)
		{
			sender.sendMessage(string.trim());
		}
	}
	
	private static int getStringLength(Object[] objects)
	{
		int length=0;
		for(Object object : objects)
		{
			if(object instanceof String)
				length+=((String) object).length();
		}
		return length;
	}
	
	private static String makeString(Object[] objects)
	{
		String temp="";
		for(Object object : objects)
		{
			temp+=object.toString();
		}
		return temp;
	}
	
	public static void send(Object[] message,CommandSender sender,ChatColor defaultcolor)
	{
		ChatColor currentcolor=defaultcolor;
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<Object> currentline = new ArrayList<Object>();
		currentline.add(currentcolor);
		for (Object object : message) {
			if(object instanceof ChatColor)
			{
				currentcolor=(ChatColor) object;
				currentline.add(currentcolor);
			}
			else if(object instanceof String)
			{
				String temp = (String) object;
				for(int templength=temp.length();templength>0;templength=temp.length())
				{
					int currentlength=getStringLength(currentline.toArray());
					int lastspace=0;
					if(templength+currentlength>maxlinelength)
					{
						lastspace=(maxlinelength-currentlength);
						lastspace=lastspace>templength?templength:lastspace;
						lastspace = temp.substring(0, lastspace).lastIndexOf(' ');
						if(lastspace<0)
						{
							lastspace=maxlinelength-currentlength;
						}
					}
					else
					{
						lastspace=templength;
					}
					lastspace=lastspace>temp.length()?temp.length():lastspace;
					currentline.add(temp.substring(0,lastspace));
					output.add(makeString(currentline.toArray()));
					currentline.clear();
					currentline.add(currentcolor);
					temp=temp.substring(lastspace);
				}
			}
			else if(object instanceof Symbol)
			{
				Symbol temp = (Symbol) object;
				if(temp==Symbol.Newline)
				{
					output.add(makeString(currentline.toArray()));
				}
				else if(temp==Symbol.DefaultColor)
				{
					currentcolor = defaultcolor;
					currentline.add(currentcolor);
				}
			}
		}
		if(!currentline.isEmpty())
		{
			if(currentline.size()==1&&currentline.get(0) instanceof ChatColor)
			{
				
			}
			else
			{
				output.add(makeString(currentline.toArray()));
			}
		}
		String[] templist = new String[output.size()];
		output.toArray(templist);
		ChatUtil.output.put((Player) sender, templist);
		rawsendout(sender, ChatUtil.output.get((Player) sender));
	}
	
	public static void sendError(Object[] message,CommandSender sender)
	{
		send(message,sender,errorcolor);
	}
	
	public static void sendError(CommandSender sender,String message)
	{
		Object[] tempmessage = {message};
		send(tempmessage,sender,errorcolor);
	}
	
	public static void tooMany(int number,CommandSender sender)
	{
		Object[] message = {"Too many parameters:"+number};
		sendError(message,sender);
	}
	
	public static void tooFew(int number,CommandSender sender)
	{
		Object[] message = {"Too few parameters:"+number};
		sendError(message,sender);
	}
	
	public static void empty(CommandSender sender)
	{
		Object[] message = {"Parameter was emtpy"};
		sendError(message,sender);
	}
	
	public static void note(Object[] message,CommandSender sender)
	{
		send(message,sender,note);
	}
	
	public static void note(CommandSender sender,String message)
	{
		Object[] tempmessage = {message};
		note(tempmessage,sender);
	}
	
}
