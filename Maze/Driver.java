import javax.swing.*;

public class Driver
{
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("Maze");

		MazePanel panel = new MazePanel();
		frame.getContentPane().add(panel);

		frame.setSize(1000,1000);
		frame.setVisible(true);
	}
}