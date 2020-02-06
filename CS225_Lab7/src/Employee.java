import java.io.Serializable;
import java.text.DecimalFormat;

public class Employee extends UniqueObject implements Serializable
{
	/////////////////////////////////////////////////////
	//Fields
	private String firstName;
	private String lastName;
	protected double hourlyRate;
	protected int years;
	
	/////////////////////////////////////////////////////
	//Constructors
	public Employee()
	{
		firstName = "John";
		lastName = "Doe";
		hourlyRate = 9.0;
		years = 0;
	}
	public Employee(String fn, String ln, double hr, int y)
	{
		firstName = fn;
		lastName = ln;
		hourlyRate = hr;
		years = y;
	}
	
	/////////////////////////////////////////////////////
	//Getters/Setters
	protected String getFirstName() { return firstName;	}
	protected String getLastName() { return lastName; }
	protected double getHourlyRate() { return hourlyRate; }
	protected double getYears() { return years;	}
	protected double getYearlySalary() { return hourlyRate * 40D * 52D;	}
	
	/////////////////////////////////////////////////////
	//Other Methods
	protected void promote()
	{
		years++;
		hourlyRate *= 1.03;
	}
	
	public String toString()
	{
		DecimalFormat money = new DecimalFormat("$0.00");
		return firstName + " " + lastName 
				+ " (#" + this.getUniqueIdString() + ")"
				+ " has been with the company for " + years + " years"
				+ " and makes " + money.format(hourlyRate) + "/hr.";
	}
}
