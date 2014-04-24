import java.awt.*;
import java.util.*;

import javax.swing.*;

public class ShadowLink extends Rectangle{
	
	ImageIcon pic;
	Random ran;
	
	int hp;
	int dx, dy, movecnt, ID;
	String direction;
	String action, name;
	boolean dead;
	long t1, t2;
	
	ShadowLink()
	{
		name = "Shadow Link";
		hp = 30;
		width = 20;
		height = 20;
		pic = new ImageIcon("data/ShadowLinkDown.png");
		x = 280;
		y = 235;
		dy = 3;
		dead = false;
		ran = new Random();movecnt = 1;
		direction = "down";
		action = "none";
	}
	
	public void attackHero()
	{
		action = "none";
	}
	
	public void moveAround(int _x, int _y)
	{
		if(action.equalsIgnoreCase("attack") || action.equalsIgnoreCase("open"))
		{
			dx = 0;
			dy = 0;
			attackHero();
		}
		else
		{
			if(x > _x/* && !(x > 500) && !(x < 0)*/)
			{
				dx = -3;
				if(/*y == _y ||*/ Math.abs(x - _x) > 5)
					direction = "left";
			}
			if(x <= _x/* && !(x > 500) && !(x < 0)*/)
			{
				dx = 3;
				if(/*y == _y || */Math.abs(x - _x) > 5)
					direction = "right";
			}
			if(y > _y/* && !(y > 500) && !(y < 0)*/)
			{
				dy = -3;
				if(/*x == _x || */Math.abs(y - _y) >= 5)
					direction = "up";
			}
			if(y <= _y /*&& !(y > 500) && !(y < 0)*/)
			{
				dy = 3;
				if(/*x == _x || */Math.abs(y - _y) >= 5)
					direction = "down";
			}
			if(x == _x)
			{
				dx = 0;
				if(y > _y)
					direction = "down";
				else
					direction = "up";
			}
			if(y == -y)
			{
				dy = 0; 
				if(x > _x)
					direction = "left";
				else
					direction = "right";
			}
		//}
			if((Math.abs(x - _x) < 35 && Math.abs(y - _y) < 10) || (Math.abs(x - _x) < 10 && Math.abs(y - _y) < 35))
			{
				dx = 0;
				dy = 0;
				if(!action.equalsIgnoreCase("attack") && !action.equalsIgnoreCase("Open"))
				{
					if(direction.equalsIgnoreCase("up"))
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkUp.png");
					}
					if(direction.equalsIgnoreCase("down"))
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkDown.png");
					}
					if(direction.equalsIgnoreCase("right"))
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkRight.png");
					}
					if(direction.equalsIgnoreCase("left"))
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkLeft.png");
					}
			
					int num = ran.nextInt(3);
			
					if(num == 1)
					{
						action = "attack";
						attackHero();
					}
				}
			}
			else
			{
				System.out.println("Moving Around . . . . .");
				if(direction.equalsIgnoreCase("up"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveUp1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveUp2.png");
					}
				}
				if(direction.equalsIgnoreCase("down"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveDown1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveDown2.png");
					}
				}
				if(direction.equalsIgnoreCase("right"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveRight1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveRight2.png");
					}
				}
				if(direction.equalsIgnoreCase("left"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveLeft1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveLeft2.png");
					}
				}
				movecnt++;
			}
		}	
		//System.out.println("Position y:" + y);
	
	}
	public void update(int _x, int _y)
	{
		System.out.println("Updating . . . . .");
		//action = "none";
		moveAround(_x,_y);
	}
	
	public void draw(Graphics g, Component c)
	{
		if( pic != null )
		{
			g.drawImage(pic.getImage(),x,y,width,height,c);
		}
	}

}
