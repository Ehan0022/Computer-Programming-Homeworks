import java.util.ArrayList;

public class ShoppingMall 
{
	private ArrayList<Item> itemList= new ArrayList<Item>();

	public ArrayList<Item> getItems() 
	{
		return itemList;
	}
	
	public void addDairy()
	{
		itemList.add(new Dairy());
	}
	
	public void addFruit()
	{
		itemList.add(new Fruit());
	}
	
	public void addVegetable()
	{
		itemList.add(new Vegetable());
	}
	
	public void addTop()
	{
		itemList.add(new Top());
	}
	
	public void addTrousers()
	{
		itemList.add(new Trousers());
	}
	
	public void addUnderware()
	{
		itemList.add(new Underware());
	}
	
	public void addArbitrary(Item item)
	{
		itemList.add(item);
	}
	
	public double bill()
	{
		double total =0;
		for(int i=0; i<itemList.size(); i++)
		{
			total += itemList.get(i).calculatePrice();
		}
		
		return total;
	}
	
	
	
	
	
	
	
	
	
	
}
