package Controller;

import Model.*;
/*
 * Author Maryam Najiarani
 * 
 * This Class will control the processes of the game 
 * 
 */
import View.ViewClass ;
public class GameController 
{

	private ArtifactContainer artifactContainer;
	private RoomManager roomManager;
	private DoorManager doorManager ;
	private MonsterContainer monsterContainer ;
	private MemoryContainer memoryContainer ;
	
	Player player = null ;
	
	
	private boolean confirmClose()
	{
		if( player == null )
			return true ;
		
		
		ViewClass.print( "This operation would close the current game. Do you want to save the progress ? (Yes, No)");
		String res = UserInput.getString() ;
		
		if(res.equalsIgnoreCase("Yes"))
			saveGame();
		
		return true ;
		
	}
	
	/********************************************************************************************************************************/
	// Player will create new game 
	private void createNewPlayer()
	{
		String name = UserInput.getString("please enter user name") ;
		String password = UserInput.getString("please enter password") ;
		CharacterStat stat = new CharacterStat(100,20,5,1) ;
		player = new Player( name, password, "L1", stat) ;
		
		// now open the door which are open initially for each user
		for( int i=0; i<doorManager.getDoorCount();i++)
		{
			Door door = doorManager.getDoor(i) ;
			
			if( door.getConnectedRoomId1().startsWith("L") || door.getConnectedRoomId1().startsWith("A") ||
					door.getConnectedRoomId2().startsWith("L") || door.getConnectedRoomId2().startsWith("A") )
				player.addDoor(door.getDoorID());
		}
		
	}
	
	/********************************************************************************************************************************/
	// Player will save the game
	private void saveGame()
	{
		if( player == null )
		{
			ViewClass.print("no active player , you should create or load a game");
			return ;
		}
		player.save();
	}
	
	/********************************************************************************************************************************/
	//player will load the game were its left off
	private void loadGame()
	{
		String name = UserInput.getString("please enter user name") ;
		String password = UserInput.getString("please enter password") ;

		player = new Player();
		if( ! player.load(name, password))
		{
			ViewClass.print("Cannot load  user. user/password incorrect" );
			player = null ;
		}
		
	}
	
	/********************************************************************************************************************************/
	// display the inventory of the items and memories
	private void displayInventory()
	{
		if( player == null )
		{
			ViewClass.print("no active player , you should create or load a game");
			return ;
		}
		ViewClass.print("\nPlayer " + player.getUserName() + " has " + player.getArtifactCount() + " artifacts !");
		for( int i=0 ; i< player.getArtifactCount() ; i++)
		{
			Artifact artifact = artifactContainer.getArtifact(player.getArtifactID(i)) ;
			if(artifact != null )
				ViewClass.print("Player owns : " + artifact.getArtifactName());
			else
				ViewClass.print("Player owns : ERROR") ;
			
		}
		
		ViewClass.print("\n\n");
				
				
		
	}
	
	/********************************************************************************************************************************/
	//Anythime display the score of the player
	private void displayPlayerScore()
	{
		if( player == null )
		{
			ViewClass.print("no active player , you should create or load a game");
			return ;
		}

		ViewClass.print( "HP = " + player.getStats().getHP() );
		ViewClass.print( "ATTACK = " + player.getStats().getATK() );
		ViewClass.print( "DEFENCE = " + player.getStats().getDEF() );
		ViewClass.print( "DODGES = " + player.getStats().getDodge() );
		
	}
	
	/********************************************************************************************************************************/
	
	private boolean displayMenu() // true means we should quit
	{
		int res = MenuControl.getMenuResponse() ;
		
		switch(res)
		{
		case 0:
			ViewClass.print("Resuming game");
			break;
		case 1:
			
			if( confirmClose() )
					createNewPlayer() ;
			
			break;
			
		case 2:
			saveGame() ;
			break;
		case 3:
			
			if( confirmClose() )
					loadGame() ;

			break;
			
		case 4:
			if( confirmClose() )
				return true;
			break;
		case 5:
			// handle help
			break;
		case 6:
			displayInventory() ;
			break;
				
		case 7:
			displayPlayerScore() ;
			break;
		}

		return false;
	}
	
