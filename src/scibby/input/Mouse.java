package scibby.input;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class Mouse implements MouseInputListener{

	public static Rectangle MOUSE = new Rectangle(0, 0, 1, 1);

	private static boolean buttons[] = new boolean[65535];

	@Override
	public void mousePressed(MouseEvent e){
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e){
		buttons[e.getButton()] = false;
	}
	
	public static boolean isButtonPressed(int button){
		return buttons[button];
	}

	@Override
	public void mouseMoved(MouseEvent e){
		MOUSE.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mouseDragged(MouseEvent e){}
}
