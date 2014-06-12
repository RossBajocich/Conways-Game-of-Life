package gui;

import java.awt.Graphics;

import javax.swing.JFrame;

import utilities.Keyboard;
import utilities.Mouse;

public class Window extends JFrame {
	private static RenderManger rm;
	private static GameLoop g;
	private static Keyboard k;
	private static Mouse m;
	private static Thread game, render;

	public Window(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setResizable(true);
		setIgnoreRepaint(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIgnoreRepaint(true);
		k = new Keyboard();
		addKeyListener(k);
		setVisible(true);
		setResizable(false);
		rm = new RenderManger(this);
		g = new GameLoop(rm, k, m);
		game = new Thread(g, "Game");
		render = new Thread(rm, "Render");
		m = new Mouse(g);
		addMouseListener(m);

	}

	public void paint(Graphics g) {
		g.drawImage(rm.getImage(), 0, 0, null);
	}

	public static void main(String[] args) {
		Window w = new Window("Game", 500, 500);
		while (true) {
			if (g.isRunning()) {
				g.run();
			}
			rm.run();
		}
	}
}
