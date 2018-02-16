package com.pluralsight.pattern.state;

public class PlayerContext {

	State currentState;
	
	public PlayerContext(State initialState) {
		super();
		currentState = initialState;
	}
	
	public void pressPlay() {
		currentState.pressPlay(this);
	}

	public void setState(State idleState) {
		this.currentState = idleState;
	}
	
	public String getState() {
		return this.currentState.printState();
	}

}
