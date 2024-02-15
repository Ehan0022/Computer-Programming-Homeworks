//Emirhan Türkol 150121050
//It is a class that overrides the methods of Food interface
public class Dairy extends Food
{	
	Dairy(double basePrice)
	{
		super.setBasePrice(basePrice);
	}
	
	Dairy()
	{
		this(8.0);
	}
	
	@Override
	public double calculatePrice()
	{;
		double a=super.getBasePrice()*super.getVat()+super.getBasePrice();
		a = a*3/10+a;
		return a;
	}
}
