package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class PLUSCommand extends Command {

	public PLUSCommand(Object[] args) {
		super(args);
	}

	@Override
	public void exec() {
		try {
			Double fs = context.getValueFromStack();
			Double sc = context.getValueFromStack();
			fs += sc;
			context.addValueToStack(fs);
		}catch(EmptyStackException e){
			e.printStackTrace();
		}
	}

}
