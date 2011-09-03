package com.namarius.complexredstone.message;

public abstract class AbstractMessage {
	
	String[] argv = new String[numOfArgc()];
	
	public AbstractMessage addArg(int at,String string)
	{
		if(at>-1&&at<numOfArgc())
		{
			argv[at]=string;
		}
		return this;
	}
	
	public AbstractMessage addArg(String string)
	{
		int i=0;
		for(i = 0;i<argv.length;i++)
		{
			if(argv[i]==null)
				break;
		}
		return addArg(i,string);
	}
	
	abstract public int numOfArgc();
	
	abstract public String toString();
}
