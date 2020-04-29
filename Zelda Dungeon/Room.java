import javax.swing.*;

public class Room {
	
	ImageIcon back;
	boolean cleared, passable, ent1, ent2, stage1, stage2, stage3;
	String name;
	String next;
	int numdead;
	long t1, t2;
	
	Room(int num)
	{
		cleared = false;
		passable = true;
		ent1 = true;
		ent2 = true;
		stage1 = false;
		stage2 = false;
		stage3 = false;
		numdead = 0;
		t1 = 0;
		t2 = 0;
		next = "none";
		if(num == 1)
		{
			back = new ImageIcon("data/EntryRoom.png");
			name = "entry";
		}
		if(num == 2)
		{
			back = new ImageIcon("data/BaseRoom.png");
			name = "base";
		}
		if(num == 3)
		{
			back = new ImageIcon("data/ArenaEntrance1.png");
			name = "Arena Entry 1";
		}
		if(num == 4)
		{
			back = new ImageIcon("data/Arena1.png");
			name = "Arena 1";
		}
		if(num == 5)
		{
			back = new ImageIcon("data/RoomRight1.png");
			name = "Arena Entry 2";
		}
		if(num == 6)
		{
			back = new ImageIcon("data/RoomRight2.png");
			name = "Arena 2";
		}
		if(num == 7)
		{
			back = new ImageIcon("data/TileMoveMap.png");
			name = "MovingTilesRoom";
		}
		if(num == 8)
		{
			back = new ImageIcon("data/StairRoom.png");
			name = "StairRoom";
		}
		if(num == 9)
		{
			back = new ImageIcon("data/ArenaEntrance3.png");
			name = "Arena Entry 3";
		}
		if(num == 10)
		{
			back = new ImageIcon("data/FinalBoss1.png");
			name = "Final Arena";
		}
		
	}
	public void checkCollision(Enemy us)
	{		
		//Base
		//////////////////////////
		if(name.equalsIgnoreCase("base"))
		{
			if(us.y > 485)
			{
				us.y = 485;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
			if(us.y < 50)
			{
				us.y = 50;
				if(us.dy < 0)
				{
					us.dy = 0;
				}
			}
			if(us.y > 40 && us.y < 170)
			{
				if(us.x < 55)
				{
					us.x = 55;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 505)
				{
					us.x = 505;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y > 165 && us.y < 215)
			{
				if(us.x > 475)
				{
					us.x = 475;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				if(us.x < 90)
				{
					us.x = 90;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y > 90 && us.y < 360)
			{
				if(us.x > 475)
				{
					us.x = 475;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				if(us.x < 90)
				{
					us.x = 90;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y < 275)
			{
				if(us.x < 215)
				{
					if(us.x > 200)
					{
						us.x = 200;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				}
				if(us.x > 350)
				{
					if(us.x < 365)
					{
						us.x = 365;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			if(us.x > 215 && us.x < 275 || us.x > 290 && us.x < 350)//us.x < 350)
			{
				if(us.y < 270 && us.y > 230)
				{
					us.y = 270;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			
			
			if(us.y > 365)
			{
				//else
				//{
					if(us.x < 55)
					{
						us.x = 55;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
					if(us.x > 505)
					{
						us.x = 505;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				//}
			}
			/*if(us.y >= 410 && us.y <= 415)
			{
				if(us.x < 55)
				{
					cleared = true;
					next = "left";
				}
				if(us.x > 505)
				{
					cleared = true;
					next = "right";
				}
			}*/
			
		}
		///////////////////////////
		//Arena Entry 1
		if(name.equalsIgnoreCase("Arena Entry 1"))
		{
			//next = "none";
			if(us.y > 480)
			{
				if(us.x > 95 && us.x < 275 || us.x > 325 && us.x < 415)
				{
					if(us.y < 490)
					{
						us.y = 490;
						if(us.dy < 0)
						{
							us.dy = 0;
						}
					}
				}
			}
			if(us.x > 235 && us.x < 335)
			{
				if(us.y < 120 && us.y > 65)
				{
					us.y = 120;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			if(us.y < 120 && us.y > 65 & us.x < 165)
			{
				us.x = 165;
				if(us.dx < 0)
				{
					us.dx = 0;
				}
			}
			if(us.y < 480 && us.x < 335)
			{
				if(us.x > 325)
				{
					us.x = 325;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.x > 220 && us.y < 495)
			{
				if(us.y > 435 && us.x < 275)
				{
					us.y = 435;
					if(us.dy > 0)
					{
						us.dy = 0;
					}
				}
				if(us.y > 120)
				{
					if(us.x < 235)
					{
						us.x = 235;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			if(us.y < 50)
			{
				//else
				//{
					us.y = 50;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				//}
			}
			if(us.x < 95)
			{
				us.x = 95;
				if(us.dx < 0)
				{
					us.dx = 0;
				}
			}
			if(us.y > 495)
			{
				us.y = 495;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
			
			if(us.y > 385 && us.x > 400)
			{
				if(us.y < 400)
				{
					us.y = 400;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
				if(us.y >= 410 && us.y <= 420)
				{
					//else if(us.x < 415)
					//{
						us.x = 415;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					//}
				}
				else if(us.x > 465)
				{
					us.x = 465;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				else
				{
					if(us.x < 415 && us.y < 490)
					{
						us.x = 415;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			
			
		}
		///////////////////////////////
		if(name.equalsIgnoreCase("Arena 1"))
		{
			if(us.y <= 445 && us.y >= 160)
			{
				if(us.x < 55)
				{
					us.x = 55;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 515)
				{
					us.x = 515;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y < 75)
			{
				us.y = 75;
				if(us.dy < 0)
				{
					us.dy = 0;
				}
			}
			if(us.x > 450 && us.x <= 515 || us.x > 55 && us.x < 120)
			{
				if(us.y < 160)
				{
					us.y = 160;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
				if(us.y > 450)
				{
					us.y = 450;
					if(us.dy > 0)
					{
						us.dy = 0;
					}
				}
			}
			//else
			//{
				if(us.y > 525)
				{
					us.y = 525;
					if(us.dy > 0)
					{
						us.dy = 0;
					}
				}
			//}
		}
		if(name.equalsIgnoreCase("StairRoom"))
		{
			if(us.y > 500)
			{
				us.y = 500;
			}
			if(us.x > 475)
			{
				us.x = 475;
			}
			if(us.x < 85)
			{
				us.x = 85;
			}
			if(us.y < 35)
			{
				us.y = 35;
			}
			if((us.x <= 125 && us.x >= 85) || (us.x <= 475 && us.x >= 435))
			{
				if(us.y < 375 && us.y > 330)
				{
					us.y = 375;
				}
				if(us.y > 90 && us.y < 115)
				{
					us.y = 90;
				}
			}
			if((us.y < 450 && us.y >= 375) || (us.y <= 95 && us.y > 55))
			{
				if(us.x > 120 && us.x < 130)
				{
					us.x = 120;
				}
				if(us.x < 440 && us.x > 430)
				{
					us.x = 440;
				}
			}
			if((us.x < 440 && us.x > 305) || (us.x < 255 && us.x > 120))
			{
				if(us.y < 450 && us.y > 420)
				{
					us.y = 450;
				}
				if(us.y > 55 && us.y < 65)
				{
					us.y = 55;
				}
			}
			if((us.y <= 390 && us.y >= 325) || (us.y >= 100 && us.y < 165))
			{
				if(us.x < 215 && us.x > 205)
				{
					us.x = 215;
				}
				if(us.x > 345 && us.x < 355)
				{
					us.x = 345;
				}
			}
			if(((us.x > 125 && us.x < 215) || (us.x > 345 && us.x < 440)) && us.y < 330 && us.y > 150)
			{
				if(us.y > 315)
				{
					us.y = 315;
				}
				if(us.y < 170)
				{
					us.y = 170;
				}
			}
			if((us.y <= 315 && us.y >= 170))
			{
				if(us.x < 145)
				{
					us.x = 145;
				}
				if(us.x > 415)
				{
					us.x = 415;
				}
			}
		}
	}
	//Hero Collision
	public void checkCollision(Hero us)
	{
		if(name.equalsIgnoreCase("entry"))
		{
			if(us.x < 95)
			{
				us.x = 95;
				if(us.dx < 0)
				{
					us.dx = 0;
				}
			}
			if(us.x > 465)
			{
				us.x = 465;
				if(us.dx > 0)
				{
					us.dx = 0;
				}
			}
			if(us.y > 485)
			{
				us.y = 485;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
			if(us.y < 45)
			{
				if(us.x > 270 && us.x < 290)
				{
					cleared = true;
					us.x = 280;
					us.y = 480;
				}
				else
				{
					us.y = 45;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			if(us.y >= 460)
			{
				//System.out.println("Below 465");
				if(us.x > 200 && us.x < 360)
				{
					//System.out.println("Between 209 & 351");
					if(us.x > 200 && us.x < 275 && us.y < 465)
					{
						us.y = 465;
						if(us.dy < 0)
						{
							us.dy = 0;
						}
					}
					if(us.x > 285 && us.x < 355 && us.y < 465)
					{
						us.y = 465;
						if(us.dy < 0)
						{
							us.dy = 0;
						}
					}
					if(us.x < 210)
					{
						//System.out.println("Past left bound");
						us.x = 210;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
					if(us.x > 350)
					{
						//System.out.println("Past right bound");
						us.x = 350;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			if(us.y > 415 && us.y < 460)
			{
				//System.out.println("Between 415 & 455");
				if(us.x > 260 && us.x < 295)
				{
					if(us.x < 270)
					{
						//System.out.println("Past left bound");
						us.x = 275;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
					if(us.x > 285)
					{
						
						//System.out.println("Past right bound");us.x = 285;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			if(us.y < 420)
			{
				if(us.x > 120 && us.x < 270)
				{
					if(us.y > 410)
					{
						us.y = 410;
						if(us.dy > 0)
						{
							us.dy = 0;
						}
					}
				}
				if(us.x > 280 && us.x < 445)
				{
					if(us.y > 410)
					{
						us.y = 410;
						if(us.dy > 0)
						{
							us.dy = 0;
						}
					}
				}
				
			}
			if(us.y > 415)
			{
				if(us.x > 420 && us.x < 465)
				{
					if(us.x < 440)
					{
						us.x = 440;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
				
				if(us.x > 95 && us.x < 135)
				{
					if(us.x > 125)
					{
						us.x = 125;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			
		}
		//Entry
		//////////////////////////
		
		//Base
		//////////////////////////
		if(name.equalsIgnoreCase("base"))
		{
			if(us.y > 485)
			{
				us.y = 485;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
			if(us.y < 50)
			{
				if(us.x >= 275 && us.x <= 290 && us.num == 3)
				{
					next = "up";
					us.x = 285;
					us.y = 475;
				}
				else
				{
					us.y = 50;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			if(us.y > 40 && us.y < 170)
			{
				if(us.x < 55)
				{
					us.x = 55;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 505)
				{
					us.x = 505;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y > 165 && us.y < 215)
			{
				if(us.x > 475)
				{
					us.x = 475;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				if(us.x < 90)
				{
					us.x = 90;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y > 90 && us.y < 360)
			{
				if(us.x > 475)
				{
					us.x = 475;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				if(us.x < 90)
				{
					us.x = 90;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y < 275)
			{
				if(us.x < 215)
				{
					if(us.x > 200)
					{
						us.x = 200;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				}
				if(us.x > 350)
				{
					if(us.x < 365)
					{
						us.x = 365;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			if(us.x > 215 && us.x < 275 || us.x > 290 && us.x < 350)//us.x < 350)
			{
				if(us.y < 270 && us.y > 230)
				{
					us.y = 270;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			
			
			if(us.y > 365)
			{
				if(us.y >= 410 && us.y <= 420)
				{
					if(us.x < 55)
					{
						cleared = true;
						next = "left";
						us.x = 465;
						us.y = 415;
					}
					if(us.x > 505)
					{
						cleared = true;
						next = "right";
						us.x = 85;
						us.y = 265;
					}
				}
				else
				{
					if(us.x < 55)
					{
						us.x = 55;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
					if(us.x > 505)
					{
						us.x = 505;
						if(us.dx > 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			/*if(us.y >= 410 && us.y <= 415)
			{
				if(us.x < 55)
				{
					cleared = true;
					next = "left";
				}
				if(us.x > 505)
				{
					cleared = true;
					next = "right";
				}
			}*/
			
		}
		///////////////////////////
		//Arena Entry 1
		if(name.equalsIgnoreCase("Arena Entry 1"))
		{
			//next = "none";
			if(us.y > 480)
			{
				if(us.x > 95 && us.x < 275 || us.x > 325 && us.x < 415)
				{
					if(us.y < 490)
					{
						us.y = 490;
						if(us.dy < 0)
						{
							us.dy = 0;
						}
					}
				}
			}
			if(us.x > 235 && us.x < 335)
			{
				if(us.y < 120 && us.y > 65)
				{
					us.y = 120;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			if(us.y < 120 && us.y > 65 & us.x < 165)
			{
				us.x = 165;
				if(us.dx < 0)
				{
					us.dx = 0;
				}
			}
			if(us.y < 480 && us.x < 335)
			{
				if(us.x > 325)
				{
					us.x = 325;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.x > 220 && us.y < 495)
			{
				if(us.y > 435 && us.x < 275)
				{
					us.y = 435;
					if(us.dy > 0)
					{
						us.dy = 0;
					}
				}
				if(us.y > 120)
				{
					if(us.x < 235)
					{
						us.x = 235;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			if(us.y < 50)
			{
				if(us.x > 265 && us.x < 295 && ent1)
				{
					next = "up";
					us.x = 275;
					us.y = 545;
					us.num = 1;
				}
				else
				{
					us.y = 50;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			if(us.x < 95)
			{
				us.x = 95;
				if(us.dx < 0)
				{
					us.dx = 0;
				}
			}
			if(us.y > 495)
			{
				us.y = 495;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
			
			if(us.y > 385 && us.x > 400)
			{
				if(us.y < 400)
				{
					us.y = 400;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
				if(us.y >= 410 && us.y <= 420)
				{
					if(us.x > 470)
					{
						next = "right";
						us.x = 55;
						us.y = 410;
					}
					else if(us.x < 415)
					{
						us.x = 415;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
				else if(us.x > 465)
				{
					us.x = 465;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				else
				{
					if(us.x < 415 && us.y < 490)
					{
						us.x = 415;
						if(us.dx < 0)
						{
							us.dx = 0;
						}
					}
				}
			}
			
			
		}
		///////////////////////////////
		if(name.equalsIgnoreCase("Arena 1"))
		{
			if(us.y <= 445 && us.y >= 160)
			{
				if(us.x < 55)
				{
					us.x = 55;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 515)
				{
					us.x = 515;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y < 75)
			{
				us.y = 75;
				if(us.dy < 0)
				{
					us.dy = 0;
				}
			}
			if(us.x > 450 && us.x <= 515 || us.x > 55 && us.x < 120)
			{
				if(us.y < 160)
				{
					us.y = 160;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
				if(us.y > 450)
				{
					us.y = 450;
					if(us.dy > 0)
					{
						us.dy = 0;
					}
				}
			}
			if(cleared)
			{
				passable = false;
				if(us.y > 525)
				{
					next = "down";
					us.x = 285;
					us.y = 50;
				}
			}
			else
			{
				if(us.y > 525)
				{
					us.y = 525;
					if(us.dy > 0)
					{
						us.dy = 0;
					}
				}
			}
		}
	
		if(name.equalsIgnoreCase("Arena Entry 2"))
		{
			if(us.y < 80)
			{
				if(us.x >= 270 && us.x <= 295 && ent2)
				{
					next = "up";
					us.y = 450;
					us.x = 285;
					us.num = 0;
				}
				else
				{
					us.y = 80;
					if(us.dy < 0)
					{
						us.dy = 0;
					}
				}
			}
			if(us.y > 445)
			{
				us.y = 445;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
			if(us.x > 485)
			{
				us.x = 485;
				if(us.dx > 0)
				{
					us.dx = 0;
				}
			}
			if(us.x < 80)
			{
				if(us.y <= 280 && us.y >= 255)
				{
					next = "left";
					us.x = 500;
					us.y = 410;
				}
				else
				{
					us.x = 80;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
					
				}
			}
		}
		if(name.equalsIgnoreCase("Arena 2"))
		{
			
			if(us.x > 485)
			{
				us.x = 485;
				if(us.dx > 0)
				{
					us.dx = 0;
				}
			}
			if(us.x < 85)
			{
				us.x = 85;
				if(us.dx < 0)
				{
					us.dx = 0;
				}
			}
			if(us.y < 80)
			{
				us.y = 80;
				if(us.dy < 0)
				{
					us.dy = 0;
				}
			}
			if(us.y > 410)
			{
				if(us.x < 175)
				{
					us.x = 175;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 390)
				{
					us.x = 390;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y > 365 && us.y < 410)
			{
				if(us.x < 135)
				{
					us.x = 135;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 430)
				{
					us.x = 430;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
			}
			if(us.y < 135)
			{
				if(us.x < 255)
				{
					us.x = 255;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 310)
				{
					us.x = 310;
					if(us.dx > 0)
					{
						us.dx = 0;
					}	
				}
			}
			if(us.y > 135 && us.y < 180)
			{
				if(us.x < 135)
				{
					us.x = 135;
					if(us.dx < 0)
					{
						us.dx = 0;
					}
				}
				if(us.x > 430)
				{
					us.x = 430;
					if(us.dx > 0)
					{
						us.dx = 0;
					}
				}
				
			}
			if(cleared)
			{
				passable = false;
				if(us.y > 465)
				{
					next = "down";
					us.x = 285;
					us.y = 50;
				}
			}
			if(us.y > 465)
			{
				us.y = 465;
				if(us.dy > 0)
				{
					us.dy = 0;
				}
			}
		}
		if(name.equalsIgnoreCase("MovingTilesRoom"))
		{
			if(us.y > 420)
			{
				if(us.x <= 280)
				{
					us.x = 280;
					if(us.dx < 0)
						us.dx = 0;
				}
				if(us.x > 300 && us.x < 445 && us.y > 445)
				{
					us.y = 445;
				}
				if(us.x >= 280 && us.x < 420 && us.y < 435)
				{
					us.y = 435;
				}
			}
			if(us.y >= 450 && us.x > 295)
			{
				us.x = 295;
			}
			if(us.y >= 365 && us.x > 440 && us.passable == false)
			{
				us.x = 440;
				//System.out.println("Error Here");
			}
			if(us.y < 425 && us.y >= 365 && us.x > 415)
			{
				if(us.x < 425 && us.passable == false)
					us.x = 425;
			}
			////////////////////////////////////////////////////////////////////////// Need to figure out how not to walk on black background
			if(us.x <= 445 && us.x >= 425)
			{
				if(us.y <= 405 && us.y > 355)
				{
					if(us.y < 365)// && !us.passable)
					{
						us.y = 365;
						System.out.println("Cannot Pass");
					}
				}
			}
			//////////////////////////////////////////////////////////////////////////
			
			if(us.y > 500)
			{
				us.y = 500;
			}
			if(cleared)
			{
				if(us.y > 80)
				{
					us.y = 80;
				}
				if(us.x < 418)
				{
					us.x = 418;
				}
				if(us.x > 438)
				{
					us.x = 438;
				}
			}
			if(us.y < 50)
			{
				if(us.x >= 424 && us.x <= 438)
				{
					next = "up";
					us.direction = "right";
					us.pic = new ImageIcon("data/LinkStandingRight.png");
					System.out.println("Next Room");
					us.x = 85;
					us.y = 420;
					//us.x = 160;
					//us.y = 475;
					
				}
				else
				{
					us.y = 50;
				}
			}
			
		}
		if(name.equalsIgnoreCase("StairRoom"))
		{
			if(us.y > 500)
			{
				us.y = 500;
			}
			if(us.x > 475)
			{
				us.x = 475;
			}
			if(us.x < 85)
			{
				us.x = 85;
			}
			if(us.y < 35)
			{
				if(us.x >= 265 && us.x <= 290)
				{
					next = "up";
					us.x = 130;
					us.y = 475;
				}
				else
				{
					us.y = 35;
				}
			}
			if((us.x <= 125 && us.x >= 85) || (us.x <= 475 && us.x >= 435))
			{
				if(us.y < 375 && us.y > 330)
				{
					us.y = 375;
				}
				if(us.y > 90 && us.y < 115)
				{
					us.y = 90;
				}
			}
			if((us.y < 450 && us.y >= 375) || (us.y <= 95 && us.y > 55))
			{
				if(us.x > 120 && us.x < 130)
				{
					us.x = 120;
				}
				if(us.x < 440 && us.x > 430)
				{
					us.x = 440;
				}
			}
			if((us.x < 440 && us.x > 305) || (us.x < 255 && us.x > 120))
			{
				if(us.y < 450 && us.y > 420)
				{
					us.y = 450;
				}
				if(us.y > 55 && us.y < 65)
				{
					us.y = 55;
				}
			}
			if((us.y <= 390 && us.y >= 325) || (us.y >= 100 && us.y < 165))
			{
				if(us.x < 215 && us.x > 205)
				{
					us.x = 215;
				}
				if(us.x > 345 && us.x < 355)
				{
					us.x = 345;
				}
			}
			if(((us.x > 125 && us.x < 215) || (us.x > 345 && us.x < 440)) && us.y < 330 && us.y > 150)
			{
				if(us.y > 315)
				{
					us.y = 315;
				}
				if(us.y < 170)
				{
					us.y = 170;
				}
			}
			if((us.y <= 315 && us.y >= 170))
			{
				if(us.x < 145)
				{
					us.x = 145;
				}
				if(us.x > 415)
				{
					us.x = 415;
				}
			}

			/*if((us.x >= 215 && us.x < 255) || (us.x > 305 && us.x <= 345 ))
			{
				if(us.y < 110 && us.y > 90)
				{
					us.y = 110;
				}
				if(us.y > 390 && us.x < 410)
				{
					us.y = 390;
				}
			}*/
			
		}
		if(name.equalsIgnoreCase("Arena Entry 3"))
		{
			if(us.y > 475)
			{
				us.y = 475;
			}
			if(us.x < 45)
			{
				us.x = 45;
			}
			if(us.y < 90)
			{
				us.y = 90;
			}
			
			if((us.y <= 480 && us.y > 330) || (us.y >= 85 && us.y < 230))
			{
				if(us.x > 235 && us.x < 245)
				{
					us.x = 235;
				}
				if(us.x < 340 && us.x > 330)
				{
					us.x = 340;
				}
			}
			if(us.x >= 245 && us.x <= 330)
			{
				if(us.y < 240)
				{
					us.y = 240;
				}
				if(us.y > 330)
				{
					us.y = 330;
				}
			}
			if(us.y > 160 && us.y < 400)
			{
				if(us.x > 195 && us.x < 375)
				{
					if(us.x < 210)
					{
						us.x = 210;
					}
					if(us.x > 365)
					{
						us.x = 365;
					}
				}
				if(us.x < 90 && us.x > 70)
				{
					us.x = 70;
				}
				if(us.x < 510 && us.x > 500)
				{
					us.x = 510;
				}
			}
			if((us.x <= 195 && us.x >= 90) || (us.x >= 375 && us.x <= 500))
			{
				if(us.y < 400 && us.y > 390)
				{
					us.y = 400;	
				}
				if(us.y > 160 && us.y < 170)
				{
					us.y = 160;
				}
				//System.out.println("Here");
			}
			if(us.x > 525)
			{
				if(us.y >= 275 && us.y <= 295)
				{
					next = "left";
					us.direction = "up";
					us.pic = new ImageIcon("data/LinkStandingUp.png");
					//System.out.println("Next Room");
					us.x = 280;
					us.y = 525;
				}
				else
				{
					us.x = 525;
				}
			}
			
			
		}
		
		if(name.equalsIgnoreCase("Final Arena"))
		{
			if(!stage1)
			{
				if((us.x > 30 && us.x < 220) || (us.x > 345 && us.x < 535))
				{
					//System.out.println("Within Bounds . . . .");
					if(us.y < 495)
					{
						us.y = 495;
					}
				}
				if(us.y > 535)
				{
					us.y = 535;
				}
				if(us.y > 490 && us.y < 540)
				{
					if(us.x < 40)
					{
						us.x = 40;
					}
					if(us.x > 525)
					{
						us.x = 525;
					}
				}
				if(us.y < 395)
				{
					back = new ImageIcon("data/FinalBoss2.png");
					stage1 =  true;
				}
			}
			if(stage1 && !stage2)
			{
				if(t1 == 0)
					t1 = System.currentTimeMillis();
				t2 = System.currentTimeMillis();
				if(us.y > 390)
				{
					us.y = 390;
				}
				if(t2 - t1 > 3000)
				{
					stage2 = true;
					back = new ImageIcon("data/FinalBoss3.png");
					t1 = 0; t2 = 0;
				}
			}
			if(stage1 && stage2)
			{
				if(us.x < 40)
				{
					us.x = 40;
				}
				if(us.x > 525)
				{
					us.x = 525;
				}
				if(us.y < 50)
				{
					us.y = 50;
				}
				if(us.y > 490)
				{
					us.y = 490;
				}
			}
		}
		
		
	}
	

}
