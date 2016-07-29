package scibby.core;

public abstract class GameMain{

	protected GameContainer init(int width, int height, GameContainer gc, String title){
		gc = new GameContainer(width, height, 60, title);
		gc.start();
		return gc;
	}
}
