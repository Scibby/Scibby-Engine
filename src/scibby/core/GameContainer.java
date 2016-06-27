package scibby.core;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import scibby.graphics.Display;
import scibby.input.MouseInput;
import scibby.input.MouseMotion;
import scibby.states.GameStateManager;

public class GameContainer extends JFrame implements Runnable{

	private Thread thread;

	private boolean running = false;

	private int width;

	private int height;

	private int maxFrames;

	public String title;

	private Display disp;

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

	public void init(){
		disp = new Display(width, height, this);
		add(disp);
		pack();
		disp.addMouseMotionListener(new MouseMotion());
	}

	private void tick(){
		GameStateManager.tick();
	}

	@Override
	public void run(){
		while(running){

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

	public synchronized void start(){
		if(running) return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

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

	public Display getDisp(){
		return disp;
	}

	public void addMouseClick(MouseListener ml){
		if(disp != null){
			disp.addMouseListener(ml);
		}
	}

	public void addKeyBoard(KeyListener kl){
		if(disp != null){
			disp.addKeyListener(kl);
		}
	}
}
