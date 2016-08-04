package scibby.level;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import scibby.entities.Entity;
import scibby.entities.Tile;

public abstract class Level{

	private static int currentLevel;
	
	private static Level level;
	
	public static ArrayList<Level> levels = new ArrayList<Level>();
	
	protected LinkedList<Entity> entities = new LinkedList<Entity>();
	
	protected HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();
	
	public static void tick(){
		if(currentLevel == 0) return;
		for(Entity e : level.entities){
			e.tick();;
		}
	}

	public static void render(Graphics2D g){
		if(currentLevel == 0) return;
		for(Entity e : level.entities){
			e.render(g);
		}
	}
	
	public static Tile getTile(int x, int y, int width){
		return level.tiles.get(x + y * width);
	}
	
	public static void add(Entity entity){
		if(currentLevel == 0) return;
		level.entities.add(entity);
	}
	
	public static void remove(Entity entity){
		if(currentLevel == 0) return;
		level.entities.remove(entity); 
	}
	
	public static void setLevel(int levelNumber){
		currentLevel = levelNumber;
		level = levels.get(levelNumber - 1);
	}
	
}
