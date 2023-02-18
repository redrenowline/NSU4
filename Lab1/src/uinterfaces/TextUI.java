package uinterfaces;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import core.commands.factory.CommandsFactory;
import core.context.Context;

public class TextUI {

	private Context cont;
	
	private ResourceBundle resources;
	
	private CommandsFactory factory;
	
	public TextUI(String[] args){
		resources = ResourceBundle.getBundle("uinterfaces.UIResources", new Locale("ru"));
		cont = new Context();
		factory = new CommandsFactory(cont);
		factory.createComand("PUSH q");
	}
	
	public void start() {
		System.out.print(String.format(resources.getString("HELLO_MESSAGE"), UIResources.verison));
	}
}
