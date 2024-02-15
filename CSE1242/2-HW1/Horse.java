
public class Horse extends Mammal
{
	public static int count;
	
	Horse(String name,int age)
	{
		super(name,age);
		super.setLegNumber(4);
		super.setNumberOfOffSprings(1);
		super.setPregnancyPerYear(1);
		count++;
	}
	
	@Override
	public void sayGreeting()
	{
		System.out.println("I will work harder");
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
