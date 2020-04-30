import java.awt.*;

public class Paddle
{

	//position
	int x;
	int y;

	//dimensions
	int width;
	int height;

	Paddle()
	{
		y = 400;
		x = 250;

		width = 60;
		height = 10;
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x,y,width,height);
	}

}