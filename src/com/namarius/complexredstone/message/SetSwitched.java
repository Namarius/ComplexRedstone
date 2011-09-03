package com.namarius.complexredstone.message;

public class SetSwitched extends AbstractMessage {

	@Override
	public int numOfArgc() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Switched to set'" + argv[0] + "'.";
	}

}
