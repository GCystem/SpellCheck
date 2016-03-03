import java.io.*;
import java.util.Scanner;


/**
 * Import the word list file 
 * @author George Chen
 * @version 1.0
 */
public class WordList 
{
	String[] list = new String[109582]; // String array storing words 
	
	/**
	 * WordList constructor
	 */
	public WordList()
	{
		File file = new File("c:\\SpellChecker/wordsEn.txt"); // create file
		int i=0;
		
		try
		{
			Scanner input = new Scanner(file);  // Scanner to input the file
			while(input.hasNext())
			{
				list[i] = input.next();
				i++;				
			} // end while loop
			 
		} // end try
			
		catch(FileNotFoundException e)
		{
			System.out.println("Error Opening File\n");
		} // end catch 
			
	} // end constructor WordList
	
	/**
	 * Get the array of strings containing words
	 * @return list the word list
	 */
	public  String[] getArray()
	{
		return list;
	} // end method getArray
	
} // end class WordList
