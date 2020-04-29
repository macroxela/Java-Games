
import java.util.*;
import static java.lang.System.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random tst = new Random();
		int h, power_up;
		int num_defeated = 0;
		int boss_battle = 5;
		String att_name;
		Random rand = new Random();
		out.println("What is your name?");
		String name = scan.next();
		out.println("Hello " + name + " you are about to embark on an epic journey.");
		String t;
		out.println("What type do you want to be?\nWater\nFire\nGrass\nElectric");
		t = scan.next();
		
		Hero user1 = new Hero(name, t);
		
		out.println("\nYour stats are: ");
		user1.print_stats();
		
		Enemy a = new Enemy();
		out.println("\nYou are against: "+ a.name + "\nHP: " + a.hp);
		
		//Step 1 create frame
		JFrame frame = new JFrame("Battlefield");		
		//Step 2 Create a panel
		GamePanel panel = new GamePanel(user1, a);		
		//Step 3 Put the panel in the frame
		frame.getContentPane().add(panel);
		//step 4 Set size of frame, make it visible
		frame.setSize(400,600);
		frame.setVisible(true);
		
		panel.removeAll();
		panel.updateUI();
		
		out.println("\nAttack? ");
		String ans = scan.next();
		String natt;
		power_up = 5;
		while(ans.equalsIgnoreCase("Yes") && a.hp > 0 && user1.hp > 0)
		{
			out.println("\nWhich attack?");
			if(user1.att.a1 != null)
				out.println("(1)" + user1.att.a1);
			if(user1.att.a2 != null)
				out.println("(2)" + user1.att.a2);
			if(user1.att.a3 != null)
				out.println("(3)" + user1.att.a3);
			if(user1.att.a4 != null)
				out.println("(4)" + user1.att.a4);
			
			int o = scan.nextInt();
			
			////////////////////////////////////////////////////////////////////////////////////
			//Determine attacking order
			if(a.speed > user1.speed)
			{
				a.attack(user1);
				out.println(user1.name + " took damage, \nHP: " + user1.hp + "\n");
				if(a.check_alive(user1))
				{
					user1.attack(a, o);
					out.println("Enemy "+ a.name + " took damage, \nHP: " + a.hp);
					
				}
			}
			//////////////////////////////////////////////////////////////////////////////////
			else if(a.speed < user1.speed)
			{
				user1.attack(a, o);
				out.println("Enemy "+ a.name + " took damage, \nHP: " + a.hp + "\n");
				if(user1.check_alive(a))
				{
					a.attack(user1);
					out.println(user1.name + " took damage, \nHP: " + user1.hp + "\n");
				}
			}
			///////////////////////////////////////////////////////////////////////////////////
			else 
			{
				h = tst.nextInt(2);
				if( h == 1)
				{
					user1.attack(a, o);
					out.println("Enemy "+ a.name + " took damage, \nHP: " + a.hp + "\n");
					if(user1.check_alive(a))
					{
						a.attack(user1);
						out.println(user1.name + " took damage, \nHP: " + user1.hp + "\n");
					}				
				}
				else
				{
					a.attack(user1);
					out.println(user1.name + " took damage, \nHP: " + user1.hp + "\n");
					if(a.check_alive(user1))
					{
						user1.attack(a, o);
						out.println("Enemy "+ a.name + " took damage, \nHP: " + a.hp + "\n");
					}
				}
			}
			//////////////////////////////////////////////////////////////////////////////////////
			// Check to see if user lost
			if(user1.hp <= 0)
			{
				out.println("You lost the game . . .");
				panel.update_info(user1, a);
				break;
			}
			//check to see if enemy lost
			if(a.hp <= 0)
			{
				out.println("You defeated " + a.name);
				user1.level_up(a);
				out.println("You gained " + (user1.exp - user1.old_exp) + " experience points.");
				panel.update_info(user1, a);
				num_defeated++;
				if(num_defeated > 17)
				{
					out.println("You beat the game!!!");
					break;
				}
				// Increase user's level
				if(user1.old_level < user1.level)
				{
					out.println("You leveled up!! \nLevel: " + user1.level);
					out.println("Attack:" + user1.attack + "\nDefense:" + user1.defense + "\nSpeed:" + user1.speed + "\nHP:" + user1.max_hp);
					
					if(user1.level >= user1.lvl_evolve1 || user1.level >= user1.lvl_evolve2)
					{
						out.println(user1.name + " evolved!!");
						user1.attack += 5;
						user1.defense += 5;
						user1.speed += 5;
						user1.hp += 5;
						if(user1.type.equalsIgnoreCase("Grass"))
						{
							user1.att.a4 = "Solar Burst";
							user1.att.a4_type = "Fire";
							out.println(user1.name + " learned " + user1.att.a4);
						}
						if(user1.type.equalsIgnoreCase("Fire"))
						{
							user1.att.a4 = "Solar Beam";
							user1.att.a4_type = "Grass";
							out.println(user1.name + " learned " + user1.att.a4);
						}
						if(user1.type.equalsIgnoreCase("Water"))
						{
							user1.att.a4 = "Ice Beam";
							user1.att.a4_type = "Ice";
							out.println(user1.name + " learned " + user1.att.a4);
						}
						if(user1.type.equalsIgnoreCase("Electric"))
						{
							user1.att.a4 = "Energy Ball";
							user1.att.a4_type = "Grass";
							out.println(user1.name + " learned " + user1.att.a4);
						}
					}
				}
				
				out.println("Fight another enemy?");
				String ans2 = scan.next();
				
				if(!ans2.equalsIgnoreCase("Yes"))
				{
					out.println("Decided to stop");
					break;
				}
	/////////////////////////////////////////////////////////////////////////////////	
				if(ans2.equalsIgnoreCase("Yes"))
				{
					//Bosses
					if(num_defeated == boss_battle)
					{
						int ran_num = rand.nextInt(3) + 1;
						power_up += 1;
						user1.hp = user1.max_hp;
						
						if(num_defeated == 5)
						{
							boss_battle = 7;
							if(ran_num == 1)
								a = new Enemy("Moltres");
							else if(ran_num == 2)
								a = new Enemy("Zapdos");
							else if(ran_num == 3)
								a = new Enemy("Articuno");
							
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						if(num_defeated == 7)
						{
							boss_battle = 10;
							if(ran_num == 1)
								a = new Enemy("Raikou");
							else if(ran_num == 2)
								a = new Enemy("Entei");
							else if(ran_num == 3)
								a = new Enemy("Suicune");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						if(num_defeated == 10)
						{
							boss_battle = 12;
							a = new Enemy("Darkrai");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						if(num_defeated == 12)
						{
							boss_battle = 14;
							a = new Enemy("Mew");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						if(num_defeated == 14)
						{
							boss_battle = 15;
							a = new Enemy("Mewtwo");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						
						if(num_defeated == 15)
						{
							boss_battle = 16;
							if(ran_num == 1)
								a = new Enemy("Reshiram");
							else if(ran_num == 2)
								a = new Enemy("Zekrom");
							else if(ran_num == 3)
								a = new Enemy("Kyurem");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						
						if(num_defeated == 16)
						{
							int u = tst.nextInt(2) + 1;
							boss_battle = 17;
							if(u ==1)
								a = new Enemy("Palkia");
							else
								a = new Enemy("Dialga");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						if(num_defeated == 17)
						{
							a = new Enemy("Giratina");
							a.attack += power_up;
							a.defense += power_up;
							a.speed += power_up;
							a.hp += power_up;
							a.print_stats();
						}
						
						
					}
					else
					{
						a = new Enemy();
						a.attack += power_up;
						a.defense += power_up;
						a.hp += power_up;
						a.speed += power_up;
						a.value += power_up;
						a.print_stats();
						user1.hp = user1.max_hp;
					}
					panel.update_info(user1, a);
				}
				else
					break;
			}
			else if(user1.hp > 0)
			{
				panel.update_info(user1, a);
				out.println("Attack? ");
				ans = scan.next();
				
				if(!ans.equalsIgnoreCase("Yes"))
				{
					out.println("You ran away . . .");
					break;
				}
			}
		}
	}

}
