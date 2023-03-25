package ru.nsu.ccfit.Prokhorov.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;

public class DEFINETest {

	@Test
	public void Test1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("DEFINE a 5").exec();
			factory.createComand("PUSH a").exec();
		}catch(Exception e) {
			return;
		}
		assertTrue(cont.see() == 5);
	}
	
	@Test
	public void Test2() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("DEFINE a 5").exec();
			factory.createComand("PUSH a").exec();
			factory.createComand("DEFINE a 10").exec();
			factory.createComand("PUSH a").exec();
			factory.createComand("MULT").exec();
		}catch(Exception e) {
			return;
		}
		assertTrue(cont.see() == 50);
	}

	@Test
	public void TestException1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("DEFINE a").exec();
		}catch(Exception e) {
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
		try {
			factory.createComand("DEFINE a b").exec();
		}catch(Exception e) {
			assertTrue(true);
			return;
		}
		fail();
		return;
	}	
	
}
