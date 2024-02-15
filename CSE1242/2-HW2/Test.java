//Emirhan Türkol 150121050
public class Test {

	public static void main(String[] args) 
	{
		ShoppingMall sm = new ShoppingMall();
		sm.addDairy();
		sm.addFruit();
		sm.addVegetable();
		sm.addTop();
		sm.addTrousers();
		sm.addUnderware();
		sm.addArbitrary(new Top(100));
		
		printContent(sm);
		printWashingInstructions(sm);
		System.out.println(sm.bill());
		
	}
	//This method calls the madeOf method of Vegan objects
	public static void printContent(ShoppingMall sm)
	{
		for(int i=0; i<sm.getItems().size(); i++)
		{
			if(sm.getItems().get(i) instanceof Vegetable)
			{
				Vegetable veg;
				veg = (Vegetable)sm.getItems().get(i);
				veg.madeOf();
			}
			
			if(sm.getItems().get(i) instanceof Fruit)
			{
				Fruit fruit;
				fruit = (Fruit)sm.getItems().get(i);
				fruit.madeOf();
			}			
		}
	}
	//This method calls the howToWash method of the washable objects
	public static void printWashingInstructions(ShoppingMall sm)
	{
		for(int i=0; i<sm.getItems().size(); i++)
		{
			if(sm.getItems().get(i) instanceof Vegetable)
			{
				Vegetable veg;
				veg = (Vegetable)sm.getItems().get(i);
				veg.howToWash();
			}
			if(sm.getItems().get(i) instanceof Fruit)
			{
				Fruit fruit;
				fruit = (Fruit)sm.getItems().get(i);
				fruit.howToWash();
			}
			if(sm.getItems().get(i) instanceof Top)
			{
				Top top = new Top();
				top = (Top)sm.getItems().get(i);
				top.howToWash();
			}
			if(sm.getItems().get(i) instanceof Trousers)
			{
				Trousers tr = new Trousers();
				tr = (Trousers)sm.getItems().get(i);
				tr.howToWash();
			}
			if(sm.getItems().get(i) instanceof Underware)
			{
				Underware uw = new Underware();
				uw = (Underware)sm.getItems().get(i);
				uw.howToWash();						
			}
		}						
	}
	
	
	
}





















