package ru.nsu.ccfit.Prokhorov.calculator.core.context;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
	
	private Map<String, Double> values;
	private Stack<Double> stack;
	
	
	public Context() {
		values = new HashMap<String, Double>();
		stack = new Stack<Double>();
	}
	
	public void addValue(String name, Double value) throws NotFoundElementInContextException {
		if(values.put(name, value) != null) {
			throw (new NotFoundElementInContextException());
		}
	}
	
	public Double getValue(String name) throws NotFoundElementInContextException {
		if(!values.containsKey(name)) {
			throw (new NotFoundElementInContextException());
		}
		return values.get(name);
	}
	
	public void addValueToStack(Double val) {
		stack.push(val);
	}
	
	public Double getValueFromStack() throws EmptyStackException {
		return stack.pop();
	}
	
	public Double see() throws EmptyStackException {
		return stack.peek();
	}
}
