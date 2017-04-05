package Model;
import java.util.Scanner;

public class PuzzleTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner readInput = new Scanner( System.in ) ;
		Puzzle p = new Puzzle(1) ;
		
		if( p.loadProblem())
		{
			System.out.println("Please answer this question : " );
			System.out.println("description : " + p.getDescription() ) ;
			System.out.println(p.getProblem());
			
			String response = readInput.nextLine() ;
			if( response.equals(p.getAnswer()))
				System.out.println("correct answer");
			else
				{
					System.out.println("wrong answer");
					System.out.println("The correct answer is : " + p.getAnswer());
				}
			
				
		}
		else
		{
			System.out.println("puzzle loading error") ;
		}
	}

}
