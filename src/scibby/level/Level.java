package scibby.level;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import scibby.entities.Entity;
import scibby.entities.Mob;
import scibby.entities.Projectile;
import scibby.entities.Tile;
import scibby.events.Event;
import scibby.graphics.Camera;
import scibby.layer.Layer;

public abstract class Level extends Layer{

	private static int currentLevel;

	private static Level level;

	protected final int WIDTH, HEIGHT;

	protected final int TILE_SIZE;

	private static ArrayList<Level> levels = new ArrayList<Level>();

	protected ArrayList<Entity> entities = new ArrayList<Entity>();

	protected ArrayList<Entity> players = new ArrayList<Entity>();
	
	protected HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();

	protected Camera camera;

	public Level(int width, int height, int viewSizeX, int viewSizeY, int tileSize){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.TILE_SIZE = tileSize;
		camera = new Camera(viewSizeX, viewSizeY, width * tileSize, height * tileSize);
	}

	public void tick(){
		for(Entity e : entities){
			e.tick();
			if(e instanceof Mob){
				for(int i = 0; i < ((Mob) e).projectiles.size(); i++){
					if(((Mob) e).projectiles.get(i).removed){
						((Mob) e).projectiles.remove(((Mob) e).projectiles.get(i));
					}
				}
				level.camera.tick((Mob) e);
			}
		}
	}

	public void render(Graphics2D g){

		g.translate(-camera.camX, -camera.camY);

		for(int y = 0; y < level.HEIGHT; y++){
			for(int x = 0; x < level.WIDTH; x++){
				getTile(x, y).render(g);
			}
		}

		for(Entity e : entities){
			e.render(g);
			if(e instanceof Mob){
				for(Projectile p : ((Mob) e).projectiles){
					p.render(g);
				}
			}
		}
		g.translate(camera.camX, camera.camY);
	}
	
	@Override
	public abstract void onEvent(Event event);

	public Tile getTile(int x, int y){
		return tiles.get(x + y * level.WIDTH);
	}

	public void addEntity(Entity entity){
		if(currentLevel == 0) return;
		entities.add(entity);
	}

	public void removeEntity(Entity entity){
		if(currentLevel == 0) return;
		entities.remove(entity);
	}
	
	public static void addLevel(Level level){
		levels.add(level);
	}

	public static void setLevel(int levelNumber){
		currentLevel = levelNumber;
		level = levels.get(levelNumber - 1);
	}

	public static Level getCurrentLevel(){
		return level;
	}
	
	public Camera getCamera(){
		return camera;
	}
	
	public int getTileSize(){
		return TILE_SIZE;
	}
	
	public int getHeight(){
		return HEIGHT;
	}

	public int getWidth(){
		return WIDTH;
	}
}
