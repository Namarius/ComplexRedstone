package com.namarius.complexredstone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

import com.namarius.complexredstone.debugger.CRDebugSet;

public class CRBlockListener extends BlockListener {
	
	class InternalLocation
	{
		private Location location;
		private int counter;
		public InternalLocation(Location location)
		{
			this.location=location;
			counter=1;
		}
		
		public void retain()
		{
			++counter;
		}
		
		public boolean release()
		{
			--counter;
			return canRelease();
		}
		
		public boolean canRelease()
		{
			return counter<1;
		}
		
		public Location getLocation()
		{
			return location;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return location.equals(obj);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return location.hashCode();
		}
	}
	
	ComplexRedstone plugin;
	HashMap<Player,HashMap<String,CRDebugSet>> allsets = new HashMap<Player,HashMap<String,CRDebugSet>>();
	HashMap<Player,CRDebugSet> activesets = new HashMap<Player,CRDebugSet>();
	HashMap<Location,Integer> blocks = new HashMap<Location,Integer>();
	CRBlockListener(ComplexRedstone plugin)
	{
		this.plugin=plugin;
	}
	
	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) {
		Location location=event.getBlock().getLocation();
		if(blocks.containsKey(location))//Well we have a cache hit
		{
			for (CRDebugSet sets : activesets.values()) {
				sets.reciveEvent(event);				
			}
		}
	}
	
	public boolean insertBlock(Location location)
	{
		Integer count = blocks.get(location);
		if(count != null)
		{
			count++;
			return false;
		}
		else
		{
			blocks.put(location, new Integer(1));
			return true;
		}
	}
	
	public boolean removeBlock(Location location)
	{
		Integer count = blocks.get(location);
		if(count != null)
		{
			count--;
			if(count<1)
			{
				blocks.remove(location);
				return true;
			}
			else
				return false;
		}
		else
		{
			return false;
		}
	}
}
