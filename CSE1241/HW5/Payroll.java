
public class Payroll 
{
	int workHour;
	int itemCount;
	
	Payroll(int workHour, int itemCount)
	{
		this.workHour=workHour;
		this.itemCount=itemCount;
	}
	
	
	
	public int calculateSalary()
	{
		int a=30*workHour+20*itemCount;
		return a;
	}
	
	public String toString()
	{
		return ("Work hour is "+workHour+" "+"and the produced item count is"+itemCount);
	}


	
	//getter and setters

	public int getWorkHour() {
		return workHour;
	}



	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}



	public int getItemCount() {
		return itemCount;
	}



	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	
}
