package scibby.states;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameStateManager{

	private ArrayList<State> stateList = new ArrayList<State>();

	public State currentState;
	
	public void tick(){
		for(int i = 0; i < stateList.size(); i++){
			stateList.get(i).tick();
		}
	}

	public void render(Graphics g){
		currentState.render(g);
	}

	public void addState(State state){
		stateList.add(state);
	}

	public void removeState(State state){
		stateList.remove(state);
	}

}
