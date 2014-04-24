import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Enemy extends Rectangle{
	
	ImageIcon pic, pic2;
	Random ran;
	
	int hp;
	int dx, dy, movecnt, ID, random, attackcnt, minioncnt;
	String direction;
	String action, name, secact;
	boolean dead, minions;
	long t1, t2;
	double t;
	//Projectile proc;
	
	Enemy()
	{
	}
	
	Enemy(int num)
	{
		ran = new Random();
		//int num = ran.nextInt(2);
		ID = ran.nextInt();
		dead = false;
		if(num == 0)
		{
			pic = new ImageIcon("data/DarknutDown.png");
			name = "Darknut";
			x = 250;
			y = x;
			dy = 3;
			hp = 15;
			width = 30;
			height = 30;
		}
		if(num == 1)
		{
			pic = new ImageIcon("data/SpearMoblinDown.png");
			name = "SpearMoblin";
			x = 350;
			y = x;
			dy = 3;
			hp = 25;
			width = 30;
			height = 30;
		}
		if(num == 2)
		{
			pic = new ImageIcon("data/IronBallSoldierDown.png");
			name = "IronBallSoldier";
			x = 350;
			y = x;
			dy = 3;
			hp = 25;
			width = 30;
			height = 30;
		}
		if(num == 3)
		{
			pic = new ImageIcon("data/ShadowLinkDown.png");
			name = "ShadowLink";
			x = 280;
			y = 235;
			hp = 30;
			dy = 3;
			width = 20;
			height = 20;
		}
		if(num == 4)
		{
			pic = new ImageIcon("data/Vaati.png");
			name = "Vaati";
			hp = 100;
			width = 50;
			height = 50;
		}
		if(num == 5)
		{
			pic = new ImageIcon("data/Eye_w_2.png");
			name = "whiteminion";
			hp = 1;
			width = 15;
			height = 15;
		}
		if(num == 6)
		{
			pic = new ImageIcon("data/Eye_y_2.png");
			name = "yellowminion";
			hp = 1;
			width = 15;
			height = 15;
		}
		movecnt = 1;
		direction = "down";
		action = "none";
		secact = "none";
		random = 0;
		attackcnt = 0;
		minioncnt = 0;
		minions = false;
		
		t1 = 0;
	}
	
	public void attackHero()
	{
		if(t1 == 0)
		{
			t1 = System.currentTimeMillis();
			random = ran.nextInt(4) + 1;
		}
		
		t2 = System.currentTimeMillis();
		
		int num = 0;
		
		if(name.equalsIgnoreCase("yellowminion") || name.equalsIgnoreCase("whiteminion"))
		{
			//action = "none";
			//dx = 5;
			//dy = 5;
			x += dx;
			y += dy;
			t1 = 0; t2 = 0;
		}
		
		if(name.equalsIgnoreCase("ShadowLink"))
		{
			//random = 4;
			//System.out.println("Nothing . . . . .");
			if(random == 1)
			{
				
			//	t1 = 0; t2 = 0;
				action = "none";
				if(t2 - t1 > 750)
				{
					num = 1;
				}
			}
			if(random == 2)
			{
				if(t2 - t1 > 500)
					num = 1;
				if(t2 - t1 > 750)
					num = 2;
				if(t2 - t1 > 900)
					num = 3;
				if(t2 - t1 > 1050)
					num = 4;
			}
			if(random == 3)
			{
				if(t2 - t1 > 750)
					num = 1;
				if(t2 - t1 > 900)
					num = 2;
				if(t2 - t1 > 1050)
					num = 3;
				if(t2 - t1 > 1200)
					num = 4;
			}
			if(random == 4)
			{
				if(t2 - t1 > 100)
					num = 1;
				if(t2 - t1 > 200)
					num = 2;
				if(t2 - t1 > 300)
					num = 2;
				if(t2 - t1 > 400)
					num = 3;
				if(t2 - t1 > 500)
					num = 4;
				if(t1 - t2 > 600)
					num = 0;
				if(t1 - t2 > 700)
					num = 1;
				if(t2 - t1 > 800)
					num = 2;
				if(t2 - t1 > 900)
					num = 3;
				if(t2 - t1 > 1000)
					num = 4;
				if(t2 - t1 > 1100)
					num = 5;
			}
		}
		if(name.equalsIgnoreCase("Darknut"))
		{
			if(t2 - t1 > 750)
				num = 1;
			if(t2 - t1 > 900)
				num = 2;
			if(t2 - t1 > 1050)
				num = 3;
			if(t2 - t1 > 1170)
				num = 4;
			if(t2 - t1 > 2350)
				num = 5;
			if(t2 - t1 > 3450)
				num = 6;
		}
		if(name.equalsIgnoreCase("SpearMoblin"))
		{
			if(t2 - t1 > 750)
				num = 1;
			if(t2 - t1 > 1350)
				num = 2;
			if(t2 - t1 > 1950)
				num = 3;
		}
		if(name.equalsIgnoreCase("IronBallSoldier"))
		{
			if(t2 - t1 > 750)
				num = 1;
			if(t2 - t1 > 1350)
				num = 2;
			if(t2 - t1 > 1950)
				num = 3;
		}
		
		/*if(t2 - t1 > 1000)
			num = 1;
		if(t2 - t1 > 2000)
			num = 2;
		if(t2 - t1 > 3000)
			num = 3;
		if(t2 - t1 > 3000)
			num = 4;
		if(t2 - t1 > 4000)
			num = 5;
		if(t2 - t1 > 5000)
			num = 6;*/
		
		//System.out.println(num);
		//System.out.println(t2);
		
		if(name.equalsIgnoreCase("ShadowLink"))
		{
			
			if(random == 4)
			{
				if(direction.equalsIgnoreCase("up"))
					dy = -4;
				if(direction.equalsIgnoreCase("down"))
					dy = 4;
				if(direction.equalsIgnoreCase("left"))
					dx = -4;
				if(direction.equalsIgnoreCase("right"))
					dx = 4;
			}
			if(num == 0 && random == 4)
			{
				pic = new ImageIcon("data/ShadowLinkSpin1.png");
				height = 30;
				width = 25;
			}
			if(num == 2 && random == 4)
			{
				pic = new ImageIcon("data/ShadowLinkSpin2.png");
				height = 25;
				width = 30;
			}
			if(num == 3 && random == 4)
			{
				pic = new ImageIcon("data/ShadowLinkSpin3.png");
				height = 30;
				width = 25;
			}
			if(num == 4 && random == 4)
			{
				pic = new ImageIcon("data/ShadowLinkSpin4.png");
				height = 25;
				width = 30;
			}
			if(num == 5 && random == 4)
			{
				height = 20; width = 20;
				t1 = 0; t2 = 0;
				dx = 0; dy = 0;
				action = "none";
			}
			
			if(direction.equalsIgnoreCase("up"))
			{				
				if(num == 0 && random == 1)
				{
					pic = new ImageIcon("data/ShadowLinkAttackUp.png");
					height = 25;
					dy = -5;
				}
				if(num == 1 && random == 1)
				{
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
					//pic = new ImageIcon("data/ShadowLinkUp.png");
				}
				//////////////////////////////////////////////////////////////////
				if(num == 0 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashUp1.png");
					height = 30;
				}
				if(num == 1 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashUp2.png");
					dy = -5;
				}
				if(num == 2 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashUp3.png");
				}
				if(num == 3 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashUp4.png");
				}
				if(num == 4 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashUp5.png");
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
				}
				///////////////////////////////////////////////////////////////////
				
				///////////////////////////////////////////////////////////////////
				if(num == 0 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashUp1.png");
					height = 30;
				}
				if(num == 1 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashUp2.png");
					dy = -5;
				}
				if(num == 2 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashUp3.png");
				}
				if(num == 3 && random == 2)
					pic = new ImageIcon("data/ShadowLinkSwordSlashUp4.png");
			}
			if(direction.equalsIgnoreCase("down"))
			{
				if(num == 0 && random == 1)
				{
					pic = new ImageIcon("data/ShadowLinkAttackDown.png");
					height = 25;
					dy = 5;
				}
				if(num == 1 && random == 1)
				{
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
					//pic = new ImageIcon("data/ShadowLinkDown.png");
				}
				//////////////////////////////////////////////////////////////////
				if(num == 0 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashDown1.png");
					height = 30;
				}
				if(num == 1 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashDown2.png");
					dy = -5;
				}
				if(num == 2 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashDown3.png");
				}
				if(num == 3 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashDown4.png");
				}
				if(num == 4 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashDown5.png");
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
				}
				////////////////////////////////////////////////////////////////////
				if(num == 0 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashDown1.png");
					height = 30;
				}
				if(num == 1 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashDown2.png");
					dy = 5;
				}
				if(num == 2 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashDown3.png");
				}
				if(num == 3 && random == 2)
					pic = new ImageIcon("data/ShadowLinkSwordSlashDown4.png");
			}
			if(direction.equalsIgnoreCase("left"))
			{				
				if(num == 0 && random == 1)
				{
					pic = new ImageIcon("data/ShadowLinkAttackLeft.png");
					width = 25;
					dx = -5;
				}
				if(num == 1 && random == 1)
				{
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
					//pic = new ImageIcon("data/ShadowLinkLeft.png");
				}
				////////////////////////////////////////////////////////////////////////
				if(num == 0 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashLeft1.png");
					height = 30;
				}
				if(num == 1 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashLeft2.png");
					dy = -5;
				}
				if(num == 2 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashLeft3.png");
				}
				if(num == 3 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashLeft4.png");
				}
				if(num == 4 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashLeft5.png");
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
				}
				///////////////////////////////////////////////////////////////////////
				if(num == 0 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashLeft1.png");
					width = 30;
				}
				if(num == 1 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashLeft2.png");
					dx = -5;
				}
				if(num == 2 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashLeft3.png");
				}
				if(num == 3 && random == 2)
					pic = new ImageIcon("data/ShadowLinkSwordSlashLeft4.png");
			}
			if(direction.equalsIgnoreCase("right"))
			{				
				if(num == 0 && random == 1)
				{
					pic = new ImageIcon("data/ShadowLinkAttackRight.png");
					width = 25;
					dx = 5;
				}
				if(num == 1 && random == 1)
				{
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
					//pic = new ImageIcon("data/ShadowLinkRight.png");
				}
				/////////////////////////////////////////////////////////////////////////////
				if(num == 0 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashRight1.png");
					height = 30;
				}
				if(num == 1 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashRight2.png");
					dy = -5;
				}
				if(num == 2 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashRight3.png");
				}
				if(num == 3 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashRight4.png");
				}
				if(num == 4 && random == 3)
				{
					pic = new ImageIcon("data/ShadowLinkDashSlashRight5.png");
					action = "none";
					dy = 0;
					width = 20; height = 20;
					t1 = 0; t2 = 0;
				}
				////////////////////////////////////////////////////////////////////////////
				if(num == 0 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashRight1.png");
					width = 30;
				}
				if(num == 1 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashRight2.png");
					dx = 5;
				}
				if(num == 2 && random == 2)
				{
					pic = new ImageIcon("data/ShadowLinkSwordSlashRight3.png");
				}
				if(num == 3 && random == 2)
					pic = new ImageIcon("data/ShadowLinkSwordSlashRight4.png");
			}
			/**/
			if(num == 4 && random == 2)
			{
				action = "none";
				if(direction.equalsIgnoreCase("up"))
				{
					pic = new ImageIcon("data/ShadowLinkUp.png");
				}
				if(direction.equalsIgnoreCase("down"))
				{
					pic = new ImageIcon("data/ShadowLinkDown.png");
				}
				if(direction.equalsIgnoreCase("left"))
				{
					pic = new ImageIcon("data/ShadowLinkLeft.png");
				}
				if(direction.equalsIgnoreCase("right"))
				{
					pic = new ImageIcon("data/ShadowLinkRight.png");
				}
				height = 20;
				width = 20;
				dx = 0; dy = 0;
				t1 = 0; t2 = 0;
				random = 0;
			}
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
		if(direction.equalsIgnoreCase("up"))
		{
			if(num == 0)
			{
				if(name.equalsIgnoreCase("Darknut"))
					pic = new ImageIcon("data/DarknutAttackUp1.png");
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackUp1.png");
					height = 40;
					dy = -1;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					//action = "open";
					pic = new ImageIcon("data/IronBallSoldierAttackUp1.png");
				}
				//System.out.println("Hello");
			}
			if(num == 1)
			{
				if(name.equalsIgnoreCase("Darknut"))
					pic = new ImageIcon("data/DarknutAttackUp2.png");
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackUp2.png");
					action = "open";
					dy = 0;
					width = 30;
					height = 30;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierAttackUp2.png");
				}
				//System.out.println("About to ");
			}
			if(num == 2)///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					dy = -10;
					pic = new ImageIcon("data/DarknutAttackUp3.png");
					//System.out.println("Attacking");
					height = 35;
					action = "attack";
				}
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					action = "none";
					t1 = 0; t2 = 0;
					//width = 30;
					//height = 30;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierUp.png");
					action = "none";
					t1 = 0; t2 = 0;
				}
			}//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(num == 3)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutAttackUp4.png");
					height = 30;
					width = 35;
					//System.out.println("Attacking 2");
				}
			}
			if(num == 4)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					action = "open";
					pic = new ImageIcon("data/DarknutAttackUp5.png");
					width = 45;
					height = 30;
					//System.out.println("Attacked");
				}
			}
			if(num == 5)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutOpenUp.png");
					width = 30;
					height = 30;
					//System.out.println("Open");
				}
			}
			if(num == 6)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					//pic = new ImageIcon("data/DarknutUp.png");
					action = "defend";
					t1 = 0; t2 = 0;
				}
			}
		}
		if(direction.equalsIgnoreCase("down"))
		{
			if(num == 0)
			{
				if(name.equalsIgnoreCase("Darknut"))
					pic = new ImageIcon("data/DarknutAttackDown1.png");
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackDown1.png");
					height = 40;
					dy = 1;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					//action = "open";
					pic = new ImageIcon("data/IronBallSoldierAttackDown1.png");
				}
			}
			if(num == 1)
			{
				if(name.equalsIgnoreCase("Darknut"))
					pic = new ImageIcon("data/DarknutAttackDown2.png");
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackDown2.png");
					action = "open";
					dy = 0;
					width = 30;
					height = 30;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierAttackDown2.png");
				}
			}
			if(num == 2)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					dy = 10;
					pic = new ImageIcon("data/DarknutAttackDown3.png");
					height = 35;
					action = "attack";
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierDown.png");
					action = "none";
					t1 = 0; t2 = 0;
				}
			}
			if(num == 3)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutAttackDown4.png");
					height = 30;
					width = 35;
				}
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					action = "none";
					t1 = 0; t2 = 0;
					width = 30;
					height = 30;
				}
			}
			if(num == 4)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					action = "open";
					dy = 0;
					pic = new ImageIcon("data/DarknutAttackDown5.png");
					width = 45;
					height = 30;
				}
			}
			if(num == 5)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutOpenDown.png");
					width = 30;
					height = 30;
				}
			}
			if(num == 6)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					//pic = new ImageIcon("data/DarknutDown.png");
					action = "defend";
					t1 = 0; t2 = 0;
				}
			}
		}
		if(direction.equalsIgnoreCase("left"))
		{
			if(num == 0)
			{
				if(name.equalsIgnoreCase("Darknut"))
					pic = new ImageIcon("data/DarknutAttackLeft1.png");
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackLeft1.png");
					width = 40;
					dx = -1;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					//action = "open";
					pic = new ImageIcon("data/IronBallSoldierAttackLeft1.png");
				}
			}
			if(num == 1)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutAttackLeft2.png");
					width = 30;
				}
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackLeft2.png");
					action = "open";
					dx = 0;
					width = 30;
					height = 30;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierAttackLeft2.png");
				}
			}
			if(num == 2)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					dx = -10;
					height = 30;
					pic = new ImageIcon("data/DarknutAttackLeft3.png");
					action = "attack";
				}
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					action = "none";
					t1 = 0; t2 = 0;
					width = 30;
					height = 30;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierLeft.png");
					action = "none";
					t1 = 0; t2 = 0;
				}
			}
			if(num == 3)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutAttackLeft4.png");
					width = 35;
				}
			}
			if(num == 4)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					action = "open";
					dx = 0;
					pic = new ImageIcon("data/DarknutAttackLeft5.png");
					width = 40;
				}
			}
			if(num == 5)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutOpenLeft.png");
					width = 30;
				}
			}
			if(num == 6)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					//pic = new ImageIcon("data/DarknutLeft.png");
					action = "defend";
					t1 = 0; t2 = 0;
				}
			}
		}
		if(direction.equalsIgnoreCase("right"))
		{
			if(num == 0)
			{
				if(name.equalsIgnoreCase("Darknut"))
					pic = new ImageIcon("data/DarknutAttackRight1.png");
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackRight1.png");
					width = 40;
					dx = 1;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					//action = "open";
					pic = new ImageIcon("data/IronBallSoldierAttackRight1.png");
				}
			}
			if(num == 1)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutAttackRight2.png");
					width = 30;
				}
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					pic = new ImageIcon("data/SpearMoblinAttackRight2.png");
					action = "open";
					dx = 0;
					width = 30;
					height = 30;
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierAttackRight2.png");
				}
			}
			if(num == 2)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					dx = 10;
					height = 35;
					pic = new ImageIcon("data/DarknutAttackRight3.png");
					action = "attack";
				}
				if(name.equalsIgnoreCase("SpearMoblin"))
				{
					action = "none";
					t1 = 0; t2 = 0;
					width = 30;
					height = 30;
					//System.out.println("Error here");
				}
				if(name.equalsIgnoreCase("IronBallSoldier"))
				{
					pic = new ImageIcon("data/IronBallSoldierRight.png");
					action = "none";
					t1 = 0; t2 = 0;
				}
			}
			if(num == 3)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutAttackRight4.png");
					width = 40;
				}
			}
			if(num == 4)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					action = "open";
					dx = 0;
					pic = new ImageIcon("data/DarknutAttackRight5.png");
					width = 35;
				}
			}
			if(num == 5)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					pic = new ImageIcon("data/DarknutOpenRight.png");
					width = 30;
				}
			}
			if(num == 6)
			{
				if(name.equalsIgnoreCase("Darknut"))
				{
					//pic = new ImageIcon("data/DarknutRight.png");
					action = "defend";
					t1 = 0; t2 = 0;
				}
			}
		}
		//dx = 0; dy = 0;
		x += dx;
		y += dy;
	}
	
	public void vaatiAttack()
	{
		if(t1 == 0)
		{
			t1 = System.currentTimeMillis();
			random = ran.nextInt(2);
		}
		t2 = System.currentTimeMillis();
		//random = 1;
		int num = 0;
		
		if(random == 0)
		{
			if(t2 - t1 > 500)
				num = 1;
			if(t2 - t1 > 750)
				num = 2;
			if(t2 - t1 > 1000)
				num = 3;
			if(t2 - t1 > 1500)
				num = 4;
			if(t2 - t1 > 2000)
				num = 5;
			if(t2 - t1 > 2500)
				num = 6;
			if(t2 - t1 > 3000)
				num = 7;
			if(t2 - t1 > 3500)
				num = 8;
		}
		
		if(random == 1)
		{
			if(t2 - t1 > 500)
				num = 1;
			if(t2 - t1 > 1000)
				num = 2;
			if(t2 - t1 > 1500)
				num = 3;
			if(t2 - t1 > 2000)
			{
				num = 4;
				//System.out.println("Process 4 . . . .");
			}
			if(t2 - t1 > 2500)
				num = 5;
			if(t2 - t1 > 3000)
				num = 6;
			if(t2 - t1 > 3500)
				num = 7;
			if(t2 - t1 > 4000)
				num = 8;
			if(t2 - t1 > 4300)
				num = 9;
		}
		
		if(num == 0 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t1.png");
		}
		if(num == 1 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t2.png");
		}
		if(num == 2 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t3.png");
			width = 52;
		}
		if(num == 3 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t4.png");
			width = 55;
			height = 55;
		}
		if(num == 4 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t5.png");
			width = 57;
			height = 57;
		}
		if(num == 5 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t6.png");
			width = 60;
			height = 60;
		}
		if(num == 6 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t7.png");
			width = 70;
			height = 70;
		}
		if(num == 7 && random == 0)
		{
			pic = new ImageIcon("data/Vaati_t8.png");
			action = "Attack";
			t2 = 0; t1 = 0;
		}
		
		if(num == 0 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack1.png");
		}
		if(num == 1 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack2.png");
		}
		if(num == 2 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack3.png");
			width = 52;
		}
		if(num == 3 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack4.png");
			width = 55;
			height = 55;
		}
		if(num == 4 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack5.png");
			width = 57;
			height = 57;
		}
		if(num == 5 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack6.png");
			width = 60;
			height = 60;
		}
		if(num == 6 && random == 1)
		{
			pic = new ImageIcon("data/VaatiAttack7.png");
			width = 70;
			height = 70;
		}
		if(num == 7 && random == 1)
		{
			pic = new ImageIcon("data/Vaati.png");
			pic2 = new ImageIcon("data/VaatiAttack8.png");
			width = 50;
			height = 50;
		}
		if(num == 8 && random == 1)
		{
			pic2 = new ImageIcon("data/VaatiAttack9.png");
			//System.out.println("Attack 9");
		}
		if(num == 9 && random == 1)
		{
			pic2 = null;
			minions = true;
			action = "none";
			t2 = 0; t1 = 0;
		}
		//System.out.println(t2 - t1);
		
	}
	
	public void moveAround(int _x, int _y)
	{
		//System.out.println(action);
		if((action.equalsIgnoreCase("attack") || action.equalsIgnoreCase("open")) && !name.equalsIgnoreCase("Vaati") && !name.equalsIgnoreCase("whiteminion") && !name.equalsIgnoreCase("yellowminion"))
		{
			dx = 0;
			dy = 0;
			attackHero();
			//System.out.println("Still attacking . . . .");
		}
		else if(!name.equalsIgnoreCase("Vaati"))
		{
			if(x > _x)
			{
				dx = -3;
				if( Math.abs(x - _x) > 5)
					direction = "left";
			}
			if(x <= _x)
			{
				dx = 3;
				if(Math.abs(x - _x) > 5)
					direction = "right";
			}
			if(y > _y)
			{
				dy = -3;
				if(Math.abs(y - _y) >= 5)
					direction = "up";
			}
			if(y <= _y)
			{
				dy = 3;
				if(Math.abs(y - _y) >= 5)
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
			if(y == _y)
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
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutUp.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinUp.png");
						if(name.equalsIgnoreCase("IronBallSoldier"))
							pic = new ImageIcon("data/IronBallSoldierUp.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkUp.png");
					}
					if(direction.equalsIgnoreCase("down"))
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutDown.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinDown.png");
						if(name.equalsIgnoreCase("IronBallSoldier"))
							pic = new ImageIcon("data/IronBallSoldierDown.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkDown.png");
					}
					if(direction.equalsIgnoreCase("right"))
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutRight.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinRight.png");
						if(name.equalsIgnoreCase("IronBallSoldier"))
							pic = new ImageIcon("data/IronBallSoldierRight.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkRight.png");
					}
					if(direction.equalsIgnoreCase("left"))
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutLeft.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinLeft.png");
						if(name.equalsIgnoreCase("IronBallSoldier"))
							pic = new ImageIcon("data/IronBallSoldierLeft.png");
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
				if(direction.equalsIgnoreCase("up"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveUp1.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveUp1.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveUp1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveUp2.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveUp2.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveUp2.png");
					}
				}
				if(direction.equalsIgnoreCase("down"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveDown1.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveDown1.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveDown1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveDown2.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveDown2.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveDown2.png");
					}
				}
				if(direction.equalsIgnoreCase("right"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveRight1.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveRight.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveRight1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveRight2.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveRight.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveRight2.png");
					}
				}
				if(direction.equalsIgnoreCase("left"))
				{
					if(movecnt%2 == 0)
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveLeft1.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveLeft.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveLeft1.png");
					}
					else
					{
						if(name.equalsIgnoreCase("Darknut"))
							pic = new ImageIcon("data/DarknutMoveLeft2.png");
						if(name.equalsIgnoreCase("SpearMoblin"))
							pic = new ImageIcon("data/SpearMoblinMoveLeft.png");
						if(name.equalsIgnoreCase("ShadowLink"))
							pic = new ImageIcon("data/ShadowLinkMoveLeft2.png");
					}
				}
				movecnt++;
			}
		}
		if(name.equalsIgnoreCase("Vaati"))
		{
			if(!action.equalsIgnoreCase("change"))
			{
				if(x > _x)
				{
					dx = -3;
					if(Math.abs(x - _x) > 15)
						direction = "left";
				}
				if(x <= _x)
				{
					dx = 3;
					if(Math.abs(x - _x) > 15)
						direction = "right";
				}
				if(y > _y)
				{
					dy = -3;
					if(Math.abs(y - _y) >= 15)
						direction = "up";
				}
				if(y <= _y)
				{
					dy = 3;
					if(Math.abs(y - _y) >= 15)
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
				if(y == _y)
				{
					dy = 0; 
					if(x > _x)
						direction = "left";
					else
						direction = "right";
				}
			}
			// x < _x && y < _y 
			// x > _x && y < _y
			// x > _x && y > _y
			// x < _x && y > _y
			
			if(!action.equalsIgnoreCase("Attack") && !action.equalsIgnoreCase("change"))// && !secact.equalsIgnoreCase("minion"))
			{
				if(t1 == 0)
					t1 = System.currentTimeMillis();
				t2 = System.currentTimeMillis();
				
				int num = ran.nextInt(500);
				//System.out.println("Going to change . . .");
				//System.out.println(t2 - t1);gsf
				
				if(t2 - t1 > 8000)
				{
					action = "change";
					t2 = 0;
					t1 = 0;
					vaatiAttack();
					dx = 0;
					dy = 0;
					
				}
			}
			if(action.equalsIgnoreCase("change"))
			{
				vaatiAttack();
				//System.out.println("Changing . . . .");
			}
			if(action.equalsIgnoreCase("Attack"))
			{
				if(t1 == 0)
					t1 = System.currentTimeMillis();
				t2 = System.currentTimeMillis();
				
				if(t2 - t1 > 15000)
				{
					action = "none";
					pic = new ImageIcon("data/Vaati.png");
					width = 50;
					height = 50;
					t2 = 0; t1 = 0;
					System.out.println("Problem Here 1 . . . .");
				}
			}
			
			//System.out.println(action);
		}
		//System.out.println("Position y:" + y);
	}
	
	public void update(int _x, int _y)
	{
		moveAround(_x, _y);
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics g, Component c)
	{
		if( pic != null )
		{
			g.drawImage(pic.getImage(),x,y,width,height,c);
		}
		if( pic2 != null )
		{
			g.drawImage(pic2.getImage(),x - 10,y - 10,70,70,c);
		}
		
	}

}
