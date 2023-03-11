package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;

public class DIVCommand extends Command {

	public DIVCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != 1) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException{
		Double fs = null, sc = null;
		try {
			fs = context.getValueFromStack();
			sc = context.getValueFromStack();
			Double res = fs / sc;
			context.addValueToStack(res);
		}catch(Exception e){
			if(sc != null) context.addValueToStack(sc.doubleValue());
			if(fs != null) context.addValueToStack(fs.doubleValue());
			throw (new ExecutionCommandException());
		}
	}

}
