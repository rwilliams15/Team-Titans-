package Model;
import java.io.File;
import java.util.Scanner;
import View. ViewClass; 

/* Maryam Najiarani
 * this is the puzzle class that will generate puzzle questions to the user 
 * each puzzle is related to the specific room 
 * read related contents 
 */
public class Puzzle {

	ViewClass view = new ViewClass();
	
	private String roomId ;
	
	private String description ;
	private String puzzleID ;
	private String problem;
	private String answer ;
	

	public Puzzle( String roomId )
	{
		this.roomId = roomId ;
	}
	
	
	public boolean loadProblem() 
	{
		
		String fileName ;
		String str ;
		
		
		try{
			
			fileName = "Puzzle1.txt" ;	
			File puzzleFile = new File(fileName);
			Scanner fileReader = new Scanner(puzzleFile);	
			
			
			//read how many items are in the puzzle file
			str = fileReader.nextLine() ;
			//int itemCount = Integer.parseInt(str) ;  
			
			
			// select a puzzle number based on the rooms
			/*1 + (int)Math.floor(  Math.random() * itemCount ) ; 
			 * 
			 * 
			//New code to specify each puzzle to specific room 
			 * 
			 */
			int item = 1;
			
			 switch (roomId) {
	         case "P1": 
	             item = 1;
	             break;
	         case "P2": 
	             item = 2;
	             break;
	         case "P3": 
	             item = 3;
	             break;
	         case "P4": 
	             item = 4;
	             break;
	         case "P5": 
	             item = 5;
	             break;
	         case "P6": 
	             item = 6;
	             break;
	         case "P7": 
	             item = 7;
	             break;
			 }
	             
	             
			// skip all puzzles before reaching the selected puzzles
			for( int i=0; i<item-1 ; i++)
			{
				String str1 = fileReader.nextLine();
				String str2 = fileReader.nextLine();
				String str3 = fileReader.nextLine();
				String str4 = fileReader.nextLine();
			}
			
			// read content of the selected Puzzle
			this.puzzleID = fileReader.nextLine().trim();
			this.description = fileReader.nextLine().trim(); 
			this.problem = fileReader.nextLine().trim();
			this.answer = fileReader.nextLine().trim();
			
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
