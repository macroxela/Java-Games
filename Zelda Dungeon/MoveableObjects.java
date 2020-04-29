import java.awt.*;

import javax.swing.*;


public class MovableObjects extends Rectangle{
	
	ImageIcon pic;
	String property, direction, number;
	int dx, dy;
	
	MovableObjects(String property)
	{
		if(property.equalsIgnoreCase("tile"))
		{
			pic = new ImageIcon("data/Tile.png");
			width = 30;
			height = 30;
		}
		dx = 0;
		dy = 0;
		number = "none";
	}
	
	public void setDirection(String dir)
	{
		if(dir.equalsIgnoreCase("Vertical"))
			dy = 5;
		if(dir.equalsIgnoreCase("Horizontal"))
			dx = 5;
		if(dir.equalsIgnoreCase("Diagonal"))
		{
			dx = 3;
			dy = 3;
		}
		direction = dir;
	}
	
	public void moveAround()
	{
		if(x > 505 || x < 75)
			dx *= -1;
		//if(y < 100 || y > 375)
			//dy *= -1;
		
		if(x > 410 && (y > 260 || y < 50))
			dy *= -1;
		else if(x < 400 && (y < 100 || y > 375))
			dy *= -1;
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics g, Component c)
	{
		g.drawImage(pic.getImage(),x,y,width,height,c);
	}
	

}
