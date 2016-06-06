package scibby.core;

import static scibby.util.Util.*;

import java.io.Serializable;

import javax.swing.JFrame;

import scibby.util.Util.Severity;

public class GameContainer extends JFrame implements Runnable, Serializable{

	private Thread thread;

	private boolean running = false;

	public int width;

	public int height;

	public int maxFrames;

	public GameContainer(int WIDTH, int HEIGHT, int MAX_FRAMES){
		this.width = WIDTH;
		this.height = HEIGHT;
		this.maxFrames = MAX_FRAMES;
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void run(){
		while(running){
			
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

}
