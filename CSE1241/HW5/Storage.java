
public class Storage 
{
	int capacity;
	Item items[];
	static int r=0;
	
	public Storage(int capacity) 
	{
		this.capacity = capacity;
		items=new Item[capacity];
	}
	
	public void addItem(Item item)
	{
		items[r]=item;
		r++;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
	
	
}
