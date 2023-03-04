package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;

public class MULTCommand extends Command {

	public MULTCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != 1) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec() {
		try {
			Double fs = context.getValueFromStack();
			Double sc = context.getValueFromStack();
			fs *= sc;
			context.addValueToStack(fs);
		}catch(EmptyStackException e) {
			e.printStackTrace();
		}
	}

}
