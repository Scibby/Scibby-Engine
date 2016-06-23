package scibby.core;

import java.io.Serializable;

import javax.swing.JFrame;

import scibby.graphics.Display;

public class GameContainer extends JFrame implements Runnable, Serializable{

	private Thread thread;

	private boolean running = false;

	public int width;

	public int height;

	public int maxFrames;

	public String title;

	Display disp;

	public GameContainer(int width, int height, int maxFrames){
		this.width = width;
		this.height = height;
		this.maxFrames = maxFrames;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public GameContainer(int width, int height, int maxFrames, String title){
		this.width = width;
		this.height = height;
		this.maxFrames = maxFrames;
		this.title = title;

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	private void init(){
		disp = new Display(width, height);
		add(disp);
		pack();
	}

	private void tick(){

	}

	@Override
	public void run(){
		while(running){

			init();

			long initialNanoTime = System.nanoTime();
			double ticksPerSecond = 1000000000 / maxFrames;
			double delta = 0;
			int updates = 0;
			int frames = 0;
			long milli = System.currentTimeMillis();
			while(running){
				long now = System.nanoTime();
				delta += (now - initialNanoTime) / ticksPerSecond;
				initialNanoTime = now;
				if(delta >= 1){
					tick();
					updates++;
					disp.render();
					frames++;
					delta--;
				}

				if(System.currentTimeMillis() - milli > 1000){
					milli += 1000;
					updates = 0;
					frames = 0;
				}
			}
			System.out.println(updates + ", " + frames);
		}

	}

	/**
	 * Starts the thread.
	 */
	public synchronized void start(){
		if(running) return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Stops the thread.
	 */
	public synchronized void stop(){
		if(!running) return;

		running = false;
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

}
