/* CS 225 - Intro to Computer Science II
 * File Name: CS225_Project3_OldMcD_Client.java
 * Project 3 - Due 2/26/2017
 * Instructor: Dr. Dan Grissom
 * 
 * Name: Jaylen Quizon
 * Description: Insert your meaningful description for Project 3.
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

// Enum type for food
enum FoodType { BONE, SALMON, GRASS }

public class CS225_Project3_OldMcD_Client
{
	// Constants for food costs
	final static double grassCost = 1.0;
	final static double boneCost = 3.0;
	final static double salmonCost = 5.0;
	
	// Random number generator
	private static Random r = new Random();
	
	public static void main(String[] args)
	{
		// Your program should always output your name and the project number.
		// DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Project 3");
		System.out.println("");

		// For autograding purposes - setting seed (read in from command line)
		// so random always generates same numbers
		if (args.length > 0)
			r.setSeed(Long.parseLong(args[0]));
		
		// Decimal format class for printing out any prices
		DecimalFormat df = new DecimalFormat("$0.00");		
		
		for (int i = 0; i < 2; i++)
		{
			// An ArrayList of animals in the stalls
			ArrayList<Animal> stalls;

			// This test case will be executed during FIRST iteration;
			// It is used to reproduce the output in the Project writeup
			if (i == 0)
			{
				System.out.println("----------CASE 1: generateDogCatCow5ServingArrangement() Output----------");
				stalls = generateDogCatCow5ServingArrangement();
			}
			else
			{
				int numAnimals = 10;
				// This test case will be executed during SECOND iteration;
				// It is used to generate a random test case
				System.out.println("-------------CASE 2: generateRandomStallArrangement() Output-------------");
				stalls = generateRandomStallArrangement(numAnimals);
			}
			
			
			// TODO: Insert your code here which causes Old MacDonald (this client code) to
			// visit each of the stalls. Old MacDonald should speak to each animal to determine
			// what type of food to feed it. All along the way, he keeps track of what types 
			// of animals and how much of each type of food he is using. See the project
			// PDF for specific output expectations.
			
			double totalSalmonCost = 0.0;
			double totalGrassCost = 0.0;
			double totalBoneCost = 0.0;
			double totalCostAll = 0.0;
			int catsTotal = 0;
			int dogsTotal = 0;
			int cowsTotal = 0;
			double cost = 0.0;

			System.out.println("Stalls: " + stalls.size());
			for (int k = 0; k < stalls.size(); k++)
			{
			System.out.println("Stall " +  (k + 1) + " of "+ stalls.size() 
			+ " contains a " + (stalls.get(k).toString()).substring(0,3)  
			+ " who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings));
			}
			
			if ((stalls.get(1).speak()) == "MEOW")
			{
				System.out.println("MEOW");
				System.out.println("Cat spoke");
				while(stalls.get(1).isStillHungry() == true)
				{
				stalls.get(1).feed(FoodType.SALMON);
				stalls.get(1).numberOfFeedings++;
				cost = stalls.get(1).numberOfFeedings;
				totalSalmonCost = stalls.get(1).numberOfFeedings * salmonCost;
				}
			}
			else if ((stalls.get(2).speak()) == "MOO")
			{
				System.out.println("MOO");
				System.out.println("Cow spoke");
				while(stalls.get(2).isStillHungry() == true)
				{
					stalls.get(2).feed(FoodType.GRASS);
					stalls.get(2).numberOfFeedings++;
					cost = stalls.get(2).numberOfFeedings;
					totalGrassCost = stalls.get(2).numberOfFeedings  * grassCost;
				}
			}
			else if ((stalls.get(0).speak()) == "WOOF")
			{
				System.out.println("WOOF");
				System.out.println("Dog spoke");
				while(stalls.get(0).isStillHungry() == true)
				{
					stalls.get(0).feed(FoodType.BONE);
					stalls.get(0).numberOfFeedings++;
					cost = stalls.get(0).numberOfFeedings;
					totalBoneCost = stalls.get(0).numberOfFeedings * boneCost;
				}
			}
			
			System.out.println("Old MacDonald's total expenses: ");
			System.out.println(df.format(totalBoneCost) + " spent feeding " + dogsTotal + " dogs " 
					+ stalls.get(0).numberOfFeedings + " total feedings.");
			
			System.out.println(df.format(totalSalmonCost) + " spent feeding " + catsTotal + " cats " 
					+ stalls.get(1).numberOfFeedings + " total feedings.");
			
			System.out.println(df.format(totalGrassCost) + " spent feeding " + cowsTotal + " cows " 
					+ stalls.get(2).numberOfFeedings + " total feedings.");
			
			totalCostAll = totalSalmonCost + totalBoneCost + totalGrassCost;
			
			System.out.println("\t" + "Total cost: " + df.format(totalCostAll));
			// End of test
			System.out.println("E-I-E-I-O!\n");	
		}		
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// DO NOT EDIT
	// This method generates a stall with numAnimals which are generated randomly.
	// In addition, the number of feedings required per animal are set randomly as
	// a number between 1 and 10.
	/////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<Animal> generateRandomStallArrangement(int numAnimals)
	{
		// Create new stall (ArrayList) of animals
		ArrayList<Animal> newStallArrangement = new ArrayList<Animal>();
		 
		// Generate numAnimals new animals
		for (int i = 0; i < numAnimals; i++)
		{
			int randAnimal = r.nextInt(3); // (Dog = 0, Cat = 1, Cow = 2)
			int numFeedings = r.nextInt(10)+1; // 1-10 feedings required per animal
			
			if (randAnimal == 0)
				newStallArrangement.add(new Dog(numFeedings));
			else if (randAnimal == 1)
				newStallArrangement.add(new Cat(numFeedings));
			else
				newStallArrangement.add(new Cow(numFeedings));
		}
		
		return newStallArrangement;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// DO NOT EDIT
	// This method generates a stall with a dog, cat and cow, which each need five
	// servings of food.
	/////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<Animal> generateDogCatCow5ServingArrangement()
	{
		// Create new stall (ArrayList) of animals containing a Dog, Cat & Cow, each with a requirement of 5 servings
		ArrayList<Animal> newStallArrangement = new ArrayList<Animal>();
		newStallArrangement.add(new Dog(5));
		newStallArrangement.add(new Cat(5));
		newStallArrangement.add(new Cow(5));
		return newStallArrangement;
	}
}


/******************************************************************************
Insert 2 test cases, which represent program input/output for two different
random stall configurations. You may literally copy and paste your console contents,
but your two test cases should be DIFFERENT from any test cases given in the
Project description itself.

------------
Test Case 1:
------------
(Your test case I/O here.)

------------
Test Case 2:
------------
(Your test case I/O here.)
******************************************************************************/