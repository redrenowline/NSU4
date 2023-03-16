package ru.nsu.ccfit.Prokhorov.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;

public class POPTest {

	@Test
	public void Test1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 5").exec();
			factory.createComand("PUSH 6").exec();
			factory.createComand("POP").exec();
		}catch(Exception e) {
			return;
		}
		assertTrue(cont.see() == 5);
	}
	
	@Test
	public void TestException1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 5").exec();
			factory.createComand("POP 1 12").exec();
		}catch(Exception e) {
			assertTrue(true);
			return;
		}
		fail();
		return;
	}

}
