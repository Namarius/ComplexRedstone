package com.namarius.complexredstone.commands;

import java.lang.reflect.Constructor;

public enum CRCommandType
{
	StartCommand(StartCommand.class),
	EndCommand(EndCommand.class),
	StepCommand(StepCommand.class),
	ArmCommand(ArmCommand.class),
	FuseCommand(FuseCommand.class),
	ListCommand(ListCommand.class),
	AddCommand(AddCommand.class),
	DeleteCommand(DeleteCommand.class),
	AddSetCommand(AddSetCommand.class),
	DeleteSetCommand(DeleteSetCommand.class),
	SwitchCommand(SwitchCommand.class),
	EnableCommand(EnableCommand.class),
	DisableCommand(DisableCommand.class),
	ForcedDisableCommand(ForcedDisableCommand.class);
	
	private Class<? extends CRCommand> command = null; 
	
	CRCommandType(Class<? extends CRCommand> command)
	{
		this.command=command;
	}
	
	public CRCommand getCommand() {
		try {
			Constructor<? extends CRCommand> c = this.command.getConstructor();
			return c.newInstance((Object[])null);
		}
		catch (Exception e) {}
		return null;
	}
}
