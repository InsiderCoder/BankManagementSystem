package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton one00, five00, one000, two000, five000, ten000, back;
	String pinnumber;
	
	FastCash(String pinnumber){
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
		
		JLabel text = new JLabel("Please select your withdraw amount");
		text.setBounds(200, 290, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		one00 = new JButton("Rs 100");
		one00.setBounds(170, 415, 130, 30);
		one00.addActionListener(this);
		image.add(one00);
		
		five00 = new JButton("Rs 500");
		five00.setBounds(370, 415, 130, 30);
		five00.addActionListener(this);
		image.add(five00);
		
		one000 = new JButton("Rs 1000");
		one000.setBounds(170, 450, 130, 30);
		one000.addActionListener(this);
		image.add(one000);
		
		two000 = new JButton("Rs 2000");
		two000.setBounds(370, 450, 130, 30);
		two000.addActionListener(this);
		image.add(two000);
		
		five000 = new JButton("Rs 5000");
		five000.setBounds(170, 485, 130, 30);
		five000.addActionListener(this);
		image.add(five000);
		
		ten000 = new JButton("Rs 10000");
		ten000.setBounds(370, 485, 130, 30);
		ten000.addActionListener(this);
		image.add(ten000);
		
		back = new JButton("BACK");
		back.setBounds(370, 520, 130, 30);
		back.addActionListener(this);
		image.add(back);
		
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn conn = new Conn();
			try {
				ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while (rs.next()) {
					if (rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient balance");
					return;
				}
				
				Date date = new Date();
				String query = "Insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Sucessfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}catch (Exception e){
				
			}
		}
	}
	public static void main(String[] args) {
		new FastCash("");

	}

}
