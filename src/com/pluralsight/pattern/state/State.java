package com.pluralsight.pattern.state;

public interface State {
	
	public void pressPlay(PlayerContext context);

	public String printState();
}
