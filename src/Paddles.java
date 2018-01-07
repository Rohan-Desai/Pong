import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Paddles extends JPanel {
	int PYCord1 = 150;
	int PYCord2 = 150;
	int BXCord1 = 100;
	int BYCord1 = 300;
	int MoveX = 5;
	int MoveY = 5;

	public Paddles() {
		super();
		System.out.print(PYCord1);
		this.setFocusable(true);
		Paddles ref = this;
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (PYCord1 >= 25) {
						PYCord1 = PYCord1 - 50;
					}
					ref.repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (PYCord1 <= 250) {
						PYCord1 = PYCord1 + 50;
					}
					ref.repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					if (PYCord2 >= 25) {
						PYCord2 = PYCord2 - 50;
					}
					ref.repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					if (PYCord2 <= 250) {
						PYCord2 = PYCord2 + 50;
					}
					ref.repaint();
				}
			}
		});

		Timer timer = new Timer();
		TimerTask task;

		task = new TimerTask() {
			public void run() {
				BXCord1 = BXCord1 + MoveX;
				BYCord1 = BYCord1 + MoveY;
				if (BXCord1 < 0) {
					MoveX = 0;
					MoveY = 0;
					repaint();
				}
				if (BXCord1 > 360) {
					MoveX = 0;
					MoveY = 0;
					repaint();
				}
				if (BYCord1 < 0) {
					MoveY = 5;
					repaint();
				}
				if (BYCord1 > 370) {
					MoveY = -5;
					repaint();
				}
				for (int i = 0; i < 76; i++) {
					if (BYCord1 == PYCord1 + i && BXCord1 == 350) {
						MoveY = -5;
						MoveX = 5;
						repaint();
					}
					if (BYCord1 == PYCord2 + i && BXCord1 == 20) {
						MoveY = 5;
						MoveX = -5;
						repaint();
					}
				}
			}

		};

		timer.scheduleAtFixedRate(task, 0, 100);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.fillRect(20, PYCord2, 10, 75);
		g.fillRect(350, PYCord1, 10, 75);
		g.fillOval(BXCord1, BYCord1, 10, 10);
	}

	public void draw() {
		// TODO Auto-generated method stub

	}

}
