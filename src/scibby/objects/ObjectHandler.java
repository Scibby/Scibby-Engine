package scibby.objects;

import java.awt.Graphics;
import java.util.ArrayList;

import scibby.states.State;

public class ObjectHandler{

	private ArrayList<GameObject> objectList = new ArrayList<GameObject>();

	public void tick(){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).tick();
		}
	}

	public void render(Graphics g){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).render(g);
		}
	}

	public void addObjects(GameObject object){
		objectList.add(object);
	}

	public void removeObjects(GameObject object){
		objectList.remove(object);
	}
	
	public void clearObjects(){
		objectList.clear();
	}

}
