package Model;

import Model.UserInput;
/*
 * Author Joe Pelletier
 * Modified by Maryam Najiarani
 * 
 */

public class MenuControl {
		
	public static int getMenuResponse() 
	{
		System.out.println("\n**********************************");
		System.out.println("Main Menu :\n");
		System.out.println("What would you like to do?");
		System.out.println("0. Continue");
		System.out.println("1. New Game");
		System.out.println("2. Save Game");
		System.out.println("3. Load Game");
		System.out.println("4. Quit");
		System.out.println("5. View Help");
		System.out.println("6. View Inventory");
		System.out.println("7. View Score");
		System.out.println("Please pick a number : ");
		int intInput = 0 ;
		try
		{
			intInput = UserInput.getInt();
		}
		catch(Exception e)
		{
			System.out.println("Wrong Item !!!\n");		
		}
		System.out.println("\n**********************************\n");
		
		//System.out.println("You have picked item" + intInput);
		//String strInput = UserInput.getString();
		return intInput ;
		
	}
}
