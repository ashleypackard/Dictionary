package hashmapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryRunner 
{

	public static void main(String[] args) 
	{

		System.out.println("Welcome to the Dictionary");
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a number to set the map size: ");

		int hashmapSize = 0;
		String input = "";
		while (true) 
		{
			input = userInput.nextLine().trim();
			
			// validate user input
			try {
				hashmapSize = Integer.parseInt( input );
				// negative numbers are useless
				if(hashmapSize < 1) 
				{
					System.out.println("Please enter a positive number.");
					continue;
				// positive numbers only!
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a positive number.");
				continue;
			}
			
			if (hashmapSize > 0)
			{
				break;
			}
			
		}
		
		
		
		File myFile = new File("res/sallySold.txt");
//		File myFile = new File("res/inputFile.txt");
//		File myFile = new File("res/despicableMe.txt");		
		Scanner fileScanner = null;
		try 
		{
			fileScanner = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found.");
			System.exit(0);
		}
		
		MyHashmap theMap = new MyHashmap(hashmapSize);
		
		while(fileScanner.hasNext())
		{
			String theInput = fileScanner.next();
			
			theInput = theInput.toLowerCase();
			theInput = theInput.replaceAll("[<>;.?!@#$%^&*():\",\']","" );
			theInput = theInput.trim();

			
			theMap.callDictionary(theInput);
		}

			
		System.out.println("The Dictionary: \n" + theMap.printDictionary());
		
		
		
		
		
	}

}
