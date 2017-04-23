package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/*
 * Author   Erick Vale
 * Modified  Maryam Najiarani
 */
import java.util.Scanner;

import View.ViewClass;

public class Player {

	private String userName;
	private String password;
	private CharacterStat stats ;
	ArrayList<String> artifactIDs ; // contains the list of artifacts carried by user
	ArrayList<String> doorIDs ; // contains list of doors opened by the user
	ArrayList<String> puzzleIDs ; // contains list of puzzles opened by the user
	ArrayList<String> monsterIDs ;
	String currentRoomID ;
	
	public CharacterStat getStats()
	{
		return stats ;
	}
	public void setStats( CharacterStat stats)
	{
		this.stats = stats ;
	}
	
	public void save() 
	{
		String fileName = getUserName()+".txt" ;
		
		try {
		FileOutputStream fos = new FileOutputStream(fileName);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);

	    oos.writeObject(userName);
	    oos.writeObject(password);
	    oos.writeInt(stats.getHP());
	    oos.writeInt(stats.getATK());
	    oos.writeInt(stats.getDEF());
	    oos.writeInt(stats.getDodge());
	    
	    
	    if( artifactIDs.size()>0)
	    {
	    	oos.writeInt(1);
	    	oos.writeObject(artifactIDs);
	    }
	    else
	    {
	    	oos.writeInt(0);
	    }
	    
	    if( doorIDs.size()>0)
	    {
	    	oos.writeInt(1);
	    	oos.writeObject(doorIDs);
	    }
	    else
	    {
	    	oos.writeInt(0);
	    }
	    
	    if( puzzleIDs.size()>0)
	    {
	    	oos.writeInt(1);
	    	oos.writeObject(puzzleIDs);
	    }
	    else
	    {
	    	oos.writeInt(0);
	    }
	    
	    if( monsterIDs.size()>0)
	    {
	    	oos.writeInt(1);
	    	oos.writeObject(monsterIDs);
	    }
	    else
	    {
	    	oos.writeInt(0);
	    }
	    
	   
	    oos.writeObject(currentRoomID);
	    
	    ViewClass.print("User " + getUserName() +  " info saved to database");
		}
		catch(Exception e)
		{
			
		}
		
	}
	public boolean load( String name , String password) 
	{
		String fileName = name+".txt" ;
		try
		{
			
			FileInputStream fis = new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);

			String fileUserName = (String)ois.readObject();
			String FilePassword = (String) ois.readObject();
			
			setUserName(name);
			setPassword(password);
			if( ! fileUserName.equals(name) || !FilePassword.equals(password))
			{
				ViewClass.print("Incorrect username/password");
				return false ;
			}
			stats = new CharacterStat() ;
			stats.setHP( ois.readInt() );
			stats.setATK( ois.readInt() );
			stats.setDEF( ois.readInt() );
			stats.setDodge( ois.readInt() );
			
			if(ois.readInt()==1)
				artifactIDs = (ArrayList<String>)ois.readObject();
			else
				artifactIDs = new ArrayList<String>() ;
			if(ois.readInt()==1)
				doorIDs = (ArrayList<String>)ois.readObject();
			else
				doorIDs = new ArrayList<String>() ;

			if(ois.readInt()==1)
				puzzleIDs = (ArrayList<String>)ois.readObject();
			else
				puzzleIDs = new ArrayList<String>() ;

			if(ois.readInt()==1)
				monsterIDs = (ArrayList<String>)ois.readObject();
			else
				monsterIDs = new ArrayList<String>() ;

			ViewClass.print("User " + getUserName() + " info loaded");
			currentRoomID =  (String)ois.readObject(); 
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		return false;
	}
	public Player() 
	{
		
	}
	public Player( String userName, String password, String roomID, CharacterStat stats) 
	{
		artifactIDs = new ArrayList<String>() ;
		doorIDs = new ArrayList<String>() ;
		this.stats = stats ;
		puzzleIDs =  new ArrayList<String>() ;
		monsterIDs = new ArrayList<String>() ;
		
		setUserName(userName);
		setPassword(password);
		setCurrentRoomID(roomID);

		
	}
	
	public String getCurrentRoomID()
	{
		return currentRoomID ;
	}
	public void setCurrentRoomID(String roomID )
	{
		this.currentRoomID = roomID ;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addDoor(String doorID)
	{
		doorIDs.add(doorID) ;
	}
	
	public boolean isDoorOpen( String doorID)
	{
		for (int i=0; i< doorIDs.size() ; i++ )
			if( doorIDs.get(i).equalsIgnoreCase(doorID))
				return true ;
		return false;
	}
	public void addArtifact( String artifactID )
	{
		if( !hasArtifact( artifactID )) // this would ensure there is no duplicate !
			artifactIDs.add(artifactID ) ;
	}
	// Control the stat of artifact
	public boolean UseArtifact(String artifactID )
	{
		for( int i=0; i< artifactIDs.size(); i++)
			if( artifactIDs.get(i).equalsIgnoreCase(artifactID))
			{	
				
				if( artifactIDs.get(i).equals("I1"))
				{
					stats.setATK(stats.getATK()+10);
				}
				if( artifactIDs.get(i).equals("I2"))
				{
					addDoor("D16");
					addDoor("D17");
				}
				if( artifactIDs.get(i).equals("I3"))
				{
					stats.setDEF(stats.getDEF()+10);
				}
				if( artifactIDs.get(i).equals("I4"))
				{
					stats.setHP(stats.getHP()+50);
				}
				if( artifactIDs.get(i).equals("I5"))
				{
					stats.setATK(stats.getATK()+5);
				}
				if( artifactIDs.get(i).equals("I6"))
				{
					stats.Update(3, 3, 3, 3);
				}
				if( artifactIDs.get(i).equals("I7"))
				{
					stats.setHP(stats.getHP()+20);
				}
				if( artifactIDs.get(i).equals("I8"))
				{
					stats.setHP(stats.getHP()+40);
				}
				if( artifactIDs.get(i).equals("I9"))
				{
					stats.setHP(stats.getHP()+60);
				}
				
				
				artifactIDs.remove(i) ;
					
				return true;
			}
		return false ;
	}
	public boolean hasArtifact(String artifactID )
	{
		for( int i=0; i< artifactIDs.size(); i++)
			if( artifactIDs.get(i).equalsIgnoreCase(artifactID))
			{
				return true;
			}
		return false ;
	}
	
	public int getArtifactCount()
	{
		return artifactIDs.size() ;
	}
	
	public String getArtifactID( int i)
	{
		return artifactIDs.get(i) ;
		
	}
	public boolean hasDoor(String doorID )
	{
		for( int i=0; i< doorIDs.size(); i++)
		{
			if( doorIDs.get(i).equalsIgnoreCase(doorID))
				return true;
		}
		return false ;
	}
	

	public void addPuzzle(String puzzleID)
	{
		if( !hasPuzzle(puzzleID))
			puzzleIDs.add(puzzleID) ;
	}
	public boolean hasPuzzle(String puzzleID)
	{
		for( int i=0; i< puzzleIDs.size() ; i++)
		{
			if( puzzleIDs.get(i).equalsIgnoreCase(puzzleID))
				return true ;
		}
			
		
		return false;
	}
	
	public void addMonster(String monsterID)
	{
		if( !hasMonster(monsterID))
			monsterIDs.add(monsterID) ;
	}
	public boolean hasMonster(String monsterID)
	{
		for( int i=0; i< monsterIDs.size() ; i++)
		{
			if( monsterIDs.get(i).equalsIgnoreCase(monsterID))
				return true ;
		}
			
		
		return false;
	}
}
