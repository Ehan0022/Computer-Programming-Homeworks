
public class Underware extends Clothing
{
	Underware(double basePrice)
	{
		super.setBasePrice(basePrice);
	}
	
	Underware()
	{
		this(30.0);
	}
	
	@Override
	public double calculatePrice()
	{;
		double a=super.getBasePrice()*super.getVat()+super.getBasePrice();
		a = a*4.5/10+a;
		return a;
	}
	
	@Override
	public void howToWash()
	{
		System.out.println("Wash Top at 60 degrees");
	}
}
