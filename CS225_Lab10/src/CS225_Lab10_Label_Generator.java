import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;

////////////////////////////////////////////////////////
// This file used WindowBuilder to create a GUI with 
// components placed using absolute values. The resultant
// code is clean and easy to understand, but the GUI
// will not resize "Gracefully"
public class CS225_Lab10_Label_Generator extends JFrame
{
	////////////////////////////////////////////////////
	// Control Instance Variables
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZipCode;
	private JRadioButton btnMale;
	private JRadioButton btnFemale;
	private JComboBox<?> cbTitles;
	private JButton btnSubmit;
	private JTextArea textArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	////////////////////////////////////////////////////
	// Main to initialize and call the GUI
	public static void main(String[] args)
	{
            try 
            {
            	CS225_Lab10_Label_Generator frame = new CS225_Lab10_Label_Generator();
                frame.setVisible(true);
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
	}

	////////////////////////////////////////////////////
	// Constructor
	public CS225_Lab10_Label_Generator()
	{
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////
	// Initialize all components and controls
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CS225_Lab10_Label_Generator.class.getResource("/resources/download.jpg")));
		
		JLabel lblMailIcon = new JLabel();
	    lblMailIcon.setIcon(new ImageIcon(CS225_Lab10_Label_Generator.class.getResource("/resources/download2.jpg")));
	    lblMailIcon.setBounds(10, 11, 96, 88);
	    contentPane.add(lblMailIcon);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(10, 127, 66, 25);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(86, 129, 172, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("LastName:");
		lblLastName.setBounds(10, 166, 66, 14);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(86, 163, 172, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 201, 66, 14);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(86, 198, 172, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 232, 66, 14);
		contentPane.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(86, 229, 172, 20);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 263, 66, 14);
		contentPane.add(lblState);
		
		txtState = new JTextField();
		txtState.setBounds(86, 260, 172, 20);
		contentPane.add(txtState);
		txtState.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zipcode:");
		lblZipCode.setBounds(10, 294, 66, 14);
		contentPane.add(lblZipCode);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(86, 291, 172, 20);
		contentPane.add(txtZipCode);
		txtZipCode.setColumns(10);
		
		btnMale = new JRadioButton("Male");
		buttonGroup.add(btnMale);
		btnMale.setBounds(31, 332, 89, 23);
		contentPane.add(btnMale);
		
		btnFemale = new JRadioButton("Female");
		buttonGroup.add(btnFemale);
		btnFemale.setBounds(122, 332, 89, 23);
		contentPane.add(btnFemale);
		
		cbTitles = new JComboBox<>();
		cbTitles.setModel(new DefaultComboBoxModel(new String[] {"Dr." , "Mr." , "Mrs.", "Ms." , "Miss" }));
		cbTitles.setBounds(109, 101, 116, 20);
		contentPane.add(cbTitles);
		
		textArea = new JTextArea();
		textArea.setBounds(288, 6, 386, 302);
		contentPane.add(textArea);
		setTitle("Jaylen's Best Label Generator he could possible make!");	
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(CS225_Lab10_Label_Generator.class.getResource("/resources/download3.jpg")));
		btnSubmit.setBounds(288, 332, 386, 47);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Mail Label :o");
		lblNewLabel.setBounds(122, 36, 102, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrefix = new JLabel("Prefix:");
		lblPrefix.setBounds(10, 99, 66, 25);
		contentPane.add(lblPrefix);
		
	}

	////////////////////////////////////////////////////
	// Create all component events
	private void createEvents()
	{
		////////////////////////////////////////////////
		// Handler for the Submit button - grab the input
		// from the text boxes and combobox and output in 
		// a popup message.
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (btnMale.isSelected()) 
				{
                    textArea.setForeground(Color.BLUE);
                }
                if (btnFemale.isSelected()) 
                {
                    textArea.setForeground(Color.PINK);
                }
                
				textArea.setText(cbTitles.getSelectedItem() + " " 
                + txtFirstName.getText() + " " + txtLastName.getText() 
                + "\n" + txtAddress.getText() + ", " + txtCity.getText() 
                + ", " + txtState.getText() + ", " + txtZipCode.getText());
			}
		});
	}
}