package scibby.graphics;

public class Screen{

	private int width;
	private int height;

	private int[] pixels;

	public Screen(int width, int height, int[] pixels){
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public void fillRect(int x, int y, int width, int height, int colour){
		for(int yy = y; yy < y + height; yy++){
			for(int xx = x; xx < x + width; xx++){
				if(xx < 0 || xx >= this.width || yy < 0 || yy >= this.height) continue;
				pixels[xx + yy * this.width] = colour;
			}
		}
	}
	
	public void renderSprite(int x, int y, Sprite sprite){
		for(int yy = 0; yy < sprite.height; yy++){
			for(int xx = 0; xx < sprite.width; xx++){
				if(xx < 0 || xx >= this.width || yy < 0 || yy >= this.height) continue;
				pixels[(xx + x) + (yy + y) * this.width] = sprite.pixels[xx + yy * sprite.width];
			}
		}
	}

}
