package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
	
	JLabel page3, type, cardno, y16d, number, pin, y4d, pnumber, srequired;
	JRadioButton sa, ca, fda, rda;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;
	
	SignupThree(String formno){
		
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		setLayout(null);
		setSize(850, 800);
		setLocation(350, 10);
		
		getContentPane().setBackground(Color.WHITE);
		
		page3 = new JLabel("Page 3 : Account Details");
		page3.setFont(new Font("Oswrad", Font.BOLD, 25));
		page3.setBounds(300, 50, 500, 30);
		add(page3);
		
		type = new JLabel("Account Type :");
		type.setFont(new Font ("Raleway", Font.BOLD, 20));
		type.setBounds(100, 140, 150, 30);
		add(type);
		
		sa = new JRadioButton("Saving Account");
		sa.setBounds(100, 180, 120, 30);
		sa.setBackground(Color.WHITE);
		add(sa);
		
		ca = new JRadioButton("Current Account");
		ca.setBounds(100, 210, 120, 30);
		ca.setBackground(Color.WHITE);
		add(ca);
		
		fda = new JRadioButton("Fixed Deposit Account");
		fda.setBounds(300, 180, 160, 30);
		fda.setBackground(Color.WHITE);
		add(fda);
		
		rda = new JRadioButton("Recurring Deposit Account");
		rda.setBounds(300, 210, 190, 30);
		rda.setBackground(Color.WHITE);
		add(rda);
		
		ButtonGroup typegroup = new ButtonGroup();
		typegroup.add(sa);
		typegroup.add(ca);
		typegroup.add(fda);
		typegroup.add(rda);
		
		cardno = new JLabel("Card Number :");
		cardno.setFont(new Font ("Raleway", Font.BOLD, 20));
		cardno.setBounds(100, 270, 150, 30);
		add(cardno);
		
		y16d = new JLabel("Your 16 Digit Card Number");
		y16d.setFont(new Font ("Raleway", Font.BOLD, 15));
		y16d.setBounds(100, 290, 200, 30);
		add(y16d);
		
		number = new JLabel("XXXX-XXXX-XXXX-5486");
		number.setFont(new Font ("Raleway", Font.BOLD, 20));
		number.setBounds(350, 270, 300, 30);
		add(number);
		
		pin = new JLabel("PIN :");
		pin.setFont(new Font ("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 340, 150, 30);
		add(pin);
		
		y4d = new JLabel("Your 4 Digit Password");
		y4d.setFont(new Font ("Raleway", Font.BOLD, 15));
		y4d.setBounds(100, 360, 200, 30);
		add(y4d);
		
		pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font ("Raleway", Font.BOLD, 20));
		pnumber.setBounds(350, 340, 300, 30);
		add(pnumber);
		
		srequired = new JLabel("Services Required :");
		srequired.setFont(new Font ("Raleway", Font.BOLD, 20));
		srequired.setBounds(100, 420, 200, 30);
		add(srequired);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBounds(100, 450, 190, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("Mobile Banking");
		c2.setBounds(100, 490, 190, 30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		c3 = new JCheckBox("Cheque Book");
		c3.setBounds(100, 530, 190, 30);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		c4 = new JCheckBox("Internet Banking");
		c4.setBounds(300, 450, 190, 30);
		c4.setBackground(Color.WHITE);
		add(c4);
		
		c5 = new JCheckBox("EMAIL & SMS Alerts");
		c5.setBounds(300, 490, 190, 30);
		c5.setBackground(Color.WHITE);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBounds(300, 530, 190, 30);
		c6.setBackground(Color.WHITE);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the entered details are correct to the best of my knowledge.");
		c7.setBounds(100, 600, 600, 30);
		c7.setBackground(Color.WHITE);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBounds(300, 660, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(420, 660, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String acctype = null;
			if (sa.isSelected()) {
				acctype = "Saving Account";
			}else if (ca.isSelected()) {
				acctype = "Current Account";
			}else if (fda.isSelected()) {
				acctype = "Fixed Deposit Account";
			}else if (rda.isSelected()) {
				acctype = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if (c1.isSelected()) {
				facility = facility + "ATM Card";
			}else if (c2.isSelected()) {
				facility = facility + "Mobile Banking";
			}else if (c3.isSelected()) {
				facility = facility + "Cheque Book";
			}else if (c4.isSelected()) {
				facility = facility + "Internet Banking";
			}else if (c5.isSelected()) {
				facility = facility + "EMAIL & SMS Alerts";
			}else if (c6.isSelected()) {
				facility = facility + "E-Statement";
			}
			
			try {
				if(acctype.equals("")) {
					JOptionPane.showMessageDialog(null, "Account type is required");
				}else {
					Conn c1 = new Conn();
					String query1 = "insert into signupthree values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					
					c1.s.executeUpdate(query1);
					c1.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number:- " + cardnumber + "\n Pin:- " + pinnumber);
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
				}
			} catch (Exception e){
				System.out.println(e);
			}
		}else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new SignupThree("");
	}

}
