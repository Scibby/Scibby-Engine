package scibby.input;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener{

	public static Rectangle MOUSE = new Rectangle(0, 0, 1, 1);

	@Override
	public void mouseMoved(MouseEvent e){
		MOUSE.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e){}
}
