package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.VolatileImage;

public class RenderManger implements Runnable {
	Window parent;
	VolatileImage img;
	Graphics graphics;

	public RenderManger(Window parent) {
		this.parent = parent;
		img = parent.createVolatileImage(parent.getWidth(), parent.getHeight());
	}

	public void reset() {
		graphics = img.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, img.getWidth(), img.getHeight());
	}

	public void run() {
		if (parent != null && img != null) {
			parent.getGraphics().drawImage(img, 0, 0, null);
		} else {
			System.out.println("Something went wrong. parent: " + parent
					+ ", img: " + img);
		}
		//parent.repaint();
	}

	public Graphics getGraphics() {
		return img.getGraphics();
	}

	public VolatileImage getImage() {
		return img;
	}

}
