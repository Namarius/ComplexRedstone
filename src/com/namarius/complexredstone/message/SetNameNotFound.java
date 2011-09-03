package com.namarius.complexredstone.message;

public class SetNameNotFound extends AbstractMessage {

	@Override
	public int numOfArgc() {
		return 1;
	}

	@Override
	public String toString() {
		return "Set '" + argv[0] + "' not found.";
	}

}
