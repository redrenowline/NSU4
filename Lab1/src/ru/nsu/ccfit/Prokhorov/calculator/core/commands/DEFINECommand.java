package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.CalculationException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.NotFoundElementInContextException;

public final class DEFINECommand extends Command {

	private String name;
	private Double value;
	
	protected int ARGS_LENGTH = 3;
	
	public DEFINECommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(!(args.length == ARGS_LENGTH) || !(args[CONTEXT_POSITION] instanceof Context) || !(args[FIRSTARG_POSITION] instanceof String) || !(args[SECONDARG_POSITION] instanceof String)) {
			throw (new WrongArgumentsException());
		}
		context = (Context)args[CONTEXT_POSITION];
		name = (String) args[FIRSTARG_POSITION];
		try {
			value = Double.parseDouble((String)args[SECONDARG_POSITION]);
		}catch(NumberFormatException e) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException, CalculationException{
		try {
			context.addValue(name, value);
		} catch (NotFoundElementInContextException e) {
			throw (new ExecutionCommandException());
		}
	}

}
