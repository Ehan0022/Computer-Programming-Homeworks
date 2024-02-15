
public class Employee 
{
	int id;
	String name;
	String surname;
	int workHour;
	int speed;
	Item items[];
	Payroll payroll;
	static int numberOfEmpLoyees=0;
	
	public Employee(int id, String name, String surname, int workHour, int speed) 
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
		int numberOfItems=speed*workHour;
		items=new Item[numberOfItems];
		
	}
	
	Employee()
	{
		
	}
	
	
	
	public Item[] startShift()
	{
		Item[] temp=new Item[speed*workHour];
		for(int i=0; i<speed*workHour; i++)
		{
			int randoID=(int)(Math.random()*101);
			temp[i]=new Item(randoID);
		}
		items=temp;
		return temp;
		
	}
	
	public Payroll endShift()
	{
		Payroll p1=new Payroll(workHour,speed*workHour);
		payroll=p1;
		return payroll;
	}
	
	public String toString()
	{
		return("This is the employee with the id"+id+" "+"speed "+speed+". The work hour is "+workHour+" and the produced item count is"+(speed*workHour));  
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
	
}
