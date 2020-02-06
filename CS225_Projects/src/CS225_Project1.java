import java.util.Scanner;

/* CS 225 - Intro to Computer Science II
 * File Name: CS225_Project1.java
 * Java Programming
 * Project 1 - Due 1/29/2017
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Jaylen Quizon
 * Name 2: 
 * Description: This file contains the source code for Project 1.
 */

///////////////////////////////////////////////////////////////////////////////
// INSTRUCTIONS: Update the header above EACH LAB with the correct due date,
// first/last name and description for this specific project. You should also update
// the first/last name below in the "System.out.println" statement at the beginning
// of the "main()" method. Failure to do so will result in lost points. DO NOT change
// the name of the class or the autograder will give you 0 points.
//
// PHILOSOPHY: Projects provide a chance to solidify your skills on a harder problem.
// Whereas labs are meant to expose you to concepts in a safe environment with a lot
// of help, projects are meant to strengthen your skills and confidence as an independent
// programmer. They will be challenging as everything feels so new, but you'll also 
// experience a lot of growth as you "fight" through the projects.
//
// COLLABORATION: Students MUST work alone on programming projects. It is OKAY to discuss
// the high-level concepts of the programming project and very general coding strategies 
// with classmates, but AT NO POINT should you ever look at the code of your classmate's
// project OR show your code to help another classmate. However, you MAY obtain help from 
// the lab technicians (available whenever the lab is open). If you do so, you MUST add 
// comments to your code declaring which portions of code you received help on and you 
// MUST include which lab technician helped you for that portion. You will not be penalized
// for utilizing lab technicians and this documentation is for your protection in case
// the autograder determines that you cheated, when it is really detecting code that is
// very similar because two students were independently helped by the same lab technician.
// Lab technicians MAY be consulted to ensure they did offer the support that is being claimed
// by your code.
//
// CHEATING: Your projects will be automatically and algorithmically checked for cheating
// by the online submission system. These algorithms are very good and will check against
// each of your classmate's submissions (in this section and other sections), projects that
// have been submitted in the past by previous students at this university and other
// universities, as well as content and code found on the internet. In short, if you cheat,
// EXPECT TO BE CAUGHT.
//
// Be aware that being caught for cheating can result in a 0% on the project for you AND the
// person that gave their code (it is your responsibility to not share your code, too). By the
// course breakdown, this will result in an automatic loss in 8% of your entire course grade.
//
// The lab technicians and instructor are available for help and there is NO REASON to take
// the risk in cheating.
///////////////////////////////////////////////////////////////////////////////

//enum class used to represent each cell of the mine board:
//HM = Hidden Mine, RM = Revealed Mine, HE = Hidden Empty, RE = Revealed Empty
enum MineCell { HM, RM, HE, RE;

public static MineCell hm; }

public class CS225_Project1
{
	// Your code should go below this line
	// Constants used to make defining the mine board easier
	final static MineCell he = MineCell.HE;
	final static MineCell hm = MineCell.HM;
	
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Project 1");
		System.out.println("");

		// Definition of mine board. *** DO NOT CHANGE ***
		// The hidden mines are represented by hm and the hidden empty
		// cells with he in a 55 array.
		MineCell [][] mineBoard = { {he, he, he, he, he},
									{he, hm, he, hm, he},
									{he, he, he, he, he},
									{he, he, hm, he, he},
									{he, he, hm, hm, he} };
		
		// Test your board printing functions before continuing
		//testBoardPrinting(mineBoard); // TODO 3: Comment out when print methods tested
		
