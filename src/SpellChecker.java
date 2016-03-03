import java.util.Scanner;


/**
 * Spell check the input word
 * @author George Chen
 * @version 1.0
 */
public class SpellChecker 
{
	/**
	 * Main method for class SpellChecker
	 * @param args
	 */
	public static void main(String[] args)
	{
		String word; // word input
		String correction; // word suggestion
		boolean match = false;
		WordList wordlist = new WordList(); // create object WordList
		String[] list = wordlist.getArray(); // create array with words
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Please enter a word:");
			word = input.nextLine();
		
			// check if input in the word list
			for(int i=0;i<list.length;i++)
			{
				if(list[i].equals(word))
					match = true;
			} // end for loop
		
			if(match)
			{
				System.out.println("Word is spelled correctly.\n");
				match = false;
			}
			else if(!match)
			{
				System.out.println("Word is not spelled correctly.\n");
				correction = check(list,word);
				System.out.printf("Did u mean '%s'?\n", correction);
			
			}
		
		
		} // end while loop
	} // end main method
	
	/**
	 * 
	 * @param list English word list
	 * @param word Input word
	 * @return temp word suggestion
	 */
	public static String check(String[] list, String word)
	{
		
		String temp = "";
		int wordlength = word.length();
		String[] combo = new String[wordlength-1]; // word suggestions 
		char[] wordchar = word.toCharArray();
		char a1;		
		int i=0;
		int j=0;
		
		for(i=0;i<wordlength-1;i++)
		{
			// switch adjacent letter
			a1 = wordchar[i];
			wordchar[i] = wordchar[i+1];
			wordchar[i+1] = a1; 
			
			// store different combination of words 
			combo[i] = new String(wordchar);
			
			// switch back letters
			wordchar[i+1] = wordchar[i];
			wordchar[i] = a1;
		} // end for loop
		
		i=0; // reset counter
		
		// check if match in the word list
		for(i=0;i<combo.length;i++)
		{
			for(j=0;j<list.length;j++)
			{
				if(combo[i].equals(list[j]))
				{
					temp = combo[i];
				}
				
			} // end for loop
		} // end for loop
		
		
		return temp;
	} // end method check
	
} // end class SpellChecker
