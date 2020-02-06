import java.util.ArrayList;
import java.util.Scanner;

/* CS 225 - Intro to Computer Science II
 * File Name: CS225_Project2.java
 * Project 2 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name: FirstName LastName
 * Description: Insert your meaningful description for Project 2.
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
public class CS225_Project2
{
	static String [][] battleArray = new String [8][8]; 
	int [][] recordedguessArray = new int [7][7]; 
	public static void main(String[] args)
	{
		// Your program should always output your name and the project number.
		// DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Project 2");
		System.out.println("");

		init(battleArray);

		// Initializes the game
		System.out.println("---------------  Welcome to Battleship!  ---------------");
		printBoard(battleArray, true);
		promptUser();
		gameStart(battleArray);  
	}

	// For loops for the spaces within the BattleShip game
	public static void printBoard(String[][] board, boolean userShips) 
	{
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[i].length; j++) 
			{ 
				if (userShips == true) 
				{ 
					if (board[i][j].equals("S")) 
					{
						System.out.print("-" + "\t");
					}

					else 
					{ 
						System.out.print(board[i][j] + "\t");
					}
				}
				if (userShips == false) {
					System.out.print(board[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}

	// Asks the user for the length of our ships; both row and columns
	public static void promptUser() 
	{ 
		Scanner scan = new Scanner(System.in);
		boolean validity = false; 
		int battleRows = 0;
		int battleCols = 0;
		String str = "";

		for(int i = 2; i < 5; i++) 
		{ 
			System.out.println("Please enter coordinates for ship of length " + i + ":");
			while (!validity) 
			{
				System.out.print("Starting Row (0-6): " ); 
				
				// If input is between 0-6; system enters the number in
				int userInput = Integer.parseInt(scan.nextLine());
				if (userInput >= 0 && userInput < 7) 
				{
					validity = true;
					battleRows = userInput;
				}
				// Else the programs tells the user to input another number
				else 
				{
					System.out.println("Invalid row. Please try again.");
				}
			}
			validity = false;

			while (!validity) 
			{
				
				// If input is between 0-6; system enters the number in
				System.out.print("Starting Column (0-6): " ); 
				int userInput = Integer.parseInt(scan.nextLine());
				if (userInput >= 0 && userInput < 7) 
				{
					validity = true;
					battleCols = userInput;
				}
				// Else the programs tells the user to input another number
				else 
				{  
					System.out.println("Invalid column. Please try again.");
				}
			}
			validity = false;
			
			// Then it asks the user if they want their ship to go horizontal or vertical
			while (!validity) 
			{
				System.out.print("From the starting point, extend down or right? (d/r): ");
				String userInput = scan.nextLine();
				if (userInput.equals("d") || userInput.equals("r")) 
				{
					validity = true;
					str = userInput;
				}
				// If user doesn't enter "d" or "r", prompts the user to input again
				else 
				{
					System.out.println("Please only enter (d)own or (r)ight.");
				}
			}
			validity = false;
			
			shipPosition(battleRows + 1, battleCols + 1, str, i);
		}
		
		// Shows the grid of your ships before the game begins
		System.out.println("Here's the final game grid... press Enter to begin playing!");
		scan.nextLine();
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n---------------  Begin!  ---------------\n");
		printBoard(battleArray, true);

		System.out.println("------------------------------------------------------------------");
	}
	
	// Shows the placements of ships on the board
	public static void shipPosition(int row, int column, String dir, int shipLength) 
	{ 

		if(dir.equals("d")) 
		{
			for(int i = 0; i < shipLength; i++) 
			{
				battleArray[row + i][column] = "S";
			}
			printBoard(battleArray, false);
		}
		else 
		{
			for(int i = 0; i < shipLength; i++) 
			{
				battleArray[row][column + i] = "S";
			}
			printBoard(battleArray, false);
		}
	}
	
	public static void init(String [][] origBoard) 
	{ 
		origBoard[0][0] = "r\\c";
		for (int i = 1; i <= 7; i++) 
		{
			origBoard[0][i] = Integer.toString(i - 1);
			origBoard[i][0] = Integer.toString(i - 1);
		}
		for(int i = 1; i < origBoard.length; i++) 
		{
			for(int j = 1; j < origBoard[i].length; j++) 
			{
				origBoard[i][j] = "-";
			}
		}

	}
	
	public static void gameStart(String[][] board) 
	{

		int moves = 0;
		boolean gameOver = false;
		String [][] guessOfPlayer = new String[8][8];
		for (int r = 0; r < board.length; r++) 
		{
			for (int c = 0; c < board[r].length; c++) 
			{
				guessOfPlayer[r][c] = board[r][c].toString();
			}
		}

		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> columns = new ArrayList<Integer>();

		Scanner scan = new Scanner(System.in);

		// Runs the code over and over until there is a victorious player
		while(!isGameOver(guessOfPlayer)) 
		{
			int row = 0;
			int col = 0;

			System.out.println("Guess number " + (++moves) + "...");

			System.out.print("Guess a row (0-6): ");
			row = Integer.parseInt(scan.nextLine());

			System.out.print("Guess a column (0-6): ");
			col = Integer.parseInt(scan.nextLine());

			if (board[row + 1][col + 1].equals("S")) 
			{
				System.out.println("hit");
				guessOfPlayer[row + 1][col + 1] = "X";
			}
			else 
			{
				System.out.println("miss");
				guessOfPlayer[row + 1][col + 1] = "m";
			}
			rows.add(row);
			columns.add(col);
			printBoard(guessOfPlayer, true);
		}
		
		// Prompts the user that they have won the game c:
		System.out.println("Congratulations, you've sunk all the battleships!");
		System.out.println("You made a total of " + moves + " guesses, listed as follows:");
		System.out.println("Guess   | Row   Col");
		System.out.println("-------------------------");

		for (int i = 0; i < rows.size(); i++) 
		{
			System.out.println(i + "\t |" + rows.get(i) + "\t" + columns.get(i));
		}
		System.out.println("Thanks for playing! Goodbye.");
		scan.close();
	}
	
	// Checks if the game is over
	public static boolean isGameOver(String[][] board) 
	{

		for (int r = 0; r < board.length; r++) 
		{
			for (int c = 0; c < board[r].length; c++) 
			{
				if (board[r][c].equals("S")) 
				{
					return false;
				}
			}
		}
		return true;
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
Project 2

---------------  Welcome to Battleship!  ---------------
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	-	-	-	-	-	
2	-	-	-	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Please enter coordinates for ship of length 2:
Starting Row (0-6): 1
Starting Column (0-6): 2
From the starting point, extend down or right? (d/r): d
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	S	-	-	-	-	
2	-	-	S	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Please enter coordinates for ship of length 3:
Starting Row (0-6): 2
Starting Column (0-6): 3
From the starting point, extend down or right? (d/r): d
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	S	-	-	-	-	
2	-	-	S	S	-	-	-	
3	-	-	-	S	-	-	-	
4	-	-	-	S	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Please enter coordinates for ship of length 4:
Starting Row (0-6): 5
Starting Column (0-6): 3
From the starting point, extend down or right? (d/r): r
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	S	-	-	-	-	
2	-	-	S	S	-	-	-	
3	-	-	-	S	-	-	-	
4	-	-	-	S	-	-	-	
5	-	-	-	S	S	S	S	
6	-	-	-	-	-	-	-	
Here's the final game grid... press Enter to begin playing!












---------------  Begin!  ---------------
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	-	-	-	-	-	
2	-	-	-	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
------------------------------------------------------------------
Guess number 1...
Guess a row (0-6): 1
Guess a column (0-6): 2
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	-	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Guess number 2...
Guess a row (0-6): 2
Guess a column (0-6): 2
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Guess number 3...
Guess a row (0-6): 2
Guess a column (0-6): 3
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Guess number 4...
Guess a row (0-6): 3
Guess a column (0-6): 3
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	X	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Guess number 5...
Guess a row (0-6): 4
Guess a column (0-6): 3
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	X	-	-	-	
4	-	-	-	X	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Guess number 6...
Guess a row (0-6): 5
Guess a column (0-6): 3
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	X	-	-	-	
4	-	-	-	X	-	-	-	
5	-	-	-	X	-	-	-	
6	-	-	-	-	-	-	-	
Guess number 7...
Guess a row (0-6): 5
Guess a column (0-6): 4
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	X	-	-	-	
4	-	-	-	X	-	-	-	
5	-	-	-	X	X	-	-	
6	-	-	-	-	-	-	-	
Guess number 8...
Guess a row (0-6): 5
Guess a column (0-6): 5
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	X	-	-	-	
4	-	-	-	X	-	-	-	
5	-	-	-	X	X	X	-	
6	-	-	-	-	-	-	-	
Guess number 9...
Guess a row (0-6): 5
Guess a column (0-6): 6
HIT!
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	X	-	-	-	-	
2	-	-	X	X	-	-	-	
3	-	-	-	X	-	-	-	
4	-	-	-	X	-	-	-	
5	-	-	-	X	X	X	X	
6	-	-	-	-	-	-	-	
Congratulations, you've sunk all the battleships!
You made a total of 9 guesses, listed as follows:
Guess   | Row   Col
-------------------------
0	 |1	2
1	 |2	2
2	 |2	3
3	 |3	3
4	 |4	3
5	 |5	3
6	 |5	4
7	 |5	5
8	 |5	6
Thanks for playing! Goodbye.


------------
Test Case 2:
------------

Jaylen Quizon
Project 2

---------------  Welcome to Battleship!  ---------------
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	-	-	-	-	-	
2	-	-	-	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Please enter coordinates for ship of length 2:
Starting Row (0-6): 1
Starting Column (0-6): 2
From the starting point, extend down or right? (d/r): d
r\\c	0	1	2	3	4	5	6	
0	-	-	-	-	-	-	-	
1	-	-	S	-	-	-	-	
2	-	-	S	-	-	-	-	
3	-	-	-	-	-	-	-	
4	-	-	-	-	-	-	-	
5	-	-	-	-	-	-	-	
6	-	-	-	-	-	-	-	
Please enter coordinates for ship of length 3:
Starting Row (0-6): 0
Starting Column (0-6): 6
From the starting point, extend down or right? (d/r): r
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 8
	at CS225_Project2.shipPosition(CS225_Project2.java:197)
	at CS225_Project2.promptUser(CS225_Project2.java:169)
	at CS225_Project2.main(CS225_Project2.java:70)

******************************************************************************/