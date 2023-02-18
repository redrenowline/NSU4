package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class PUSHCommand extends Command {

	public PUSHCommand(Object[] args) {
		super(args);
		Context pr = (Context)this.args[0];
		System.out.print("Everything is ok");
	}

	@Override
	public void exec() {

	}

}
