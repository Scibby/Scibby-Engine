package scibby.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity{

	public double x, y;

	public int width, height;

	public Entity(double x, double y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics2D g);

}
