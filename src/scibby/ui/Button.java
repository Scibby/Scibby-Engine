package scibby.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import scibby.input.Mouse;
import scibby.util.AudioPlayer;

public class Button extends Rectangle{

	protected String text;

	protected Color color;

	protected Color hColor;

	protected boolean shouldHover;

	protected Font font;

	protected boolean hovered = false;

	protected final int oldX;
	protected final int oldY;
	protected final int oldWidth;
	protected final int oldHeight;

	protected AudioPlayer buttonSFX;

	public Button(int x, int y, int width, int height, String text, Color color, Color hColor, boolean shouldHover, Font font){
		super(x, y, width, height);
		this.text = text;
		this.color = color;
		this.hColor = hColor;
		this.shouldHover = shouldHover;
		this.font = font;

		this.oldX = x;
		this.oldY = y;
		this.oldWidth = width;
		this.oldHeight = height;
	}

	public Button(int x, int y, int width, int height, String text, Color color, Color hColor, boolean shouldHover, Font font,
			AudioPlayer audio){
		super(x, y, width, height);
		this.text = text;
		this.color = color;
		this.hColor = hColor;
		this.shouldHover = shouldHover;
		this.font = font;

		this.oldX = x;
		this.oldY = y;
		this.oldWidth = width;
		this.oldHeight = height;

		this.buttonSFX = audio;
	}

	public void drawButton(Graphics2D g){

		g.setFont(font);

		if(Mouse.MOUSE.intersects(this)){
			g.setColor(hColor);

			if(!hovered){
				if(shouldHover){
					width += (width / 4);
					height += (height / 4);

					x -= (width / 8);
					y -= (height / 8);
				}
				if(buttonSFX != null){
					buttonSFX.play();
				}
			}
			if(shouldHover){
				g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 34));
				g.setStroke(new BasicStroke(6));
			}
			hovered = true;
		}else{
			g.setColor(color);

			if(hovered){
				if(shouldHover){
					width = oldWidth;
					height = oldHeight;

					x = oldX;
					y = oldY;
				}
			}
			g.setStroke(new BasicStroke(3));
			g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 28));
			
			hovered = false;
		}

		FontMetrics fm = g.getFontMetrics(g.getFont());

		g.drawString(text, x + width / 2 - (fm.stringWidth(text) / 2), y + height / 2 + 12);

		g.draw(this);
		g.setStroke(new BasicStroke(1));
	}

}
