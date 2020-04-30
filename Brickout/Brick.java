import java.awt.*;

public class Brick {
	int x, y;
	int width, height;
	boolean broken;
	
	Brick()
	{
		x = 0;
		y = 0;
		broken = false;
		width = 30;
		height = 20;
	}
	
	Brick(int posx, int posy)
	{
		x = posx;
		y = posy;
		broken = false;
		width = 30;
		height = 20;
	}
	
	public void breakbrick()
	{
		
		x = -1;
		y = -1;
		width = 0;
		height = 0;
		broken = true;
		//return broken;
	}
	
	public boolean isBroken()
	{
		return broken;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLUE);
		//if(!broken)
			g.fillRect(x,y,width,height);
	}
	
	

}
