package com.namarius.complexredstone.debugger;

import java.util.Vector;

import org.bukkit.Location;
import org.bukkit.event.block.BlockPhysicsEvent;

import com.namarius.complexredstone.CRBlockListener;

public class CRDebugSet 
{
	private CRBlockListener blocklistener;
	private final Vector<CRLocation> blocks = new Vector<CRLocation>();
	
	public CRDebugSet(CRBlockListener blocklistener)
	{
		this.blocklistener = blocklistener;
	}
	
	public boolean reciveEvent(BlockPhysicsEvent event)
	{
		return true;
	}
	
	public boolean getActive()
	{
		for (CRLocation loc : blocks) {
			blocklistener.insertBlock(loc);
		}
		return true;
	}
	
	public boolean getInactive()
	{
		for (CRLocation loc : blocks) {
			blocklistener.removeBlock(loc);
		}
		return true;
	}
	
	public boolean insertBlock(Location location,String name)
	{
		CRLocation crlocation = new CRLocation(location,name);
		int index=blocks.indexOf(crlocation);
		if(index<0)
		{
			return blocks.add(crlocation);
		}
		else
		{
			blocks.setElementAt(crlocation, index);
			return false;
		}
	}
	
	public boolean removeBlock(String name)
	{
		for (CRLocation loc : blocks) {
			if(loc.equals(name))
			{
				blocks.remove(loc);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeBlock(Location location)
	{
		for (CRLocation loc : blocks) {
			if(loc.equals(location))
			{
				blocks.remove(loc);
				return true;
			}
		}
		return false;
	}
	
}
