package ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.Command;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.ICommand;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.FactorySystemError;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class CommandsFactory {
	
	private Context context;
	private Properties prop;
	
	public CommandsFactory(Context context){
		this.context = context;
		InputStream stream = CommandsFactory.class.getResourceAsStream("FactoryResources.properties");
		prop = new Properties();
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Command createComand(String strl) throws WrongCommandException, FactorySystemError {
		String[] parsed = strl.split(" ");
		String commandName = parsed[0];
		String className = prop.getProperty(commandName);
		Class<Command> commandClass;
		try {
			commandClass = (Class<Command>) Class.forName(className);
		} catch (Exception e1) {
			throw (new WrongCommandException());
		}
		Constructor<Command> constructor;
		try {
			constructor = commandClass.getConstructor(Object[].class);
		} catch (Exception e) {
			throw (new FactorySystemError());
		}
		Object[] args = new Object[parsed.length];
		args[0] = context;
		for(int i = 1; i < parsed.length; i++) {
			args[i] = parsed[i];
		}
		try {
			return (Command) constructor.newInstance((Object)args);
		} catch (Exception e) {
			throw (new WrongCommandException());
		}

	}
}
