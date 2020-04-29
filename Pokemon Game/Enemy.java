
import static java.lang.System.out;
import java.awt.*;
import javax.swing.*;

public class Enemy extends Combatant{

	int value, x, y, level;
	ImageIcon pice;
	Attacks att;
	
	Enemy()
	{
		int ran_num = ran.nextInt(3) + 1;
		int shiny_num = ran.nextInt(99) + 1;
		
		if(ran_num == 1)
		{
			name = "Snivy";
			type = "Grass";
			hp = 30;
			attack = 6;
			defense = 4;
			value = 20;
			speed = 15;
			attribute = "Enemy";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Snivy_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/th_snivy.gif");
			att = new Attacks();
			att.set_attacks("Tackle", "Normal", "Razor Leaf", "Grass", "Bite", "Normal", null, null);
		}
		
		else if(ran_num == 2)
		{
			name = "Tepig";
			type = "Fire";
			hp = 30;
			attack = 7;
			defense = 4;
			value = 18;
			speed = 7;
			attribute = "Enemy";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Tepig_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/th_tepig.gif");
			att = new Attacks();
			att.set_attacks("Tackle", "Normal", "Ember", "Fire", "Bite", "Normal", null, null);
		}
		
		else if(ran_num == 3)
		{
			name = "Totodile";
			type = "Water";
			hp = 30;
			attack = 9;
			defense = 4;
			value = 21;
			speed = 11;
			attribute = "Enemy";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Totodile_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Totodile_NB.gif");
			att = new Attacks();
			att.set_attacks("Tackle", "Normal", "Water Gun", "Water", "Bite", "Normal", null, null);
		}
		
		x=200;
		y=1;
	}
	
