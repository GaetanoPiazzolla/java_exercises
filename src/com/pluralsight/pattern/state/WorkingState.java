package com.pluralsight.pattern.state;

public class WorkingState implements State {

	@Override
	public void pressPlay(PlayerContext context) {
	    context.setState(new IdleState());
	}

	@Override
	public String printState() {
		return "WORKING";
	}
	
}
