/* CS 225 - Intro to Computer Science II
 * File Name: Cat.java
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
public class Cat extends Animal
{
	// Constructors
	// Calls the superclass to use the constructor
	Cat(int feedingsRequired)
	{
		super(feedingsRequired);
	}

	// If the user gives the animals anything other than salmon, nothing happens
	// otherwise, numberOfFeedings increases by 1
	public void feed(FoodType ft)
	{
		if (ft != FoodType.SALMON)
			return;
		else
			numberOfFeedings++;
	}

	// In order to identify the cat
	public String speak()
	{
		return "MEOW";
	}
}