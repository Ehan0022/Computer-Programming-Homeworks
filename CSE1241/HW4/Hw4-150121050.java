//Emirhan Türkol 150121050

import java.util.Scanner;
//This program takes a string, either converts it to upper case; counts the repetitions of a given word; prints in a way that user decides or lets you know how many letters and words are used.
public class Methods 
{

	public static void main(String[] args) 
	{
		Scanner scanner= new Scanner(System.in);
		//Variables for loops and statistics method
		int opt;
		int letters=0;
		int words=0;
		String seq;
		
		do
		{		
			System.out.println("Menu:");
			System.out.println("1-Change Case");
			System.out.println("2-Count Occurances");
			System.out.println("3-Encryption");
			System.out.println("4-Statistics");
			System.out.println("5-Exit");
			System.out.println("Choose an operation");
			
			opt=scanner.nextInt();
			scanner.nextLine();
			
			//Converts the given string to fully uppercase
			if(opt==1)
			{
				System.out.println("Enter a word or a sentence");
				seq=scanner.nextLine();
				System.out.println(ChangeCase(seq));
				letters=letters+StatisticsL(seq);
				words=words+StatisticsW(seq);
			}
			//Counts the amount of times a word which user chooses repeats
			else if(opt==2)
			{
				System.out.println("Enter a word or a sentence");
				seq = scanner.nextLine();
				
				System.out.println("Enter a word");
				String input=scanner.nextLine();
				
				System.out.println("This word repeats "+CountOccur(seq,input)+" times");
				letters=letters+StatisticsL(seq);
				words=words+StatisticsW(seq);
			}
			//Prints the given string in an order that user chooses
			else if(opt==3)
			{
				System.out.println("Enter a word or a sentence");
				seq=scanner.nextLine();
				System.out.println("Choose an integer pattern");
				int pattern = scanner.nextInt();
				Encryption(seq, pattern);
				letters=letters+StatisticsL(seq);
				words=words+StatisticsW(seq);
			}
			//Prints the amount of letters and words that are used so far in the program
			else if(opt==4)
			{
				System.out.println("The number of words: "+words);
				System.out.println("The number of letters: "+letters);
			}
	}while(opt!=5);		
		System.out.println("Program ends, Bye:0)");
}
	
	
	public static String ChangeCase (String s)
	{
		
		char ch=' ';
		String a="";
		//Updates the value of each letter to Upper case or Lower case
		for(int i=0; i<s.length(); i++)
		{
			if(Character.isLowerCase(s.charAt(i)))
			{
				ch=Character.toUpperCase(s.charAt(i));
			}
			else if(s.charAt(i)==' ')
			{
				ch=' ';
			}
			else
			{
				ch=Character.toUpperCase(s.charAt(i));
			}
			a = a + ch;
		}
		return a;
	}
	
	public static int CountOccur (String s, String input)
	{
		//Calculates the amount of blank characters
		int BlankCount =0;
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ')
			{
				BlankCount++;
			}
		}
		//Assigns the index of the blank character to an array
		int [] BlankIndex = new int[BlankCount+1];
		int first=0;
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ')
			{
				BlankIndex[first]=i;
				first++;
			}
		}
		
		int occur=0;
		int n=0;
		int k=0;
		int y=BlankIndex[k];
		String a;
		//Counts the occurance of words using sub-string method
		for (int i=0; i<BlankCount+1; i++)
		{
			if(k<BlankCount)
			{
				a=s.substring(n,y);
				if (a.equalsIgnoreCase(input))
					{
						occur++;
					}
				n=BlankIndex[k]+1;
				k++;
				y=BlankIndex[k];
			}
			else
			{
				a=s.substring(n);
				if(a.equalsIgnoreCase(input))
					{
						occur++;
					}
			}
		}
		return occur;
	}
	
	
	public static void Encryption (String s, int input)
	{
		//Makes the given string uppercase
		s=ChangeCase(s);
		//Counts the amounts of blanks
		int BlankCount =0;
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ')
			{
				BlankCount++;
			}
		}
		
		int [] BlankIndex = new int[BlankCount+1];
		int first=0;
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ')
			{
				BlankIndex[first]=i;
				first++;
			}
		}
		String b;
		String a="";
		int n=0;
		int k=0;
		int y=BlankIndex[k];
		//Makes words next to each other/Erases blanks
		for(int i=0; i<BlankCount+1; i++)
		{
			if(k<BlankCount)
			{
			 b=s.substring(n,y);
			n=y+1;
			k++;
			y=BlankIndex[k];
			}
			else
			{
			 b=s.substring(n);
			}
			a = a+b;
		}
		//Creates a multi-dimensional array to store the chars of the string
		char[][]table= new char[input][a.length()];
		//Assigns the chars to array with a zigzag pattern
		int j=0;
		int way=0;
		for(int i=0; i<a.length(); i++)
		{
			table[j][i]=a.charAt(i);
			if(way%2==0)
			{
				j++;
			}
			else
			{
				j--;
			}
		
			if(j==input-1)
			{
				way++;
			}
			else if(j==0)
			{
				way++;
			}	
		}	
		//Prints the final string
		for(int i=0; i<input; i++)
		{
			for(int t=0; t<a.length(); t++)
			{
				if(table[i][t]!='\u0000')
				{
					System.out.print(table[i][t]);
				}
			}
		}
		System.out.println();
	}
	
	public static int StatisticsW (String s)
	{
		//Calculates the amount of blanks in the string and adds 1, which equals to number of words
		int blank=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ')
			{
				blank++;
			}
		}
		blank++;
		return blank;
	}
	
	public static int StatisticsL (String s)
	{
		//Counts the number of letters bye not counting blanks
		int letters=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)!=' ')
			{
				letters++;
			}
		}
		return letters;
	}
}

