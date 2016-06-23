package scibby.states;

import java.awt.Graphics;

public abstract class State{
	
	private final int stateId;
	
	public State(int stateId){
		this.stateId = stateId;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
	}
	
	public int getStateId(){
		return stateId;
	}
}
