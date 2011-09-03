package com.namarius.complexredstone;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class CRPlayerListener extends PlayerListener 
{
	private ComplexRedstone plugin;
	
	public CRPlayerListener(ComplexRedstone plugin)
	{
		this.plugin=plugin;
	}
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		plugin.addPlayer(event.getPlayer());
	}
	
	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		plugin.removePlayer(event.getPlayer());
	}
	
	@Override
	public void onPlayerKick(PlayerKickEvent event) {
		plugin.removePlayer(event.getPlayer());
	}

}
