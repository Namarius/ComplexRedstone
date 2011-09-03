package com.namarius.complexredstone;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

import com.namarius.complexredstone.debugger.CRDebugSet;
import com.namarius.complexredstone.utils.ChatUtil;

public class CRBlockListener extends BlockListener {
		
	ComplexRedstone plugin;
	HashMap<Player,HashMap<String,CRDebugSet>> allsets = new HashMap<Player,HashMap<String,CRDebugSet>>();
	HashMap<Player,CRDebugSet> activesets = new HashMap<Player,CRDebugSet>();
	HashMap<Location,Integer> blocks = new HashMap<Location,Integer>();
	CRBlockListener(ComplexRedstone plugin)
	{
		this.plugin=plugin;
	}
	
	@Override
	public void onBlockPhysics(BlockPhysicsEvent event) 
	{
		Location location=event.getBlock().getLocation();
		if(blocks.containsKey(location))//Well we have a cache hit
		{
			for (CRDebugSet sets : activesets.values()) {
				sets.reciveEvent(event);				
			}
		}
	}
	
	public boolean addSet(Player player,String name)
	{
		HashMap<String,CRDebugSet> playersets = allsets.get(player);
		if(playersets != null)
		{
			boolean ret = playersets.containsKey(name);
			playersets.put(name, new CRDebugSet(this));
			return ret;
		}
		else
		{
			HashMap<String,CRDebugSet> temp = new HashMap<String,CRDebugSet>();
			temp.put(name, new CRDebugSet(this));
			allsets.put(player, temp);
			return false;
		}
	}
	
	public boolean removeSet(Player player,String name)
	{
		HashMap<String,CRDebugSet> playersets = allsets.get(player);
		if(playersets != null)
		{
			CRDebugSet debugset = playersets.get(name);
			debugset.setInactive();
			activesets.remove(player);
			playersets.remove(name);			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean removePlayer(Player player)
	{
		HashMap<String,CRDebugSet> playersets = allsets.get(player);
		if(playersets != null)
		{
			for (CRDebugSet sets : playersets.values()) {
				sets.setInactive();
			}
			allsets.remove(player);
			activesets.remove(player);
			return true;
		}
		return false;
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
	
	public void listSets(Player player)
	{
		HashMap<String, CRDebugSet> playersets = allsets.get(player);
		CRDebugSet activeset = activesets.get(player);
		String output = "";
		int found = 0;
		if(playersets != null)
		{
			for (Map.Entry<String, CRDebugSet> set : playersets.entrySet()) {
				found++;
				if(!output.isEmpty())
					output+=", ";
				output+=((set.getValue().equals(activeset))?"Active:":"")+set.getKey();
			}
			ChatUtil.note(player, "All sets ("+found+"): "+output);
		}
	}
}
