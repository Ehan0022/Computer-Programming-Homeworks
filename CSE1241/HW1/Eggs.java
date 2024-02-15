//Divides the amount off eggs to smaller variables
// Emirhan Türkol 150121050
import java.util.Scanner;


public class Eggs 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many eggs do you have?");
		// Takes input about starting number of eggs from the user 
		int eggs = scanner.nextInt();
		// Calculates the required variables
		int gross = eggs/144;
		int dozens = (eggs%144)/12;
		int other = eggs-gross*144-dozens*12;
		//Shows the user the results
		System.out.println("Your number of eggs is " +gross+ " gross " +dozens+ " dozens " +other+ " eggs ");
	

	}

}
