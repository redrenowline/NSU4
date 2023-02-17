package core.commands;

import core.context.Context;

public abstract class Command implements ICommand {

	protected Context cnt;
	
	Command(Context cnt){
		this.cnt = cnt;
	}
}
