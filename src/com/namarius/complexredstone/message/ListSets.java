package com.namarius.complexredstone.message;

public class ListSets extends AbstractMessage {

	@Override
	public int numOfArgc() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Number of sets:" + argv[0] + ":" + argv[1];
	}

}
