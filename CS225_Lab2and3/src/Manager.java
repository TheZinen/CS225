import java.util.ArrayList;

/* CS 225 - Intro to Computer Science
 * File Name: Manager.java
 * Java Programming
 * Lab 3 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: FirstName1 LastName1
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for Lab 3, for the Manager class.
 */

///////////////////////////////////////////////////////////////////////////////
// INSTRUCTIONS: Update the header above EACH LAB with the correct due date,
// first/last names (remove the "Name 2" line if working alone) and description
// for this specific lab. You should also update the first/last names and problem
// number (if relevant) below in the "System.out.println" statement at the beginning
// of the "main()" method. Failure to do so will result in lost points. DO NOT change
// the name of the class or the autograder will give you 0 points.
//
// PHILOSOPHY: Lab is a chance to "get your feet wet" in a safe environment as it
// will be the first time you'll be trying to program new concepts. Thus, as you'll
// see below, the collaboration rules for LABS are very generous since the main idea
// is for you to learn programming with a lot of resources. To foster this 
// environment, you'll have access to a programming partner of your choice, your peers,
// experienced lab technicians and your instructor.
//
// COLLABORATION: Students may officially work with ONE (1) partner. Both names should
// be listed in the header and in the initial "System.out.println()" statement. When
// you submit your lab, only one partner should submit it (again, make sure both names
// are on all files). Students MAY seek advice and look at other students' code DURING
// lab for tips (including students who are not your direct partner), but may NOT
// copy/paste code from students other than your official partner.
//
// FINISHING & GRADING: Lab assignments must be performed in the Computer Science
// Laboratory each week. You are required to attend every lab session. Labs usually
// consist of several book problems (sometimes there are none) and 1-2 code problems.
// The book problems and code should both be turned in when fully completed. 
//
// When you finish a code problem during lab, you will demonstrate your working program
// to the instructor or to a lab-tech/TA on duty and you and the instructor will both
// sign off on that problem. At that point, you will receive full credit for that problem.
// If you did not finish one or more code problems by the end of lab, you may sign off with
// an instructor/lab-tech/TA during the last 15 minutes of lab; in this event, you will not
// be deducted points for not finishing on time, but will be graded based on your final
// submission. Book problems will always be graded via the submission and will not be checked
// off during lab.
//
// If you do not finish your lab assignment during the lab period, you and your partner may
// only seek help with your code from lab technicians (available whenever the lab is open)
// and the instructor to aid with any confusion; please refer to posted lab times at the
// entrance of the Main Computer Lab to see when lab techs and computers are available.
// You may also complete the labs on your own machine if yo'd like (this is preferable).
///////////////////////////////////////////////////////////////////////////////
public class Manager extends Employee
{
	// Default Array
	private ArrayList<Employee>managedEmployees = new ArrayList <Employee>();

	// Default Constructor
	public Manager()
	{
		managedEmployees.clear();
	}
	
	// Overloaded Constructor
	public Manager(String fn, String ln, double hr, double y)
	{
		super(ln, fn, hr, y);
		managedEmployees.clear();
	}

	// To add an employee
	public void addEmployee(Employee e)
		{managedEmployees.add(e);}

	// To remove an employee
	public void removeEmployee(long id)
		{managedEmployees.remove(id);}
	
	// Increases hourlyRate 5% & adds $0.25 for each employee
	public void promote(){
		years++;
		hourlyRate = hourlyRate + hourlyRate * .05 + (.25 * 6);
	}
}
