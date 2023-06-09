package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.CalculationException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongCommandException;

public class SQRTCommand extends Command {

	
	protected int ARGS_LENGTH = 1;
	public SQRTCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != ARGS_LENGTH) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException, CalculationException {
		try {
			Double fs = context.getValueFromStack();
			fs = Math.sqrt(fs);
			if(fs.isNaN() || fs.isInfinite()) {
				throw (new CalculationException());
			}
			context.addValueToStack(fs);
		}catch(EmptyStackException e) {
			throw (new ExecutionCommandException());
		}catch(CalculationException e) {
			throw (new CalculationException());
		}
	}

}
