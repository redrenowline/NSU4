package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class POPCommand extends Command {

	
	public POPCommand(Object[] args) {
		super(args);
	}
	
	@Override
	public void exec() {
		context.getValueFromStack();
	}

}
