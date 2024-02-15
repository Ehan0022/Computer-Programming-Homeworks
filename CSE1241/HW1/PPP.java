import java.util.Scanner;
//Calculates the profit within the PPP system
// Emirhan Türkol 150121050
public class PPP 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		// Gets the required information from the user
		System.out.println("What is your monthly salary ?");
		double sal = scanner.nextDouble();
		System.out.println("What is the percantage of you salary you would like to be saved ?");
		double por = scanner.nextDouble();
		System.out.println("What percantage is the monthly interest rate ?");
		double intr = scanner.nextDouble();
		System.out.println("What percantage is the government support rate ?");
		double gov = scanner.nextDouble();
		// Shortens the code
		double a = (sal*por/100);
		double b = (1+gov/100);
		double c = (1+intr/100);
		
		// Calculates the money that will be accumulated
		double first = a*b*c;
		double second = (first+a*b)*c;
		double third = (second+a*b)*c;
		double forth = (third+a*b)*c;
		double fifth =(forth+a*b)*c;
		double sixth =(fifth+a*b)*c;
		// Shows the amounts of money after ends of months
		System.out.println("After the first month your account value is: " +(int)(first*100)/100.00 );
		System.out.println("After the second month your account value is: " +(int)(second*100)/100.00 );
		System.out.println("After the third month your account value is: " +(int)(third*100)/100.00 );
		System.out.println("After the forth month your account value is: " +(int)(forth*100)/100.00 );
		System.out.println("After the fifth month your account value is: " +(int)(fifth*100)/100.00 );
		System.out.println("After the sixth month your account value is: " +(int)(sixth*100)/100.00) ;
		
		double profit = sixth-6*a;
		//Shows the profit
		System.out.println("In total you have saved "+(int)((6*a)*100)/100.00+ " you total profit is "+(int)(profit*100)/100.00);

	}

}
