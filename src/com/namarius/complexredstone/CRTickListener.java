package com.namarius.complexredstone;

import org.getspout.spoutapi.event.spout.ServerTickEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;

public class CRTickListener extends SpoutListener {
	
	ComplexRedstone plugin;
	
	public CRTickListener(ComplexRedstone plugin) {
		this.plugin=plugin;
	}
	
	@Override
	public void onServerTick(ServerTickEvent event) {
		plugin.sendServerTick(event);
	}

}
