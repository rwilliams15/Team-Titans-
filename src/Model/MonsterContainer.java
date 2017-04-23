package Model;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/*
 * Author Maryam Najiarani
 *  the class has info related to each monster
 */
public class MonsterContainer {

	private ArrayList<Monster> monsterList ;

	public MonsterContainer()
	{
		/*
		 * 
		 * Array List of the Monster with the description related to each will be 
		 * modified in the following codes
		 */
		monsterList = new ArrayList<Monster>() ;

		final String[] IDs = {"M1", "M2", "M3", "M4", "M5", 
				"M6", "M7", "M9"};

		final String[] name = new String[] {"Envy", "Sloth", "Wrath", "Lust", "Gluttony", 
				"Pride", "Greed", "Generic Demon"};
		String description ;
		String tagLine  ;

		description = "Copies your equipment, avoid the fight completely by giving it your clothes.";
		tagLine = "You've got some nice clothes there. I want them,says Envy.";
		monsterList.add(new Monster( IDs[0], name[0], description , tagLine, new CharacterStat(100,10,15,3))) ;

		description = "First monster in the game, high defense, doesn't initiate fight " +
				"until you pick up the sword, just figure out the controls to kill it.";
		tagLine = "I don't wanna move, but I have to kill you....says Sloth";
		monsterList.add(new Monster( IDs[1], name[1], description , tagLine, new CharacterStat(100,6,50,1))) ;

		description = "Attacks on sight. No Puzzle. Just don't die.";
		tagLine = "Just the sight of you... PISSES ME OFF!\nIt's been so long since I've had anything to burn....";
		monsterList.add(new Monster( IDs[2], name[2], description , tagLine, new CharacterStat(150,15,35,7))) ;

		description = "Just a guy on his computer. Initiate fight by closing his laptop. " +
				"Attack laptop to in- stant kill him. His phone acts as a master key.";
		tagLine = "Just let me finish looking at this real quick...";
		monsterList.add(new Monster( IDs[3], name[3], description , tagLine, new CharacterStat(130,12,20,5))) ;

		description = "Giant, fat, blobby monster with a very high HP but low attack. You find " +
				"a rotten piece of food in front of the room. If you throw it at the monster, " +
				"it'll eat the food. It will then be poisoned and af- ter 3 turns, it dies.";
		tagLine = "ÒIÕm feeling a little peekish. Maybe IÕll devour your soul.";
		monsterList.add(new Monster( IDs[4], name[4], description , tagLine, new CharacterStat(200,4,20,3))) ;


		description = "Can regenerate health, be- cause Pride can make one stubborn. You can walk " +
				"in front of a mirror, and kill it while it's admiring itself in the mirror";
		tagLine = "YOU want to challenge ME?? Good luck with that, kid.";
		monsterList.add(new Monster( IDs[5], name[5], description , tagLine, new CharacterStat(75,3,5,25))) ;

		description = "Every attack has a 10% chance of stripping an item. There will be a puzzle " +
				"where to get into the room where Greed is, you must pick up a bag of gold to open " +
				"the door to the room. In the room, will be a pedestal like the one the gold was on. " +
				"You must put the gold back on that pedes- tal to distract him. Hitting him while he's " +
				"distracted will result in an instant kill, or you can choose to run.";
		tagLine = "I'm gonna take your stuff, and then I'm gonna take your life!";
		monsterList.add(new Monster( IDs[6], name[6], description , tagLine, new CharacterStat(135,13,25,6))) ;


		description = "Standard Random enemy. Random chance of dropping a healing potion or a tempo" +
				"rary stat increasing potion";
		tagLine = "I will feast on you!\n" + "Your mere existence is enraging! \n" + 
				"Is it really worth it to keep going? You're too good for this \n" +
				"and you know it. Just give in to your desires., You're just jealous of my \n" +
				"power! You want my loot? How about you trade your soul for it?";

		monsterList.add(new Monster( IDs[7], name[7], description , tagLine, new CharacterStat(30,4,10,2))) ;


	}

	public Monster getMonster(int i)
	{
		return monsterList.get(i) ;
	}
	
	
	public Monster getMonster(String id)  
	{
		for( int i=0;i<monsterList.size();i++)
			if( monsterList.get(i).getID().equalsIgnoreCase(id))
				return monsterList.get(i) ;
		return null ;
	}


}
