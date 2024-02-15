
public class Animal {
	private String name;
	private int legNumber;
	private int age;
	private int pregnancyPerYear;
	private int numberOfOffSprings;
	
	
	Animal()
	{
		
	}
	
	Animal(String name,int age)
	{
		this.age=age;
		this.name=name;
	}
	
	public void sayGreeting()
	{
	System.out.println("Have nothing to say");
	}
	
	public void reproduce()
	{
		System.out.println("None of your bussines");
	}
	
	public String toString()
	{
		return "My name is "+name+"\nI am "+age+" years old"+"\nI have "+legNumber+" legs";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegNumber() {
		return legNumber;
	}

	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPregnancyPerYear() {
		return pregnancyPerYear;
	}

	public void setPregnancyPerYear(int pregnancyPerYear) {
		this.pregnancyPerYear = pregnancyPerYear;
	}

	public int getNumberOfOffSprings() {
		return numberOfOffSprings;
	}

	public void setNumberOfOffSprings(int numberOfOffSprings) {
		this.numberOfOffSprings = numberOfOffSprings;
	}
	
	public static void AnimalNumberDecrementer (String s)
	{
		if(s.equals("class Pig"))
		{
			Pig.decrementCount();
		}
		
		if(s.equals("class Raven"))
		{
			Raven.decrementCount();
		}
		
		if(s.equals("class Sheep"))
		{
			Sheep.decrementCount();
		}
		
		if(s.equals("class Chicken"))
		{
			Chicken.decrementCount();
		}
		
		if(s.equals("class Donkey"))
		{
			Donkey.decrementCount();
		}
		
		if(s.equals("class Horse"))
		{
			Horse.decrementCount();
		}
	}
	
	
	

}
