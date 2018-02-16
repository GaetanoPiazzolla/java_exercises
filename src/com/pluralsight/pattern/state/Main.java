package com.pluralsight.pattern.state;

public class Main {

	public static void main(String args[]) {
		
		PlayerContext context = new PlayerContext(new IdleState());
		System.out.println(context.getState());
		
		context.pressPlay();
		System.out.println(context.getState());
		
		context.pressPlay();
		System.out.println(context.getState());
		
		context.pressPlay();
		System.out.println(context.getState());
		
		context.pressPlay();
		System.out.println(context.getState());
		
	}
}
