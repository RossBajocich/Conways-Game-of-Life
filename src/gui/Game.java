package gui;

import java.util.Random;

public class Game {
	Random r = new Random();
	private int xMax, yMax, width, height;
	private int[][] d, t;

	public Game(int width, int height, int xMax, int yMax) {
		d = new int[xMax][yMax];
		t = new int[xMax][yMax];
		this.width = width;
		this.height = height;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int[][] getD() {
		return d;
	}

	public int getYMax() {
		return yMax;
	}

	public int getXMax() {
		return xMax;
	}

	public void initialize() {
		for (int i = 0; i < 100; i++) {
			createGlider(t, r.nextInt(xMax - 2), r.nextInt(yMax - 2));
			createBlock(t, r.nextInt(xMax - 2), r.nextInt(yMax - 2));
			createBlinker(t, r.nextInt(xMax - 2), r.nextInt(yMax - 2));
			createAcorn(t, r.nextInt(xMax - 7), r.nextInt(yMax - 2));
		}
		randomize(2);
		for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				d[x][y] = t[x][y];
			}
		}
	}

	public void set(int x, int y, int val) {
		d[x][y] = val;
	}

	private void createAcorn(int a[][], int x, int y) {
		a[x][y + 2] = 1;
		a[x + 1][y + 2] = 1;
		a[x + 1][y] = 1;
		a[x + 3][y + 1] = 1;
		a[x + 4][y + 2] = 1;
		a[x + 5][y + 2] = 1;
	}

	private void createGlider(int a[][], int x, int y) {
		a[x][y] = 1;
		a[x + 1][y + 1] = 1;
		a[x + 2][y + 1] = 1;
		a[x][y + 2] = 1;
		a[x + 1][y + 2] = 1;
	}

	private void createBlock(int a[][], int x, int y) {
		a[x][y] = 1;
		a[x + 1][y] = 1;
		a[x][y + 1] = 1;
		a[x + 1][y + 1] = 1;
	}

	private void createBlinker(int a[][], int x, int y) {
		a[x][y] = 1;
		a[x][y + 1] = 1;
		a[x][y + 2] = 1;
	}

	public void life() {
		int n;
		for (int x = 1; x < xMax - 1; x++) {
			for (int y = 1; y < yMax - 1; y++) {
				n = 0;
				n += t[x - 1][y - 1];
				n += t[x][y - 1];
				n += t[x + 1][y - 1];

				n += t[x - 1][y];
				n += t[x + 1][y];

				n += t[x - 1][y + 1];
				n += t[x][y + 1];
				n += t[x + 1][y + 1];

				// alive
				if (n != 2 && n != 3) {
					d[x][y] = 0;
				}

				// dead
				if (n == 3) {
					d[x][y] = 1;
				}
			}
		}
		for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				t[x][y] = d[x][y];
			}
		}
	}

	public void randomize(int chance) {
		Random r = new Random();
		for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				t[x][y] = r.nextInt(chance);
			}
		}
	}
}
