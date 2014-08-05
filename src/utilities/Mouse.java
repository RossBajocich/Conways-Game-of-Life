package utilities;

import gui.Game;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class Mouse extends MouseAdapter {
	int mx, my;
	private static Game g;

	public Mouse(Game g) {
		this.g = g;
	}

	public Point getMousePos() {
		PointerInfo a = MouseInfo.getPointerInfo();
		return a.getLocation();
	}

	public void mousePressed(MouseEvent e) {
		g.setRunning(false);
		mx = e.getX();
		my = e.getY();
		g.set(e.getX() * g.getXMax() / g.getWidth(),
				e.getY() * g.getYMax() / g.getHeight(), 1);
		System.out.println("yay");
		if (e.isControlDown()) {
			g.setRunning(true);
		}
	}

	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		System.out.println("yay");
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
