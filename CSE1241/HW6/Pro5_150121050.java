//Emirhan Türkol 150121050
import java.util.Scanner;
public class BinaryFrame 
{

	public static void main(String[] args) 
	{
		//The variables that will be used after loop ends
		String[] upDec;
		int MinusCount =0;
		boolean loop;
		int steps;
		do
		{
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string");
		String s=scanner.nextLine();
		System.out.println("Enter the number of steps");
		steps=scanner.nextInt();
		
		
		MinusCount =0;
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='-')
			{
				MinusCount++;
			}
		}
		//Assigns the index of the blank character to an array
		int [] MinusIndex = new int[MinusCount+1];
		int first=0;
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='-')
			{
				MinusIndex[first]=i;
				first++;
			}
		}
		//updec contains numbers independently
		upDec = new String[MinusCount+1];
		
		String decimal ="";
		int k=0;
		int r=0;
		int n=MinusIndex[0];
		for(int i=0; i<MinusCount; i++)
		{
			decimal = s.substring(k,n);
			k=n+1;
			r++;
			n=MinusIndex[r];
			upDec[i]=decimal;
		}
		decimal =s.substring(k);
		upDec[MinusCount]=decimal;
		//Calculates the maximum value that array can take
		int q=1;
		int max=1;
		for(int i=0; i<upDec.length-q; i++)
		{
			max=max*2+1;
		}
		//If user enters a value bigger than max this for loop makes the loop run again
		loop=false;
		for(int i=0; i<upDec.length; i++)
		{
			int[]a=new int[upDec.length];
			a[i]=Integer.parseInt(upDec[i]);
			if(a[i]>max)
			{
				loop=true;
				System.out.println(upDec[i]+ " is too big for an "+upDec.length+"x"+upDec.length+" array");
			}
		}
	}while(loop);
		
		//The first table
		char[][] table= new char[upDec.length+2][upDec.length+2];
		
		String[] binary= new String[upDec.length+1];
		
		//Converts the given decimal string to a binary string
		for(int i=0; i<upDec.length; i++)
		{
			
			binary[i+1]=" "+DecToBin(upDec[i],upDec.length);
			
		}
		
		for(int i=1; i<upDec.length+1; i++)
		{
			for(int j=1; j<upDec.length+1; j++)
			{
				table[i][j]=binary[i].charAt(j);
			}
		}
		
		//Prints -'s according to length of array
		for(int i=0; i<upDec.length*2+1; i++)
		{
		System.out.print("-");
		}
		
		//Prints the initial array
		System.out.println();
		for(int i=1; i<upDec.length+1; i++)
		{
			System.out.print("|");
			for(int j=1; j<upDec.length+1; j++)
			{
				System.out.print(table[i][j]+"|");
			}
			System.out.println();
			for(int ğ=0; ğ<upDec.length*2+1; ğ++)
			{
			System.out.print("-");
			}
			System.out.println();
			
		}
		
		char[][] table2=new char[upDec.length+2][upDec.length+2];
		
		int endI=0;
		//This outer for loop takes the steps input
		for(int ş=1; ş<steps+1; ş++)
		{
		//This loop copies the content of our first array to the second one	
		for(int i=1; i<upDec.length+1; i++)
		{
			for(int j=1; j<upDec.length+1; j++)
			{
				table2[i][j]=table[i][j];
			}
		}
		//This loop checks the surroundings of every char in the array
		for(int i=1; i<upDec.length+1; i++)
		{
			
			for(int j=1; j<upDec.length+1; j++)
			{
				//These if statements calculates the amount of '1' chars neighboring them
				int count=0;
			if(table[i][j]=='1' || table[i][j]=='0')
			{
				if(table[i-1][j-1]=='1')
				{
					count++;
				}
				if(table[i-1][j]=='1')
				{
					count++;
				}
				if(table[i-1][j+1]=='1')
				{
					count++;
				}
				if(table[i][j-1]=='1')
				{
					count++;
				}
				if(table[i][j+1]=='1')
				{
					count++;
				}
				if(table[i+1][j-1]=='1')
				{
					count++;
				}
				if(table[i+1][j]=='1')
				{
					count++;
				}
				if(table[i+1][j+1]=='1')
				{
					count++;
				}
			}	
			//We change the values of our second array according to number of '1' chars
				if(table[i][j]=='1'&&(count==2||count==3))
				{
					table2[i][j]='1';
				}
				else if(table[i][j]=='1')
				{
					table2[i][j]='0';
				}
				
				if(table[i][j]=='0' && count==3)
				{
					table2[i][j]='1';
				}
				else if(table[i][j]=='0')
				{
					table2[i][j]='0';
				}	
			}	
			endI=ş;
		}
		
		
		System.out.println("It is converted to the following after the "+ş+"th step");
		
		for(int i=0; i<upDec.length*2+1; i++)
		{
		System.out.print("-");
		}
		System.out.println();
		//Prints the updated array as the next step in the program
		for(int i=1; i<upDec.length+1; i++)
		{
			System.out.print("|");
			for(int j=1; j<upDec.length+1; j++)
			{
				System.out.print(table2[i][j]+"|");
			}
			System.out.println();
			for(int ğ=0; ğ<upDec.length*2+1; ğ++)
			{
			System.out.print("-");
			}	
			System.out.println();
		}
		
		//Copies the updated version to the original version
		for(int i=1; i<upDec.length+1; i++)
		{
			for(int j=1; j<upDec.length+1; j++)
			{
				table[i][j]=table2[i][j];
			}
		}
		}
		
		//This code calculates decimal value of the binary numbers in the last step and prints them in this format: x-x-x......-x
		String end2="";
		String end="";
		for(int i=1; i<upDec.length+1; i++)
		{
			
			for(int j=1; j<upDec.length+1; j++)
			{
				end = end + table[i][j];
			}
			end=BinToDec(end);
			end2=end2+end+"-";
			
		}
		end2=end2.substring(0, end2.length()-1);
		System.out.println("The decimal value for the second table after "+endI+" steps: "+end2 );
	
	}

	//Changes decimal numbers to binary numbers
	public static String DecToBin (String s, int p)
	{
		int a=Integer.parseInt(s);
		String str="";
		do
		{
			str+=(a%2);
			a=a/2;
		}
		while(a!=0);
		
		String update="";
		
		for(int i=str.length(); 0<i; i--)
		{
			update+=str.charAt(i-1);
		}
		int y=update.length();
		for(int i=0; i<p-y; i++)
		{
			update ="0"+update;
		}
		return update;
	}
	//Changes binary numbers to decimal numbers
	public static String BinToDec (String str)
	{
		int decimal=0;
		int j=0;
		for(int i=str.length(); 0<i; i--)
		{
			if(str.charAt(i-1)=='1')
			{
				decimal+=Math.pow(2, j);
			}
			j++;
		}
		String update=decimal+"";
		return update;
	}
}
