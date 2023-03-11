package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class PUSHCommand extends Command {

	Double value;
	String key;
	
	public PUSHCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != 2 || !(args[0] instanceof Context) || !(args[1] instanceof String) ) {
			throw (new WrongArgumentsException());
		}
		context = (Context)this.args[0];
		try {
			value = Double.parseDouble(((String)this.args[1]));
		}catch(NumberFormatException e) {
			key = (String)this.args[1];
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException {
		context.addValueToStack(value);
	}
}
