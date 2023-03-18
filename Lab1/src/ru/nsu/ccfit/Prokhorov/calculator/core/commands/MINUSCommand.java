package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
public class MINUSCommand extends Command {

	
	protected int ARGS_LENGTH = 1;
	public MINUSCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != ARGS_LENGTH) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException{
		Double fs = null, sc = null;
		try {
			fs = context.getValueFromStack();
			sc = context.getValueFromStack();
			Double res = fs - sc;
			context.addValueToStack(res);
		}catch(Exception e){
			if(sc != null) context.addValueToStack(sc.doubleValue());
			if(fs != null) context.addValueToStack(fs.doubleValue());
			throw (new ExecutionCommandException());
		}
	}

}
