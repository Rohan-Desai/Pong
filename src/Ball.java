import java.awt.Graphics;

public class Ball {
	Paddle p1, p2;
	private int x, y, xSpeed = 3, ySpeed = 1;
	private static int WIDTH = 10, HEIGHT = 10;

	public Ball(Paddle p1, Paddle p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.x = PongPanel.WIDTH / 2;
		this.y = PongPanel.HEIGHT / 2;

	}

	public void updatePosition() {
		if (checkCollisionWithWall()) {
			ySpeed = -ySpeed;
		} else if (checkCollisionWithPaddles()) {
			xSpeed = -xSpeed;
		} else if (checkCollisionWithSide()) {
			xSpeed = 0;
			ySpeed = 0;
		}

		x += xSpeed;
		y += ySpeed;
	}

	private boolean checkCollisionWithWall() {
		if (y <= 0) {
			return true;
		}
		if (y >= PongPanel.HEIGHT - Ball.HEIGHT) {
			return true;
		}
		return false;
	}

	private boolean checkCollisionWithPaddles() {
		if (x <= p1.x + Paddle.WIDTH && y > p1.y && y < p1.y + Paddle.HEIGHT) {
			return true;
		}
		if (x >= p2.x - Ball.HEIGHT && y > p2.y && y < p2.y + Paddle.HEIGHT) {
			return true;
		}
		return false;
	}

	private boolean checkCollisionWithSide() {
		if (x >= PongPanel.WIDTH - 10) {
			return true;
		}
		if (x <= 0) {
			return true;
		}

		return false;
	}

	public void draw(Graphics g) {
		g.fillOval(x, y, Ball.WIDTH, Ball.HEIGHT);
	}
}
