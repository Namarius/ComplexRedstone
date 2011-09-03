package com.namarius.complexredstone.message;

public class NumberOfLines extends AbstractMessage {

	@Override
	public int numOfArgc() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Number of lines:" + argv[0];
	}

}
