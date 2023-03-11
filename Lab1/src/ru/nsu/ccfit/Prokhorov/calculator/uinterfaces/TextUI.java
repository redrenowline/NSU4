package ru.nsu.ccfit.Prokhorov.calculator.uinterfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.FactorySystemError;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongArgumentsException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;
import ru.nsu.ccfit.Prokhorov.calculator.core.context.Context;
import ru.nsu.ccfit.Prokhorov.calculator.put.files.StringGetter;

public class TextUI {
	
	private Context cont;
	
	private ResourceBundle resources;
	
	private CommandsFactory factory;
	
	private PrintStream ou;
	private InputStream in;
	
	private MODE md;
	
	public TextUI(PrintStream o, String[] args){
		this.ou = o;
		this.resources = ResourceBundle.getBundle("ru.nsu.ccfit.Prokhorov.calculator.uinterfaces.UIResources", new Locale("ru"));
		this.cont = new Context();
		this.factory = new CommandsFactory(cont);
		this.md = MODE.OFFLINEMODE;
	}
	
	public TextUI(PrintStream o, InputStream i) {
		this.ou = o;
		this.in = i;
		this.resources = ResourceBundle.getBundle("ru.nsu.ccfit.Prokhorov.calculator.uinterfaces.UIResources", new Locale("ru"));
		this.cont = new Context();
		this.factory = new CommandsFactory(cont);
		this.md = MODE.ONLINEMODE;
	}
	
	public void start() {
		ou.print(String.format(resources.getString(UIResources.HELLO_MESSAGE_ID), UIResources.verison));
		if(this.md == MODE.ONLINEMODE) {
			onlineModeExecution();
		}else {
			offlineModeExecution(null);
		}
	}
	
	public void onlineModeExecution() {
		Scanner sc = new Scanner(this.in);
		String strl = "start";
		while(strl != "exit"){
			strl = sc.nextLine();
			if(strl.startsWith(UIResources.COMMENT_STRING)) {
				continue;
			}
			try {
				factory.createComand(strl).exec();
			}catch(WrongCommandException e) {
				ou.print(resources.getString(UIResources.WRONGCOMMAND_ID));
			}catch(WrongArgumentsException e){
				ou.print(resources.getString(UIResources.WRONGARGUMENT_ID));
			}catch(FactorySystemError e) {
				ou.print(resources.getString(UIResources.FACTORYSYSTEMERROR_ID));
			} catch (ExecutionCommandException e) {
				ou.print(resources.getString(UIResources.WRONGCOMMNADEXECUTION_ID));
			}
		}
		sc.close();
	}
	
	public void offlineModeExecution(String str) {
		StringGetter getter;
		try {
			getter = new StringGetter(str);
		}catch(FileNotFoundException e) {
			ou.print(resources.getString(UIResources.FILENOTFOUNT_ID));
			return;
		}
		String sstrl;
		try {
			while((sstrl = getter.getString())!= null) {
				if(sstrl.startsWith(UIResources.COMMENT_STRING)) {
					continue;
				}
				try {
					factory.createComand(sstrl).exec();
				}catch(WrongCommandException e) {
					ou.print(resources.getString(UIResources.WRONGCOMMAND_ID));
					continue;
				}catch(WrongArgumentsException e){
					ou.print(resources.getString(UIResources.WRONGARGUMENT_ID));
					continue;
				}catch(FactorySystemError e) {
					ou.print(resources.getString(UIResources.FACTORYSYSTEMERROR_ID));
					continue;
				} catch (ExecutionCommandException e) {
					ou.print(resources.getString(UIResources.WRONGCOMMNADEXECUTION_ID));
					continue;
				}
			}
		} catch (IOException e) {
			ou.print(resources.getString(UIResources.IOEXCEPTION_ID));
		}
	}
}
