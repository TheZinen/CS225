import java.util.ArrayList;
import java.util.Scanner;

/* CS 225 - Intro to Computer Science II
 * File Name: CS225_Lab5_P2.java
 * Java Programming
 * Lab 5 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Jaylen Quizon
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for the client portion of Lab 5.
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
// You may also complete the labs on your own machine if you'd like (this is preferable).
///////////////////////////////////////////////////////////////////////////////
public class CS225_Lab5_P2
{
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Lab 5 Problem 2");
		System.out.println("");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number in binary (Ex: 10010101): ");
		String bin = scan.nextLine();
		
		int result = binaryToDec(bin);
		System.out.println(bin + " => " + result);
	}

	/////////////////////////////////////////////////////////////////////////
	// This method is a public method that can be called from main or externally
	// by another client (like an autograder). You may NOT change this method
	// header...but you can change the arguments of the recursiveBinaryToDec()
	// call in the method's code.
	public static int binaryToDec(String bin)
	{
		return recursiveBinaryToDec(bin, 0);
	}
	
	/////////////////////////////////////////////////////////////////////////
	// This is a recursive method which converts a binary String (taken in 
	// as an argument) to the decimal equivalent in integer form (returned
	// from method). You may NOT change the return type....but can change or
	// add arguments (you will need to add at least one argument).
	private static int recursiveBinaryToDec(String bin, int placeFromRight)
	{
		int valThisDigit = (int) Math.pow(2, placeFromRight);
		if (placeFromRight == bin.length())
			return 0;
		else if (bin.charAt(bin.length() - 1 - placeFromRight) == '1')
			return valThisDigit + recursiveBinaryToDec(bin, placeFromRight + 1);
		else
			return recursiveBinaryToDec(bin, placeFromRight + 1);
	}
}
