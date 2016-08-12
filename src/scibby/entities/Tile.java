package scibby.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Tile extends Entity{

	private BufferedImage image;

	public Tile(int x, int y, int width, int height, BufferedImage image){
		super(x, y, width, height);
		this.image = image;
	}

	public Tile(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	@Override
	public abstract void tick();

	@Override
	public void render(Graphics2D g){
		if(image != null){
			g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
		}
	}

	public boolean isSolid(){
		return false;
	}

}
