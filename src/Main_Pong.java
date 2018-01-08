import javax.swing.JFrame;

public class Main_Pong {
	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PongPanel game = new PongPanel();
		f.add(game);
		f.setSize(500, 500);
		f.setVisible(true);
	}
}
