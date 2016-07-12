package scibby.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EntityHandler{

	public static ArrayList<Entity> entities = new ArrayList<Entity>();

	public static void tick(){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).tick();
		}
	}

	public static void render(Graphics2D g){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).render(g);
		}
	}

	public static void addEntity(Entity entity){
		entities.add(entity);
	}

	public static void removeEntity(Entity entity){
		entities.remove(entity);
	}

	public static void clearObjects(){
		entities.clear();
	}

}
