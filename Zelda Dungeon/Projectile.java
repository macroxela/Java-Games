import java.awt.*;
import java.util.*;

import javax.swing.*;


public class Projectile extends Rectangle{
	
	int dx, dy, usx, usy, usID, ID;
	String direction;
	String attribute;
	boolean active;
	long t1, t2;
	double t;
	Random ran = new Random();
	
	ImageIcon pic;
	
	Projectile()
	{
	}
	
	Projectile(int _x, int _y, String dir, String att)
	{
		x = _x;
		y = _y;
		
		active = true;
		
		dx = 0;
		dy = 0;
		
		direction = dir;
		attribute = att;
		
		usx = 0;
		usy = 0;
		usID = 0;
		ID = ran.nextInt();
		
		if(attribute.equalsIgnoreCase("IronBall"))
		{
			pic = new ImageIcon("data/IronBall.png");
			//System.out.println("Iron Ball made");
			width = 20;
			height = 20;
		}
		if(attribute == "arrow")
		{
			if(direction.equalsIgnoreCase("up"))
				dy = -7;
			if(direction.equalsIgnoreCase("down"))
				dy = 7;
			if(direction.equalsIgnoreCase("right"))
				dx = 7;
			if(direction.equalsIgnoreCase("left"))
				dx = -7;
		
			if(attribute.equalsIgnoreCase("arrow"))
			{
				if(direction.equalsIgnoreCase("up"))
				{
					pic = new ImageIcon("data/ArrowUp1.png");
					width = 5;
					height = 10;
				}
				if(direction.equalsIgnoreCase("down"))
				{
					pic = new ImageIcon("data/ArrowDown1.png");
					width = 5;
					height = 10;
				}
				if(direction.equalsIgnoreCase("right"))
				{
					pic = new ImageIcon("data/ArrowRight1.png");
					width = 10;
					height = 5;
				}
				if(direction.equalsIgnoreCase("left"))
				{
					pic = new ImageIcon("data/ArrowLeft1.png");
					width = 10;
					height = 5;
				}
			}
		}
		if(attribute == "bomb")
		{
			pic = new ImageIcon("data/bomb.png");
			width = 15;
			height = 15;
		}
		
	}
	public void setUserPos(int _x, int _y)
	{
		usx = _x;
		usy = _y;
	}
	public void update()
	{
		if(t1 == 0)
			t1 = System.currentTimeMillis();
		
		t2 = System.currentTimeMillis();
		
		if(attribute == "IronBall")
		{
			x = (int) (50 * Math.sin(t)) + usx;
			y = (int) (50 *Math.cos(t)) + usy;
			t += 0.2;
			//System.out.println("Iron Ball Updated");
			//System.out.println("Iron Ball" + usID + " X: " + x + "  Iron Ball" + usID + " Y: " + y);
		}
		if(attribute == "arrow" )
		{
			//System.out.println(active);
			if(x <= 0 || y <= 0 || x > 700 || y > 700)
			{
				dx = 0;
				dy = 0;
				active = false;
				//System.out.println("Hit Wall");
			}
			else
			{
				x += dx;
				y += dy;
			}
		}
		if(attribute == "bomb" || attribute == "explosion")
		{
			int num = 0;
			
			if(t2 - t1 > 1750)
			{
				num = 1;
			}
			if(t2 - t1 > 2750)
			{
				num = 2;
			}
			if(t2 - t1 > 3400)
				num = 3;
			/*if(t2 - t1 > 1170)
				num = 4;
			if(t2 - t1 > 2350)
				num = 5;
			if(t2 - t1 > 3450)
				num = 6;*/
			
			
			if(num == 1)
			{
				pic = new ImageIcon("data/BombRed.png");
				width = 20;
				height = 20;
			}
			if(num == 2)
			{
				pic = new ImageIcon("data/Explosion1.png");
				attribute = "explosion";
				width = 50;
				height = 50;
			}
			if(num == 3)
			{
				x = -10;
				y = -10;
				width = 1;
				height = 1;
			}
		}
		
	}
	
	public void draw(Graphics g, Component c)
	{
		//if( pic != null )
		//{
			g.drawImage(pic.getImage(),x,y,width,height,c);
			//System.out.println("Position: " + x + "," + y);
		//}
		/*else
		{
			g.setColor(Color.RED);
			g.drawRect(x, y, width, height);
		}*/
	}

}
