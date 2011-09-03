package com.namarius.complexredstone.debugger;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;

import com.namarius.complexredstone.ComplexRedstone;
import com.namarius.complexredstone.api.BlockCache;
import com.namarius.complexredstone.message.MessageType;
import com.namarius.complexredstone.utils.ChatUtil;

public class CRPlayerDebug extends BlockListener
{
	//private ComplexRedstone plugin;
	private Player player;
	private HashMap<String, CRDebugSet> sets = new HashMap<String, CRDebugSet>();
	private CRDebugSet activeset = null;
	private BlockCache cache;
	
	public CRPlayerDebug(ComplexRedstone plugin,Player player,BlockCache cache)
	{
		//this.plugin=plugin;
		this.player=player;
		this.cache=cache;
	}
	
	public void addSet(String name)
	{
		CRDebugSet set = sets.get(name);
		if(set != null)
			set.deactivate();
		sets.put(name, new CRDebugSet(cache, this));
	}
	
	public void deleteSet(String name)
	{
		CRDebugSet set = sets.get(name);
		if(set != null)
			set.deactivate();
		sets.remove(name);
	}
	
	public void addBlock(CRLocation location)
	{
		if(activeset!=null)
		{
			activeset.addBlock(location);
		}
	}
	
	public void deleteBlock(CRLocation location)
	{
		if(activeset!=null)
		{
			activeset.deleteBlock(location);
		}
	}
	
	public void listSets()
	{
		StringBuilder string = new StringBuilder();
		for(CRDebugSet set : sets.values())
		{
			if(string.length()!=0)
				string.append(", ");
			string.append(set.toString()+(set.equals(activeset)?" (active)":""));
		}
	}
	
	public void listBlocks(String name)
	{
		CRDebugSet set;
		if(name.isEmpty())
			set=activeset;
		else
			set=sets.get(name);
		if(set!=null)
		{
			set.listBlocks();
		}
		else
		{
			if(name.isEmpty())
				ChatUtil.sendError(player, MessageType.SetNotFound.get());
			else
				ChatUtil.sendError(player, MessageType.SetNameNotFound.addArg(name));
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void deactivate() {
		if(activeset!=null)
			activeset.deactivate();
	}
	
}
