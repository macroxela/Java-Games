import javax.swing.*;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Frogger");
		FrogPanel panel = new FrogPanel();
		frame.getContentPane().add(panel);
		
		frame.setSize(400,400);
		frame.setVisible(true);

	}

}
