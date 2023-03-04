package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public final class DEFINECommand extends Command {

	private String name;
	private Double value;
	
	public DEFINECommand(Object[] args) {
		super(args);
		context  = (Context)args[0];
		name = (String) args[1];
		value = Double.parseDouble((String)args[2]);
	}

	@Override
	public void exec() {
		context.addValue(name, value);
	}

}
