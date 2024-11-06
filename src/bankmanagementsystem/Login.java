package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		setTitle("ATM");
		
		setLayout(null);
		
		setSize(800,480);
		setLocation(350, 200);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 50, 100, 100);
		add(label);
		
		// JLabel
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font ("Osward", Font.BOLD, 38));
		text.setBounds(250, 80, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("Card No.");
		cardno.setFont(new Font ("Raleway", Font.BOLD, 28));
		cardno.setBounds(150, 160, 400, 40);
		add(cardno);
		
		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font ("Raleway", Font.BOLD, 28));
		pin.setBounds(150, 220, 400, 40);
		add(pin);
		
		// JTextField
		cardTextField = new JTextField();
		cardTextField.setBounds(350, 165, 250, 30);
		add(cardTextField);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(350, 225, 250, 30);
		add(pinTextField);
		
		// JButton
		login = new JButton("SIGN IN");
		login.setBounds(350, 300, 100, 30);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(500, 300, 100, 30);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(425, 350, 100, 30);
		signup.addActionListener(this);
		add(signup);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if (ae.getSource() == login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'"; 
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin !");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if (ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Login();

	}

}
