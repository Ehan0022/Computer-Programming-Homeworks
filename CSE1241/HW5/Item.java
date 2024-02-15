
public class Item 
{
	private int id;
	static int numberOfItems=0;
	
	Item(int id)
	{
		this.id=id;
		numberOfItems++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