	/********************************************************************************************************************************/
	
	public void start()
	{
		artifactContainer = new ArtifactContainer() ;
		artifactContainer.LoadArtifacts("Artifacts.txt") ;
		
		roomManager= new RoomManager() ;
		roomManager.LoadRooms("Room1.txt") ;
		
		doorManager = new DoorManager() ;
		doorManager.LoadDoors("Doors.txt") ;
		
		monsterContainer = new MonsterContainer() ;
		
		memoryContainer = new MemoryContainer() ;
		memoryContainer.LoadMemories("Memories.txt") ;
		
		
		
		while( true )
		{
			if( player != null )
			{
				if( player.getStats().getHP()<=0)
				{
					ViewClass.print("Player has been defeated ! , GAME OVER ....");
					player = null ;
				}
			}
			if( player != null )
			{
				if( player.hasMonster("M9"))
				{
					ViewClass.print("\n\n******************************************************");
					ViewClass.print("\n\nCongradulations !!!!");
					ViewClass.print("\n\nYou have won the GAME !!!");
					player = null ;
					return ;
				}
			}

			//	while ( player == null )
			{
				if( displayMenu() )
					return ;
			}
			
				
			if( player != null )
				playNextAction() ;
			
			
		}
		
	}
	
	public void playNextAction() 
	{
		ViewClass.print("\n*****************************");
		ViewClass.print("Current room : ");
		Room room  = roomManager.getRoom( player.getCurrentRoomID()) ;
		if( room == null)
		{
			ViewClass.print("There is inconsisitency in game database , cant find room " + player.getCurrentRoomID());
			return ;
		}
		room.display() ;
		ViewClass.print("\n*****************************");
	
		 
		
		switch( room.getRoomType())
		{
		case 'B':
			handleRoomMonster(room) ;
		break;
		case 'P':
			handleRoomPuzzle(room) ;
		break;
		case 'L':
		case 'A':
			handleRoomAccess(room);
		break;
			
		case 'S':
			handleRoomSecret(room);
			break;
		case 'I':
			handleRoomArtifact(room);
		break;
		
		}
		
		
	}
	
	/********************************************************************************************************************************/
	public void unlockAllDoors( Room room)
	{
		String []exitRooms = room.getExit().split(",") ;
		for( int j=0; j< exitRooms.length ; j++)
		{
			String doorID = doorManager.getDoorID(room.getRoomId(), exitRooms[j].trim()) ;
			if( doorID != null)
			{
				if( !player.hasDoor(doorID))
				{
					ViewClass.print("Yeay,... You have unlocked room " + exitRooms[j].trim());
					player.addDoor(doorID);
				}
				
			}
		}
		
	}

	public void handleRoomPuzzle(Room room)
	{
		ViewClass.print("\nPPPPPPPPPPUUUUUUUUUUUUZZZZZZZZZZZZZZZZLLLLLLLLLLLLLEEEEEEEEE");
		ViewClass.print("\nYou have enetered a puzzle room. You have 3 chance to answer the question");
		Puzzle puzzle = new Puzzle( room.getRoomId() ) ;
		puzzle.loadProblem() ;
		
		if( puzzle == null )
		{
			ViewClass.print("cannot load puzzle, It is your lucky day !");
			unlockAllDoors( room ) ;
			
		}
		else
		{
			if( player.hasPuzzle(puzzle.getPuzzleID()))
			{

				ViewClass.print("puzzle is solved already, you can pick your exit door");
				handleRoomAccess(room);
				return ;
			}
			for(int i=0; i<3; i++)
			{
				ViewClass.print( puzzle.getProblem() );
				ViewClass.print( puzzle.getDescription() );
				
				String response = UserInput.getString("What is your answer :" );
				if( response.equalsIgnoreCase(puzzle.getAnswer()))
				{
					ViewClass.print("Correct Answer, hooray !");
					// correct answer : open the doors 
					unlockAllDoors( room ) ;
					player.addPuzzle(puzzle.getPuzzleID());
					ViewClass.print("Now you can pick your exit door");
					handleRoomAccess(room);
					return ;
					
				}
				else
				{
					ViewClass.print("Wrong answer ! try again ");
				}
				
			}
			
			// 3 incorrect answers !
			ViewClass.print("You didnt answer the puzzle, you should now exit this room");
			handleRoomAccess(room);
			return  ;
			
		}
		
		
	}

	
	/********************************************************************************************************************************/
	

