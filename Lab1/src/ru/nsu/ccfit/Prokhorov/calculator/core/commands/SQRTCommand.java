package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongCommandException;

public class SQRTCommand extends Command {

	public SQRTCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != 1) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException {
		try {
			Double fs = context.getValueFromStack();
			fs = Math.sqrt(fs);
			context.addValueToStack(fs);
		}catch(EmptyStackException e) {
			throw (new ExecutionCommandException());
		}
	}

}
