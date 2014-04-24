
public class Dungeon {

	Room rooms[];
	Room current;
	int roomscleared;
	Dungeon()
	{
		//Room baseroom = new Room();
		//Room nextRoom = new Room();
		rooms = new Room[10];
		rooms[0] = new Room(1);
		rooms[1] = new Room(2);
		rooms[2] = new Room(3);
		rooms[3] = new Room(4);
		rooms[4] = new Room(5);
		rooms[5] = new Room(6);
		rooms[6] = new Room(7);
		rooms[7] = new Room(8);
		rooms[8] = new Room(9);
		rooms[9] = new Room(10);
		current = rooms[0];
		roomscleared = 0;
	}
	
	public void roomCheck()
	{
		//System.out.println(current.name);
		//System.out.println(current.next);
		if(current.cleared && current.name.equalsIgnoreCase("Entry"))
		{
			//System.out.println("Cleared");
			current = rooms[1];
		}
		if(current.next.equalsIgnoreCase("up") && current.name.equalsIgnoreCase("MovingTilesRoom"))
		{
			current.next = "none";
			current = rooms[7];
			current.next = "none";
		}
		if(current.next.equalsIgnoreCase("up") && current.name.equalsIgnoreCase("StairRoom"))
		{
			current.next = "none";
			current = rooms[8];
			current.next = "none";
		}
		if(current.next.equalsIgnoreCase("left") && current.name.equalsIgnoreCase("Arena Entry 3"))
		{
			current.next = "none";
			current = rooms[9];
			current.next = "none";
		}
		if(/*current.cleared && */current.next.equalsIgnoreCase("left") && current.name.equalsIgnoreCase("base"))
		{
			//System.out.println("Cleared");
			current = rooms[2];
		}
		if(current.next.equalsIgnoreCase("right") && current.name.equalsIgnoreCase("base"))
		{
			current.next = "none";
			current = rooms[4];
			current.next = "none";
		}
		if(current.next.equalsIgnoreCase("up") && current.name.equalsIgnoreCase("base"))
		{
			current.next = "none";
			current = rooms[6];
		}
		if(current.next.equalsIgnoreCase("right") && current.name.equalsIgnoreCase("Arena Entry 1"))
		{
			current.next = "none";
			current = rooms[1];
			current.next = "none";
		}
		if(current.next.equalsIgnoreCase("up") && current.name.equalsIgnoreCase("Arena Entry 1") && rooms[3].passable)
		{
			current.next = "none";
			current = rooms[3];
			current.next = "none";
		}
		if(current.next.equalsIgnoreCase("down") && current.name.equalsIgnoreCase("Arena 1"))
		{
			current.next = "none";
			current = rooms[2];
			current.next = "none";
			current.ent1 = false;
		}
		if(current.next.equalsIgnoreCase("down") && current.name.equalsIgnoreCase("Arena 2"))
		{
			current.next = "none";
			current = rooms[4];
			current.next = "none";
			current.ent2 = false;
		}
		if(current.next.equalsIgnoreCase("left") && current.name.equalsIgnoreCase("Arena Entry 2"))
		{
			current.next = "none";
			current = rooms[1];
			current.next = "none";
		}
		if(current.next.equalsIgnoreCase("up") && current.name.equalsIgnoreCase("Arena Entry 2") && rooms[5].passable)
		{
			current.next = "none";
			current = rooms[5];
			current.next = "none";
		}
	}
}
