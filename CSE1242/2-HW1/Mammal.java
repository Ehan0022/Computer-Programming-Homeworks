
public class Mammal extends Animal
{
	Mammal(String name, int age)
	{
		super(name,age);
	}
	
	public void walk()
	{
		System.out.println("I can walk to the far away lands");
	}
	
	public void reproduce()
	{
		System.out.println("I give birth!");
	}
	
	public void herbivore()
	{
		System.out.println("I eat plants only!");
	}
	
	
}
