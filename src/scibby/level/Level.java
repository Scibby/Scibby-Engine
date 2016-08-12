package scibby.level;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import scibby.entities.Entity;
import scibby.entities.Mob;
import scibby.entities.Projectile;
import scibby.entities.Tile;

public abstract class Level{

	private static int currentLevel;

	private static Level level;

	protected final int WIDTH, HEIGHT;

	public static ArrayList<Level> levels = new ArrayList<Level>();

	protected LinkedList<Entity> entities = new LinkedList<Entity>();

	protected HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();

	public Level(int width, int height){
		this.WIDTH = width;
		this.HEIGHT = height;
	}

	public static void tick(){
		if(currentLevel == 0) return;
		for(Entity e : level.entities){
			e.tick();
			if(e instanceof Mob){
				for(int i = 0; i < ((Mob) e).projectiles.size(); i++){
					if(((Mob) e).projectiles.get(i).removed){
						((Mob) e).projectiles.remove(((Mob) e).projectiles.get(i));
					}
				}
			}
		}
	}

	public static void render(Graphics2D g){
		if(currentLevel == 0) return;
		
		for(int y = 0; y < level.HEIGHT; y++){
			for(int x = 0; x < level.WIDTH; x++){
				getTile(x, y).render(g);
			}
		}
		
		for(Entity e : level.entities){
			e.render(g);
			if(e instanceof Mob){
				for(Projectile p : ((Mob) e).projectiles){
					p.render(g);
				}
			}
		}
	}

	public static Tile getTile(int x, int y){
		return level.tiles.get(x + y * level.WIDTH);
	}

	public static void addEntity(Entity entity){
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

	public abstract int getHEIGHT();

	public abstract int getWIDTH();
}
