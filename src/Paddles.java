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
	int BXCord = 100;
	int BYCord = 300;
	int MoveX = 1;
	int MoveY = 1;

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
				BXCord = BXCord + MoveX;
				BYCord = BYCord + MoveY;
				if (BXCord < 0) {
					MoveX = 0;
					MoveY = 0;

				}
				if (BXCord > 360) {
					MoveX = 0;
					MoveY = 0;

				}
				if (BYCord < 0) {
					MoveY = 1;

				}
				if (BYCord > 370) {
					MoveY = -1;

				}
				for (int i = 0; i < 76; i++) {
					if (BYCord == PYCord1 + i && BXCord == 350) {
						MoveY = 1;
						MoveX = -1;

					}
					if (BYCord == PYCord2 + i && BXCord == 20) {
						MoveY = -1;
						MoveX = 1;

					}
				}
				repaint();
			}

		};

		timer.scheduleAtFixedRate(task, 0, 50);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.fillRect(20, PYCord2, 10, 75);
		g.fillRect(350, PYCord1, 10, 75);
		g.fillOval(BXCord, BYCord, 10, 10);
	}

	public void draw() {
		// TODO Auto-generated method stub

	}

}
