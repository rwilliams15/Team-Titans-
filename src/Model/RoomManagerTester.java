package Model;
import java.util.ArrayList; 
/*Maryam Najiarani
 * This room is RoomManagaer Tester class
 * 
 */

public class RoomManagerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RoomManager roomManager = new RoomManager() ; 

		if(roomManager.LoadRooms("Room1.txt"))
		{   
			ArrayList<Room> roomList = roomManager.getRoomList();
			for(int i=0; i< roomList.size(); i++)
			{
				System.out.println( "\nRoom : " + (i+1) );
				System.out.println( roomList.get(i).getRoomId() );
				System.out.println( roomList.get(i).getName() );
				System.out.println( roomList.get(i).getDescription() );
				System.out.println( roomList.get(i).getExit() );
			}

	/*
	 
			for(int i=0; i< roomManager.getRoomCount() ; i++)
			{
				System.out.println( roomManager.getRoom(i).getRoomId() );
			}
* 		
	 */

			
			
		}
		else
		{
			System.out.println("Room loading error") ;
		}
	}

}

