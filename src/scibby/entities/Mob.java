package scibby.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import scibby.util.ResourceLoader;

public abstract class Mob extends Entity{

	protected enum Direction{
		Up, Down, Left, Right
	}

	protected Direction dir;

	protected BufferedImage image;

	public Mob(int x, int y, int width, int height, String imageName){
		super(x, y, width, height);
		image = new ResourceLoader().loadImage(imageName);
	}

	@Override
	public void tick(){

	}

	@Override
	public void render(Graphics2D g){
		if(image != null){
			g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
		}else{
			g.setColor(Color.RED);
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		}
	}

	protected abstract boolean isColliding(int xa, int ya);

	protected void move(int xa, int ya){
		if(xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
			return;
		}

		if(!isColliding(xa, ya)){
			x += xa;
			y += ya;
		}
	}

}
