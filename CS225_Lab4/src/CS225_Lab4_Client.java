/* CS 225 - Intro to Computer Science
 * File Name: CS225_Lab4_Client.java
 * Java Programming
 * Lab 4 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Jaylen Quizon
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for the Lab 4 client.
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
public class CS225_Lab4_Client
{
	//////////////////////////////////////////////////////////
	// Main method calls the two different banner-creators
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen");
		System.out.println("Lab 4");
		System.out.println("");
		
		CreatePsychedelicBanner();
		CreateCustomBanner();
	}
	
	//////////////////////////////////////////////////////////
	// Client code for creating a psychedelic banner
	static void CreatePsychedelicBanner()
	{
		PersonalizedFbBanner fbb = new PersonalizedFbBanner();

		for (int i = 0; i < 10000; i++)
		{
			fbb.DrawRandomFilledOval();
			fbb.DrawRandomFilledRectangle();
		}

		for (int i = 0; i < 3; i++)
		{
			fbb.DrawTextAtRandomLocation("xD");
			fbb.DrawTextAtRandomLocation("I love me a good meme.");
			fbb.DrawTextAtRandomLocation("Hey, that's pretty good!");
			fbb.DrawTextAtRandomLocation("c:");
		}
		fbb.DrawCenteredPicture("myPic.jpg", 10);
		fbb.writeImageToFile("LastName_Psych_FBB");

		System.out.println("Your psychedelic banner is ready!");
	}
	
	///////////////////////////////////////////////////////////
	// Client code for creating your custom banner
	static void CreateCustomBanner()
	{
		PersonalizedFbBanner fbb = new PersonalizedFbBanner();
		fbb.DrawCustomizedDecoration();
		fbb.DrawCenteredPicture("myPic.jpg", 10);
		fbb.writeImageToFile("LastName_Cust_FBB");

		System.out.println("Your custom banner is ready!");
	}
}
