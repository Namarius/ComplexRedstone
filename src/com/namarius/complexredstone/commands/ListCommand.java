package com.namarius.complexredstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.namarius.complexredstone.ComplexRedstone;
import com.namarius.complexredstone.message.MessageType;
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
		if (args.length == 1) {
			String what = args[0];
			if (what.equalsIgnoreCase("set")) {
				ComplexRedstone.getCRPlayerDebug((Player) sender).listSets();
				return true;
			} else if (what.equalsIgnoreCase("block")) {
				ComplexRedstone.getCRPlayerDebug((Player) sender).listBlocks(
						null);
				return true;
			}
			ChatUtil.error(sender, "'set' nor 'block' wasn't present");
		} else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("block")) {
				ComplexRedstone.getCRPlayerDebug((Player) sender).listBlocks(
						args[1]);
				return true;
			}
			ChatUtil.error(sender, MessageType.SetNorBlock.get());
		} else if (args.length < 3)
			ChatUtil.tooFew(3 - args.length, sender);
		else
			ChatUtil.tooMany(args.length - 3, sender);
		return false;
	}

}
