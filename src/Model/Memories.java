package Model;
import View.ViewClass;

/*
 * Author Richard Williams 
 * Modified by  Maryam Najiarani
 */

public class Memories 
{
	ViewClass view = new ViewClass();
	private String memoryId;
	private String Description;
	private String Monster;
	
	public Memories()
	{
		setMemoryId("");
		setMemoryName("");
		setDescription("");
	}
	
	public void setMemoryId(String memoryId)
	{
		this.memoryId = memoryId;	
	}
	
	public void setMemoryName(String Description)
	{
		this.Description = Description;
	}
	
	public void setDescription(String Monster)
	{
		this.Monster = Monster;
	}
	
	public Memories(String memoryId, String Description, String Monster)
	{
		setMemoryId(memoryId);
		setMemoryName(Description);
		setDescription(Monster);
	}
	
	public String getMemoryId()
	{
		return memoryId;
	}
	
	public String getDescription()
	{
		return Description;
	}
	
	public String getMonster()
	{
		return Monster;
	}
	
	//Needs to become workable
	public void retainMemory()
	{
		
		//Needs code
		
		
		
		
	
		System.out.println(" " + "has been retained for further memory");
	}

}
