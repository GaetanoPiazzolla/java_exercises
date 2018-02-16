package com.pluralsight.pattern.state;

public class IdleState implements State{

	@Override
	public void pressPlay(PlayerContext context) {
		context.setState(new WorkingState());
	}

	@Override
	public String printState() {
		return "IDLE";
	}

}
