import java.awt.*;
import javax.swing.*;

public class Frog extends Rectangle
{
	ImageIcon pic;
	Frog()
	{
		x = 300;
		y = 160;
		
		width = 30;
		height = 30;
	}
	
	public void setPic(ImageIcon p)
	{
		pic = p;
	}
	
	public void update()
	{
		x = 100;
		y = 300;			
	}
	
	public void draw(Graphics g, Component c)
	{
		g.drawImage(pic.getImage(),x,y,width,height,c);
		g.drawRect(x, y, width, height);
	}
	
}
