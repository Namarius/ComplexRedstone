package com.namarius.complexredstone.debugger;

import org.bukkit.Location;

public class CRLocation extends Location {

	private String name;

	public CRLocation(Location location) {
		super(location.getWorld(), location.getX(), location.getY(), location
				.getZ(), location.getYaw(), location.getPitch());
		this.name = null;
	}

	public CRLocation(Location location, String name) {
		super(location.getWorld(), location.getX(), location.getY(), location
				.getZ(), location.getYaw(), location.getPitch());
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String setName(String name) {
		String oldname = this.name;
		this.name = name;
		return oldname;
	}

	public boolean equals(Location obj) {
		return super.equals(obj);
	}

	public boolean equals(String obj) {
		return this.name.equals(obj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.name != null) {
			return (obj != null) && this.name.equals(((CRLocation) obj).name);
		} else {
			return super.equals(obj);
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ ((name != null) ? name.hashCode() : 0);
	}

}
