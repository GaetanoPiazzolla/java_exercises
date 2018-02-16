package com.pluralsight.pattern.decorator;

public class ConcreteDecorator2 extends Decorator{

	public ConcreteDecorator2(Component component) {
		super(component);
	}
	
	public String doStuff() {
		return super.doStuff() +" with decorator2";
	}
	

}
