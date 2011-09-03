package com.namarius.complexredstone.message;

import java.lang.reflect.Constructor;

public enum MessageType {
	BlockAdded(BlockAdded.class), BlockDeleted(BlockDeleted.class), BlockNotFound(
			BlockNotFound.class), ListBlocks(ListBlocks.class), ListSets(
			ListSets.class), NoActiveSet(NoActiveSet.class), NoLastOutput(
			NoLastOutput.class), NumberOfLines(NumberOfLines.class), SetCreated(
			SetCreated.class), SetDeleted(SetDeleted.class), SetNameNotFound(
			SetNameNotFound.class), SetNorBlock(SetNorBlock.class), SetNotFound(
			SetNotFound.class), SetOverwritten(SetOverwritten.class), SetSwitched(
			SetSwitched.class);

	final private Class<? extends AbstractMessage> message;

	MessageType(Class<? extends AbstractMessage> message) {
		this.message = message;
	}

	public AbstractMessage get() {
		try {
			Constructor<? extends AbstractMessage> c = this.message
					.getConstructor();
			return c.newInstance((Object[]) null);
		} catch (Exception e) {
		}
		return null;
	}

	public AbstractMessage addArg(int at, String string) {
		return get().addArg(at, string);
	}

	public AbstractMessage addArg(String string) {
		return get().addArg(string);
	}
}
