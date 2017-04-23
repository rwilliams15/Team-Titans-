package Model;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Author Richard Williams 
 * Modified by Maryam Najiarani
 * 
 * 
 */

public class MemoryContainer 

{
	ArrayList<Memories> memoryList = null;
	public MemoryContainer()
	{
		memoryList = new ArrayList<Memories>();
	}
	
	public boolean LoadMemories(String fileName)
	{
		try
		{
			
			File memoryFile = new File(fileName);
			Scanner fileReader = new Scanner(memoryFile);
			
			String str = fileReader.nextLine();
			int itemCount = Integer.parseInt(str);
			
			for( int i = 0; i < itemCount; i++)
			{
				String memoryId = fileReader.nextLine();
				String Description = fileReader.nextLine();
				String Monster = fileReader.nextLine();
				
				Memories memories = new Memories(memoryId.trim(), Description.trim(), Monster.trim());
				memoryList.add(memories);
			}
			
			fileReader.close();
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	
	public ArrayList<Memories> getMemoryList()
	{
		return memoryList;
	}
	public int getMemoryCount()
	{
		return memoryList.size();
	}
	
	public Memories getMemories(int i)
	{
		if( i>memoryList.size()-1)
			return null;
		return memoryList.get(i);
	}
	
}
