/* CS 225 - Intro to Computer Science
 * File Name: CS225_Lab1.java
 * Java Programming
 * Lab 1 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Jaylen Quizon
 * Name 2: Tyler Murphy
 * Description: This file contains the source code for Lab 1.
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
// be deducted points for not finishing the problem, but will be graded based on your final
// submission. Book problems will always be graded via the submission and will not be checked
// off during lab.
//
// If you do not finish your lab assignment during the lab period, you and your partner may
// only seek help with your code from lab technicians (available whenever the lab is open)
// and the instructor to aid with any confusion; please refer to posted lab times at the
// entrance of the Main Computer Lab to see when lab techs and computers are available.
// You may also complete the labs on your own machine if you like (this is preferable).
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.util.Scanner;

public class CS225_Lab1
{
	static Scanner scan = new Scanner(System.in); // Holds a local scanner 
	private static int secondsLeft; // Number of seconds after each turn
	private static int score = 0;   // Score variable which you update
	private static NonBlockingHasNext t = new NonBlockingHasNext(); // Special class for timer
	private static int [][][] gameBoard = new int [3][3][3]; 
	
	//////////////////////////////////////////////////////
	// main() runs the program. Do NOT edit this method.
	//////////////////////////////////////////////////////
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon & Tyler Murphy");
		System.out.println("Lab 1");
		System.out.println("");

		// Give user instructions and begin
		System.out.println("You will be presented 3 3x3 boards of random numbers, labeled 1, 2 and 3.");
		System.out.println("Quickly select the board you believe to contain the largest sum of 9 numbers" +
							" by entering the board number and pressing enter");
		System.out.println("Press any key and hit enter to begin...");
		scan.nextLine();
		
		int numTurns = 10;
		for (int i = 0; i < numTurns; i++)
		{
			reInit3dBoard();
			print3dBoard(i, numTurns);
			int choiceMade = countDownTimer();
			choiceMade--; // Decrement to match with 0-indexed arrays	
			analyzeChoice(choiceMade);			
		}			
	}
	
	//////////////////////////////////////////////////////
	// countDownTimer() counts down from 10 seconds. Returns
	// the user input if the value that is input is a 1, 2
	// or 3. If the value is something else or no value is
	// input, this method returns a -1.
	//////////////////////////////////////////////////////
	private static int countDownTimer()
	{
		// Some really complicated stuff to work around Java shortcomings.
		// Basically, this code creates a new "thread" which allows us to
		// run other code while a scanner in NonBlockingHasNext is waiting
		// for a user input.
		t = new NonBlockingHasNext();
		(new Thread(t)).start();
		
		System.out.println("Seconds left to make choice: ");
		for (int i = 10; i > 0; i--)
		{
			secondsLeft = i;
			System.out.print(secondsLeft + "...");
			
			
			// Sleep for 1 second and....
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace(); }

			
			// ...check again for input. If received a valid input in time, then return it
			if (t.hasNext())
			{
				// Make sure choice is valid (1, 2 or 3)
				int choice = t.nextInt(); //scan.nextInt();
				if (choice >= 1 && choice <= 3)
				{
					System.out.println("\nYou chose grid #" + choice + " with " + secondsLeft + " seconds left!");
					return choice;
				}				
			}
		}
		
		// If we get here, then no choice was made!
		System.out.println("\nNo choice made!");
		return -1; // If no valid choice made
	}
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	/////////////////DO NOT EDIT ABOVE////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////
	// Simply assigns each element of the 3x3x3 3D board
	// a random number from 1-9 (should not see 0's or 10's)
	//////////////////////////////////////////////////////
	private static void reInit3dBoard()
	{
		// (see member variables) as described in the method header above.
		// NOTE: You can just overwrite the values there.
		
		Random rand = new Random();
		for (int d = 0; d < gameBoard.length; d++)
			for (int r = 0; r < gameBoard[d].length; r++)
				for (int c = 0; c < gameBoard[d][r].length; c++)
					 gameBoard[d][r][c] = rand.nextInt(9) + 1;
	}
	
	//////////////////////////////////////////////////////
	// Prints the 3x3x3 3D board out to the console. It
	// should print 3 2d boards. The line directly above each board
	// should be labeled "Board 1:", "Board 2:" or "Board 3:".
	// The line directly below each board should be blank. 
	//////////////////////////////////////////////////////
	private static void print3dBoard(int turn, int numTurns)
	{
		System.out.println("--------------------------Turn " + (turn+1) + "/" + numTurns + "--------------------------");

		// Make sure to label the boards 1-3 and not 0-2.

		for (int d = 0; d < gameBoard.length; d++)
		{
			System.out.println();
			System.out.println("Board " + (d+1));
			for (int r = 0; r < gameBoard[d].length; r++)
			{
				for (int c = 0; c < gameBoard[d][r].length; c++)
				{
					System.out.print(gameBoard[d][r][c] + "   ");
				}
				System.out.println();
			}
		}
	}

	//////////////////////////////////////////////////////
	// This method analyzes the choice made by the user 
	// conveniently passed into us for array-indexing purposes
	// as a 0, 1 or 2.
	//////////////////////////////////////////////////////
	private static void analyzeChoice(int choiceMade)
	{
		// to compute the sum of each of the 3 boards.

		int []count = new int[3];
		int index = 0;
		int score = 0;

		for (int d = 0; d < gameBoard.length; d++){
			for (int r = 0; r < gameBoard[d].length; r++){
				for (int c = 0; c < gameBoard[d][r].length; c++){
					count[r] += gameBoard[d][r][c];
				}
			}
		}
		
		for( int i = 0; i < count.length; i++)
		{
			if (count[i] > score)
			{
				index = i;
				score = count[i];
			}
		}

		// TODO 7: Print out the score of all three boards (e.g., "Board 1 value: 34"). Number
		// the boards 1-3 b/c this is what the user saw when selecting.
		// Next to the selected board, add the string "(Right)" or "(Wrong)" if their guess
		// was correct (i.e., the max board). Also, update the score by adding the number
		// of seconds left when the guess was made.

		for (int i = 0; i < count.length; i++)
		{
			System.out.println("Board " + (i + 1) + " value: " + count[i] + " ");
			if(choiceMade == index)
			{
				if (choiceMade == i)
				{
					System.out.print("Right ");
					score += secondsLeft;
				}
				else 
				{
					System.out.print("Wrong ");
				}
				System.out.println();
			}

			// HINT: At this point, the member variable "score" holds the current score and the
			// member variable "secondsLeft" holds the seconds left when the last selection was made.

			// Print out the current score
		}
			System.out.println("\n***Current Score: " + score);
	}
}
