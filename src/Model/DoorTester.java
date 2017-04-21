package Model;
import java.util.ArrayList;

public class DoorTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoorManager doorManager = new DoorManager() ; 

		if(doorManager.LoadDoors("Doors.txt"))
		{   
			ArrayList<Door> doorList = doorManager.getDoorList();
			for(int i=0; i< doorList.size(); i++)
			{
				System.out.println( "\nDoor : " + (i+1) );
				System.out.println( doorList.get(i).getDoorID() );
				System.out.println( doorList.get(i).getConnectedRoomId1());
				System.out.println( doorList.get(i).getConnectedRoomId2());
				System.out.println( doorList.get(i).getDescription() );
		

			}


		}
		else
		{
			System.out.println("Door loading error") ;
		}
	}

}


