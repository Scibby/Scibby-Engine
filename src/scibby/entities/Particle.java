package scibby.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Particle extends Entity{

	private double nx, ny;
	
	private Random random;
	
	private int life;
	
	private int time;
	
	public Particle(double x, double y, int width, int height, int life){
		super(x, y, width, height);
		this.life = life;
		random = new Random();
		nx = random.nextGaussian();
		ny = random.nextGaussian();
	}

	@Override
	public void tick(){
		x += nx;
		y += ny;
		life--;
		if(life <= 0){
			remove();
		}
	}

	@Override
	public void render(Graphics2D g){
		g.setColor(Color.GRAY);
		g.fillRect((int) x, (int) y, width, height);
	}

}
