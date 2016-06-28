package scibby.states;

import java.awt.Graphics2D;
import java.util.LinkedList;

import scibby.core.GameContainer;

public class GameStateManager{

	private static LinkedList<State> stateList = new LinkedList<State>();

	public static State currentState;

	public static void tick(){
		for(int i = 0; i < stateList.size(); i++){
			stateList.get(i).tick();
		}
	}

	public static void render(Graphics2D g){
		for(int i = 0; i < stateList.size(); i++){
			if(stateList.get(i).equals(currentState)){
				stateList.get(i).render(g);
			}
		}
	}

	public static void addState(State state){
		stateList.add(state);
	}

	public static void removeState(State state){
		stateList.remove(state);
	}

}
