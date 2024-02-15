//Emirhan Türkol 150121050
import java.util.Scanner;

public class Printer 
{
	//This program prints the given string in a specific order to make a rectangle shaped graph
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your sequence, Write 'QUIT' to exit the program");
		String s = scanner.nextLine();
		String quit ="quit";
		while (!s.equalsIgnoreCase(quit))
		{
		theTop(s);
		theBot(s);
		System.out.println("Enter your sequence, Write 'QUIT' to exit the program");
		 s = scanner.nextLine();
		}
		if (s.equalsIgnoreCase(quit))
		{
			System.out.println("OK. Good Bye :-)");
		}
	}
	
	//This method prints the top left of the sequence
	public static void theTop (String s)
	{
		int b=s.length();
		int a=s.length();
		//The outer loop
		for (int i=0; i<s.length(); i++)
		{
			//Prints the given string in decreasing order from the end of it
			for (int j=0; j<a; j++)
			{
				System.out.print(s.charAt(j));
			}
			//Prints blanks in places where letters are absent
			for(int k=s.length(); a<k; k--)
			{
				System.out.print(" ");
			}
			a--;
			//Prints blanks in places where letters are absent
			for(int k=s.length(); b<k; k--)
			{
				System.out.print(" ");
			}
			b--;
			//Prints the given string in decreasing order from the start
			for(int z=i; z<s.length(); z++)
			{
				System.out.print(s.charAt(z));
				
			}
			//Starts the next line
			System.out.println();
		}
	}
	
	//Prints the bottom left
	public static void theBot (String s)
	{
		//Variables used in loops
		int a=1;
		int b=s.length()-1;
		int c=s.length()-1;
		int d=s.length();
		int t=s.length()-1;
		//Prints the string in increasing order from left to right
		for (int i=1; i<s.length()+1; i++)
		{
			for (int j=0; j<a; j++)
			{
				System.out.print(s.charAt(j));
			}
			if (a!=s.length())
			{
				a++;
			}
			//Prints blanks
			for(int k=0; k<b; k++)
			{
				System.out.print(" ");
			}
			b--;
			//Prints blanks
			for(int k=0; k<c; k++)
			{
				System.out.print(" ");
			}
			c--;
			//Prints the given string in decreasing order 
			for(int m=t; m<d; m++)
			{
				System.out.print(s.charAt(m));
			}
			t--;
			
			System.out.println();
		}
	}
}


