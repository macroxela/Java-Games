import java.awt.*;
import javax.swing.*;


public class MovingObject extends Rectangle
{
	int dx, dy, sch, scw;
	String att;
	
	ImageIcon pic;
	MovingObject()
	{
		x = 100;
		y = 150;
		
		dx = 5;
		dy = 0;
		
		width = 100;
		height = 50;
		att = "car";
	}
	
	public void setSpeed(int xspeed, int yspeed)
	{
		dx = xspeed;
		dy = yspeed;
	}
	
	public void setXY(int xpos, int ypos)
	{
		x = xpos;
		y = ypos;
	}
	public void update()
	{
		if(x < scw )
			x += dx;
		else
			x = 0;
	}
	public void setPic(ImageIcon p)
	{
		pic = p;
	}
	
	public void draw(Graphics g, Component c)
	{
		sch = c.getHeight();
		scw = c.getWidth();
		g.drawImage(pic.getImage(), x, y%c.getHeight(), width, height, c);
		g.drawRect(x, y%c.getHeight(), width, height);
	}
}
