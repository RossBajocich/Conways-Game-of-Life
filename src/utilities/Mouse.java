package utilities;

import gui.Game;
import gui.GameLoop;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	int mx, my;
	private static GameLoop g;

	public Mouse(GameLoop g) {
		this.g = g;
	}

	public Point getMouse() {
		int tx = mx, ty = my;
		System.out.println("mx: " + mx + " my: " + my);
		return new Point(tx, ty);
	}

	public void mousePressed(MouseEvent e) {
		g.setRunning(false);
		mx = e.getX();
		my = e.getY();
		Game g2 = g.getGame();
		g2.set(e.getX() * g2.getXMax() / g2.getWidth(), e.getY() * g2.getYMax()
				/ g2.getHeight(), 1);
		System.out.println("yay");
	}

	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		System.out.println("yay");
	}

	public void mouseEntered(MouseEvent e) { }

	public void mouseExited(MouseEvent e) {	}

	public void mouseReleased(MouseEvent e) {
		g.setRunning(true);
	}
}
