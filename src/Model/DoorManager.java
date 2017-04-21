package Model;

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
	public DoorManager()
	{
		doorList = new ArrayList<Door>(); 
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
				Door door = new Door(doorID, connectedRoomId1, connectedRoomId2, description, false) ;
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
