import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IllegalNameException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter the capacity of the animal farm");
		int capacity =scanner.nextInt();
		AnimalFarm farm = new AnimalFarm(capacity);
				
		int choice;
		
		do
		{
			System.out.println("");
			System.out.println("0 - Exit the program");
			System.out.println("1 - Add animal");
			System.out.println("2 - Remove animal");
			System.out.println("3 - Search animal");
			System.out.println("4 - Sort animals");
			System.out.println("5 - Calculate next year's population estimate");
			System.out.println("6 - Print all animal's movements");
			System.out.println("7 - Print all animal's eating habits");
			System.out.println("8 - Print report");
			System.out.print("Please enter your choice:");
			
			choice=scanner.nextInt();
			
			if(choice==1)
			{			
				System.out.println("1 - Chicken");
				System.out.println("2 - Donkey");
				System.out.println("3 - Horse");
				System.out.println("4 - Pig");
				System.out.println("5 - Raven");
				System.out.println("6 - Sheep");
				
				System.out.println("Please enter your choice");
				int animalChoice = scanner.nextInt();
				
				String animalName;
				System.out.println("Enter the Name");
				scanner.nextLine();
				animalName = scanner.nextLine();
				
				int animalAge;
				System.out.println("Enter the age");
				animalAge=scanner.nextInt();
				
				Animal animal=new Animal();
				
				switch(animalChoice)
				{
					case 1:
					animal	= new Chicken(animalName,animalAge);
						break;
					case 2:
						animal	= new Donkey(animalName,animalAge); 
						break;
					case 3:
						animal	= new Horse(animalName,animalAge);
						break;
					case 4:
						animal	= new Pig(animalName,animalAge);
						break;
					case 5:
						animal	= new Raven(animalName,animalAge);
						break;
					case 6:
						animal	= new Sheep(animalName,animalAge);
						break;
			}
			
			farm.addAnimal(animal);
		}
			
			if(choice==2)
			{
				String remove;
				System.out.println("Please enter the name of the animal you want to remove");
				scanner.nextLine();
				remove=scanner.nextLine();
				farm.removeAnimal(remove);
			}
			
			
			if(choice==3)
			{
				int search;
				System.out.println("1 - Search based on name");
				System.out.println("2 - Search based on age");
				search=scanner.nextInt();
				scanner.nextLine();
				
				if(search==1)
				{
					String s;
					System.out.print("Enter name:");
					s=scanner.nextLine();
					farm.searchBasedOnName(s);					
				}
				else if(search==2)
				{
					int a;
					System.out.println("Enter age:");
					a=scanner.nextInt();
					farm.searchBasedOnAge(a);
				}
			}
			
			
			if(choice==4)
			{
				System.out.println("1 - Sort based on age");
				System.out.println("2 - Sort based on leg number");
				System.out.println("3 - Sort based on age");
				System.out.println("4 - Sort based on addition date");
				
				System.out.print("Enter your choice:");				
				int a=scanner.nextInt();
				
				switch(a)
				{
				case 1:
					farm.sortBasedOnAge();
					break;
				case 2:
					farm.sortBasedOnLegNumber();
					break;
				case 3:
					farm.sortBasedOnAge();
					break;
				}
			}
			
			
			if(choice==5)
			{
				System.out.println("Next years population forecast is "+farm.nextYearPopulationForecast());
			}
			
			if(choice==6)
			{
				farm.animalMovements();
			}
			
			if(choice==7)
			{
				farm.eatingHabits();
			}
			
			if(choice==8)
			{
				System.out.println("Enter a file name");
				scanner.nextLine();
				String s=scanner.nextLine();
				farm.printReport(s);
			}
		
		
		}while(choice!=0);
	}

}
