package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public final class DEFINECommand extends Command {

	private String name;
	private Double value;
	
	public DEFINECommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(!(args.length == 3) || !(args[0] instanceof Context) || !(args[1] instanceof String) || !(args[2] instanceof String)) {
			throw (new WrongArgumentsException());
		}
		context = (Context)args[0];
		name = (String) args[1];
		try {
			value = Double.parseDouble((String)args[2]);
		}catch(NumberFormatException e) {
			throw (new WrongArgumentsException());
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException{
		context.addValue(name, value);
	}

}
