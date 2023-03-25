package ru.nsu.ccfit.Prokhorov.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;

public class PRINTTest {

	@Test
	public void Test1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 5").exec();
			factory.createComand("PRINT").exec();
		}catch(Exception e) {
			return;
		}
		assertTrue(cont.see() == 5);
	}

}
