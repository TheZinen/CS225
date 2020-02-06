import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/* CS 225 - Intro to Computer Science
 * File Name: CS225_Lab7.java
 * Java Programming
 * Lab 8 - Due 3/15/2017
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Jaylen Quizon
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for Lab 8.
 */

public class CS225_Lab7
{
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Lab 7");
		System.out.println("");

		// Declare new employee list
		ArrayList<Employee> employees = new ArrayList<Employee>(); //Instantiate employee list

		// Init scanner
		Scanner scan = new Scanner(System.in); 

		// Create a fileName
		String fileName = "Employees.txt";
		//updateEmployeeFile(employees, fileName);

		// Read in choice until user picks valid choice
		int choice = -1;
		do
		{	
			// Prompt user for choice
			System.out.print("Please select from the following options (type number):\n"
					+ "\t1. See the list of all employees\n"
					+ "\t2. Add new employees\n ");

			try
			{
				choice = scan.nextInt();	// ...keep asking them for an int.
				scan.nextLine(); // Clear extra whitespace left by nextInt()
			}
			catch(Exception e)
			{
				scan.next(); // If they don't enter an int, advance past the bad input
			}

			// Inform user that their choice was not valid
			if(choice != 1 && choice != 2) 
				System.out.println("Invalid choice: Please try again... ");

		} while(choice != 1 && choice != 2);

		// Choice 1: List employees
		if(choice == 1)
		{ 
			// Print employees
			System.out.println("Current Employee List:");
			
			readEmployeesFromFile(fileName, employees);
			
			//Make an employee
			//Employee person = new Employee("Jaylen", "Quizon", 436.85, 5);
			//employees.add(person);
			for (Employee e : employees)
				System.out.println("\t" + e.toString());

		}
		else  // Choice 2: Add new employees
		{
			boolean addPerson = false;
			do
			{
			System.out.println("Please enter the new employee's info: ");

			System.out.println("First Name: ");
			String fn = scan.next();
			System.out.println("Last Name: ");
			String ln = scan.next();
			System.out.println("Hourly Rate: ");
			double hr = scan.nextDouble();
			System.out.println("Years Working: ");
			int y = scan.nextInt();
			
			Employee newGuy = new Employee(fn, ln, hr, y);
			employees.add(newGuy);
			
			
			System.out.println("Employee successfully added. Would you like to add another? (y/n): ");
			String userInput = scan.next();
			if (userInput.equals("y"))
				addPerson = true;
			else
				addPerson = false;
		
			} while (addPerson);
			
			// Print employees
			System.out.println("New Employee List:");

			updateEmployeeFile(employees, fileName);
			
			for (Employee e : employees)
				System.out.println("\t" + e.toString());
		}

	}

	////////////////////////////////////////////////////////////////////////
	// Reads Employees from a given file and stores them into the employees
	// list. Returns true upon success, false upon failure.
	private static boolean readEmployeesFromFile(String fileName, ArrayList<Employee> employees)
	{
		// Initialize input streams
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		boolean readFail = false;

		try
		{
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			while (1 == 1)
				employees.add((Employee)ois.readObject());
		}
		catch (EOFException e1) 
		{
			System.out.println("File successfully read.");
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			System.out.println("File not found.");
		}
		finally
		{
			try
			{
				fis.close(); 
				ois.close();
			}
			catch(Exception e) { System.out.println("ERROR: " + e.getMessage());
			}
		}

		// Return whether there was success or not
		if (readFail)
			return false;
		else
			return true; //If we made it here, then the file was read successfully. Return true.
	}

	////////////////////////////////////////////////////////////////////////
	// Reads employee list from file and updates the file with any new
	// employees. Returns true upon success; false upon failure
	private static boolean updateEmployeeFile(ArrayList<Employee> employees, String fileName) 
	{
		// Add employees from file into employees ArrayList
		readEmployeesFromFile(fileName, employees);

		// Initialize output streams
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		boolean readFail = false;

		try
		{
			fos = new FileOutputStream(fileName, false);
			oos = new ObjectOutputStream(fos);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		try
		{
			for (Employee e : employees)
			oos.writeObject(e);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try { fos.close(); }
			catch(Exception e) { System.out.println("ERROR: " + e.getMessage());}
		}



		// Return whether there was success or not
		if (readFail)
			return false;
		else
			return true; //If we made it here, then the file was read successfully. Return true.
	}
}

