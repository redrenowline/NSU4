package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import java.util.EmptyStackException;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class SQRTCommand extends Command {

	public SQRTCommand(Object[] args) {
		super(args);
		// TODO Auto-generated constructor stub
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
