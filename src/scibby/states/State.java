package scibby.states;

import java.awt.Graphics2D;

public abstract class State{

	protected final int stateId;

	public State(int stateId){
		this.stateId = stateId;
	}

	public void tick(){

	}

	public void render(Graphics2D g){

	}

	public int getStateId(){
		return stateId;
	}
}
