import java.util.*;

public class Combatant {

	double hp, attack, defense, speed;
	String name, type, attribute;
	Random ran = new Random();
	Combatant()
	{
		name = "None";
		type = "Generic";
		hp = 35;
		attack = 12;
		defense = 10;
		speed = 10;
	}
	
	double check_types(String h_type, String e_type)
	{
		if(h_type.equalsIgnoreCase(e_type))
		{
			System.out.println("Not very  effective");
			return 0.5;
		}
		if(h_type.equalsIgnoreCase("Water") && e_type.equalsIgnoreCase("Fire"))
		{
			System.out.println("Super Effective");
			return 2;
		}
		else if(h_type.equalsIgnoreCase("Fire") && e_type.equalsIgnoreCase("Water"))
		{
			System.out.println("Not very  effective");
			return 0.5;
		}
		else if(h_type.equalsIgnoreCase("Grass") && e_type.equalsIgnoreCase("Water"))
		{
			System.out.println("Super Effective");
			return 2;
		}
		else if(h_type.equalsIgnoreCase("Water") && e_type.equalsIgnoreCase("Grass"))
		{
			System.out.println("Not very  effective");
			return 0.5;
		}
		else if(h_type.equalsIgnoreCase("Fire") && e_type.equalsIgnoreCase("Grass"))
		{
			System.out.println("Super Effective");
			return 2;
		}
		else if(h_type.equalsIgnoreCase("Grass") && e_type.equalsIgnoreCase("Fire"))
		{
			System.out.println("Not very  effective");
			return 0.5;
		}
		else if(h_type.equalsIgnoreCase("Ice") && e_type.equalsIgnoreCase("Grass"))
		{
			System.out.println("Super Effective");
			return 2;
		}
		else if(h_type.equalsIgnoreCase("Electric") && e_type.equalsIgnoreCase("Water"))
		{
			System.out.println("Super Effective");
			return 2;
		}
		else if(h_type.equalsIgnoreCase("Electric") && e_type.equalsIgnoreCase("Grass"))
		{
			System.out.println("Not very  effective");
			return 0.5;
		}
		else if(h_type.equalsIgnoreCase("Dragon") || h_type.equalsIgnoreCase("Ghost") || h_type.equalsIgnoreCase("Psychic") || h_type.equalsIgnoreCase("Dark"))
		{
			return 1.3;
		}
		else if(h_type.equalsIgnoreCase("Fire") && e_type.equalsIgnoreCase("Ice"))
		{
			System.out.println("Super Effective");
			return 	2;
		}
		else if(h_type.equalsIgnoreCase("Ice") && e_type.equalsIgnoreCase("Water"))
		{
			System.out.println("Not very  effective");
			return 0.5;
		}
		else if(h_type.equalsIgnoreCase("Flying") && e_type.equalsIgnoreCase("Grass"))
		{
			System.out.println("Super Effective");
			return 2;
		}
		else if(e_type.equalsIgnoreCase("Dragon"))
		{
			return 0.7;
		}
		return 1;
	}
	
	
}
