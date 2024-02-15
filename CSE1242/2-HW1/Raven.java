
public class Raven extends Bird
{
	public static int count;
	
	Raven(String name,int age)
	{
		super(name,age);
		super.setLegNumber(2);
		super.setNumberOfOffSprings(5);
		super.setPregnancyPerYear(1);
		count++;
	}
	
	@Override
	public void sayGreeting()
	{
		System.out.println("A happy country where we poor animals shall rest forever");
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