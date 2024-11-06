package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JLabel text;
	JButton back;
	String pinnumber;
	
	BalanceEnquiry(String pinnumber){
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
		
		back = new JButton("Back");
		back.setBounds(370, 520, 130, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn = new Conn();
		int balance = 0;
		try {
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			while (rs.next()) {
				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
				}
			}catch (Exception e){
				
			}

		text = new JLabel("Your Current account balance is Rs. " + balance);
		text.setBounds(200, 290, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 13));
		image.add(text);
		
		setUndecorated(true);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

}
