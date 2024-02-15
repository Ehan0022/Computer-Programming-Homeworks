
public class Pig extends Mammal
{
	public static int count;
	
	Pig(String name,int age)
	{
		super(name,age);
		super.setLegNumber(4);
		super.setNumberOfOffSprings(12);
		super.setPregnancyPerYear(2);
		count++;
	}
	
	@Override
	public void sayGreeting()
	{
		System.out.println("All animals are equal, but some animals are more equal than others");
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public static void decrementCount()
	{
		count--;
	}
}
