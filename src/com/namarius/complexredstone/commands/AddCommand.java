package com.namarius.complexredstone.commands;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddCommand extends AbstractCommand {

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "cradd";
	}

	@Override
	public boolean localOnCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player = (Player) sender;
		String name = null;
		if(args.length==1)
		{
			name=args[0];
		}
		if(args.length>-1&&args.length<2)
		{
			Block target = player.getTargetBlock(null, 100);
		}
		return false;
	}

}
