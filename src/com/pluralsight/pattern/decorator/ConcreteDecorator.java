package com.pluralsight.pattern.decorator;

public class ConcreteDecorator extends Decorator{

	public ConcreteDecorator(Component component) {
		super(component);
	}
	
	public String doStuff() {
		return super.doStuff() +" with decorator";
	}
	

}
