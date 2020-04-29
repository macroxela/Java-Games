
import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel{
	
	ImageIcon picture;
	Enemy ene;
	Hero he;
	int counter;
	
	GamePanel()
	{
		ene = new Enemy();
		he = new Hero();
	}
	
	GamePanel(Hero us, Enemy n)
	{
		ene = n;
		he = us;
		counter = 0;
	}
	
	void update_info(Hero us, Enemy n)
	{
		ene = n;
		he = us;
	}

	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		ene.draw(g, this);
		he.draw(g, this);
		
		if(ene.hp <= 0)
		{
			g.setColor(Color.red);
			g.drawLine(ene.x,ene.y, 320, 130);
			g.drawLine(ene.x + 120,ene.y, ene.x, 130);
			g.setFont( new Font( "stupid font", Font.BOLD, 30 ) );
			g.drawString("You beat " + ene.name + "!!!", 30, 300);
		}
		
		if(he.hp <= 0)
		{
			g.setFont( new Font( "stupid font", Font.BOLD, 50 ) );
			g.drawString("GAME OVER!!!!", 30, 300);
		}
		
		if(he.level >= he.lvl_evolve1)
		{
			if(he.type.equalsIgnoreCase("Grass"))
				he.pich = new ImageIcon("img/Ivysaur_espalda_G5.gif");
			else if(he.type.equalsIgnoreCase("Fire"))
				he.pich = new ImageIcon("img/Charmeleon_espalda_G5.gif");
			else if(he.type.equalsIgnoreCase("Water"))
				he.pich = new ImageIcon("img/Wartortle_espalda_G5.gif");
			he.draw(g, this);
		}
		if(he.level >= he.lvl_evolve2)
		{
			if(he.type.equalsIgnoreCase("Grass"))
				he.pich = new ImageIcon("img/Venusaur_espalda_G5_hembra.gif");
			else if(he.type.equalsIgnoreCase("Fire"))
				he.pich = new ImageIcon("img/Charizard_espalda_G5.gif");
			else if(he.type.equalsIgnoreCase("Water"))
				he.pich = new ImageIcon("img/Blastoise_espalda_G5.gif");
			he.draw(g, this);
		}
		
		if(ene.name.equalsIgnoreCase("Giratina") && ene.hp <= 32)
		{
			ene.pice = new ImageIcon("img/Giratina_forma_origen_NB.gif");
			ene.draw(g, this);
		}
	}
}