	public void handleRoomMonster(Room room)
	{
		ViewClass.print("You have entered a Boss room");

		Monster monster  = monsterContainer.getMonster( room.getRoomNumber() - 1) ;
		if( monster == null )
		{
			ViewClass.print( "Cannot load monster information, your locky day" );
			unlockAllDoors( room ) ;
			ViewClass.print("you should now exit this room");
			handleRoomAccess(room);
		}
		else
		{
			ViewClass.print( "Mosnter " + monster.getName() + " is here  !!!" );


			if( player.hasMonster(monster.getID()))
			{
				ViewClass.print( "You have already defeated the monster !" );
				ViewClass.print("you should now exit this room");
				handleRoomAccess(room);
			}
			else
			{
				ViewClass.print( "\n");
				ViewClass.print(  monster.getDescription() );
				ViewClass.print(  monster.getTagLine() );

				String response = UserInput.getString("Do you wanna fight " + monster.getName() +  "   ?  (Yes/No)" ) ;

				if( response.equalsIgnoreCase("no"))
				{
					ViewClass.print("you should now exit this room");
					handleRoomAccess(room);
				}

				else
				{

					if( fight( monster ) )
					{
						ViewClass.print("\n\nCongradulation !!!! You defeated monster :" + monster.getName() );
						player.addMonster(monster.getID());
						unlockAllDoors(room);

						int monsterID = room.getRoomNumber() - 1 ;
						Memories memory = memoryContainer.getMemories(monsterID) ;

						if( memory != null )
						{
							ViewClass.print("\n A new memory has been released ...") ;
							ViewClass.print(memory.getDescription() ) ;
						}

						if( monster.getID() != "M9")

						{
							ViewClass.print("you should now exit this room");
							handleRoomAccess(room);
						}




					}
					else 
						return ;


				}
			}
		}

	}

	
	/********************************************************************************************************************************/

	public boolean fight( Monster monster)
	{
		ViewClass.print("***************************************************");
		ViewClass.print("The fight has begun !!! ") ;
		
		while( player.getStats().getHP()>0 )
		{
			ViewClass.print("Player HP : " +  player.getStats().getHP() + " Monster HP : " + monster.getStats().getHP() );
			String response = UserInput.getString("What do you want to do ? (1. Attack, 2. Use Inventory 3. Escape") ;
			
			if( response.equalsIgnoreCase("attack") || response.equalsIgnoreCase("1") )
				monster = handlePlayerAttack(monster) ;
			
			if( response.equalsIgnoreCase("Use") || response.equalsIgnoreCase("2") )
				handlePlayerUse() ;
			
			if( response.equalsIgnoreCase("Escape") || response.equalsIgnoreCase("3") )
			{
				ViewClass.print("\nyou have escaped the fight with " + player.getStats().getHP() + " HP left\n" );		
				break;
			}
			
			if( monster.getStats().getHP() <=0 )
			 	return true ;
		}
				
		return false;
	}
	/********************************************************************************************************************************/
	public Monster handlePlayerAttack(Monster monster) 
	{
		
		CharacterStat monsterStats = monster.getStats() ;
		CharacterStat playerStats = player.getStats() ;
		
		if( monsterStats.getDodge()>0)
		{
			ViewClass.print("Monster dodges !)") ;
			monsterStats.Update(0,0, 0, -1);
		} 
		else
		{
			int monsterDamage = playerStats.getATK() - monsterStats.getDEF() ;
			if( monsterDamage < 0 )
				monsterDamage= 0 ;
			
			
			monsterStats.Update( -monsterDamage ,0, 0, 0);
		}
		
		
		if( playerStats.getDodge()>0)
		{
			ViewClass.print("player dodges !)") ;
			playerStats.Update(0,0, 0, -1);
		}
		else
		{
			int playerDamage = monsterStats.getDEF() ;
			playerStats.Update(-playerDamage, 0, 0, 0);
		}
		
		player.setStats(playerStats);
		monster.setStats(monsterStats);
		
		
		return monster ;
	}

