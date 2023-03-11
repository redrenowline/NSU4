package ru.nsu.ccfit.Prokhorov.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.Command;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.WrongCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;

public class SQRTTest {

	@Test
	public void Test1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 4").exec();
			factory.createComand("SQRT").exec();
		}catch(Exception e) {
			return;
		}
		Assert.assertTrue(cont.see() == 2.0);
	}
	
	@Test
	public void TestException1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		Command cmd;
		try {
			 cmd = factory.createComand("SQRT");
		}catch(Exception e) {
			return;
		}
		try {
			cmd.exec();
		}catch(ExecutionCommandException e) {
			Assert.assertTrue(true);
		}	
	}
	
	@Test 
	public void TestException2() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			 factory.createComand("SQRT qwqw 12 ").exec();
		}catch(WrongCommandException e) {
			Assert.assertTrue(true);
		}catch(Exception e) {
			return;
		}
	}

}
