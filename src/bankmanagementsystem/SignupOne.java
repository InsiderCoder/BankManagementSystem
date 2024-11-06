package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JLabel formno, personDetails, name, fname, dob, gender, email, marital, address, city, state, pincode;
	JTextField nameTextField, fnameTextField, dobTextField, genderTextField, emailidTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JRadioButton male, female, married, unmarried, other;
	JButton next;
	
	SignupOne(){
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
		setLayout(null);
		setSize(850, 800);
		setLocation(350, 10);
	
		Random ran = new Random();
		long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		
		// JLabel & JTextField
		formno = new JLabel("APPLICATION FORM NO." + random);
		formno.setFont(new Font ("Oswrad", Font.BOLD, 25));
		formno.setBounds(250, 20, 500, 30);
		add(formno);
		
		personDetails = new JLabel("Page 1 : Personal Details");
		personDetails.setFont(new Font ("Oswrad", Font.BOLD, 20));
		personDetails.setBounds(300, 50, 500, 30);
		add(personDetails);
		
		name = new JLabel("Name :");
		name.setFont(new Font ("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(350, 140, 400, 30);
		add(nameTextField);
		
		fname = new JLabel("Father's Name :");
		fname.setFont(new Font ("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 180, 150, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setBounds(350, 180, 400, 30);
		add(fnameTextField);
		
		dob = new JLabel("Date Of Birth :");
		dob.setFont(new Font ("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 220, 150, 30);
		add(dob);
		
		dobTextField = new JTextField();
		dobTextField.setBounds(350, 220, 150, 30);
		add(dobTextField);
		
		gender = new JLabel("Gender :");
		gender.setFont(new Font ("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 260, 150, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(350, 260, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 260, 70, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		email = new JLabel("Email Address :");
		email.setFont(new Font ("Raleway", Font.BOLD, 20));
		email.setBounds(100, 300, 150, 30);
		add(email);
		
		emailidTextField = new JTextField();
		emailidTextField.setBounds(350, 300, 400, 30);
		add(emailidTextField);
		
		marital = new JLabel("Marital Status :");
		marital.setFont(new Font ("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 340, 150, 30);
		add(marital);
		
		married = new JRadioButton("Marride");
		married.setBounds(350, 340, 70, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 340, 90, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(550, 340, 70, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		address = new JLabel("Address :");
		address.setFont(new Font ("Raleway", Font.BOLD, 20));
		address.setBounds(100, 380, 150, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(350, 380, 400, 30);
		add(addressTextField);
		
		city = new JLabel("City :");
		city.setFont(new Font ("Raleway", Font.BOLD, 20));
		city.setBounds(100, 420, 150, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(350, 420, 400, 30);
		add(cityTextField);
		
		state = new JLabel("State :");
		state.setFont(new Font ("Raleway", Font.BOLD, 20));
		state.setBounds(100, 460, 150, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(350, 460, 400, 30);
		add(stateTextField);
		
		pincode = new JLabel("Pin Code :");
		pincode.setFont(new Font ("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 500, 150, 30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setBounds(350, 500, 400, 30);
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setBounds(370, 600, 100, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno = "" + random;
		String name = nameTextField.getText();
		String fname= fnameTextField.getText();
		String dob = dobTextField.getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}
		
		String email = emailidTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}else if(other.isSelected()) {
			marital = "Other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		try {
			if(pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "Fill the all Required Details !");
			}else {
				Conn c1 = new Conn();
				String query = "insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
				c1.s.executeUpdate(query);
				
				//signup2 object
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
				
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new SignupOne(); 

	}

}
