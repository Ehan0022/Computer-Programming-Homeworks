
public class Sheep extends Mammal
{
	public static int count;
	
	Sheep(String name,int age)
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
		System.out.println("Four legs good, two legs better");
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