		// Definition of some variables and constants
		int currentScore = 5; // Starting score is 5
		int numEmptySpotsFound = 0; // When we reach 20 empty spots, we win!
		final int minePen = 4; // Each time we hit a mine, subtract this value
		final int emptySpaceBonus = 1; // Each time we land on an empty space, add this value
		int turnsTaken = 0;//Each turn gets added
		//////////////////////////////////////////////////////
		// Continue the game while the score is greater AND
		// the number of empty spots revealed is less than 20
		Scanner scnr = new Scanner(System.in);
		while (currentScore > 0 && numEmptySpotsFound < 20)
		{
			// TODO 4: Write code here to ask the user for a row and column to guess...
			System.out.println("-----------------------Next Turn-----------------------");
			int rows = 0;
			int columns = 0; 
			
			System.out.println("Enter a row 0-4: ");
			rows = scnr.nextInt();
			System.out.println("Enter a column 0-4: ");
			columns = scnr.nextInt(); 
			
			// Respond to each guess the user could make
			if (mineBoard[rows][columns] == MineCell.HM)
			{
				// TODO 5: Write code here to respond to the user
				// guessing a cell that has hidden mine...
				turnsTaken++;
				currentScore = currentScore - minePen;
				System.out.println("You have found a mine");
				System.out.println("After round "+ turnsTaken + " score is: " + currentScore);
				System.out.println("Empty Spots found " + numEmptySpotsFound);
				mineBoard[rows][columns] = MineCell.RM;
				
			}
			else if (mineBoard[rows][columns] == MineCell.HE)
			{
				// TODO 6: Write code here to respond to the user
				// guessing a cell that has hidden empty cell...
				turnsTaken++;
				currentScore++;
				numEmptySpotsFound++;
				System.out.println("You have found an empty cell");
				System.out.println("After round " + turnsTaken + " score is: " + (currentScore));
				System.out.println("You have found " + (numEmptySpotsFound)+ " empty spots");
				mineBoard[rows][columns] = MineCell.RE;
				
			}
			else
			{
				turnsTaken++;
				System.out.println("You've already guessed this spot, please try again!");
			}
			printCurrBoard(mineBoard);
		}
//////////////////////////////////////////////////////
//TODO 7: Deliver final results. If we've reached this point,
//the game is over. Write code to let the user know if they won 
//or lost and print the final board (remember, you have a function
//to print the game-over board)
		if(currentScore <= 0 && numEmptySpotsFound < 20)
		{
			System.out.println("");
			System.out.println("*****Oh no, you LOST!*****");
		}
		else
		{
			System.out.println("");
			System.out.println("*****Nice job, you WIN!*****");
		}
		printGameOverBoard(mineBoard);
	}
	
	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board while game is still being played:
	// '?' for unexplored, 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printCurrBoard(MineCell[][] board)
	{
		for(int rows = 0 ; rows < 5; rows ++)
		{
			for (int columns = 0; columns < 5; columns++ )
			{
				if (board[rows][columns] == MineCell.HM)
				{
					System.out.print(" ? ");
				}
				else if (board[rows][columns] == MineCell.HE)
				{
					System.out.print(" ? ");
				}
				else if (board[rows][columns] == MineCell.RE)
				{
					System.out.print(" E ");
				}
				else if (board[rows][columns] == MineCell.RM)
				{
					System.out.print(" M ");
				}
			}
			System.out.println(" ");
		}
		// TODO 1: Write code to print the current game state as specified
		// in the comment above
	}
	
	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board after the game is over (thus, we can
	// reveal everything to the user):
	// 'm' for unrevealed mines, 'e' for unrevealed empty cells,
	// 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printGameOverBoard(MineCell[][] board)
	{
		// TODO 2: Write code to print the final (game-over) game state
		// as specified in the comment above
		for(int rows = 0 ; rows < 5; rows ++)
		{
			for (int columns = 0; columns < 5; columns++ )
			{
				if (board[rows][columns] == MineCell.HM)
				{
					System.out.print(" m ");
				}
				else if (board[rows][columns] == MineCell.HE)
				{
					System.out.print(" e ");
				}
				else if (board[rows][columns] == MineCell.RE)
				{
					System.out.print(" E ");
				}
				else if (board[rows][columns] == MineCell.RM)
				{
					System.out.print(" M ");
				}
			}
			System.out.println(" ");
			
		}
	}

	/////////////////////////////////////////////////////////////////////
	// This function simply calls your two board printing methods to help
	// you test that your print methods are working properly before moving
	// on with this lab.
	/////////////////////////////////////////////////////////////////////
	static void testBoardPrinting(MineCell[][] board)
	{
		printCurrBoard(board);
		System.out.println();
		printGameOverBoard(board);
		System.out.println("\n\n*****Exiting program after test. Comment out testBoardPrinting() method in main() to move on.");
		System.exit(0);
	}
}


