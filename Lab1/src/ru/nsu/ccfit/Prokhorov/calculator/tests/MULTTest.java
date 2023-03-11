package ru.nsu.ccfit.Prokhorov.calculator.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ru.nsu.ccfit.Prokhorov.calculator.core.commands.Command;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.ExecutionCommandException;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.exceptions.FactorySystemError;
import ru.nsu.ccfit.Prokhorov.calculator.core.commands.factory.CommandsFactory;

public class MULTTest {

	@Test
	public void Test1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		try {
			factory.createComand("PUSH 5").exec();
			factory.createComand("PUSH 12").exec();
			factory.createComand("MULT").exec();
		}catch(Exception e) {
			return;
		}
		assertTrue(cont.see() == 60);
	}
	
	@Test
	public void TestException1() {
		ru.nsu.ccfit.Prokhorov.calculator.core.context.Context cont = new ru.nsu.ccfit.Prokhorov.calculator.core.context.Context();
		CommandsFactory factory = new CommandsFactory(cont);
		Command cmd = null;
		try {
			factory.createComand("PUSH 5").exec();		
			cmd = factory.createComand("MULT");
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
			factory.createComand("MULT 4 3 abacacba").exec();
		}catch (ExecutionCommandException e) {
			return;
		} catch (FactorySystemError e) {
			Assert.assertTrue(true);
			return;
		}
	}
	
}
