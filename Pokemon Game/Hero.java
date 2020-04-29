import static java.lang.System.out;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Hero extends Combatant{

	int exp, nxt_level, level, g, old_exp, old_level, max_hp, lvl_evolve1, lvl_evolve2;
	int value, x, y;
	ImageIcon pich;
	Attacks att;
	
	Hero()
	{
		nxt_level = 10;
		level = 1;
		exp = 0;
		hp = 30;
		attack = 10;
		defense = 10;
		speed = 10;
		attribute = "Hero";
		x = 10;
		y = 400;
		int r = ran.nextInt(3);
		g = 2;
		if(r == 0)
		{
			type = "Fire";
			pich = new ImageIcon("img/Charmander_espalda_G5.gif");
			att.set_attacks("Tackle","Normal","Ember","Fire","Bite", "Normal", null, null);
		}
		
		else if(r == 1)
		{
			type = "Water";
			pich = new ImageIcon("img/Squirtle_espalda_G5.gif");
			att.set_attacks("Tackle","Normal","Water Gun","Water","Bite", "Normal", null, null);
		}
		else if(r == 2)
		{
			type = "Grass";
			pich = new ImageIcon("img/Bulbasaur_espalda_G5.gif");
			att.set_attacks("Tackle","Normal","Vine Whip","Grass","Bite", "Normal", null, null);
		}
	}
	
	Hero(String s, String t)
	{
		name = s;
		nxt_level = 10;
		level = 1;
		exp = 0;
		speed = 10;
		hp = 25;
		g = 2;
		x = 10;
		y = 400;
		max_hp = 25;
		lvl_evolve1 = 5;
		lvl_evolve2 = 10;
		//attack = 200;     //* Use to go through entire game quickly, check to see if bosses appear
		
		int ran_num = ran.nextInt(99) + 1;
		if(t.equalsIgnoreCase("Fire"))
		{
			type = "Fire";
			if(ran_num == 75)
				pich = new ImageIcon("img/Charmander_espalda_G5_variocolor.gif");
			else
				pich = new ImageIcon("img/Charmander_espalda_G5.gif");
			att = new Attacks();
			att.set_attacks("Tackle","Normal","Ember","Fire","Bite", "Normal", null, null);
		}
		else if(t.equalsIgnoreCase("Water"))
		{
			type = "Water";
			if(ran_num == 75)
				pich = new ImageIcon("img/Squirtle_espalda_G5_variocolor.gif");
			else
				pich = new ImageIcon("img/Squirtle_espalda_G5.gif");
			att = new Attacks();
			att.set_attacks("Tackle","Normal","Water Gun","Water","Bite", "Normal", null, null);
		}
		else if(t.equalsIgnoreCase("Grass"))
		{
			type = "Grass";
			if(ran_num == 75)
				pich = new ImageIcon("img/Bulbasaur_espalda_G5_variocolor.gif");
			else
				pich = new ImageIcon("img/Bulbasaur_espalda_G5.gif");
			att = new Attacks();
			att.set_attacks("Tackle","Normal","Vine Whip","Grass","Bite", "Normal", null, null);
		}
		else if(t.equalsIgnoreCase("Electric"))
		{
			type = "Electric";
			if(ran_num == 75)
				pich = new ImageIcon("img/Pikachu_espalda_G5_variocolor.gif");
			else
				pich = new ImageIcon("img/Pikachu_espalda_G5.gif");
			att = new Attacks();
			att.set_attacks("Tackle","Normal","Thundershock","Electric","Scratch", "Normal", null, null);
		}
	}
	
	void print_stats()
	{
		System.out.println("Level: " + level + "\nAttack: " + attack);
		System.out.println("Defense: " + defense + "\nSpeed: " + speed);
		System.out.println("HP: " + max_hp);
	}
	
	void level_up(Enemy en)
	{
		old_exp = exp;
		exp += level*en.value;
		old_level = level;
		
		while(exp >= nxt_level)
		{
			level++;
			nxt_level = g*nxt_level;
			attack++;
			defense++;
			g++;
			speed++;
			max_hp++;
			hp = max_hp;
		}
		//print_stats();
	}
	
	void attack(Enemy en)
	{
		en.hp -= attack/en.defense;
		if(en.hp <= 0)
			en.hp = 0;
	}
	
	void attack(Enemy en, int n)
	{
		String a_type = "blank";
		double stab = 1;
		double damage;
		double weakness_resistance;
		double critical_hit;
		int ran_num;
		ran_num = ran.nextInt(10) + 1;
		
		if(ran_num == 7)
		{
			critical_hit = 2;
			System.out.println("Critical Hit");
		}
		else
			critical_hit = 1;

		if(n == 1)
		{
			a_type = att.a1_type;
			System.out.println(name + " used " + att.a1);
		}
		else if(n == 2)
		{
			a_type = att.a2_type;
			System.out.println(name + " used " + att.a2);
		}
		else if(n == 3)
		{
			a_type = att.a3_type;
			System.out.println(name + " used " + att.a3);
		}
		else if(n == 4)
		{
			a_type = att.a4_type;
			System.out.println(name + " used " + att.a4);
		}
		
		if(a_type.equalsIgnoreCase(type))
			stab = 1.75;
		
		weakness_resistance = super.check_types(a_type, en.type);
		
		//Damage = ((((2 * Level / 5 + 2) * AttackStat * AttackPower / DefenseStat) / 50) + 2) * STAB 
		//* Weakness/Resistance * RandomNumber / 100
		
		damage = ((attack*level)/en.defense)*stab*weakness_resistance*critical_hit;
		System.out.println("Damage: " + damage);
		en.hp -= damage;
		if(en.hp <= 0)
			en.hp = 0;
	}
	
	boolean check_alive(Enemy ene)
	{
		if(ene.hp > 0)
			return true;
		return false;
	}
	
	public void draw(Graphics g, Component c)
	{
		g.drawImage(pich.getImage(), x, y, c);
	}
}
