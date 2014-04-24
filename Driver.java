import javax.swing.*;
import java.awt.*;

public class Driver {

	
	public static void main(String[] args) {
		
		DungeonPanel panel = new DungeonPanel();
		JFrame frame = new JFrame("Dungeon");
		
		frame.getContentPane().add(panel);

		frame.setSize(600,600);
		frame.setVisible(true);
		//B: Shoot arrows
		//C: Drop Bombs
		//Space or Ctrl: Sword attack, stopped working after adding bombs
		
	}

}
