import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CS225_Lab10_Basketball_Roster extends JFrame 
{
    private JPanel contentPane;
    private JList<String> firstRoster;
    private JList<String> firstStarters;
    private DefaultListModel<String> rosterList = new DefaultListModel<String>();
    private DefaultListModel<String> starterList = new DefaultListModel<String>();
    private JCheckBox checkGuard1;
    private JCheckBox checkGuard2;
    private JCheckBox checkForward1;
    private JCheckBox checkForward2;
    private JCheckBox checkCenter;
    private JButton btnStart;

    public static void main(String[] args) 
    {
    	try 
    	{
    		CS225_Lab10_Basketball_Roster frame = new CS225_Lab10_Basketball_Roster();
    		frame.setVisible(true);
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    	}
    }

    public CS225_Lab10_Basketball_Roster() 
    {
    	String[] teamPlayers = new String[] {"Matthew Dellavedova (G)", "Joe Harris (G)", 
    			"Brendan Haywood (C)", "Kyrie Irving (G)", "LeBron James (F)", "James Jones (F)",
    			"Kevin Love (F)", "Shawn Marion (F)", "Mike Miller (F)", "Timofey Mozgov (C)",
    			"Kendrick Perkins (C)", "Iman Shumpert (G)", "J.R. Smith (G)", 
    			"Tristan Thompson (C)", "Anderson Varejao (C)"};
        setTitle("JAYLEN'S Dream Team Roster");
        setDefaultCloseOperation(3);
        setBounds(100, 100, 582, 603);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblRoster = new JLabel("Roster:"); 
        int n = teamPlayers.length;
        int n2 = 0;
        while (n2 < n) 
        {
            String p = teamPlayers[n2];
            rosterList.addElement(p);
            ++n2;
        }
        
        firstRoster = new JList<String>(rosterList);
        firstRoster.setBorder(new BevelBorder(1, null, null, null, null));
        JButton btnRight = new JButton(">");
        JButton btnLeft = new JButton("<");
        
        JLabel lblStarters = new JLabel("Starters:");
        firstStarters = new JList<String>(starterList);
        firstStarters.setBorder(new BevelBorder(1, null, null, null, null));
        
        btnStart = new JButton("Start Game");
        btnStart.setEnabled(false);
        
        checkGuard1 = new JCheckBox("Guard1");
        checkGuard1.setEnabled(false);
        
        checkGuard2 = new JCheckBox("Guard2");
        checkGuard2.setEnabled(false);
        
        checkForward1 = new JCheckBox("Forward1");
        checkForward1.setEnabled(false);
        
        checkForward2 = new JCheckBox("Forward2");
        checkForward2.setEnabled(false);
        
        checkCenter = new JCheckBox("Center");
        checkCenter.setEnabled(false);
        
        btnRight.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		if (firstRoster.getSelectedIndex() >= 0) 
        		{
        			String player = (String)firstRoster.getSelectedValue();
        			boolean addPlayer = false;
        			
        			if (player.contains("(G)")) 
        			{
        				if (!checkGuard1.isSelected()) 
        				{
        					checkGuard1.setSelected(true);
        					addPlayer = true;
        				} 
        				else if (!checkGuard2.isSelected()) 
        				{
        					checkGuard2.setSelected(true);
        					addPlayer = true;
        				}
        			} 
        			else if (player.contains("(F)")) 
        			{
        				if (!checkForward1.isSelected()) 
        				{
        					checkForward1.setSelected(true);
        					addPlayer = true;
        				} 
        				else if (!checkForward2.isSelected()) 
        				{
        					checkForward2.setSelected(true);
        					addPlayer = true;
        				}
        			} 
        			else if (player.contains("(C)") && !checkCenter.isSelected())
        			{
        				checkCenter.setSelected(true);
        				addPlayer = true;
        			}
        			if (addPlayer) 
        			{
        				rosterList.removeElement(player);
        				starterList.addElement(player);
        				
        				if (checkGuard1.isSelected() && checkGuard2.isSelected() && checkForward1.isSelected() 
        						&& checkForward1.isSelected() && checkCenter.isSelected()) 
        				{
        					btnStart.setEnabled(true);
        				} 
        				else 
        				{
        					btnStart.setEnabled(false);
        				}
        			}
        		}
        	}
        });
        
        btnLeft.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                if (firstStarters.getSelectedIndex() >= 0) 
                {
                    String player = firstStarters.getSelectedValue();
                    if (player.contains("(G)")) 
                    {
                        if (checkGuard2.isSelected()) 
                        {
                            checkGuard2.setSelected(false);
                        } 
                        else if (checkGuard1.isSelected()) 
                        {
                            checkGuard1.setSelected(false);
                        }
                    } 
                    else if (player.contains("(F)"))
                    {
                        if (checkForward2.isSelected()) 
                        {
                            checkForward2.setSelected(false);
                        } 
                        else if (checkForward1.isSelected()) 
                        {
                            checkForward1.setSelected(false);
                        }
                    } 
                    else if (player.contains("(C)") && checkCenter.isSelected()) 
                    {
                        checkCenter.setSelected(false);
                    }
                    
                    starterList.removeElement(player);
                    rosterList.addElement(player);
                    if (checkGuard1.isSelected() && checkGuard2.isSelected() && checkForward1.isSelected() 
                    		&& checkForward1.isSelected() && checkCenter.isSelected()) 
                    {
                        btnStart.setEnabled(true);
                    } 
                    else 
                    {
                        btnStart.setEnabled(false);
                    }
                }
            }
        });
        
        btnStart.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) 
            {
                JOptionPane.showMessageDialog(null, "Let's get it started in here!");
            }
        });
        
        GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
        
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblRoster)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(firstRoster, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnLeft)
        						.addComponent(btnRight))))
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(25)
        					.addComponent(lblStarters))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(18)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_contentPane.createSequentialGroup()
        									.addComponent(checkGuard2)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(checkForward2))
        								.addGroup(gl_contentPane.createSequentialGroup()
        									.addComponent(checkGuard1)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(checkForward1))
        								.addComponent(firstStarters, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        								.addComponent(checkCenter))
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addComponent(btnStart)
        							.addGap(7)))))
        			.addContainerGap(136, Short.MAX_VALUE))
        );
        
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblRoster)
        						.addComponent(lblStarters))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(firstRoster, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addGap(5)
        							.addComponent(firstStarters, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(checkGuard1)
        						.addComponent(checkForward1))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(checkGuard2)
        						.addComponent(checkForward2))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(checkCenter)
        					.addGap(13)
        					.addComponent(btnStart))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(133)
        					.addComponent(btnRight)
        					.addGap(18)
        					.addComponent(btnLeft)))
        			.addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}