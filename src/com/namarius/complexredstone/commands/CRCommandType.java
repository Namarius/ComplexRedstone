package com.namarius.complexredstone.commands;

import java.lang.reflect.Constructor;

public enum CRCommandType
{
	StartCommand(StartCommand.class),
	EndComman(EndCommand.class),
	StepComman(StepCommand.class),
	ArmComman(ArmCommand.class),
	FuseComman(FuseCommand.class),
	ListComman(ListCommand.class),
	AddComman(AddCommand.class),
	DeleteComman(DeleteCommand.class),
	AddSetComman(AddSetCommand.class),
	DeleteSetComman(DeleteSetCommand.class),
	SwitchComman(SwitchCommand.class),
	EnableComman(EnableCommand.class),
	DisableComman(DisableCommand.class),
	ForcedDisableComman(ForcedDisableCommand.class);
	
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
