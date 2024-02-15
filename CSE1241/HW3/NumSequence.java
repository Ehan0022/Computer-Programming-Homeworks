//Emirhan Türkol 150121050
import java.util.Scanner;

public class NumSequence 
{
	//This program calculates the number that user in the sequence
	public static void main(String[] args) 
	{
		//Take the required input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number n for the sequence A(n)=4*A(n-1)+A(n-2)");
		int n = scanner.nextInt();
		int first =0;
		int second= 1;
		
		int sum=0;
		//Calculates the result
		for (int i=0; i<n-2; i++)
		{
			sum = -first+4*second;
			first = second;
			second = sum;
		}
		System.out.println("The "+n+"th number in the sequence is "+sum);
	}

}
