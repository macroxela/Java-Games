import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MazePanel extends JPanel implements KeyListener
{

	GridWorld world;

	int playerx;
	int playery;
	int zombx;
	int zomby;

	Random dice;

	MazePanel()
	{
		int n=50;
		int m=50;
		world = new GridWorld(n,m);
		dice = new Random();

		//build some walls
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				if( dice.nextInt(100) < 25 )
					world.grid[i][j].walkable=false;
				else
				{
					world.grid[i][j].weight = dice.nextInt(100);
				}
			}
		}

		//randomly place player
		playerx = dice.nextInt(n) + 1;
		playery = dice.nextInt(m) + 1;
		world.grid[playerx][playery].walkable=true;

		//randomly place zombie
		zombx = dice.nextInt(n) + 1;
		zomby = dice.nextInt(m) + 1;
		world.grid[zombx][zomby].walkable=true;

		//key listener
		addKeyListener(this);
		setFocusable(true);

	}

	public void paintComponent(Graphics g)
	{
		//draw the world map
		world.draw(g, this);

		//draw the player
		g.setColor(Color.BLUE);
		g.fillOval(playerx*10,playery*10,10,10);

		//draw the zombie
		g.setColor(Color.RED);
		g.fillOval(zombx*10,zomby*10,10,10);
	}

	public void keyPressed(KeyEvent k)
	{
		int c = k.getKeyCode();

		if( c == KeyEvent.VK_DOWN )
		{
			if(world.grid[playerx][playery + 1].walkable)
				playery++;
		}
		if( c == KeyEvent.VK_UP )
		{
			if(world.grid[playerx][playery - 1].walkable)
				playery--;
		}
		if( c == KeyEvent.VK_LEFT )
		{
			if(world.grid[playerx - 1][playery].walkable)
				playerx--;
		}
		if( c == KeyEvent.VK_RIGHT )
		{
			if(world.grid[playerx + 1][playery].walkable)
				playerx++;
		}
		
		if(world.grid[zombx][zomby + 1].path)
			zomby++;
		if(world.grid[zombx][zomby - 1].path)
			zomby--;
		if(world.grid[zombx + 1][zomby].path)
			zombx++;
		if(world.grid[zombx - 1][zomby].path)
			zombx--;
		//compute shortest path from zombie to player
		world.shortestPath(zombx,zomby,playerx,playery);
		//world.dijkstraPath(zombx, zomby, playerx, playery);
		
		repaint();
	}

	public void keyReleased(KeyEvent k)
	{

	}

	public void keyTyped(KeyEvent k)
	{
	}

}