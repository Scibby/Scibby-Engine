package scibby.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import scibby.core.GameContainer;
import scibby.states.GameStateManager;

public class Screen extends Canvas{

	private int width;

	private int height;

	private BufferedImage image;
	public int[] pixels;
	
	public Screen(int width, int height, GameContainer gc){

		this.width = width;
		this.height = height;
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		Dimension dim = new Dimension(width, height);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setMaximumSize(dim);
	}

	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		GameStateManager.getCurrentState().render(g);
		
		g.drawImage(image, 0, 0, null);
		g.dispose();

		bs.show();
	}

	public void fillRect(int x, int y, int width, int height, int colour) {
		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				if (xx < 0 || xx >= this.width || yy < 0 || yy >= this.height) continue;
				pixels[xx + yy * this.width] = colour;
			}
		}
	}
	
}
