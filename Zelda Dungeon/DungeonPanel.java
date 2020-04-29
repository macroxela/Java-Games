import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.applet.*;


public class DungeonPanel extends JPanel implements KeyListener
{
	Hero user;
	Enemy en;
	ImageIcon background, tri, GM, start_sq, end_sq;
	LinkedList<Projectile> item = new LinkedList<Projectile>();
	LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	LinkedList<MovableObjects> tiles = new LinkedList<MovableObjects>();
	ShadowLink link;
	Random ran;
	Dungeon dungeon;
	int cnt = 0;
	int vx = 0;
	int vy = 0;
	boolean start, won, end;
	
	long t1, t2, t3, t4;
	
	DungeonPanel()
	{
		//background = new ImageIcon("data/deathmountaind1.png");
		dungeon = new Dungeon();
		background = dungeon.current.back;//new ImageIcon("data/BaseRoom.png");
		tri = new ImageIcon("data/TriforceAnimated.gif");
		GM = new ImageIcon("data/GameOver.gif");
		start_sq = new ImageIcon("data/ZeldaLogo.gif");
		end_sq = new ImageIcon("data/Explosion2.png");
		user = new Hero();
		ran = new Random();
		//Projectile s = new Projectile(100,100,"none","IronBall");
		t1 = 0;
		t2 = 0;
		t3 = 0;
		t4 = 0;
		start = true;
		won = false;
		end = true;
				
		UpdateThread ut = new UpdateThread(this);
		ut.start();

		addKeyListener(this);
		setFocusable(true);
	}
	public void startanimation(Graphics g)
	{
		if(start && t1 == 0)
			t1 = System.currentTimeMillis();
		if(start)
			t2 = System.currentTimeMillis();
		
		if(t2 - t1 < 1500 && start)
			g.drawImage(start_sq.getImage(),0,0,getWidth(),getHeight(),this);
		else
		{
			start = false;
			t1 = 0; t2 = 0;
		}
	}
	public void endanimation(Graphics g)
	{
		if(t3 == 0)
		{
			t3 = System.currentTimeMillis();
			System.out.println("It ended");
		}
		
		
		System.out.println(t4 - t3);
		
		t4 = System.currentTimeMillis();
		
		//System.out.println(" End  Vx: " + vx + " Vy: " + vy);
		if(t4 - t3 > 1000)
		{
			end_sq = new ImageIcon("data/Explosion2.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 1500)
		{
			end_sq = new ImageIcon("data/Explosion3.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 2000)
		{
			end_sq = new ImageIcon("data/Explosion2.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 2500)
		{
			end_sq = new ImageIcon("data/Explosion3.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 3000)
		{
			end_sq = new ImageIcon("data/Explosion2.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 3500)
		{
			end_sq = new ImageIcon("data/Explosion3.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 4000)
		{
			end_sq = new ImageIcon("data/Explosion2.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 4500)
		{
			end_sq = new ImageIcon("data/Explosion3.png");
			//g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
		}
		if(t4 - t3 > 5000)
		{
			end_sq = new ImageIcon("data/transparent.png");
			end = false;
		}
		
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),this);
		for(MovableObjects o : tiles)
		{
			o.draw(g, this);
		}
		
		//g.drawImage(tri.getImage(),252,209,50,50,this);
		user.draw(g, this);
		for(Enemy o : enemies)
		{
			o.draw(g, this);
		}
		for(Projectile o : item)
		{
			o.draw(g, this);
		}
		if(won)
		{
			endanimation(g);
			g.drawImage(end_sq.getImage(),vx,vy,70,70,this);
			g.setColor(Color.white);
			g.setFont( new Font( "stupid font", Font.BOLD, 50 ) );
			g.drawString("THE END", 200, 300);
			g.drawImage(tri.getImage(),250,150,100,100,this);
		}
		if(user.over)
			g.drawImage(GM.getImage(), 0, 0, getWidth(), getHeight(), this);
		
		startanimation(g);
		
	}
		
	public void update()
	{
		if(!won)
		{
		if(dungeon.current.name.equalsIgnoreCase("StairRoom") && user.num == 4)
		{
			System.out.println(user.num);
			en = new Enemy(3);
			user.num = 5;
			enemies.add(en);
			System.out.println("Shadow Link");
			System.out.println(user.num);
		}
		if(dungeon.current.name.equalsIgnoreCase("MovingTilesRoom") && user.num == 3)
		{
			MovableObjects tile = new MovableObjects("tile");
			tile.x = 425;
			tile.y = 356;
			tile.setDirection("Horizontal");
			tile.number = "first";
			tiles.add(tile);
			tile = new MovableObjects("tile");
			tile.x = 85;
			tile.y = 100;
			tile.setDirection("Vertical");
			tiles.add(tile);
			tile = new MovableObjects("tile");
			tile.x = 385;
			tile.y = 250;
			tile.setDirection("Horizontal");
			tile.dx = 6;
			tiles.add(tile);
			tile = new MovableObjects("tile");
			tile.x = 430;
			tile.y = 100;
			tile.setDirection("Vertical");
			tiles.add(tile);
			user.num = 4;
		}
		if(dungeon.rooms[6].cleared)
		{
			LinkedList<MovableObjects> del = new LinkedList<MovableObjects>();
			for(MovableObjects o : tiles)
			{
				del.add(o);
			}
			for(MovableObjects o : del)
			{
				tiles.remove(o);
			}
		}
		
		if(dungeon.current.name.equalsIgnoreCase("Final Arena") &&  dungeon.current.stage1 && dungeon.current.stage2 && !dungeon.current.stage3)
		{
			en = new Enemy(4);
			en.x = 100;
			en.y = 200;
			enemies.add(en);
			dungeon.current.stage3 = true;
		}
		if(dungeon.current.name.equalsIgnoreCase("MovingTilesRoom"))
		{
			for(MovableObjects o : tiles)
			{
				if(o.contains(user) && user.y >= 80)
				{
					user.passable = true;
					user.dx = o.dx;
					user.dy = o.dy;
					o.moveAround();
					user.dx = o.dx;
					user.dy = o.dy;
					if(user.y == 80)
					{
						user.dy = 0;
						dungeon.current.cleared = true;
					}
				}
				else
					o.moveAround();
			}
		}
		if(dungeon.current.name.equalsIgnoreCase("Arena 1") && (user.num == 1 || user.num == 0))
		{
			en = new Enemy(1);
			en.x = 200;
			en.y = 200;
			enemies.add(en);
			en = new Enemy(1);
			en.x = 300;
			en.y = 200;
			enemies.add(en);
			user.num = 2;
		}
		if(dungeon.current.name.equalsIgnoreCase("Arena 2") && (user.num == 0 || user.num == 1))
		{
			en = new Enemy(0);
			en.x = 200;
			en.y = 200;
			enemies.add(en);
			en = new Enemy(0);
			en.x = 300;
			en.y = 200;
			enemies.add(en);
			en = new Enemy(0);
			en.x = 400;
			en.y = 200;
			enemies.add(en);
			user.num = 2;
		}
		if(dungeon.roomscleared >= 10)
		{
			won = true;
			t1 = 0;
			t2 = 0;
		}
		if(dungeon.current.name.equalsIgnoreCase("base") && dungeon.roomscleared == 2 && (user.num == 2 || user.num == 1))
		{
			en = new Enemy(2);
			en.x = 200;
			en.y = 200;
			enemies.add(en);
			Projectile IronBall = new Projectile(en.x,en.y,"none","IronBall");
			IronBall.usID = en.ID;
			item.add(IronBall);
			user.num = 3;
		}
		
		user.setEnemies(enemies);
		boolean collided = false;
		for(Enemy o : enemies)
		{
			for(Enemy u : enemies)
			{
				if(o.ID != u.ID)
				{
					if(o.intersects(u))
					{
						if(u.x - o.x < o.width && u.x - o.x > 0)
						{
							o.x = u.x - o.width - 10;
						}
						if(u.y - o.y < o.height && u.y - o.y > 0)
						{
							o.y = u.y - o.height - 10;
						}
						if(o.y - u.y < u.height && o.y - u.y > 0)
						{
							o.y += 10; 
						}
						if(o.x - u.x < u.width && o.x - u.x > 0)
						{
							o.x += 10;
						}
					}
				}
				for(Projectile r : item)
				{
					if(o.name.equalsIgnoreCase("IronBallSoldier") && r.attribute.equalsIgnoreCase("IronBall") && o.ID == r.usID)
					{
						r.setUserPos(o.x, o.y);
					}
					if(o.intersects(r) && !r.attribute.equalsIgnoreCase("bomb") && !r.attribute.equalsIgnoreCase("IronBall"))
					{
						o.hp--;
						if(r.direction.equalsIgnoreCase("right") || r.direction.equalsIgnoreCase("left"))
						{
							o.y -= 10;
						}
						if(r.direction.equalsIgnoreCase("up") || r.direction.equalsIgnoreCase("down"))
						{
							o.x -= 10;
						}
					}
				}
				
			}
			if(o.intersects(user))
			{
				if(o.action.equalsIgnoreCase("attack") && !user.action.equalsIgnoreCase("sword") && !user.action.equalsIgnoreCase("sword slash") && !user.action.equalsIgnoreCase("sword dash"))
				{
					user.hp--;
					if(user.hp <= 0)
					{
						user.alive = false;
					}
				}
				if(user.action.equalsIgnoreCase("sword") || user.action.equalsIgnoreCase("sword slash") || user.action.equalsIgnoreCase("sword dash"))
				{
					if(!o.action.equalsIgnoreCase("attack"))
						o.hp--;
					//System.out.println("Enemy Hp: " + o.hp);
					if(user.x - o.x < o.width && user.x - o.x > 0)
					{
						o.x = user.x - o.width - 10;
					}
					if(user.y - o.y < o.height && user.y - o.y > 0)
					{
						o.y = user.y - o.height - 10;
					}
					if(o.y - user.y < user.height && o.y - user.y > 0)
					{
						o.y += 10; 
					}
					if(o.x - user.x < user.width && o.x - user.x > 0)
					{
						o.x += 10;
					}
				}
				else
				{
					if(user.x - o.x < o.width && user.x - o.x > 0)
					{
						user.x = o.x + o.width + 10;
					}	
					if(user.y - o.y < o.height && user.y - o.y > 0)
					{
						user.y = o.y + o.height + 10;
					}
					if(o.y - user.y < user.height && o.y - user.y > 0)
					{
						user.y -= 10; 
					}
					if(o.x - user.x < user.width && o.x - user.x > 0)
					{
						user.x -= 10;
					}
					collided = true;
				}
			}
			if(o.hp <= 0)
			{	
				o.dead = true;
			}
		}
		if(!collided)
		{
			dungeon.current.checkCollision(user);
			dungeon.roomCheck();
			background = dungeon.current.back;
			user.update();
		}
		if(user.alive)
		{
			Enemy v;
			for(Enemy o : enemies)
			{
				if(o.name.equalsIgnoreCase("Vaati"))
				{
					vx = o.x;
					vy = o.y;		
					//System.out.println("Vx: " + vx + " Vy: " + vy);
				}
					
			}
			LinkedList<Enemy> dummy = new LinkedList<Enemy>();
			for(Enemy o : enemies)
			{
				if(!o.dead)
				{
					o.update(user.x, user.y);
					dungeon.current.checkCollision(o);
					
					if(o.name.equalsIgnoreCase("Vaati") && o.minions)
					{
						int randnum = ran.nextInt(2) + 5;
						int num = ran.nextInt(10);
						en = new Enemy(randnum);
						en.x = vx + num + 50;
						en.y = vy + num + 50;
						dummy.add(en);
						o.minioncnt++;
						if(o.minioncnt > 4)
						{
							o.minions = false;
							o.minioncnt = 0;
						}
					}
				}
				else
				{
					o.x = -50;
					o.y = -50;
					o.dx = 0;
					o.dy = 0;
				}
			}
			for(Enemy o : dummy)
			{
				enemies.add(o);
			}
			
		}
		
		if(t1 == 0)
			t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();
		
		for(Projectile o : item)
		{
			o.update();
			if(user.intersects(o) && (o.attribute.equalsIgnoreCase("explosion") || o.attribute.equalsIgnoreCase("IronBall")))
			{
				user.hp--;
				if(o.attribute.equalsIgnoreCase("IronBall"))
				{
					if(user.y < o.y)
						user.y += 150;
					else
						user.y -= 150;
				}
				if(user.hp < 0)
				{
					user.alive = false;
				}
			}
		}
		
		if(t2 - t1 > 500 && user.action.equalsIgnoreCase("sword slash"))
		{
			int num = 0;
			if(t2 - t1 > 750)
				num = 1;
			if(t2 - t1 > 900)
				num = 2;
			if(t2 - t1 > 1050)
				num = 3;
			if(user.direction.equalsIgnoreCase("up"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkSwordSlashUp2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkSwordSlashUp3.png");
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkSwordSlashUp4.png");
			}
			if(user.direction.equalsIgnoreCase("down"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkSwordSlashDown2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkSwordSlashDown3.png");
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkSwordSlashDown4.png");
			}
			if(user.direction.equalsIgnoreCase("left"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkSwordSlashLeft2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkSwordSlashLeft3.png");
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkSwordSlashLeft4.png");
			}
			if(user.direction.equalsIgnoreCase("right"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkSwordSlashRight2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkSwordSlashRight3.png");
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkSwordSlashRight4.png");
			}
			/**/
			if(num >= 3)
			{
				user.action = "none";
				if(user.direction.equalsIgnoreCase("up"))
				{
					user.pic = new ImageIcon("data/LinkStandingUp.png");
				}
				if(user.direction.equalsIgnoreCase("down"))
				{
					user.pic = new ImageIcon("data/LinkStandingDown.png");
				}
				if(user.direction.equalsIgnoreCase("left"))
				{
					user.pic = new ImageIcon("data/LinkStandingLeft.png");
				}
				if(user.direction.equalsIgnoreCase("right"))
				{
					user.pic = new ImageIcon("data/LinkStandingRight.png");
				}
				user.height = 20;
				user.width = 20;
				
				t1 = 0; t2 = 0;
			}
		}
		//////////////////////////////////////////////////////////
		if(t2 - t1 > 500 && user.action.equalsIgnoreCase("sword dash"))
		{
			int num = 0;
			if(t2 - t1 > 750)
				num = 1;
			if(t2 - t1 > 900)
				num = 2;
			if(t2 - t1 > 1050)
				num = 3;
			if(t2 - t1 > 1200)
				num = 4;
			if(user.direction.equalsIgnoreCase("up"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkDashSlashUp2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkDashSlashUp3.png");
					user.dy = -5;
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkDashSlashUp4.png");
				if(num == 3)
					user.pic = new ImageIcon("data/LinkDashSlashUp5.png");
			}
			if(user.direction.equalsIgnoreCase("down"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkDashSlashDown2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkDashSlashDown3.png");
					user.dy = 5;
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkDashSlashDown4.png");
				if(num == 3)
					user.pic = new ImageIcon("data/LinkDashSlashDown5.png");
			}
			if(user.direction.equalsIgnoreCase("left"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkDashSlashLeft2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkDashSlashLeft3.png");
					user.dx = -5;
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkDashSlashLeft4.png");
				if(num == 3)
					user.pic = new ImageIcon("data/LinkDashSlashLeft5.png");
			}
			if(user.direction.equalsIgnoreCase("right"))
			{
				if(num == 0)
					user.pic = new ImageIcon("data/LinkDashSlashRight2.png");
				if(num == 1)
				{
					user.pic = new ImageIcon("data/LinkDashSlashRight3.png");
					user.dx = 5;
				}
				if(num == 2)
					user.pic = new ImageIcon("data/LinkDashSlashRight4.png");
				if(num == 3)
					user.pic = new ImageIcon("data/LinkDashSlashRight5.png");
			}
			
			if(num >= 4)
			{
				user.action = "none";
				if(user.direction.equalsIgnoreCase("up"))
				{
					user.pic = new ImageIcon("data/LinkStandingUp.png");
				}
				if(user.direction.equalsIgnoreCase("down"))
				{
					user.pic = new ImageIcon("data/LinkStandingDown.png");
				}
				if(user.direction.equalsIgnoreCase("left"))
				{
					user.pic = new ImageIcon("data/LinkStandingLeft.png");
				}
				if(user.direction.equalsIgnoreCase("right"))
				{
					user.pic = new ImageIcon("data/LinkStandingRight.png");
				}
				user.height = 20;
				user.width = 20;
				user.dx = 0;
				user.dy = 0;
				
				t1 = 0; t2 = 0;
			}
			
		}
		
		if((t2 - t1 > 500 && user.action.equalsIgnoreCase("sword")) || (t2 - t1 > 800 && user.action.equalsIgnoreCase("thrown")))
		{
			user.height = 20;
			user.width = 20;
			user.action = "none";
			
			if(user.direction.equalsIgnoreCase("up"))
			{
				user.pic = new ImageIcon("data/LinkStandingUp.png");
			}
			if(user.direction.equalsIgnoreCase("down"))
			{
				user.pic = new ImageIcon("data/LinkStandingDown.png");
			}
			if(user.direction.equalsIgnoreCase("left"))
			{
				user.pic = new ImageIcon("data/LinkStandingLeft.png");
			}
			if(user.direction.equalsIgnoreCase("right"))
			{
				user.pic = new ImageIcon("data/LinkStandingRight.png");
			}
			
			t1 = 0; t2 = 0;
		}
		//System.out.println(dungeon.roomscleared);
		if(dungeon.current.numdead == 2 && dungeon.current.name.equalsIgnoreCase("Arena 1"))
		{
			dungeon.current.numdead = 0;
			dungeon.current.cleared = true;
			dungeon.roomscleared++;
		}
		if(dungeon.current.numdead == 3 && dungeon.current.name.equalsIgnoreCase("Arena 2"))
		{
			dungeon.current.numdead = 0;
			dungeon.current.cleared = true;
			dungeon.roomscleared++;
		}
		LinkedList<Enemy> en = new LinkedList<Enemy>();
		LinkedList<Projectile> p = new LinkedList<Projectile>();
		for(Enemy o : enemies)
		{
			if(o.dead)
			{
				if(o.name.equalsIgnoreCase("Vaati"))
					dungeon.roomscleared = 10;
				en.add(o);
			}
		}
		for(Projectile o : item)
		{
			for(Enemy u : en)
			{
				if(u.ID == o.usID)
					p.add(o);
			}
			if(!o.active)
			{
				System.out.println("Not Active");
				p.add(o);
			}
		}
		for(Enemy o : en)
		{
			/*if(o.name.equalsIgnoreCase("Vaati"))
			{
				vx = o.x;
				vy = o.y;
				System.out.println("Vx: " + vx + " Vy: " + vy);
			}*/
			enemies.remove(o);
			System.out.println("Removed");
			dungeon.current.numdead++;
			System.out.println("Dead: " + dungeon.current.numdead);
			if(enemies.isEmpty())
				System.out.println("Empty");
		}
		for(Projectile o : p)
		{
			item.remove(o);
			System.out.println("Item removed");
		}
		
		repaint();
		}
	}
	
	public void keyPressed(KeyEvent k) 
	{
		int c = k.getKeyCode();
		
		if(user.alive)
		{
		if(c == KeyEvent.VK_B)
		{
			user.action = "arrow";
			if(user.direction.equalsIgnoreCase("up"))
			{
				user.pic = new ImageIcon("data/LinkArrowUp.png");
			}
			else if(user.direction.equalsIgnoreCase("left"))
			{
				user.pic = new ImageIcon("data/LinkArrowLeft.png");
			}
			else if(user.direction.equalsIgnoreCase("right"))
			{
				user.pic = new ImageIcon("data/LinkArrowRight.png");
			}
			else if(user.direction.equalsIgnoreCase("down"))
			{
				user.pic = new ImageIcon("data/LinkArrowDown.png");
			}
		}
		if(c == KeyEvent.VK_CONTROL)
		{
			user.action = "sword dash";
			if(user.direction.equalsIgnoreCase("up"))
			{
				user.pic = new ImageIcon("data/LinkDashSlashUp1.png");
				user.height = 30;
			}
			if(user.direction.equalsIgnoreCase("down"))
			{
				user.pic = new ImageIcon("data/LinkDashSlashDown1.png");
				user.height = 30;
			}
			if(user.direction.equalsIgnoreCase("left"))
			{
				user.pic = new ImageIcon("data/LinkDashSlashLeft1.png");
				user.width = 30;
			}
			if(user.direction.equalsIgnoreCase("right"))
			{
				user.pic = new ImageIcon("data/LinkDashSlashRight1.png");
				user.width = 30;
			}
		}
		if(c == KeyEvent.VK_C)
		{
			user.action = "bomb";
			if(user.direction.equalsIgnoreCase("up"))
			{
				user.pic = new ImageIcon("data/LinkBombUp.png");
				user.height = 30;
			}
			if(user.direction.equalsIgnoreCase("down"))
			{
				user.pic = new ImageIcon("data/LinkBombDown.png");
				user.height = 30;
			}
			if(user.direction.equalsIgnoreCase("left"))
			{
				user.pic = new ImageIcon("data/LinkBombLeft.png");
				user.height = 30;
			}
			if(user.direction.equalsIgnoreCase("right"))
			{
				user.pic = new ImageIcon("data/LinkBombRight.png");
				user.height = 30;
			}
		}
		if(c == KeyEvent.VK_SPACE)
		{
			int rand = ran.nextInt(2);
			if(rand == 0)
			{
				user.action = "sword slash";
				if(user.direction.equalsIgnoreCase("up"))
				{
					user.pic = new ImageIcon("data/LinkSwordSlashUp1.png");
					user.height = 30;
				}
				if(user.direction.equalsIgnoreCase("down"))
				{
					user.pic = new ImageIcon("data/LinkSwordSlashDown1.png");
					user.height = 30;
				}
				if(user.direction.equalsIgnoreCase("left"))
				{
					user.pic = new ImageIcon("data/LinkSwordSlashLeft1.png");
					user.width = 30;
				}
				if(user.direction.equalsIgnoreCase("right"))
				{
					user.pic = new ImageIcon("data/LinkSwordSlashRight1.png");
					user.width = 30;
				}
				
			}
			else
			{
				user.action = "sword";
				if(user.direction.equalsIgnoreCase("up"))
				{
					user.pic = new ImageIcon("data/LinkSwordFowardUp2.png");
					user.height = 30;
				}
				if(user.direction.equalsIgnoreCase("down"))
				{
					user.pic = new ImageIcon("data/LinkSwordFowardDown2.png");
					user.height = 30;
				}
				if(user.direction.equalsIgnoreCase("left"))
				{
					user.pic = new ImageIcon("data/LinkSwordFowardLeft2.png");
					user.width = 30;
				}
				if(user.direction.equalsIgnoreCase("right"))
				{
					user.pic = new ImageIcon("data/LinkSwordFowardRight2.png");
					user.width = 30;
				}
			}
		}
		if(c == KeyEvent.VK_LEFT)
		{
			user.dx = -5;
			if(!user.action.equalsIgnoreCase("arrow") && !user.action.equalsIgnoreCase("bomb"))
			{
				user.action = "none";
				if(user.x %2 == 0)
					user.pic = new ImageIcon("data/LinkLeft1.png");
				else
					user.pic = new ImageIcon("data/LinkLeft2.png");
				user.direction = "left";
				user.height = 20;
				user.width = 20;
			}
			else if(user.action.equalsIgnoreCase("bomb"))
			{
				if(user.x %2 == 0)
					user.pic = new ImageIcon("data/LinkBombMoveLeft1.png");
				else
					user.pic = new ImageIcon("data/LinkBombMoveLeft2.png");
				user.direction = "left";
				user.height = 30;
			}
		}
		if(c == KeyEvent.VK_RIGHT)
		{
			user.dx = 5;
			if(!user.action.equalsIgnoreCase("arrow") && !user.action.equalsIgnoreCase("bomb"))
			{
				user.action = "none";
				if(user.x %2 == 0)
					user.pic = new ImageIcon("data/LinkRight1.png");
				else
					user.pic = new ImageIcon("data/LinkRight2.png");
				user.direction = "right";
				user.height = 20;
				user.width = 20;
			}
			else if(user.action.equalsIgnoreCase("bomb"))
			{
				if(user.x %2 == 0)
					user.pic = new ImageIcon("data/LinkBombMoveRight1.png");
				else
					user.pic = new ImageIcon("data/LinkBombMoveRight2.png");
				user.direction = "right";
				user.height = 30;
			}
		}
		if(c == KeyEvent.VK_UP)
		{
			user.dy = -5;
			if(!user.action.equalsIgnoreCase("arrow") && !user.action.equalsIgnoreCase("bomb"))
			{
				user.action = "none";
				if(user.y %2 == 0)
					user.pic = new ImageIcon("data/LinkUp3.png");
				if(user.y %2 == 1)
					user.pic = new ImageIcon("data/LinkUp2.png");
				user.direction = "up";
				user.height = 20;
				user.width = 20;
			}
			else if(user.action.equalsIgnoreCase("bomb"))
			{
				if(user.y %2 == 0)
					user.pic = new ImageIcon("data/LinkBombMoveUp1.png");
				else
					user.pic = new ImageIcon("data/LinkBombMoveUp2.png");
				user.direction = "up";
				user.height = 30;
			}
		}
		if(c == KeyEvent.VK_DOWN)
		{
			user.dy = 5;
			if(!user.action.equalsIgnoreCase("arrow") && !user.action.equalsIgnoreCase("bomb"))
			{
				user.action = "none";
				if(user.y %2 == 0)
					user.pic = new ImageIcon("data/LinkDown1.png");
				else
					user.pic = new ImageIcon("data/LinkDown2.png");
				user.direction = "down";
				user.height = 20;
				user.width = 20;
			}
			else if(user.action.equalsIgnoreCase("bomb"))
			{
				if(user.y %2 == 0)
					user.pic = new ImageIcon("data/LinkBombMoveDown1.png");
				else
					user.pic = new ImageIcon("data/LinkBombMoveDown2.png");
				user.direction = "down";
				user.height = 30;
			}
		}
		}
		repaint();
	}

	public void keyReleased(KeyEvent k) 
	{
		int c = k.getKeyCode();
		
		if(user.alive)
		{
			if(c == KeyEvent.VK_B)
			{
				user.action = "thrown";
				if(user.direction.equalsIgnoreCase("up"))
				{
					user.pic = new ImageIcon("data/LinkArrowUp2.png");
				}
				if(user.direction.equalsIgnoreCase("down"))
				{
					user.pic = new ImageIcon("data/LinkArrowDown2.png");
				}
				if(user.direction.equalsIgnoreCase("left"))
				{
					user.pic = new ImageIcon("data/LinkArrowLeft2.png");
				}
				if(user.direction.equalsIgnoreCase("right"))
				{
					user.pic = new ImageIcon("data/LinkArrowRight2.png");
				}
			
				item.add(new Projectile(user.x, user.y, user.direction, "arrow"));
			}
			if(c == KeyEvent.VK_C)
			{
				user.action = "none";
				if(user.direction.equalsIgnoreCase("up"))
				{
					item.add(new Projectile(user.x, user.y - 10, "none", "bomb"));
				}
				if(user.direction.equalsIgnoreCase("down"))
				{
					item.add(new Projectile(user.x, user.y + user.height + 10, "none", "bomb"));
				}
				if(user.direction.equalsIgnoreCase("left"))
				{
					item.add(new Projectile(user.x - 10, user.y, "none", "bomb"));
				}
				if(user.direction.equalsIgnoreCase("right"))
				{
					item.add(new Projectile(user.x + user.width + 10, user.y, "none", "bomb"));
				}
			}
			if( c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_LEFT || c == KeyEvent.VK_UP || c == KeyEvent.VK_DOWN || c == KeyEvent.VK_C )
			{
				user.dx = 0;
				user.dy = 0;
			
				if(!user.action.equalsIgnoreCase("arrow"))
				{
					user.action = "none";
					user.width = 20;
					user.height = 20;
					if(user.direction.equalsIgnoreCase("up"))
					{
						user.pic = new ImageIcon("data/LinkStandingUp.png");
					}
					if(user.direction.equalsIgnoreCase("down"))
					{
						user.pic = new ImageIcon("data/LinkStandingDown.png");
					}
					if(user.direction.equalsIgnoreCase("left"))
					{
						user.pic = new ImageIcon("data/LinkStandingLeft.png");
					}
					if(user.direction.equalsIgnoreCase("right"))
					{
						user.pic = new ImageIcon("data/LinkStandingRight.png");
					}
				}
			}
		}
		
		
	}

	public void keyTyped(KeyEvent k) 
	{
		
	}

}
