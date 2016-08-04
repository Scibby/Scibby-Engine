package scibby.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import scibby.level.Level;
import scibby.util.ResourceLoader;

public abstract class Projectile extends Entity{

	private int xOrigin, yOrigin;
	private int speed = 10;
	private Entity player;
	private double nx, ny;
	private double angle;
	private int range;
	private BufferedImage image;

	public Projectile(float x, float y, float width, float height, int id, double angle,int range, Entity player, BufferedImage image){
		super(x, y, width, height, id);
		xOrigin = (int) x;
		yOrigin = (int) y;
		this.player = player;
		this.angle = angle;
		this.range = range;
		this.image = image;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		Level.add(this);
	}

	@Override
	public void tick(){

		x += nx;
		y += ny;

		collision();

		if(Math.abs(x - xOrigin) > range){
			Level.remove(this);
		}

		if(Math.abs(y - yOrigin) > range){
			Level.remove(this);
		}
	}

	protected abstract void collision();

	@Override
	public void render(Graphics2D g){
		if(image != null){
			g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
		}else{
			g.setColor(Color.GREEN.darker());
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		}
	}

}
