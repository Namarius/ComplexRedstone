package com.namarius.complexredstone;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.World;

public class TickRunner implements Runnable {
	private ComplexRedstone plugin;
	private HashMap<Long, Material> events = new HashMap<Long, Material>();
	private long tick = 0L;

	public TickRunner(ComplexRedstone plugin) {
		this.plugin = plugin;
	}

	public void addEvent(long time, Material material) {
		Long i = new Long(time);
		events.put(i, material);
	}

	@Override
	public void run() {

		World worlds = plugin.getServer().getWorlds().get(0);
		long time = worlds.getFullTime();
		if (time > tick) {
			plugin.info("Action:" + time);
			tick = time;
		}
	}

}
