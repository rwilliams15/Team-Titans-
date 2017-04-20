package Model;
import View.ViewClass;
/* Maryam Najiarani
 * This is the Room class that will contains the Rooms 
 * will give Id, description, name and the exit to the Room manager class 
 */
public class Room {

	ViewClass view = new ViewClass();
	
	private String roomId; 
	private String name;
	private String description; 
	private String exit; 
	
	public Room()
	{
		setRoomId("");
		setName("");
		setDescription("");
		setExit("");
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExit(String exit) {
		this.exit = exit;
	}

	public Room(String roomId, String name, String description, String exit)
	{
		setRoomId(roomId);
		setName(name);
		setDescription(description);
		setExit(exit);

	}


	public String getRoomId() {
		return roomId;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public String getExit() {
		return exit;
	}
	

}
