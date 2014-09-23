package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import utilities.Keyboard;
import utilities.Mouse;

public class GameLoop implements Runnable {
	private RenderManger rm;
	private boolean running = true;
	static final double FPS = 60;
	private Keyboard k;
	Game g;
	private static int width, height;
	int xPixels, yPixels;
	private Mouse m;

	public GameLoop(RenderManger rm, Keyboard k, Mouse m) {
		this.rm = rm;
		this.k = k;
		width = rm.parent.getWidth();
		height = rm.parent.getHeight();
		g = new Game(width, height, 100, 100);
		xPixels = width / g.getXMax();
		yPixels = height / g.getYMax();
		System.out.println("xMAX: " + g.getXMax() + ", yMAX: " + g.getYMax());
		System.out.println("xPixels: " + xPixels + ", yPixels: " + yPixels);
		System.out.println("FPS: " + FPS);
		g.initialize();
		this.m = m;
	}

	public Game getGame() {
		return g;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean state) {
		running = state;
	}

	public void drawBoard(Graphics gr) {
		gr.setColor(Color.BLACK);
		for (int x = 0; x < g.getXMax(); x++) {
			for (int y = 0; y < g.getYMax(); y++) {
				if (g.getD()[x][y] != 0) {
					gr.fillRect(x * xPixels, y * yPixels, xPixels, yPixels);
				}
			}
		}
	}

	public void run() {
		if (running) {
			double start, end;
			start = System.currentTimeMillis();

			// game logic
			rm.reset();
			Graphics gr = rm.getGraphics();
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			drawBoard(gr);
			if (g.isRunning()) {
				System.out.println("ran!");
				g.life();
			}
			gr.dispose();
			
			// end game logic

			end = System.currentTimeMillis();
			double diff = end - start;
			double d = 1000 / FPS;
			if (d - diff >= 0) {
				try {
					Thread.sleep((long) (d - diff));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