	/********************************************************************************************************************************/
	public void handlePlayerUse()
	{
		displayInventory();
		if( player.getArtifactCount()==0)
		{
			ViewClass.print("You dont have any artifact to use\n");
			return ;
		}
		ViewClass.print("Please enter the artifact number (0 to ignore , 1 to " + player.getArtifactCount() + " to select an artifact") ;
		int response = UserInput.getInt() ;
		if( response == 0 )
			return ;
		
		String artifactID = player.getArtifactID(response -1 );
		player.UseArtifact(artifactID) ;
		
		
		ViewClass.print("These are stats after using the artifact :");
		displayPlayerScore();
		
	}

	/********************************************************************************************************************************/

	public void handleRoomArtifact(Room room)
	{
		//if( !room.getRoomId().startsWith("I") )
		int artifactNumber = Integer.parseInt( room.getRoomId().substring(1)) - 1 ;
		Artifact ar = artifactContainer.getArtifact( artifactNumber ) ;
		
		
		if( ar == null)
		{
			ViewClass.print("Cannot load artifact" );
		}
		else
		{
			ViewClass.print("\n!!! ARTIFACT ROOM !!!!" );
			ViewClass.print("You have enetered a room containts artifact ");
			ViewClass.print (ar.getArtifactName() );
			ViewClass.print (ar.getDescription() );
			
			if( player.hasArtifact(ar.getArtifactId()))
			{
				ViewClass.print("User already owns the artifact" );
			}
			else
			{
				ViewClass.print("Congradulations ! now you own this artifact : " +  ar.getArtifactName()  );
				player.addArtifact(ar.getArtifactId());
				unlockAllDoors(room);
			}
			
			
		}
		
		ViewClass.print("\n\nYou should now exit this room " );
		handleRoomAccess(room);
		
	
	}

	/********************************************************************************************************************************/
	
	public void handleRoomAccess(Room room)
	{
		while( true )
		{
			ViewClass.print("Current room has access to these other rooms : " + room.getExit());
			
			
		
			String choice = UserInput.getString("Which room do you want to go ? ") ;
			
			String doorID = doorManager.getDoorID(room.getRoomId(), choice) ;
			
			if( doorID == null)
			{
				ViewClass.print("There is no door connecting this room to " + choice  + ", wrong choice.... , please try again\n");
				continue ;
						
			}
			
			if( player.isDoorOpen(doorID))
			{
				ViewClass.print("This room is accessible, you are now entering : " + choice);
				player.setCurrentRoomID(choice);
				break ;
				
			}
			{
				ViewClass.print("This room locked, please pick another room");
				continue ;
			}
		}
		
	}

	
	/********************************************************************************************************************************/
	

	public void handleRoomSecret(Room r)
	{
		
	}
	
	/********************************************************************************************************************************/
	
	public void handleRoomLibrary(Room r)
	{
		
	}
	
	/********************************************************************************************************************************/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameController game = new GameController() ;
		
		game.start();
		
	}
	/********************************************************************************************************************************/
	
			
		
}

