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
import scibby.util.ResourceLoader;

public class Display extends Canvas{

	private int width;

	private int height;

	private BufferedImage image;
	public int[] pixels;

	private Screen screen;
	
	private static Graphics2D g;

	public Display(int width, int height, GameContainer gc){

		this.width = width;
		this.height = height;

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		screen = new Screen(width, height, pixels);
		
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

		g = (Graphics2D) bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		GameStateManager.getCurrentState().render(screen);

		g.drawImage(image, 0, 0, null);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
		
		g.dispose();

		bs.show();
	}

	public static Graphics2D getG(){
		return g;
	}
	
}
