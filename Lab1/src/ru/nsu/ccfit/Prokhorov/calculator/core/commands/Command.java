package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public abstract class Command implements ICommand {

	protected Object[] args;
	
	public Command(Object[] args) {
		this.args = args;
	}
	
}
