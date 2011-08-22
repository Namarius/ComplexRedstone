package com.namarius.complexredstone;

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
	public void onPlayerQuit(PlayerQuitEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerQuit(event);
	}
	
	@Override
	public void onPlayerKick(PlayerKickEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerKick(event);
	}

}
