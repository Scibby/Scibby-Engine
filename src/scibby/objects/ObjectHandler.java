package scibby.objects;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectHandler{

	private static ArrayList<GameObject> objectList = new ArrayList<GameObject>();

	public static void tick(){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).tick();
		}
	}

	public static void render(Graphics g){
		for(int i = 0; i < objectList.size(); i++){
			objectList.get(i).render(g);
		}
	}

	public static void addObject(GameObject object){
		objectList.add(object);
	}

	public static void removeObject(GameObject object){
		objectList.remove(object);
	}
	
	public static void clearObject(){
		objectList.clear();
	}

}
