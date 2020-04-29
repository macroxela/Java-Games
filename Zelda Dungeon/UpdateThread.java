import javax.swing.*;

public class UpdateThread extends Thread
{

	DungeonPanel panel;

	UpdateThread(DungeonPanel p)
	{
		panel = p;
	}

	public void run()
	{
		while(true)
		{
			panel.update();
			try
			{
				Thread.sleep(50);
			}
			catch(Exception e){}
		}
	}


}
