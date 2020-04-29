import java.awt.*;
import javax.swing.*;

//A single cell in the game world

public class Cell
{
	//walkable true means your a path, false means you're a wall
	boolean  walkable, marked, path;
	int weight, distance;
	Point pred;

	Cell()
	{
		walkable = true;
		marked = false;
		path = false;
		weight = 0;
		distance = 9999999;
	}

}