package com.namarius.complexredstone;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.namarius.complexredstone.api.BlockCache;
import com.namarius.complexredstone.commands.CRCommand;
import com.namarius.complexredstone.commands.CRCommandType;
import com.namarius.complexredstone.debugger.CRPlayerDebug;

public class ComplexRedstone extends JavaPlugin {
	private static ComplexRedstone self;
	private Logger log;
	private BlockCache blockcache = new BlockCache();
	private CRBlockListener blocklistener = new CRBlockListener(this);
	private CRPlayerListener playerlistener = new CRPlayerListener(this);
	private TickRunner tickrunner = new TickRunner(this);
	private Server server;
	private HashMap<String,CRCommand> commands = new HashMap<String,CRCommand>();
	private static HashMap<Player,CRPlayerDebug> players = new HashMap<Player, CRPlayerDebug>();
	
	private static void setSelf(ComplexRedstone plugin)
	{
		self=plugin;
	}
	
	public static ComplexRedstone getSelf()
	{
		return self;
	}
	
	public static CRPlayerDebug getCRPlayerDebug(Player player)
	{
		return players.get(player);
	}
	
	@Override
	public void onDisable() {
		log.info("ComplexRedstone shutting down");
	}

	@Override
	public void onEnable() {
		setSelf(this);
		server = this.getServer();
		PluginManager pm = server.getPluginManager();
		log = server.getLogger();
		info("ComplexRestone booting up");
		pm.registerEvent(Type.BLOCK_PHYSICS, blockcache, Priority.Monitor, this);
		pm.registerEvent(Type.PLAYER_QUIT,playerlistener,Priority.Monitor,this);
		pm.registerEvent(Type.PLAYER_KICK, playerlistener, Priority.Monitor, this);
		commands.clear();
		for (CRCommandType c : CRCommandType.values()) {
			CRCommand lc=c.getCommand();
			commands.put(lc.commandName(),lc);
		}
		info("ComplexRedstone up and running");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) 
	{
		String cmd = command.getName().toLowerCase();
		CRCommand ccommand=commands.get(cmd);
		return ccommand.onCommand(sender, command, label, args);
	}
	
	public void removePlayer(Player player)
	{
		blocklistener.removePlayer(player);
	}
	
	
	public void info(String in)
	{
		log.info(in);
	}
	
	public void warning(String in)
	{
		log.warning(in);
	}

	public TickRunner getTickRunner() {
		return tickrunner;
	}
}
