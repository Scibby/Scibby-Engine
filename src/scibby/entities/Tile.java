package scibby.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import scibby.entities.Entity;

public abstract class Tile extends Entity{

	private BufferedImage image;

	public Tile(float x, float y, float width, float height, int id, BufferedImage image){
		super(x, y, width, height, id);
		this.image = image;
	}

	@Override
	public abstract void tick();

	@Override
	public void render(Graphics2D g){

		if(image != null){
			g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
		}else{
			g.setColor(Color.WHITE);
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		}

	}

	public boolean isSolid(){
		return false;
	}

}
