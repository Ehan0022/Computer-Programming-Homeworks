//Emirhan Türkol 150121050
public class Factory 
{
	String name;
	Employee employees[];
	Storage storage;
	Payroll payrolls[]= {};
	double itemPrice;
	static int payI=0;
	static int addEmp=0;
	
	public Factory(String name, double itemPrice, int a) 
	{
		this.name = name;
		this.itemPrice = itemPrice;
		storage =new Storage(a);
	}
	
	
	public void addEmployee(Employee employee)
	{
		if(addEmp==0)
		{
			employees=new Employee[Employee.numberOfEmpLoyees];
			addEmp++;
		}
		if(addEmp==1)
		{
			Employee temp[]=new Employee[Employee.numberOfEmpLoyees];
			System.arraycopy(employees,0,temp,0,employees.length);
			employees=temp;
		}
		
		
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i]==null)
			{
				employees[i]=employee;
			}
		}
		
		for(int i=0; i<employee.items.length; i++)
		{
			storage.addItem(employee.startShift()[i]);
		}
				
	}
	
	public Employee removeEmployee(int id)
	{
		Employee temp=new Employee();
		if(employees==null)
		{
			System.out.println("There are no employees");
		}
		else
		{
		for(int i=0; i<employees.length; i++)
		{
			if(employees[i].getId()==id)
			{
				addPayroll(employees[i].endShift());
				temp=employees[i];
				employees[i]=null;
			}
			else
			{
				System.out.println("There is no such employee with the given id");
			}
		}
		}
		
		return temp;
		
	}
	
	public double getRevenue()
	{
		return storage.items.length*itemPrice;
	}
	
	public double getPaidSalaries()
	{
		int a=0;
		for(int i=0; i<payrolls.length; i++)
		{
			a=a+payrolls[i].calculateSalary();
		}
		double b=(double)a;
		return b;
	}
	
	private void addPayroll (Payroll payroll)
	{
		Payroll temp1[];
		temp1=payrolls;
		Payroll payrolls[]=new Payroll[Employee.numberOfEmpLoyees];
		System.arraycopy(temp1,0,payrolls,0,temp1.length);
		
		payrolls[payI]=payroll;
		payI++;
		
	}
	
	
	
	
	
}
