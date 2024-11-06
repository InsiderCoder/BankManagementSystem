package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;
	
	Withdrawl(String pinnumber){
		this.pinnumber = pinnumber;
		setSize(900, 900);
		setLocation(300, 0);
		
		ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image j2 = j1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon j3 = new ImageIcon(j2);
		JLabel image = new JLabel(j3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setBounds(195, 290, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Railway", Font.BOLD, 22));
		amount.setBounds(180, 350, 320, 25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(370, 485, 130, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(370, 520, 130, 30);
		back.addActionListener(this);
		image.add(back);
		
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}else {
				try {
					Conn conn = new Conn();
					String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}else if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Withdrawl("");

	}

}

