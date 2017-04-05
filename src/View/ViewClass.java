package View;

import java.util.Scanner;

public class ViewClass {

	private Scanner input;

	
	public ViewClass()
	{
		input = new Scanner(System.in);
	}
	
	public void Display(String d)
	{
		System.out.println(d);
	}

	public String getResponse()
	{
		return input.nextLine();
	}
}
