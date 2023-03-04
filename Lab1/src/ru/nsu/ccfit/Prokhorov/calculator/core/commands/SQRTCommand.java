package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;

public class SQRTCommand extends Command {

	public SQRTCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != 1) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec() {
		try {
			Double fs = context.getValueFromStack();
			fs = Math.sqrt(fs);
			context.addValueToStack(fs);
		}catch(EmptyStackException e) {
			e.printStackTrace();
		}
	}

}
