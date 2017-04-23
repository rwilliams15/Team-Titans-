package Model;


import java.util.Scanner;
import View.ViewClass;
/*
 * Author Joe Pelletier
 * Modified by Maryam Najiarani
 * 
 */


public class UserInput {

	public static final Scanner input = new Scanner(System.in);

	private UserInput()
	{
	}

	public static String getString() 
	{
		String userInput = input.nextLine();
		System.out.println();

		if (userInput.equalsIgnoreCase("help"))
		{
			System.out.println("Display Help");
		}

		return userInput;

	}
	public static String getString(String text) 
	{
		ViewClass.print(text);
		String userInput = input.nextLine();
		System.out.println();

		if (userInput.equalsIgnoreCase("help"))
		{
			System.out.println("Display Help");
		}

		return userInput;

	}

	public static int getInt()  
	{
		int res = 0 ;
		try 
		{
			String userInput = input.nextLine();
			System.out.println();

			if(userInput.equalsIgnoreCase("help"))
			{
				System.out.println("Display Help");
			}
			
			
			res = Integer.parseInt(userInput);
				
			
		} catch(Exception e)
		{
			System.out.println();
			
		}
		
		return res;
	}
}

