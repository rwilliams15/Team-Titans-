package Model;



/* Author Maryam Najiarani
 * 
 * this is the Door class that represents each door 
 * an arrayList of these door should be created in the game runner class
 */
public class Door 
{


	private String doorID;
	private String connectedRoomId1; 
	private String connectedRoomId2; 
	private String description; 
	private boolean isOpen; 

	public Door(String doorID, String connectedRoomId1, String connectedRoomId2, String description, boolean isOpen)
	{
		setDoorID(doorID);
		setConnectedRoomId1(connectedRoomId1); 
		setConnectedRoomId2(connectedRoomId2); 
		setDescription(description); 
		setOpen(isOpen); 

	}

	public String getDoorID() 
	{
		return doorID;
	}

	public void setDoorID(String doorID)
	{

		this.doorID = doorID;
	}

	public String getDescription() 
	{
		return description;
	}

	public String getConnectedRoomId1() 
	{
		return connectedRoomId1;
	}

	public void setConnectedRoomId1(String connectedRoomId1)
	{
		this.connectedRoomId1 = connectedRoomId1;
	}

	public String getConnectedRoomId2() 
	{
		return connectedRoomId2;
	}

	public void setConnectedRoomId2(String connectedRoomId2)
	{
		this.connectedRoomId2 = connectedRoomId2;
	}

	public boolean isOpen() 
	{
		return isOpen;
	}

	public void setOpen(boolean isOpen) 
	{
		this.isOpen = isOpen;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
}
