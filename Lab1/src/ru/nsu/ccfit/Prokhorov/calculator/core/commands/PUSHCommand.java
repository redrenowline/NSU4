package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class PUSHCommand extends Command {

	Double value;
	
	public PUSHCommand(Object[] args) {
		super(args);
		context = (Context)this.args[0];
		value = Double.parseDouble(((String)this.args[1]));
	}

	@Override
	public void exec() {
		context.addValueToStack(value);
	}
}
