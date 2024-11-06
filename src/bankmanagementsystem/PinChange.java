package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JLabel text, pintext, newpin, repin;
	JPasswordField newpintext, repintext;
	JButton change, back;
	String pinnumber;
	
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		setSize(900, 900);
		setLocation(300, 0);
		
		ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image j2 = j1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon j3 = new ImageIcon(j2);
		JLabel image = new JLabel(j3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(260, 290, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		pintext = new JLabel("CHANGE YOUR PIN");
		pintext.setBounds(260, 290, 700, 35);
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(pintext);
		
		newpin = new JLabel("New Pin");
		newpin.setBounds(200, 360, 180, 35);
		newpin.setForeground(Color.WHITE);
		newpin.setFont(new Font("System", Font.BOLD, 16));
		image.add(newpin);
		
		repin = new JLabel("Re-Enter Pin");
		repin.setBounds(200, 390, 700, 35);
		repin.setForeground(Color.WHITE);
		repin.setFont(new Font("System", Font.BOLD, 16));
		image.add(repin);
		
		newpintext = new JPasswordField();
		newpintext.setFont(new Font("Railway", Font.BOLD, 25));
		newpintext.setBounds(330, 360, 180, 25);
		image.add(newpintext);
		
		repintext = new JPasswordField();
		repintext.setFont(new Font("Railway", Font.BOLD, 25));
		repintext.setBounds(330, 390, 180, 25);
		image.add(repintext);
		
		change = new JButton("Change");
		change.setBounds(370, 485, 130, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(370, 520, 130, 30);
		back.addActionListener(this);
		image.add(back);
		
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			try {
				String npin = newpintext.getText();
				String rpin = repintext.getText();
			
				if(!npin.equals(rpin)) {
						JOptionPane.showMessageDialog(null, "Entered PIN dose not match");
						return;
					}
				
					
					if(npin.equals("")) {
							JOptionPane.showMessageDialog(null, "Enter New Pin");
					}
					
					if(rpin.equals("")) {
						JOptionPane.showMessageDialog(null, "Re-Enter New Pin");
					}
					
					Conn conn = new Conn();
					String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
					String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
					String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					conn.s.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "Pin change successfully");
					
					setVisible(false);
					new Transactions(rpin).setVisible(true);
					
					
				}catch (Exception e) {
			
				}
			
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new PinChange("");

	}

}
