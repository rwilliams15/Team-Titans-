package Model;
/*
 * Author Maryam Najiarani
 * 
 * this class is define the array list of the door and connected hem to the specific room
 * 
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DoorManager 
{
	// Array of Doors
	
	ArrayList<Door> doorList = null;
	
	public ArrayList<Door> getDoorList() {
		return doorList;
	}
	public void setDoorList(ArrayList<Door> doorList) {
		this.doorList = doorList;
	}
	
	public Door getDoor(int i)
	{
		return doorList.get(i) ;
	}
	public int getDoorCount()
	{
		return doorList.size() ;
	}
	
	public DoorManager()
	{
		doorList = new ArrayList<Door>(); 
	}
	
	public String getDoorID( String room1, String room2)
	{
		for( int i=0; i< doorList.size() ; i++)
		{
			Door door  = doorList.get(i) ;
			if( door.getConnectedRoomId1().equalsIgnoreCase(room1) &&  door.getConnectedRoomId2().equalsIgnoreCase(room2))
				return door.getDoorID() ;
			
			if( door.getConnectedRoomId2().equalsIgnoreCase(room1) &&  door.getConnectedRoomId1().equalsIgnoreCase(room2))
				return door.getDoorID() ;
			
		}
		return null ;
	}
	//It load the door 
	public boolean LoadDoors( String fileName )
	{
		try{



			File doorFile = new File(fileName);
			Scanner fileReader = new Scanner(doorFile);	


			//read how many items are in the door file
			String str = fileReader.nextLine() ;
			int itemCount = Integer.parseInt(str) ;  



			for( int i=0; i<itemCount ; i++)
			{

				String doorID = fileReader.nextLine();
				String connectedRoomId1 = fileReader.nextLine(); 
				String connectedRoomId2 = fileReader.nextLine();
				String description = fileReader.nextLine();

				// make new doors and add them to the ArrayList
				
				
				Door door = new Door(doorID.trim(), connectedRoomId1.trim(), connectedRoomId2.trim(), description.trim(), false) ;
				doorList.add(door) ;
			}

			// read content of the selected doors

			fileReader.close();
			return true ;
		}

		catch( Exception e)
		{
			return false ;
		}
	}
}
