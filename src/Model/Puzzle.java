package Model;
import java.io.File;
import java.util.Scanner;
//import View. View Class; 

/* Maryam Najiarani
 * this is the puzzle class that will generate random questions to the user 
 * check the answer from the user
 */
public class Puzzle {

	
	private int roomId ;
	
	private String description ;
	private String puzzleID ;
	private String problem;
	private String answer ;
	

	public Puzzle( int roomID )
	{
		this.roomId = roomID ;
	}
	
	
	public boolean loadProblem() 
	{
		
		String fileName ;
		String s ;
		
		
		try{
			
			fileName = "Puzzle" + Integer.toString(roomId) + ".txt" ;	
			File puzzleFile = new File(fileName);
			Scanner fileReader = new Scanner(puzzleFile);	
			
			
			//read how many items are in the puzzle file
			s = fileReader.nextLine() ;
			int itemCount = Integer.parseInt(s) ;  
			
			
			// select an item number by random
			int item = 1 + (int)Math.floor(  Math.random() * itemCount ) ;
			
			// skip all items before reaching the selected item
			for( int i=0; i<item-1 ; i++)
			{
				String s1 = fileReader.nextLine();
				String s2 = fileReader.nextLine();
				String s3 = fileReader.nextLine();
				String s4 = fileReader.nextLine();
			}
			
			// read content of the selected item
			this.puzzleID = fileReader.nextLine();
			this.description = fileReader.nextLine(); 
			this.problem = fileReader.nextLine();
			this.answer = fileReader.nextLine();
			
			fileReader.close();
			return true ;
		}
		
		catch( Exception e)
		{
			return false ;
		}
	}
	
	public String getProblem()
	{
		return this.problem;
	}
	public String getAnswer()
	{
		return this.answer;
	}
	public String getDescription()
	{
		return this.description;
	}
	
	public String getPuzzleID()
	{
		return this.puzzleID ;
	}
	
}
