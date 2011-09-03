package com.namarius.complexredstone.message;

public class SetDeleted extends AbstractMessage {

	@Override
	public int numOfArgc() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Set '"+argv[0]+"' deleted.";
	}

}
