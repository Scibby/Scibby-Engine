package scibby.objects;

import java.awt.Graphics;

public abstract class GameObject{

	protected float x, y;

	protected float velX, velY;

	protected float width, height;
	
	protected final int ID;

	protected ObjectHandler handler;

	public GameObject(float x, float y, float width, float height, final int id, ObjectHandler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ID = id;
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

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

}
