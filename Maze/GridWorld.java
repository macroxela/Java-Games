import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GridWorld
{
	Cell [][] grid;
	int n,m;
	ImageIcon wall = new ImageIcon("pics/Tree1_1.PNG");
;

	GridWorld(int _n, int _m)
	{
		n=_n;
		m=_m;

		grid = new Cell[n+2][m+2];

		//place cells
		for(int i=0; i<n+2; i++)
			for(int j=0; j<m+2; j++)
				grid[i][j]= new Cell();

		//build a border
		for(int i=0; i<n+2; i++)
		{
			grid[i][0].walkable = false;
			grid[i][n+1].walkable = false;
		}
		for(int j=0; j<m+2; j++)
		{
			grid[0][j].walkable=false;
			grid[n+1][j].walkable=false;
		}
	}

	public void draw(Graphics g, Component c)
	{
		Color col; 
		for(int i=0; i<n+2; i++)
		{
			for(int j=0; j<m+2; j++)
			{
				col = new Color(grid[i][j].weight + 10,grid[i][j].weight + 100,grid[i][j].weight + 10);
				if(grid[i][j].path)
					g.setColor(Color.GREEN);
				//else if(grid[i][j].marked)
					//g.setColor(Color.PINK);
				else if(grid[i][j].walkable)
					g.setColor(col);
				else 
					g.setColor(Color.BLACK);

				g.fillRect(i*10,j*10,10,10);
			}
		}
	}

	public void clearJunk()
	{
		for(int i=0; i<n+2; i++)
		{
			for(int j=0; j<m+2; j++)
			{
				grid[i][j].marked=false;
				grid[i][j].path=false;
				grid[i][j].pred=null;
			}
		}
	}
/*
	public void check(PriorityQueue Q, Point t, Cell c1, Cell c2)
	{
		
		 int dist = grid[t.x][t.y].distance + grid[t.x][t.y + 1].weight;
				if(dist < grid[t.x][t.y + 1].distance)
					grid[t.x][t.y + 1].distance = dist;
				grid[t.x][t.y + 1].pred = t;
		 
		
		int dist = c1.distance + c2.weight;
		if(dist < c2.distance)
			c2.distance = dist;
		c2.pred = t;
		Q.remove(t);
		Q.add(t);
	}
	*/
	/*public void dijkstraPath(int startx, int starty, int endx, int endy)
	{
		clearJunk();
		
		PriorityQueue<Point> Q = new PriorityQueue<Point>();
		Point start = new Point(startx, starty);
		Point end = new Point(endx, endy);
		grid[startx][starty].distance = 0;
		//grid[startx][starty].marked = true;
		Q.add(start);
		
		while(!Q.isEmpty())
		{
			Point t = Q.poll();
			
			if(grid[t.x][t.y + 1].walkable)// && !grid[t.x][t.y + 1].marked)
			{
				check(Q, t, grid[t.x][t.y], grid[t.x][t.y + 1]);
				
			}
			if(grid[t.x][t.y - 1].walkable)// && !grid[t.x][t.y - 1].marked)
			{
				check(Q, t, grid[t.x][t.y], grid[t.x][t.y + 1]);
			}
			if(grid[t.x + 1][t.y].walkable)// && !grid[t.x + 1][t.y].marked)
			{
				check(Q, t, grid[t.x][t.y], grid[t.x][t.y + 1]);
			}
			if(grid[t.x - 1][t.y].walkable)// && !grid[t.x - 1][t.y].marked)
			{
				check(Q, t, grid[t.x][t.y], grid[t.x][t.y + 1]);
			}
			System.out.println(grid[t.x][t.y].distance);
		}
		
		Point p = end;
		System.out.println("Distance " + grid[end.x][end.y].distance);
		while(p != null &&  !p.equals(start))
		{
			System.out.println(p);
			grid[p.x][p.y].path = true;
			p = grid[p.x][p.y].pred;
		}
	}*/
	
	
	//compute shortest path from start to end
	//This is the "breadth first search" algorithm.
	public void shortestPath(int startx, int starty, int endx, int endy)
	{
		clearJunk();

		Point start = new Point(startx, starty);
		Point end = new Point(endx, endy);

		//first: create a Q (queue), mark start point as "marked", put start in Q
		Queue<Point> Q = new LinkedList<Point>();
		grid[startx][starty].marked = true;
		Q.offer(start);

		//keep looping as long as Q is not empty
		while( ! Q.isEmpty() )
		{
			//pull point t out of Q
			Point t = Q.remove();

			//if t is the end point, exit loop and finish
			if( t.equals(end) )
				break;

			//otherwise, marked all of t's unmarked neighbors, put them in Q
			if( ! grid[t.x][t.y-1].marked && grid[t.x][t.y-1].walkable )
			{
				grid[t.x][t.y-1].marked=true;
				Q.offer( new Point(t.x,t.y-1) );
				grid[t.x][t.y-1].pred = t;
			}

			if( ! grid[t.x+1][t.y].marked && grid[t.x+1][t.y].walkable )
			{
				grid[t.x+1][t.y].marked=true;
				Q.offer( new Point(t.x+1,t.y) );
				grid[t.x+1][t.y].pred = t;
			}

			if( ! grid[t.x][t.y+1].marked && grid[t.x][t.y+1].walkable )
			{
				grid[t.x][t.y+1].marked=true;
				Q.offer( new Point(t.x,t.y+1) );
				grid[t.x][t.y+1].pred = t;
			}

			if( ! grid[t.x-1][t.y].marked && grid[t.x-1][t.y].walkable )
			{
				grid[t.x-1][t.y].marked=true;
				Q.offer( new Point(t.x-1,t.y) );
				grid[t.x-1][t.y].pred = t;
			}

		}

		//reconstruct path
		Point p = end;
		while( p!=null &&  ! p.equals(start) )
		{
			System.out.println(p);
			grid[p.x][p.y].path=true;
			p = grid[p.x][p.y].pred;
		}

	}
}