package com.namarius.complexredstone.api;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Location;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;


public class BlockCache extends BlockListener {

	private HashMap<Location, HashSet<BlockListener>> blocks = new HashMap<Location, HashSet<BlockListener>>();
	
	public BlockCache() {
		
	}
	
	public void addLocation(Location loc,BlockListener listener)
	{
		if(loc != null && listener != null)
		{
			HashSet<BlockListener> set = this.blocks.get(loc);
			if(set != null)
			{
				set.add(listener);
			}
			else
			{
				set = new HashSet<BlockListener>();
				set.add(listener);
				this.blocks.put(loc,set);
			}
		}
	}
	
	public void addLocations(Location[] loc,BlockListener listener)
	{
		for (Location location : loc) {
			addLocation(location, listener);
		}
	}
	
	public void removeLocation(Location loc,BlockListener listener)
	{
		if(loc != null && listener != null)
		{
			HashSet<BlockListener> set = this.blocks.get(loc);
			set.remove(listener);
			if(set.isEmpty())
				this.blocks.remove(loc);
		}
	}
	
	public void removeLocations(Location[] loc,BlockListener listener)
	{
		for (Location location : loc) {
			removeLocation(location, listener);
		}
	}
	
	private BlockListener[] getListener(Location loc)
	{
		BlockListener[] ret = null;
		if(loc != null)
		{
			HashSet<BlockListener> listener=this.blocks.get(loc);
			if(listener != null)
			{
				listener.toArray(ret);
			}
			
		}
		return ret;
	}
	
	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) {
		Location loc = event.getBlock().getLocation();
		BlockListener[] listener = getListener(loc);
		if(listener != null)
			for (BlockListener blockListener : listener) {
				blockListener.onBlockPhysics(event);
			}
	}
}
