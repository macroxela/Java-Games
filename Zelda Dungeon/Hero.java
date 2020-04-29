import java.awt.*;
import java.util.*;

import javax.swing.*;


public class Hero extends Rectangle{
	
	String name;
	int hp;
	ImageIcon pic;
	ImageIcon life_full, life_3_4, life_1_2, life_1_4;
	int dx, dy, num;
	String direction;
	String action;
	boolean alive, over, bomb, passable;
	long t1, t2;
	LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	LinkedList<ImageIcon> hearts = new LinkedList<ImageIcon>();
	
	Hero()
	{
		name = "Default";
		hp = 6;
		num = 4;
		alive = true;
		bomb = false;
		pic = new ImageIcon("data/LinkStandingUp.png");
		//x = 418;
		//y = 80;
		x = 280;
		y = 485;
		width = 20;
		height = 20;
		direction = "up";
		action = "none";
		hp = 20;
		life_full = new ImageIcon("data/HeartContainer.png");
		life_3_4 = new ImageIcon("data/HeartContainer_3_4.png");
		life_1_2 = new ImageIcon("data/HeartContainer_1_2.png");
		life_1_4 = new ImageIcon("data/HeartContainer_1_4.png");
		for(int i = 0; i < 5; i++)
		{
			hearts.add(life_full);
		}
		over = false;
		passable = false;
	}
	
	Hero(String _n)
	{
		name = _n;
		hp = 6;
		pic = new ImageIcon("data/LinkStandingUp.png");
		x = 150;
		y = x;
		width = 20;
		height = 20;
		direction = "up";
		action = "none";
		over = false;
	}
	
	public void setEnemies(LinkedList<Enemy> en)
	{
		//for(Enemy o : en)
		//{
			enemies = en;
		//}
		
	}
	
	public void faintSequence()
	{
		
		if(!alive)
		{
			if(t1 == 0)
				t1 = System.currentTimeMillis();
			t2 = System.currentTimeMillis();
			int num = 0;
			if(t2 - t1 > 650)
				num = 1;
			if(t2 - t1 > 1300)
				num = 2;
			if(t2 - t1 > 1950)
				num = 3;
			if(t2 - t1 > 2600)
				num = 4;
			if(t2 - t1 > 3250)
				num = 5;
			if(t2 - t1 > 3900)
				num = 6;
			if(t2 - t1 > 6000)
				num = 7;
			
			if(num == 1)
			{
				pic = new ImageIcon("data/LinkDead1.png");
			}
			if(num == 2)
			{
				pic = new ImageIcon("data/LinkDead2.png");
			}
			if(num == 3)
			{
				pic = new ImageIcon("data/LinkDead3.png");
			}
			if(num == 4)
			{
				pic = new ImageIcon("data/LinkDead4.png");
			}
			if(num == 5)
			{
				pic = new ImageIcon("data/LinkDead5.png");
			}
			if(num == 6)
			{
				pic = new ImageIcon("data/LinkDead6.png");
			}
			if(num == 7)
			{
				over = true;
			}
			
		}
	}
	
	public void update()
	{
		if(alive)
		{
			x += dx;
			y += dy;
			//System.out.println("X: " + x + "\nY: " + y);
		}
		else
		{
			dx = 0;
			dy = 0;
			faintSequence();
		}
		
		//System.out.println("HP: " + hp);
		LinkedList<ImageIcon> dummy = new LinkedList<ImageIcon>();
		
		if(hp < 20)
		{
			while(!hearts.isEmpty())
			{
				hearts.remove();
			}
		}
		if(hp == 19)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_3_4);*/
			for(int i = 0; i < 4; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_3_4);

			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 18)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_2);*/
			for(int i = 0; i < 4; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_1_2);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 17)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_4);*/
			for(int i = 0; i < 4; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_1_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 16)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			System.out.println("Problem Here");*/
			for(int i = 0; i < 4; i++)
			{
				dummy.add(life_full);
			}
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 15)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_3_4);*/
			for(int i = 0; i < 3; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_3_4);

			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 14)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_2);*/
			for(int i = 0; i < 3; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_1_2);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 13)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_4);*/
			for(int i = 0; i < 3; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_1_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 12)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			System.out.println("Problem Here");*/
			for(int i = 0; i < 3; i++)
			{
				dummy.add(life_full);
			}
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 11)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_3_4);*/
			for(int i = 0; i < 2; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_3_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 10)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_2);*/
			for(int i = 0; i < 2; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_1_2);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 9)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_4);*/
			for(int i = 0; i < 2; i++)
			{
				dummy.add(life_full);
			}
			dummy.add(life_1_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 8)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();*/
			for(int i = 0; i < 2; i++)
			{
				dummy.add(life_full);
			}
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 7)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_3_4);*/
			
			dummy.add(life_full);
			dummy.add(life_3_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 6)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_2);*/
			dummy.add(life_full);
			dummy.add(life_1_2);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 5)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_4);*/
			dummy.add(life_full);
			dummy.add(life_1_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 4)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();*/
			dummy.add(life_full);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 3)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_3_4);*/
			dummy.add(life_3_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 2)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_2);*/
			dummy.add(life_1_2);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 1)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();
			hearts.add(life_1_4);*/
			dummy.add(life_1_4);
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		if(hp == 0)
		{
			/*if(!hearts.isEmpty())
				hearts.removeLast();*/
			for(ImageIcon o : dummy)
			{
				hearts.add(o);
			}
		}
		
		while(!dummy.isEmpty())
		{
			dummy.remove();
		}
	}
	
	public void draw(Graphics g, Component c)
	{
		if( pic != null )
		{
			g.drawImage(pic.getImage(),x,y,width,height,c);
		}
		int cnt = 10;
		if(life_full != null)
		{
			for(ImageIcon o : hearts)
			{
				g.drawImage(o.getImage(), cnt, 20, 20, 20, c);
				cnt += 20;
			}
		}
	}

}
