package com.pluralsight.pattern.decorator;

public abstract class Decorator implements Component {
	
	Component component;

	public Decorator(Component component) {
		this.component = component; 
	}
	
	public String doStuff() {
		return component.doStuff();
	}
}
