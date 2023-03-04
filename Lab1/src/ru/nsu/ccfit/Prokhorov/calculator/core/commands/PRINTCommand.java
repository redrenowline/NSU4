package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public final class PRINTCommand extends Command {

	public PRINTCommand(Object[] args) {
		super(args);
	}

	@Override
	public void exec() {
		System.out.print(context.see() + "\n");
	}

}
