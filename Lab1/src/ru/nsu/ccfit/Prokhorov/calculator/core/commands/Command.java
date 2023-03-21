package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.CalculationException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public abstract class Command{

	protected Object[] args;
	protected Context context;
	
	protected final int CONTEXT_POSITION = 0;
	protected final int FIRSTARG_POSITION = 1;
	protected final int SECONDARG_POSITION = 2;
	
	public Command(Object[] args) throws WrongArgumentsException {
		this.args = args;
		context = (Context) args[CONTEXT_POSITION];
	}
	
	public abstract void exec()  throws ExecutionCommandException, CalculationException;
	
}
