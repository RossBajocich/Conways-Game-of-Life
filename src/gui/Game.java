package gui;

import java.util.Random;

public class Game {
	Random r = new Random();
	private int xMax, yMax, width, height;
	private int[][] d, t;
	private int[][] gunPat = { { 24, 8 }, { 22, 7 }, { 24, 7 }, { 12, 6 },
			{ 13, 6 }, { 20, 6 }, { 21, 6 }, { 34, 6 }, { 35, 6 }, { 11, 5 },
			{ 15, 5 }, { 20, 5 }, { 21, 5 }, { 34, 5 }, { 35, 5 }, { 0, 4 },
			{ 1, 4 }, { 10, 4 }, { 16, 4 }, { 20, 4 }, { 21, 4 }, { 0, 3 },
			{ 1, 3 }, { 10, 3 }, { 14, 3 }, { 16, 3 }, { 17, 3 }, { 22, 3 },
			{ 24, 3 }, { 10, 2 }, { 16, 2 }, { 24, 2 }, { 11, 1 }, { 15, 1 },
			{ 12, 0 }, { 13, 0 }, };
	private boolean running = false;

	public Game(int width, int height, int xMax, int yMax) {
		d = new int[xMax][yMax];
		t = new int[xMax][yMax];
		this.width = width;
		this.height = height;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
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
		for (int i = 0; i < 10; i++) {
			/*
			 * createGlider(t, r.nextInt(xMax - 2), r.nextInt(yMax - 2));
			 * createBlock(t, r.nextInt(xMax - 2), r.nextInt(yMax - 2));
			 * createBlinker(t, r.nextInt(xMax - 2), r.nextInt(yMax - 2));
			 * createAcorn(t, r.nextInt(xMax - 7), r.nextInt(yMax - 2));
			 */
			// createGosperGliderGun(t, r.nextInt(xMax - 40), r.nextInt(yMax -
			// 30));
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
		t[x][y] = val;
	}

	private void createGosperGliderGun(int a[][], int x, int y) {
		for (int i = 0; i < gunPat.length; i++) {
			System.out.println("x: " + gunPat[i][0] + "\ty: " + gunPat[i][1]);
			a[x + gunPat[i][0]][y + gunPat[i][1]] = 1;
		}
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
