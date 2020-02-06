/* CS 225 - Intro to Computer Science
 * File Name: CS225_Lab9.java
 * Java Programming
 * Lab 9 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Jaylen Quizon
 * 
 * Description: This file contains the source code for Lab 9.
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
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CS225_Lab9 extends JFrame
{
	// Components
	JButton addButton = new JButton("+");
	JButton subButton = new JButton("-");
	JButton mulButton = new JButton("*");
	JButton divButton = new JButton("/");
	
	JLabel Operant1 = new JLabel("Operant1:");
	JLabel Operant2 = new JLabel("Operant2:");
	JLabel Answer = new JLabel("Answer:");
	
	JTextField op1 = new JTextField("", 10);
	JTextField op2 = new JTextField("", 10);
	JTextField solution = new JTextField("", 10);
	
	public static void main(String[] args)
	{
				// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Jaylen Quizon");
		System.out.println("Lab 9");
		System.out.println("");

		CS225_Lab9 gui = new CS225_Lab9();
		System.out.println("Exiting main...");
	}
	
	public CS225_Lab9()
	{
		super();
		initComponents();
		createEvents();
	}

	// Initializing all of the components within the GUI
	private void initComponents() 
	{
		// Init components
		setTitle("Jaylen's Super Awesome Magic Calculator");
		setSize(750 , 100);
		setLocation(200 , 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Get container of window and add controls
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		container.add(Operant1);
		container.add(op1);
		container.add(Operant2);
		container.add(op2);
		container.add(addButton);
		container.add(subButton);
		container.add(mulButton);
		container.add(divButton);
		container.add(Answer);
		container.add(solution);
		
		addButton.setToolTipText("This button adds up your values.");
		subButton.setToolTipText("This button subtracts up your values.");
		mulButton.setToolTipText("This button multiplies up your values.");
		divButton.setToolTipText("This button divides your values.");
	}

	private void createEvents() 
	{
		addButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					double firstNum = Double.parseDouble(op1.getText());
					double secondNum = Double.parseDouble(op2.getText());
					double finalNum = (firstNum + secondNum);
					Answer.setText(firstNum + " + " + secondNum + " =");
					solution.setText(String.valueOf(finalNum));
					if (finalNum < 0)
					{
						solution.setForeground(Color.RED);
					}
					else
					{
						solution.setForeground(Color.BLACK);
					}
				}
				catch (Exception e)
				{
					Answer.setText("N/A");
					solution.setText("N/A");
					JOptionPane.showMessageDialog(null, "Invalid operand. Must be number", "ERROR:", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		subButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					double firstNum = Double.parseDouble(op1.getText());
					double secondNum = Double.parseDouble(op2.getText());
					double finalNum = (firstNum - secondNum);
					Answer.setText(firstNum + " - " + secondNum + " =");
					solution.setText(String.valueOf(finalNum));
					if (finalNum < 0)
					{
						solution.setForeground(Color.RED);
					}
					else
					{
						solution.setForeground(Color.BLACK);
					}
				}
				catch (Exception e)
				{
					Answer.setText("N/A");
					solution.setText("N/A");
					JOptionPane.showMessageDialog(null, "Invalid Numbers. Please try again!", "ERROR:", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		mulButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					double firstNum = Double.parseDouble(op1.getText());
					double secondNum = Double.parseDouble(op2.getText());
					double finalNum = (firstNum * secondNum);
					Answer.setText(firstNum + " * " + secondNum + " =");
					solution.setText(String.valueOf(finalNum));
					if (finalNum < 0)
					{
						solution.setForeground(Color.RED);
					}
					else
					{
						solution.setForeground(Color.BLACK);
					}
				}
				catch (Exception e)
				{
					Answer.setText("N/A");
					solution.setText("N/A");
					JOptionPane.showMessageDialog(null, "Invalid Numbers. Please try again!", "ERROR:", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		divButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					double firstNum = Double.parseDouble(op1.getText());
					double secondNum = Double.parseDouble(op2.getText());
					double finalNum = (firstNum / secondNum);
					Answer.setText(firstNum + " / " + secondNum + " =");
					solution.setText(String.valueOf(finalNum));
					if (finalNum < 0)
					{
						Answer.setForeground(Color.RED);
					}
					else
					{
						solution.setForeground(Color.BLACK);
					}
				}
				catch (Exception e)
				{
					Answer.setText("N/A");
					solution.setText("N/A");
					JOptionPane.showMessageDialog(null, "Invalid Numbers. Please try again!", "ERROR:", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
