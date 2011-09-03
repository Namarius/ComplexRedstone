package com.namarius.complexredstone.debugger;

import java.util.ListIterator;
import java.util.Vector;

import org.bukkit.event.block.BlockPhysicsEvent;
import org.getspout.spoutapi.event.spout.ServerTickEvent;

import com.namarius.complexredstone.api.BlockCache;
import com.namarius.complexredstone.message.MessageType;
import com.namarius.complexredstone.utils.ChatUtil;

public class CRDebugSet {
	private BlockCache cache;
	private CRPlayerDebug listener;
	private final Vector<CRLocation> blocks = new Vector<CRLocation>();

	public CRDebugSet(BlockCache cache, CRPlayerDebug listener) {
		this.cache = cache;
		this.listener = listener;
	}

	public boolean reciveBlockEvent(BlockPhysicsEvent event) {
		return true;
	}

	public void reciveServerTickEvent(ServerTickEvent event) {

	}

	public void activate() {
		CRLocation[] loc = null;
		cache.addLocations(blocks.toArray(loc), listener);
	}

	public void deactivate() {
		CRLocation[] loc = null;
		cache.removeLocations(blocks.toArray(loc), listener);
	}

	public void addBlock(CRLocation loc) {
		if (blocks.add(loc)) {
			cache.addLocation(loc, listener);
			String name = loc.getName();
			if (name == null)
				name = loc.toString();
			ChatUtil.note(listener.getPlayer(),
					MessageType.BlockAdded.addArg(name));
		}
	}

	public void deleteBlock(CRLocation loc) {
		if (blocks.remove(loc))
			cache.removeLocation(loc, listener);
		String name = loc.getName();
		if (name == null)
			name = loc.toString();
		ChatUtil.note(listener.getPlayer(),
				MessageType.BlockDeleted.addArg(name));
	}

	public void listBlocks() {
		StringBuilder string = new StringBuilder();
		int index = 0;
		for (ListIterator<CRLocation> location = blocks.listIterator(); location
				.hasNext();) {
			index = location.nextIndex();
			CRLocation loc = location.next();
			if (string.length() != 0)
				string.append(", ");
			String name = loc.getName();
			name = name != null ? name : "";
			string.append("[" + index + "] " + loc.getName());
		}
		ChatUtil.note(
				listener.getPlayer(),
				MessageType.ListBlocks
						.addArg(new Integer(index + 1).toString()).addArg(
								string.toString()));
	}

}
