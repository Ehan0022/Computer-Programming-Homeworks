
public class Donkey extends Mammal
{
	static int count;
	
	Donkey(String name, int age)
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
		System.out.println("Life will go on as it has always gone -that is, badly!");
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
