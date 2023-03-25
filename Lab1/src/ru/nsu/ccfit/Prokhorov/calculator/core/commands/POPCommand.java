package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.CalculationException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;

public class POPCommand extends Command {

	protected int ARGS_LENGTH = 1;
	
	public POPCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != ARGS_LENGTH) {
			throw (new WrongArgumentsException());
		}
	}
	
	@Override
	public void exec()  throws ExecutionCommandException, CalculationException {
		context.getValueFromStack();
	}

}
