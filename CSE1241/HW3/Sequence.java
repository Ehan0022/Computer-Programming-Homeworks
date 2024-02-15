//Emirhan Türkol 150121050
import java.util.Scanner; 
public class Sequence 
{
	//This program prints a custom pattern using '*' and ' ' and new lines
	public static void main(String[] args)
	{
		//Takes input for loops
		System.out.println("Enter your sequence");
		Scanner scanner = new Scanner(System.in);
		String seq = scanner.nextLine()+" ";
		//The loop for checking characters in the string
		for(int i=0; i<seq.length()-1; i++)
		{
			//Checks the digit in front of the characters
			int fors=1;
			if(seq.charAt(i)<58 && seq.charAt(i)>48)
			{
				fors = (seq.charAt(i)-48);
			}
			//Checks if the next char is b and prints blanks
			if (seq.charAt(i+1)=='b')
			{
				for(int j=0; j<fors; j++)
				{
					System.out.print(" ");
				}
			}
			//Checks if the next char is s and prints stars
			if (seq.charAt(i+1)=='s')
			{
				for(int k=0; k<fors; k++)
				{
					System.out.print("*");
				}
			}
			//Checks if the next char is n and prints a new line
			if (seq.charAt(i+1)=='n')
			{
				for(int z=0; z<fors; z++)
				{
					System.out.println();
				}
			}	
		}
		
	}
}
