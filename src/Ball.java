import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Ball extends JPanel {
	int PYCord1 = 150;
	int PYCord2 = 150;
	int BXCord1 = 200;
	int BYCord1 = 175;

	public Ball() {
		super();
		System.out.print(PYCord1);
		this.setFocusable(true);
		Ball ref = this;
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
		for(;;) {
			if
			
		}
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
