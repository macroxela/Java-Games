
import javax.swing.*;

public class Brickout
{
	public static void main(String [] args)
	{
		//make a frame
		JFrame frame = new JFrame("Brick Out");

		//make a panel, add to frame
		BrickPanel panel = new BrickPanel();
		frame.getContentPane().add(panel);

		//set frame size, make visible
		frame.setSize(500,500);
		frame.setVisible(true);

		//make ball start moving
		panel.animate();
	}
}