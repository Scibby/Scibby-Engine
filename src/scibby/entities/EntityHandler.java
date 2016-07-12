package scibby.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EntityHandler{

	private static ArrayList<Entity> entitys = new ArrayList<Entity>();

	public static void tick(){
		for(int i = 0; i < entitys.size(); i++){
			entitys.get(i).tick();
		}
	}

	public static void render(Graphics2D g){
		for(int i = 0; i < entitys.size(); i++){
			entitys.get(i).render(g);
		}
	}

	public static void addEntity(Entity entity){
		entitys.add(entity);
	}

	public static void removeEntity(Entity entity){
		entitys.remove(entity);
	}

	public static void clearObjects(){
		entitys.clear();
	}

}
