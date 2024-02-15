
public class Top extends Clothing
{
	Top(double basePrice)
	{
		super.setBasePrice(basePrice);
	}
	
	Top()
	{
		this(20.0);
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
		System.out.println("Wash Top at 40 degrees");
	}
}
