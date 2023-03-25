package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.CalculationException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;

public class DIVCommand extends Command {

	
	protected int ARGS_LENGTH = 1;
	public DIVCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != ARGS_LENGTH) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException, CalculationException{
		Double fs = null, sc = null;
		try {
			fs = context.getValueFromStack();
			sc = context.getValueFromStack();
			Double res = fs / sc;
			if(res.isNaN() || res.isInfinite()) {
				throw (new CalculationException());
			}
			context.addValueToStack(res);
		}catch(CalculationException e) {
			throw (new CalculationException());
		}catch(Exception e){
			if(sc != null) context.addValueToStack(sc.doubleValue());
			if(fs != null) context.addValueToStack(fs.doubleValue());
			throw (new ExecutionCommandException());
		}
	}

}
