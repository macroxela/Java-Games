import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.util.*; 

public class BrickPanel extends JPanel implements KeyListener
{

	//ball location
	int x, brick_x;
	int y, brick_y;
	
	//ball velocity
	int dx;
	int dy;
	
	int counter = 1;
	
	//paddle
	Paddle paddle;
	Brick brick;
	LinkedList<Brick> brickList;
	KeyEvent key;
	boolean pause;
	
	BrickPanel()
	{
		x=50;
		y=300;
		dx = 3;
		dy = 2;
		paddle = new Paddle();
		brickList = new LinkedList<Brick>();
		brick_x =  10;
		brick_y = 0;
		for(int i = 0; i < 13; i++)
		{
			for(int j = 0; j <10; j++ )
			{
				Brick b = new Brick(i*35 + brick_x, j*25 + brick_y);
				brickList.add(b);
			}
			brick_x ++;
		}
		
		//add a KeyListener to panel
		addKeyListener(this);
		setFocusable(true);
		pause=true;
	}

	public void animate()
	{
		while(true)
		{
			while(pause)
			{
				//move the ball a little bit
				x += dx;
				y += dy;

				//check for collision with vertical walls
				if( x+20 >= getWidth() || x < 0)
				{
					dx = -1*dx;
				}

				//horizontal wall collision?
				if( y+20 >= getHeight() || y < 0 )
				{
					dy = -1*dy;
				}

				//check for collision with paddle
				if(paddle.x < x + 20 && x < paddle.x+ paddle.width && paddle.y < y +20&& y < paddle.y+paddle.height)
				{
					dy = -1*dy;
				}
			
				for(Brick b : brickList)
				{
				
					if(b.x < x + 20 && x < b.x+ b.width && b.y < y +20&& y < b.y+b.height)
					{
						dy = -1*dy;
						y += dy;
						b.breakbrick();
					}
				}
			
				repaint();
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e)
				{
					System.out.println("Uh oh, something bad happened!");
				}
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		//first, clear old stuff
		super.paintComponent(g);
		//g.setFont(new Font("TimesRoman", Font.PLAIN,  20));
		
		
		//draw ball
		g.setColor(Color.RED);
		g.fillOval(x,y, 20,20);

		//draw paddle
		paddle.draw(g);
		
		//draw bricks
		for(Brick b : brickList)
			b.draw(g);
	}

	public void keyPressed(KeyEvent e)
	{
		char avar=e.getKeyChar();
    	//move paddle according to letter pressed
    	if( e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0)
    		paddle.x -= 20;
    	if( e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x + 60 < getWidth())
    		paddle.x += 20;
    	
    	if(avar == 'p')
    	{
    		counter++;
    		if(counter%2 == 0)
    			pause=false;
    		else 
    			pause = true;  		
    	}  	
	}

	public void keyReleased(KeyEvent e)
	{
    //       Invoked when a key has been released.
	}

 	public void keyTyped(KeyEvent e)
 	{
    //       Invoked when a key has been typed.
	}


}