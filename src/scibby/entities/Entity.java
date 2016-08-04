package scibby.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity{

	public int x, y;

	public int width, height;

	public Entity(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics2D g);

	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}

	public Rectangle getBoundsTop(){
		return new Rectangle(x + 6, y, width - 12, 12);
	}

	public Rectangle getBoundsBottom(){
		return new Rectangle(x + 6, y + (height - 12), width - 12, 12);
	}

	public Rectangle getBoundsLeft(){
		return new Rectangle(x, y + 6, 6, height - 12);
	}

	public Rectangle getBoundsRight(){
		return new Rectangle(x + (width - 6), y + 6, 6, height - 12);
	}

}
