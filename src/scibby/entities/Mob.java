package scibby.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import scibby.level.Level;

public abstract class Mob extends Entity{

	protected enum Direction{
		Up(0), Down(2), Left(3), Right(1);

		private int num;

		private Direction(int num){
			this.num = num;
		}

		protected int getNum(){
			return num;
		}
	}

	protected Direction dir;

	protected BufferedImage image;

	public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public Mob(int x, int y, int width, int height, BufferedImage image){
		super(x, y, width, height);
		this.image = image;
	}

	public Mob(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	@Override
	public void tick(){
		for(Projectile p : projectiles){
			p.tick();
		}
	}

	@Override
	public void render(Graphics2D g){
		if(image != null){
			g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
		}
	}

	protected boolean isColliding(double xa, double ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			double xt = ((x + xa) - c % 2) / 32;
			double yt = ((y + ya) - c / 2) / 32;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0) ix = (int) Math.floor(xt);
			if(c / 2 == 0) iy = (int) Math.floor(yt);
			Tile tile = Level.getTile(ix, iy);
			if(tile != null){
				if(tile.isSolid()){
					solid = true;
				}
			}
		}
		return solid;
	}

	protected void move(double xa, double ya){

		if(xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
			return;
		}

		if(xa > 0) dir = Direction.Right;
		if(xa < 0) dir = Direction.Left;
		if(ya > 0) dir = Direction.Down;
		if(ya < 0) dir = Direction.Up;

		while(xa != 0){
			if(Math.abs(xa) > 1){
				if(!isColliding(abs(xa), ya)){
					this.x += abs(xa);
				}
				xa -= abs(xa);
			}else{
				if(!isColliding(abs(xa), ya)){
					this.x += xa;
				}
				xa = 0;
			}
		}

		while(ya != 0){
			if(Math.abs(ya) > 1){
				if(!isColliding(xa, abs(ya))){
					this.y += abs(ya);
				}
				ya -= abs(ya);
			}else{
				if(!isColliding(xa, abs(ya))){
					this.y += ya;
				}
				ya = 0;
			}
		}

	}

	private int abs(double value){
		if(value < 0) return -1;
		return 1;
	}

}
