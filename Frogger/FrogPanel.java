import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class FrogPanel extends JPanel implements KeyListener
{
	ImageIcon frogpic, background;
	ImageIcon busR, carR, car2R, logpic;
	Frog frog;
	
	boolean win = false;
	
	MovingObject bus, car, car2, log;
	
	LinkedList<MovingObject> moveList;
	
	FrogPanel()
	{
		frogpic = new ImageIcon("data/frogU.gif");
		background = new ImageIcon("data/background.jpg");
		
		frog = new Frog();
		frog.setPic(frogpic);
		
		log = new MovingObject();
		logpic = new ImageIcon("data/medlog.png");
		log.setPic(logpic);
		log.y = 100;
		log.dx = 3;
		log.att = "log";
		
		createCars();
		
		addKeyListener(this);
		setFocusable(true);
		
		UpdateThread ut = new UpdateThread(this);
		ut.start();
	}
	
	public void createCars()
	{
		moveList = new LinkedList<MovingObject>();
		busR = new ImageIcon("data/busR.gif");
		carR = new ImageIcon("data/carR.gif");
		car2R = new ImageIcon("data/car2Right.gif");
				
		bus = new MovingObject();
		bus.setPic(busR);
		moveList.add(bus);
		
		car = new MovingObject();
		car.setPic(carR);
		car.setSpeed(8, 0);
		car.setXY(200, 200);
		moveList.add(car);
		
		car2 = new MovingObject();
		car2.setPic(car2R);
		car2.setSpeed(6, 0);
		car2.setXY(200, 250);
		moveList.add(car2);
	}
	
	public boolean checkCollision(MovingObject o)
	{
		if(o.intersects(frog) == true )
		{
			if(o.att.equalsIgnoreCase("Car"))
			{
				frog.update();
				System.out.println("Run Over");
			}
			else if(o.att.equalsIgnoreCase("log"))
			{
				if(frog.x > o.scw)
					win = true;
				frog.x += o.dx;
			}
			return true;
		}
		return false;
	}
	
	public void update()
	{
		for(MovingObject o : moveList)
		{
			checkCollision(o);
			o.update();
		}
		if(frog.y  + frog.height <= log.y + log.height)
		{
			if(checkCollision(log))
			{
				System.out.println("Hit log");
			}
			else
			{
				frog.update();
				System.out.println("Drown");
			}
		}
		log.update();
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
		log.draw(g, this);
		frog.draw(g,this);
		for(MovingObject o : moveList)
		{
			o.draw(g, this);
		}
		if(win)
		{
			g.setColor(Color.red);
			g.setFont( new Font( "stupid font", Font.BOLD, 50 ) );
			g.drawString("WIN!!!!", 100,100);
		}
	}

	public void keyPressed(KeyEvent k) 
	{
		char c = k.getKeyChar();
		
		if( k.getKeyCode() == KeyEvent.VK_LEFT )
    		frog.x -= 10;
    	if( k.getKeyCode() == KeyEvent.VK_RIGHT )
    		frog.x += 10;
    	if( k.getKeyCode() == KeyEvent.VK_DOWN )
    		frog.y += 10;
    	if( k.getKeyCode() == KeyEvent.VK_UP )
    		frog.y -= 10;
				
		repaint();
	}

	public void keyReleased(KeyEvent k) 
	{
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent k) 
	{
		// TODO Auto-generated method stub		
	}
}