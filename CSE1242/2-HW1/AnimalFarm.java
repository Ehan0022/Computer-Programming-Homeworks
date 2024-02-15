import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AnimalFarm 
{
	public ArrayList<Animal> animalList=new ArrayList<>();
	ArrayList<String> animalNames=new ArrayList<>();
	private int capacity;
	private static int numberOfAnimals=0;
	
	AnimalFarm(int capacity)
	{
		this.capacity=capacity;
	}

	public static int getNumberOfAnimals() {
		return numberOfAnimals;
	}
	
	//Takes an Animal as input and adds it to the farm objects arraylist. Throws an exception if user enters a name that is used already
	public boolean addAnimal(Animal animal) throws IllegalNameException
	{
		boolean NoSameName=true;
		for (int i=0; i<animalList.size(); i++)
		{
			if(animal.getName().equals(animalList.get(i).getName()))
			{
				NoSameName=false;
			}
		}
		
		if(NoSameName==true&&numberOfAnimals<capacity)
		{
			animalList.add(animal);
			animalNames.add(animal.getName());
			numberOfAnimals++;
		}
		else 
		{
			throw new IllegalNameException("An animal with this name exists");
		}
		return NoSameName;	
	}
	//Removes the specified animal, decrements the count of the animal
	public boolean removeAnimal(String name)
	{
		boolean result=false;
		String s ="";
		
		for(int i=0; i<animalList.size(); i++)
		{
			if(name.equals(animalList.get(i).getName()))
			{
				result=true;
				s=animalList.get(i).getClass().toString();
				animalList.remove(i);
				animalNames.remove(i);	
				numberOfAnimals--;
			}
		}
		//Count decrement
			Animal.AnimalNumberDecrementer(s);
			return result;
	}
	
	//Prints the greeting of one animal
	public void printOneAnimalGreeting(Animal animal)
	{
		animal.sayGreeting();
	}
	//Prints all animals greetings
	public void printAllAnimalGreetings()
	{
		for(int i=0; i<animalNames.size(); i++)
		{
			printOneAnimalGreeting(animalList.get(i));
		}
	}
	//Takes an Animal as input and prints the given animals Name
	public void printOneAnimalName(Animal animal)
	{
		System.out.println(animal.getName());
	}
	//Prints all animals names
	public void printAllAnimalNames()
	{
		for(int i=0; i<animalList.size(); i++)
		{
			printOneAnimalName(animalList.get(i));
		}
	}
	//Prints the properties of all animals using its toString method
	public void printAllAnimals()
	{
		for(int i=0; i<animalList.size(); i++)
		{
			System.out.println(animalList.get(i).toString());
		}
	}
	//Calculates the next years population forceast
	public int nextYearPopulationForecast()
	{
		int babies=0;
		for(int i=0; i<animalList.size(); i++)
		{
			babies+=animalList.get(i).getNumberOfOffSprings()*animalList.get(i).getPregnancyPerYear();
		}
		return babies;
	}
	
	//Prints the movement pattern of animals, makes a distinction with if statements between Mammals and Birds
	public void animalMovements()
	{
		Bird tempBird;
		Mammal tempMammal;
		
		for(int i=0; i<animalList.size(); i++)
		{
			if(animalList.get(i).getClass().getSuperclass().toString().equals("class Bird"))
			{				
				tempBird=(Bird)animalList.get(i);
				tempBird.fly();
			}
			else if(animalList.get(i).getClass().getSuperclass().toString().equals("class Mammal"))
			{
				tempMammal=(Mammal)animalList.get(i);
				tempMammal.walk();
			}
		}
	}
	//Prints the eating habits of all animals with a distinciton between birds and mammals
	public void eatingHabits()
	{
		Bird tempBird;
		Mammal tempMammal;
		
		for(int i=0; i<animalList.size(); i++)
		{
			if(animalList.get(i).getClass().getSuperclass().toString().equals("class Bird"))
			{				
				tempBird=(Bird)animalList.get(i);
				tempBird.omnivore();
			}
			else if(animalList.get(i).getClass().getSuperclass().toString().equals("class Mammal"))
			{
				tempMammal=(Mammal)animalList.get(i);
				tempMammal.herbivore();
			}
		}
	}
	//Sorts animal names alphabetticaly by checking their first initials bye the alphabet
	public void sortAlphabetically()
	{
		String[] tempArray=new String[animalNames.size()];
		for(int i=0; i<animalNames.size(); i++)
		{
			tempArray[i]=animalNames.get(i);	
		}
		
		for(int i=97; i<123; i++)
		{
			for(int b=0; b<tempArray.length; b++)
			{
				if(tempArray[b].toLowerCase().charAt(0)==i)
				{
					System.out.println(tempArray[b]);
				}
			}
		}
	}
	//Prints the animals in ascending order in relation with the amount of legs they have
	public void sortBasedOnLegNumber()
	{
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<animalList.size(); j++)
			{
				if(animalList.get(j).getLegNumber()==i)
				{
					System.out.println(animalList.get(j).getName()+" has "+animalList.get(j).getLegNumber()+" legs.");
				}
			}
		}
	}
	//Finds out the oldest member and sets the for loop to end at that member than prints them in ascending order
	public void sortBasedOnAge()
	{
		int biggest=0;
		int[] tempArray=new int[animalList.size()];
		for(int i=0; i<animalList.size(); i++)
		{
			tempArray[i]=animalList.get(i).getAge();
		}
		Arrays.sort(tempArray);
		biggest=tempArray[tempArray.length-1];
			
		for(int i=0; i<=biggest; i++)
		{
			for(int j=0; j<animalList.size(); j++)
			{
				if(animalList.get(j).getAge()==i)
				{
					System.out.println(animalList.get(j).getName()+" is "+animalList.get(j).getAge()+" years old.");
				}
			}
		}
	}
	//Searches a specific animal with an specific age
	public void searchBasedOnAge(int age)
	{
		for(int i=0; i<animalList.size(); i++)
		{
			if(animalList.get(i).getAge()==age)
			{
				System.out.println(animalList.get(i).getName()+" "+animalList.get(i).getAge());
			}
		}
	}
	//Searches an animal with an specific name
	public void searchBasedOnName(String name)
	{
		for(int i=0; i<animalList.size(); i++)
		{
			if(animalList.get(i).getName().equals(name))
			{
				System.out.println(animalList.get(i).toString());
			}
		}
	}
	//Creates a txt file and makes a summary of the farm to that file
	public void printReport(String fileName)
	{	
		
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write("We have a total of "+(Chicken.count+Horse.count+Pig.count+Raven.count+Sheep.count+Donkey.count)+" animals in the farm\n");
			writer.append("\n");
			writer.append(Chicken.count+" of them are Chicken. Those are:\n");
			writer.append("Name,Age,Leg Number\n");
			
			
				for(int j=0; j<animalList.size(); j++)
				{
					if(animalList.get(j) instanceof Chicken)
					{
						writer.append(animalList.get(j).getName()+","+animalList.get(j).getAge()+","+animalList.get(j).getLegNumber()+"\n");
					}
				}
				writer.append("\n");
				
				writer.append(Donkey.count+" of them are Donkeys. Those are:\n");
				writer.append("Name,Age,Leg Number\n");
				
					for(int j=0; j<animalList.size(); j++)
					{
						if(animalList.get(j) instanceof Donkey)
						{
							writer.append(animalList.get(j).getName()+","+animalList.get(j).getAge()+","+animalList.get(j).getLegNumber()+"\n");
						}
					}
					writer.append("\n");
					
					writer.append(Horse.count+" of them are Horses. Those are:\n");
					writer.append("Name,Age,Leg Number\n");
					
						for(int j=0; j<animalList.size(); j++)
						{
							if(animalList.get(j) instanceof Horse)
							{
								writer.append(animalList.get(j).getName()+","+animalList.get(j).getAge()+","+animalList.get(j).getLegNumber()+"\n");
							}
						}
						writer.append("\n");
						
						writer.append(Pig.count+" of them are Pigs. Those are:\n");
						writer.append("Name,Age,Leg Number\n");
						
							for(int j=0; j<animalList.size(); j++)
							{
								if(animalList.get(j) instanceof Pig)
								{
									writer.append(animalList.get(j).getName()+","+animalList.get(j).getAge()+","+animalList.get(j).getLegNumber()+"\n");
								}
							}
							writer.append("\n");
							
							writer.append(Raven.count+" of them are Ravens. Those are:\n");
							writer.append("Name,Age,Leg Number\n");
							
								for(int j=0; j<animalList.size(); j++)
								{
									if(animalList.get(j) instanceof Raven)
									{
										writer.append(animalList.get(j).getName()+","+animalList.get(j).getAge()+","+animalList.get(j).getLegNumber()+"\n");
									}
								}
								writer.append("\n");
								
								writer.append(Sheep.count+" of them are Sheeps. Those are:\n");
								writer.append("Name,Age,Leg Number\n");
								
									for(int j=0; j<animalList.size(); j++)
									{
										if(animalList.get(j) instanceof Sheep)
										{
											writer.append(animalList.get(j).getName()+","+animalList.get(j).getAge()+","+animalList.get(j).getLegNumber()+"\n");
										}
									}	
									writer.append("\n");
									
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
}
































