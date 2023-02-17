package core.commands;

import core.context.Context;

public abstract class Command implements ICommand {

	protected Object[] args;
	
	public Command(Object[] args) {
		this.args = args;
	}
	
}
