package ru.nsu.ccfit.Prokhorov.calculator.core.commands;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.NotFoundElementInContextException;

public class PUSHCommand extends Command {

	Double value;
	String key = null;
	
	protected int ARGS_LENGTH = 2;
	
	public PUSHCommand(Object[] args) throws WrongArgumentsException {
		super(args);
		if(args.length != ARGS_LENGTH || !(args[CONTEXT_POSITION] instanceof Context) || !(args[FIRSTARG_POSITION] instanceof String) ) {
			throw (new WrongArgumentsException());
		}
		context = (Context)this.args[CONTEXT_POSITION];
		try {
			value = Double.parseDouble(((String)this.args[FIRSTARG_POSITION]));
		}catch(NumberFormatException e) {
			key = (String)this.args[FIRSTARG_POSITION];
		}
	}

	@Override
	public void exec()  throws ExecutionCommandException {
		if(key == null)
			context.addValueToStack(value);
		else
			try {
				context.addValueToStack(context.getValue(key));
			} catch (NotFoundElementInContextException e) {
				throw (new ExecutionCommandException());
			}
	}
}
