package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public abstract class Command{

	protected Object[] args;
	protected Context context;
	
	public Command(Object[] args) throws WrongArgumentsException {
		this.args = args;
		context = (Context) args[0];
	}
	
	public abstract void exec()  throws ExecutionCommandException;
	
}
