package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.exceptions.NotFoundElementInContextException;

public class MINUSCommand extends Command {

	public MINUSCommand(Object[] args) {
		super(args);
	}

	@Override
	public void exec() {
		try {
			Double fs = context.getValueFromStack();
			Double sc = context.getValueFromStack();
			fs -= sc;
			context.addValueToStack(fs);
		}catch(EmptyStackException e) {
			e.printStackTrace();
		}
	}

}
