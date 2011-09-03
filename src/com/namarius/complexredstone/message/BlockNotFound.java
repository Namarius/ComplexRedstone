package com.namarius.complexredstone.message;

public class BlockNotFound extends AbstractMessage {

	@Override
	public int numOfArgc() {
		return 1;
	}

	@Override
	public String toString() {
		return "The block:'"+argv[0]+"'wasn't found.";
	}

}