	Enemy(String s)
	{
		int shiny_num = ran.nextInt(99) + 1;
		
		name = s;
		if(s.equalsIgnoreCase("Reshiram"))
		{
			type = "Dragon";
			hp = 40;
			attack = 40;
			defense = 30;
			value = 50;
			speed = 35;
			attribute = "Boss";
			pice = new ImageIcon("img/Reshiram_NB.gif");
			att = new Attacks();
			att.set_attacks("Dragon Pulse", "Dragon", "Fusion Flare", "Fire", "Solar Beam", "Grass", "Blue Flame", "Fire");
		}
		else if(s.equalsIgnoreCase("Zekrom"))
		{
			type = "Dragon";
			hp = 40;
			attack = 40;
			defense = 30;
			value = 50;
			speed = 35;
			attribute = "Boss";
			pice = new ImageIcon("img/zani1.gif");
			att = new Attacks();
			att.set_attacks("Dragon Pulse", "Dragon", "Fusion Bolt", "Electric", "Lightning Strike", "Electric", "Flamethrower", "Fire");
		}
		else if(s.equalsIgnoreCase("Kyurem"))
		{
			type = "Dragon";
			hp = 40;
			attack = 40;
			defense = 30;
			value = 50;
			speed = 35;
			attribute = "Boss";
			pice = new ImageIcon("img/Kyurem_NB.gif");
			att = new Attacks();
			att.set_attacks("Dragon Pulse", "Dragon", "Blizzard", "Ice", "Hydro Pump", "Water", "Crunch", "Normal");
		}
		else if(s.equalsIgnoreCase("Moltres"))
		{
			type = "Fire";
			hp = 40;
			attack = 25;
			defense = 14;
			value = 50;
			speed = 23;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Moltres_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Moltres_NB.gif");
			att = new Attacks();
			att.set_attacks("Sky Attack", "Flying", "Fire Blast", "Fire", "Solar Beam", "Grass", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Articuno"))
		{
			type = "Water";
			hp = 40;
			attack = 25;
			defense = 14;
			value = 50;
			speed = 22;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Articuno_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Articuno_NB.gif");
			att = new Attacks();
			att.set_attacks("Sky Attack", "Flying", "Ice Beam", "Ice", "Water Pulse", "Water", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Zapdos"))
		{
			type = "Electric";
			hp = 40;
			attack = 25;
			defense = 14;
			value = 50;
			speed = 27;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Zapdos_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Zapdos_NB.gif");
			att = new Attacks();
			att.set_attacks("Sky Attack", "Flying", "Thunderbolt", "Electric", "Water Pulse", "Water", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Raikou"))
		{
			type = "Electric";
			hp = 40;
			attack = 27;
			defense = 14;
			value = 150;
			speed = 25;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Raikou_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Raikou_NB.gif");
			att = new Attacks();
			att.set_attacks("Crunch", "Normal", "Thunderbolt", "Electric", "Volt Tackle", "Electric", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Suicune"))
		{
			type = "Water";
			hp = 40;
			attack = 27;
			defense = 20;
			value = 150;
			speed = 25;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Suicune_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Suicune_NB.gif");
			att = new Attacks();
			att.set_attacks("Ice beam", "Ice", "Thunderbolt", "Electric", "Hydro Pump", "Water", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Entei"))
		{
			type = "Fire";
			hp = 40;
			attack = 27;
			defense = 20;
			value = 150;
			speed = 25;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Entei_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Entei_NB.gif");
			att = new Attacks();
			att.set_attacks("Crunch", "Normal", "Fire Blast", "Fire", "Solar Beam", "Grass", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Darkrai"))
		{
			type = "Dark";
			hp = 40;
			attack = 30;
			defense = 20;
			value = 150;
			speed = 40;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Darkrai_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Darkrai_NB.gif");
			att = new Attacks();
			att.set_attacks("Ice Beam", "Ice", "Fire Blast", "Fire", "Solar Beam", "Grass", "Dark Pulse", "Dark");
		}
		
		else if(s.equalsIgnoreCase("Mew"))
		{
			type = "Psychic";
			hp = 40;
			attack = 28;
			defense = 20;
			value = 250;
			speed = 35;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Mew_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Mew_NB.gif");
			att = new Attacks();
			att.set_attacks("Ice Beam", "Ice", "Fire Blast", "Fire", "Solar Beam", "Grass", "Psychic", "Psychic");
		}
		else if(s.equalsIgnoreCase("Mewtwo"))
		{
			type = "Psychic";
			hp = 50;
			attack = 30;
			defense = 27;
			value = 250;
			speed = 40;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Mewtwo_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Mewtwo_NB.gif");
			att = new Attacks();
			att.set_attacks("Thunderbolt", "Electric", "Fire Blast", "Fire", "Solar Beam", "Grass", "Psychic", "Psychic");
		}
		else if(s.equalsIgnoreCase("Dialga"))
		{
			type = "Dragon";
			hp = 60;
			attack = 30;
			defense = 30;
			value = 300;
			speed = 27;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Dialga_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Dialga_NB.gif");
			att = new Attacks();
			att.set_attacks("Roar of Time", "Dragon", "Fire Blast", "Fire", "Thunderbolt", "Electric", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Palkia"))
		{
			type = "Dragon";
			hp = 60;
			attack = 30;
			defense = 25;
			value = 300;
			speed = 27;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Palkia_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Palkia_NB.gif");
			att = new Attacks();
			att.set_attacks("Spacial Rend", "Dragon", "Water Pulse", "Water", "Thunderbolt", "Electric", "Take Down", "Normal");
		}
		else if(s.equalsIgnoreCase("Giratina"))
		{
			type = "Dragon";
			hp = 65;
			attack = 40;
			defense = 40;
			value = 300;
			speed = 35;
			attribute = "Boss";
			if(shiny_num == 75)
				pice = new ImageIcon("img/Giratina_NB_variocolor.gif");
			else
				pice = new ImageIcon("img/Giratina_NB.gif");
			att = new Attacks();
			att.set_attacks("Dragon Pulse", "Dragon", "Shadow Force", "Ghost", "Thunderbolt", "Electric", "Flamethrower", "Fire");
		}
		
		x=200;
		y=1;
	}
	
	void print_stats()
	{
		System.out.println("Name: " + name + "\nAttack: " + attack);
		System.out.println("Defense: " + defense + "\nSpeed: " + speed);
		System.out.println("HP: " + hp + "\n");
	}
	
	void attack(Hero he)
	{
		int ran_att = 0;
		if(att.a4 != null)
		{
			ran_att = ran.nextInt(4) + 1;
		}
		else
		{
			ran_att = ran.nextInt(3) + 1;
		}
		String a_type = "blank";
		
		if(ran_att == 1)
		{
			out.println(name + " used " + att.a1);
			a_type = att.a1_type;
		}
		else if(ran_att == 2)
		{
			out.println(name + " used " + att.a2);
			a_type = att.a2_type;
		}
		else if(ran_att == 3)
		{
			out.println(name + " used " + att.a3);
			a_type = att.a3_type;
		}
		else if(ran_att == 4)
		{
			out.println(name + " used " + att.a4);
			a_type = att.a4_type;
		} 
		 
		
		double stab = 1;
		double damage;
		double weakness_resistance;
		double critical_hit;
		int ran_num;
		ran_num = ran.nextInt(10) + 1;
		if(name.equalsIgnoreCase("Giratina") && hp <= 32)
		{
			attack += 2;
			defense += 2;
		}
		if(ran_num == 7)
		{
			critical_hit = 2;
			System.out.println("Critical Hit");
		}
		else
			critical_hit = 1;
		
		if(a_type.equalsIgnoreCase(type))
			stab = 1.75;
		
		weakness_resistance = super.check_types(a_type, he.type);
		
		//Damage = ((((2 * Level / 5 + 2) * AttackStat * AttackPower / DefenseStat) / 50) + 2) * STAB 
		//* Weakness/Resistance * RandomNumber / 100
		
		damage = ((attack)/he.defense)*stab*weakness_resistance*critical_hit;
		System.out.println("Damage: " + damage);
		he.hp -= damage;
		if(he.hp <= 0)
			he.hp = 0;
		
		/*he.hp -= attack/he.defense;
		if(he.hp <= 0)
			he.hp = 0;*/
	}
	
	boolean check_alive(Hero a)
	{
		if(a.hp > 0)
			return true;
		return false;
	}

	public void draw(Graphics g, Component c)
	{
		g.drawImage(pice.getImage(), x, y, c);
	}
	
}
