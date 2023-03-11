package ru.nsu.ccfit.Prokhorov.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.Command;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.FactorySystemError;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;

public class MINUSTest {

	@Test
	public void Test1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 5").exec();
			factory.createComand("PUSH 4").exec();
			factory.createComand("MINUS").exec();
		} catch (Exception e) {
			e.printStackTrace();
		};
		Assert.assertTrue(cont.see().doubleValue() == -1);
	}
	
	@Test
	public void Test2() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 5203.321").exec();
			factory.createComand("PUSH -1323.4213123").exec();
			factory.createComand("MINUS").exec();
		} catch (Exception e) {
			e.printStackTrace();
		};
		Assert.assertTrue(cont.see().doubleValue() == -6526.7423123);
	}
	
	@Test
	public void TestException1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		Command cmd = null;
		try {
			factory.createComand("PUSH 5").exec();		
			cmd = factory.createComand("MINUS");
		} catch (Exception e) {
			fail();
			return;
		};
		try {
			cmd.exec();
		}catch(ExecutionCommandException e){
			assertTrue(true);
			return;
		}
		fail();
		return;
	}

	@Test
	public void TestException2() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		Command cmd = null;
		try {
			factory.createComand("PUSH 5").exec();		
		} catch (Exception e) {
			fail();
			return;
		};
		try {
			factory.createComand("MINUS 4 3 abacacba").exec();
		}catch (ExecutionCommandException e) {
			return;
		} catch (FactorySystemError e) {
			Assert.assertTrue(true);
			return;
		}
		fail();
		return;
	}

}
