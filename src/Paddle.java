import java.awt.Graphics;

public class Paddle {
	public static int WIDTH = 10, HEIGHT = 75;
	public int x, y;

	public Paddle(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}

	public void moveUp() {
		if (y == 0) {
			return;
		}

		y -= 5;
	}

	public void moveDown() {
		if (y >= PongPanel.HEIGHT - Paddle.HEIGHT) {
			return;
		}

		y += 5;
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, Paddle.WIDTH, Paddle.HEIGHT);
	}

}
