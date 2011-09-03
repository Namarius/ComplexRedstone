package com.namarius.complexredstone.debugger;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;

import com.namarius.complexredstone.ComplexRedstone;
import com.namarius.complexredstone.api.BlockCache;

public class CRPlayerDebug extends BlockListener
{
	private ComplexRedstone plugin;
	private Player player;
	private HashMap<String, CRDebugSet> sets = new HashMap<String, CRDebugSet>();
	private CRDebugSet activeset = null;
	private BlockCache cache;
	
	public CRPlayerDebug(ComplexRedstone plugin,Player player,BlockCache cache)
	{
		this.plugin=plugin;
		this.player=player;
		this.cache=cache;
	}

}
