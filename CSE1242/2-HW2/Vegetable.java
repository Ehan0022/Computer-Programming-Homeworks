
public class Vegetable extends Food implements Vegan,Washable
{

	Vegetable(double basePrice)
	{
		super.setBasePrice(basePrice);
	}
	
	Vegetable()
	{
		this(10.0);
	}
	
	@Override
	public double calculatePrice()
	{;
		double a=super.getBasePrice()*super.getVat()+super.getBasePrice();
		a = a*2.5/10+a;
		return a;
	}
	
	@Override
	public void howToWash()
	{
		System.out.println("Wash vegetable with warm water");
	}
	
	
	@Override
	public void madeOf()
	{
		System.out.println("It is only made of vegetables");
	}
}
