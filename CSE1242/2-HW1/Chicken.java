
public class Chicken extends Bird
{
	static int count;
	
	Chicken(String name, int age)
	{
		super(name,age);
		super.setLegNumber(2);
		super.setNumberOfOffSprings(1);
		super.setPregnancyPerYear(200);
		count++;
	}
	
	@Override
	public void sayGreeting()
	{
		System.out.println("I have nothing to say other than I am against the pigs!");
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
