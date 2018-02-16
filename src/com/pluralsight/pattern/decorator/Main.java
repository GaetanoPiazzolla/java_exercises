package com.pluralsight.pattern.decorator;

public class Main {

	public static void main(String[] args) {
		Component a = new ConcreteComponent();
		System.out.println(a.doStuff());
		Decorator b = new ConcreteDecorator(a);
		System.out.println(b.doStuff());
		Decorator c = new ConcreteDecorator2(b);
		System.out.println(c.doStuff());
	}
}
