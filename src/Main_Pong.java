import javax.swing.JFrame;

public class Main_Pong {
	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Paddles C = new Paddles();
		f.add(C);
		f.setSize(400, 425);
		f.setVisible(true);
		C.draw();

	}
}
