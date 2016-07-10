package scibby.core;

public abstract class GameMain{

	protected GameContainer init(int width, int height, GameContainer gc){
		gc = new GameContainer(width, height, 60, "Title");
		gc.start();
		return gc;
	}
}
