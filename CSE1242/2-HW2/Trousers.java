
public class Trousers extends Clothing
{
	Trousers(double basePrice)
	{
		super.setBasePrice(basePrice);
	}
	
	Trousers()
	{
		this(40.0);
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
		System.out.println("Wash Top at 30 degrees");
	}
}
