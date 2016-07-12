package scibby.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity{

	protected float x, y;

	protected float velX, velY;

	protected float width, height;

	protected final int ID;

	public Entity(float x, float y, float width, float height, final int id){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ID = id;
	}

	public abstract void tick();

	public abstract void render(Graphics2D g);

	public float getX(){
		return x;
	}

	public void setX(float x){
		this.x = x;
	}

	public float getY(){
		return y;
	}

	public void setY(float y){
		this.y = y;
	}

	public float getVelX(){
		return velX;
	}

	public void setVelX(float velX){
		this.velX = velX;
	}

	public float getVelY(){
		return velY;
	}

	public void setVelY(float velY){
		this.velY = velY;
	}

	public float getWidth(){
		return width;
	}

	public void setWidth(float width){
		this.width = width;
	}

	public float getHeight(){
		return height;
	}

	public void setHeight(float height){
		this.height = height;
	}

	public int getID(){
		return ID;
	}

	public Rectangle getBounds(){
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public Rectangle getBoundsTop(){
		return new Rectangle((int) x + 6, (int) y, (int) width - 12, 12);
	}

	public Rectangle getBoundsBottom(){
		return new Rectangle((int) x + 6, (int) ((int) y + (height - 12)), (int) width - 12, 12);
	}

	public Rectangle getBoundsLeft(){
		return new Rectangle((int) x, (int) y + 6, 6, (int) height - 12);
	}

	public Rectangle getBoundsRight(){
		return new Rectangle((int) ((int) x + (width - 6)), (int) y + 6, 6, (int) height - 12);
	}

}
