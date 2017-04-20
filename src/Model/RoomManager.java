package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/* Maryam Najiarani
 * this is the RoomManager Class contains Array of the Rooms
 * it will load the rooms with the details related to each room
 */
public class RoomManager {
// Array of Rooms
	ArrayList<Room> roomList = null;
	public RoomManager()
	{
		roomList = new ArrayList<Room>(); 
	}

	//It load the room 
	public boolean LoadRooms( String fileName )
	{
	try{
			

        
			File roomFile = new File(fileName);
			Scanner fileReader = new Scanner(roomFile);	
			
			
			//read how many items are in the Room file
			String str = fileReader.nextLine() ;
			int itemCount = Integer.parseInt(str) ;  
			
			

			for( int i=0; i<itemCount ; i++)
			{
				
				String roomID = fileReader.nextLine();
				String name = fileReader.nextLine(); 
				String description = fileReader.nextLine();
				String exit = fileReader.nextLine();
				// make new rooms and add them to the ArrayList
				Room room = new Room(roomID, name, description, exit) ;
				roomList.add(room) ;
			}
			
			// read content of the selected Room
			
			fileReader.close();
			return true ;
		}
		
		catch( Exception e)
		{
			return false ;
		}

	}


	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
	public int getRoomCount()
	{
		return roomList.size();
	}
	public Room getRoom(int i)
	{
		return roomList.get(i) ;
	}
	
	
	
}
