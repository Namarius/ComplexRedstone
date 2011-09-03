package com.namarius.complexredstone.message;

public class SetCreated extends AbstractMessage {

	@Override
	public int numOfArgc() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		return "Set '" + argv[0] + "' created.";
	}

}
