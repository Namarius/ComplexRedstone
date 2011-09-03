package com.namarius.complexredstone.message;

public class BlockAdded extends AbstractMessage {

	@Override
	public int numOfArgc() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Block '" + argv[0] + "' added.";
	}

}
