package ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.Command;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.ICommand;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;

public class CommandsFactory {
	
	private Context context;
	
	public CommandsFactory(Context context){
		this.context = context;
	}
	
	public ICommand createComand(String strl) {
		String[] parsed = strl.split(" ");
		String commandName = parsed[0];
		try {
			InputStream stream = CommandsFactory.class.getResourceAsStream("FactoryResources.properties");
			Properties prop = new Properties();
			prop.load(stream);
			String className = prop.getProperty(commandName);
			Class<? extends Command> commandClass = (Class<? extends Command>) Class.forName(className);
			Constructor<? extends Command> constructor = commandClass.getConstructor(Object[].class);
			Object[] args = new Object[parsed.length];
			args[0] = context;
			for(int i = 1; i < parsed.length; i++) {
				args[i] = parsed[i];
			}
			return (ICommand) constructor.newInstance(args);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
