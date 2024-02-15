
public class Fruit extends Food implements Vegan,Washable
{
	Fruit(double basePrice)
	{
		super.setBasePrice(basePrice);
	}
	
	Fruit()
	{
		this(6.0);
	}
	
	@Override
	public double calculatePrice()
	{;
		double a=super.getBasePrice()*super.getVat()+super.getBasePrice();
		a = a*2/10+a;
		return a;
	}
	
	@Override
	public void howToWash()
	{
		System.out.println("Wash fruit with cold water");
	}
	
	
	@Override
	public void madeOf()
	{
		System.out.println("It is only made of fruits");
	}
	
}
