/*
 Code From DaniWeb
 http://www.daniweb.com/software-development/java/threads/162294/clock.java
 */
 

import java.util.*;
import java.text.*;
public class Clock
{
	private int hours;
	private int minutes;
	private int seconds;
	int minutesleft, secondsleft;
	
	//Constructor
	Clock()
	{
		hours=0;
		minutes=0;
		seconds=0;
	}

	Clock(int h, int m, int s)
	{
		hours=h;
		minutes=m;
		seconds=s;
	}

	//Accessors
	public void setTime(int h, int m, int s)
	{
		hours=h;
		minutes=m;
		seconds=s;
	}

	public int getHours()
	{
		return hours;
	}	

	public int getMinutes()
	{
		return minutes;
	}

	public int getSeconds()
	{
		return seconds;
	}

	public void setHours(int h)
	{
		hours=h;
	}

	//Modifiers
	public void setMinutes(int m)
	{
		minutes=m;
	}

	public void setSeconds(int s)
	{
		seconds=s;
	}

	public void printTime()
	{
		System.out.println(hours+ "H:" + minutes + "M:" + seconds + "S");
	}

	public void inputTime()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter hours: ");
		hours=input.nextInt();
		System.out.println("Enter minutes: ");
		minutes=input.nextInt();
		System.out.println("Enter seconds: ");
		seconds=input.nextInt();
	}

	public String toString()
	{
		String s= hours+ "H:" + minutes + "M:" + seconds + "S";
		return s;
	}

	public void incrementSeconds(int seconds)
	{
		this.seconds = this.seconds+seconds;
	}

	public void incrementMinutes(int minutes)
	{
		this.minutes = this.minutes+ minutes;
	}

	public void incrementHours(int hours)
	{
		this.hours = this.hours+hours;
	}
}
// this is the end of class Clock, put all new methods before this
