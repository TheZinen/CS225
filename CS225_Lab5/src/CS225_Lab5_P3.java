import java.lang.reflect.Array;
import java.util.Scanner;

/* CS 225 - Intro to Computer Science II
 * File Name: CS225_Lab5_P3.java
 * Java Programming
 * Lab 5 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: FirstName1 LastName1
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
// be deducted points for not finishing "on time", but will be graded based on your final
// submission. Book problems will always be graded via the submission and will not be checked
// off during lab.
//
// If you do not finish your lab assignment during the lab period, you and your partner may
// only seek help with your code from lab technicians (available whenever the lab is open)
// and the instructor to aid with any confusion; please refer to posted lab times at the
// entrance of the Main Computer Lab to see when lab techs and computers are available.
// You may also complete the labs on your own machine if you'd like (this is preferable).
///////////////////////////////////////////////////////////////////////////////
public class CS225_Lab5_P3
{
	// Used to track the number of recursive calls made 
	// (that is, the number of binary searches)
	public static int numRecursiveCalls = 0;
	
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Lab 5 Problem 3");
		System.out.println("");
	
		// Hardcoded, sorted array
		int [] sortedArray = {10, 20, 38, 40, 102, 182, 553, 919, 931, 937, 949, 1623, 2039 };
		// Index values:	   0,  1,  2,  3,   4,   5,  6*,   7,  8,  9,  10,   11,   12
		
		// Prompt the user for a number to search
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number to search for in the array: ");
		int key = scan.nextInt();		
		
		// Search for the key in the sortedArray and return the index
		int index = binarySearch(sortedArray, key);
		
		// Print out results
		if (index >= 0)
			System.out.println(key + " found at index " + index + " after " + numRecursiveCalls + " recursive calls.");
		else
			System.out.println(key + " not found after " + numRecursiveCalls + " recursive calls.");
	}

	/////////////////////////////////////////////////////////////////////////
	// This method is a public method that can be called from main or externally
	// by another client (like an autograder). You may NOT change this method
	// header or the code within.
	public static int binarySearch(int[] sortedArray, int key)
	{
		// Start off by performing a binary search on the ENTIRE array
		return recursiveBinarySearch(sortedArray, key, 0, sortedArray.length - 1);
	}
	
	/////////////////////////////////////////////////////////////////////////
	// This is a recursive method which performs binary search (think of the 
	// "higher/lower" number guessing game. Each recursive call checks to see
	// if the number in the middle of the array is the number being looked
	// for (that is, they key); if the key is not found, a recursive call is
	// made which splits the area being searched in half and either searches
	// the top half or bottom half of the CURRENT array.
	//
	// If the method completes and determines that the key is not in the array,
	// the method should return -1; otherwise, the method should return the index
	// of the key.
	//
	// NOTE: The sortedArray never changes...only the beginning/end search indices
	// (beginSearchIndex/endSearchIndex), which effectively changes the portions of the 
	// array that we are searching through.
	private static int recursiveBinarySearch(int[] sortedArray, int key, int beginSearchIndex, int endSearchIndex)
	{	
		int midSearchIndex = endSearchIndex + (beginSearchIndex + endSearchIndex) / 2;
		int baseCase = 0;
		
			while(beginSearchIndex <= endSearchIndex)
			{
	            baseCase = (endSearchIndex + beginSearchIndex)/2;
	            numRecursiveCalls++; // Do NOT erase/change. Used for autograding and counting the number of recursive calls
	            
	            if(sortedArray[baseCase] < key)
	                return beginSearchIndex = baseCase+1;
	            else if(sortedArray[baseCase] > key)
	                return endSearchIndex = baseCase-1;
	            else if(sortedArray[baseCase] == key)
	            {
	                baseCase = baseCase;
	                break;
	            }
			}
		if (beginSearchIndex < 0 || endSearchIndex >= sortedArray.length || beginSearchIndex > endSearchIndex)
			return -1;
		else if (sortedArray[midSearchIndex] == key)
			return midSearchIndex;
		else if (key > sortedArray[midSearchIndex])
			return beginSearchIndex = baseCase+1; 
		else
			return endSearchIndex = baseCase-1;
	}
}