/******************************************************************************
Insert 2 test cases, which represent program input/output for two different
combinations of inputs. You may literally copy and paste your console contents,
but your two test cases should be DIFFERENT from any test cases given in the
Project description itself.

------------
Test Case 1:
------------
Jaylen Quizon
Project 1

-----------------------Next Turn-----------------------
Enter a row 0-4: 
4
Enter a column 0-4: 
4
You have found an empty cell
After round 1 score is: 6
You have found 1 empty spots
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
4
Enter a column 0-4: 
3
You have found a mine
After round 2 score is: 2
Empty Spots found 1
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  M  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
4
You have found an empty cell
After round 3 score is: 3
You have found 2 empty spots
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  E  
 ?  ?  ?  M  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
3
You have found an empty cell
After round 4 score is: 4
You have found 3 empty spots
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  E  E  
 ?  ?  ?  M  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
2
You have found a mine
After round 5 score is: 0
Empty Spots found 3
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  M  E  E  
 ?  ?  ?  M  E  

*****Oh no, you LOST!*****
 e  e  e  e  e  
 e  m  e  m  e  
 e  e  e  e  e  
 e  e  M  E  E  
 e  e  m  M  E  


------------
Test Case 2:
------------
Jaylen Quizon
Project 1

-----------------------Next Turn-----------------------
Enter a row 0-4: 
1
Enter a column 0-4: 
1
You have found a mine
After round 1 score is: 1
Empty Spots found 0
 ?  ?  ?  ?  ?  
 ?  M  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
2
Enter a column 0-4: 
2
You have found an empty cell
After round 2 score is: 2
You have found 1 empty spots
 ?  ?  ?  ?  ?  
 ?  M  ?  ?  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  ?  ?  
 ?  ?  ?  ?  ?  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
3
You have found an empty cell
After round 3 score is: 3
You have found 2 empty spots
 ?  ?  ?  ?  ?  
 ?  M  ?  ?  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  ?  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
4
Enter a column 0-4: 
4
You have found an empty cell
After round 4 score is: 4
You have found 3 empty spots
 ?  ?  ?  ?  ?  
 ?  M  ?  ?  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
0
Enter a column 0-4: 
0
You have found an empty cell
After round 5 score is: 5
You have found 4 empty spots
 E  ?  ?  ?  ?  
 ?  M  ?  ?  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
1
Enter a column 0-4: 
2
You have found an empty cell
After round 6 score is: 6
You have found 5 empty spots
 E  ?  ?  ?  ?  
 ?  M  E  ?  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
1
Enter a column 0-4: 
2
You've already guessed this spot, please try again!
 E  ?  ?  ?  ?  
 ?  M  E  ?  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
1
Enter a column 0-4: 
3
You have found a mine
After round 8 score is: 2
Empty Spots found 5
 E  ?  ?  ?  ?  
 ?  M  E  M  ?  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
1
Enter a column 0-4: 
4
You have found an empty cell
After round 9 score is: 3
You have found 6 empty spots
 E  ?  ?  ?  ?  
 ?  M  E  M  E  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
0
Enter a column 0-4: 
1
You have found an empty cell
After round 10 score is: 4
You have found 7 empty spots
 E  E  ?  ?  ?  
 ?  M  E  M  E  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
0
Enter a column 0-4: 
2
You have found an empty cell
After round 11 score is: 5
You have found 8 empty spots
 E  E  E  ?  ?  
 ?  M  E  M  E  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
0
Enter a column 0-4: 
3
You have found an empty cell
After round 12 score is: 6
You have found 9 empty spots
 E  E  E  E  ?  
 ?  M  E  M  E  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
0
Enter a column 0-4: 
4
You have found an empty cell
After round 13 score is: 7
You have found 10 empty spots
 E  E  E  E  E  
 ?  M  E  M  E  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
1
Enter a column 0-4: 
0
You have found an empty cell
After round 14 score is: 8
You have found 11 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 ?  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
2
Enter a column 0-4: 
0
You have found an empty cell
After round 15 score is: 9
You have found 12 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  ?  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
2
Enter a column 0-4: 
1
You have found an empty cell
After round 16 score is: 10
You have found 13 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  ?  ?  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
2
Enter a column 0-4: 
4
You have found an empty cell
After round 17 score is: 11
You have found 14 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  ?  E  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
2
Enter a column 0-4: 
3
You have found an empty cell
After round 18 score is: 12
You have found 15 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 ?  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
0
You have found an empty cell
After round 19 score is: 13
You have found 16 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  ?  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
1
You have found an empty cell
After round 20 score is: 14
You have found 17 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  E  ?  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
2
You have found a mine
After round 21 score is: 10
Empty Spots found 17
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  E  M  E  ?  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
3
Enter a column 0-4: 
4
You have found an empty cell
After round 22 score is: 11
You have found 18 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  E  M  E  E  
 ?  ?  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
4
Enter a column 0-4: 
1
You have found an empty cell
After round 23 score is: 12
You have found 19 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  E  M  E  E  
 ?  E  ?  ?  E  
-----------------------Next Turn-----------------------
Enter a row 0-4: 
4
Enter a column 0-4: 
0
You have found an empty cell
After round 24 score is: 13
You have found 20 empty spots
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  E  M  E  E  
 E  E  ?  ?  E  

*****Nice job, you WIN!*****
 E  E  E  E  E  
 E  M  E  M  E  
 E  E  E  E  E  
 E  E  M  E  E  
 E  E  m  m  E  
******************************************************************************/