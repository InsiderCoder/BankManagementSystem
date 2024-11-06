package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	JLabel additionalDetails, religion, category, income, educational, qualification, occupation, pannumber, aadharnumber, seniorcitizen, exisitingacc;
	JComboBox religionbox, categorybox, incomebox, educationalbox, occupationbox;
	JTextField panTextField, aadharTextField;
	JRadioButton syes, sno, eyes, eno;
	JButton next;
	String formno;
	
	SignupTwo(String formno){
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		setSize(850, 800);
		setLocation(350, 10);
		
		// JLabel & JTextField
		
		additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font ("Oswrad", Font.BOLD, 20));
		additionalDetails.setBounds(300, 50, 500, 30);
		add(additionalDetails);
		
		religion = new JLabel("Religion :");
		religion.setFont(new Font ("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String valreligion[] = {"Hindi", "Muslim", "Sikh", "Christian", "Other"};
		religionbox = new JComboBox(valreligion);	
		religionbox.setBounds(350, 140, 400, 30);
		religionbox.setBackground(Color.WHITE);
		add(religionbox);
		
		category = new JLabel("Category :");
		category.setFont(new Font ("Raleway", Font.BOLD, 20));
		category.setBounds(100, 180, 150, 30);
		add(category);
		
		String valcategory[] = {"General", "OBC", "ST", "SC", "Other"};
		categorybox = new JComboBox(valcategory);
		categorybox.setBounds(350, 180, 400, 30);
		categorybox.setBackground(Color.WHITE);
		add(categorybox);
		
		income = new JLabel("Income :");
		income.setFont(new Font ("Raleway", Font.BOLD, 20));
		income.setBounds(100, 220, 150, 30);
		add(income);
		
		String valincome [] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		incomebox = new JComboBox(valincome);
		incomebox.setBounds(350, 220, 400, 30);
		incomebox.setBackground(Color.WHITE);
		add(incomebox);
		
		educational = new JLabel("Educational :");
		educational.setFont(new Font ("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 260, 150, 30);
		add(educational);
		
		qualification = new JLabel("Qualification :");
		qualification.setFont(new Font ("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 280, 150, 30);
		add(qualification);
		
		String valeducational[] = {"Null", "Upto 9th Class Passed", "10th Class Passed", "Graduate(Gen.)", "Post Graduate(Gen.)", "CA/ ICWA/ MBA/ CFA", "Computer Degree/ Diploma/ MCA",};
		educationalbox = new JComboBox(valeducational);
		educationalbox.setBounds(350, 280, 400, 30);
		educationalbox.setBackground(Color.WHITE);
		add(educationalbox);
		
		occupation = new JLabel("Occupation :");
		occupation.setFont(new Font ("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 340, 150, 30);
		add(occupation);
		
		String valoccupation[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
		occupationbox = new JComboBox(valoccupation);
		occupationbox.setBounds(350, 340, 400, 30);
		occupationbox.setBackground(Color.WHITE);
		add(occupationbox);
		
		pannumber = new JLabel("PAN Number :");
		pannumber.setFont(new Font ("Raleway", Font.BOLD, 20));
		pannumber.setBounds(100, 380, 150, 30);
		add(pannumber);
		
		panTextField = new JTextField();
		panTextField.setBounds(350, 380, 400, 30);
		add(panTextField);
		
		aadharnumber = new JLabel("Aadhar Number :");
		aadharnumber.setFont(new Font ("Raleway", Font.BOLD, 20));
		aadharnumber.setBounds(100, 420, 190, 30);
		add(aadharnumber);
		
		aadharTextField = new JTextField();
		aadharTextField.setBounds(350, 420, 400, 30);
		add(aadharTextField);
		
		seniorcitizen = new JLabel("Senior Citizen :");
		seniorcitizen.setFont(new Font ("Raleway", Font.BOLD, 20));
		seniorcitizen.setBounds(100, 460, 150, 30);
		add(seniorcitizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(350, 460, 60, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 460, 70, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup sgroup = new ButtonGroup();
		sgroup.add(syes);
		sgroup.add(sno);
		
		exisitingacc = new JLabel("Exisiting Account :");
		exisitingacc.setFont(new Font ("Raleway", Font.BOLD, 20));
		exisitingacc.setBounds(100, 500, 190, 30);
		add(exisitingacc);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(350, 500, 60, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 500, 70, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup egroup = new ButtonGroup();
		egroup.add(eyes);
		egroup.add(eno);
		
		next = new JButton("Next");
		next.setBounds(370, 600, 100, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String religion = (String) religionbox.getSelectedItem();
		String category = (String) categorybox.getSelectedItem();
		String income = (String) incomebox.getSelectedItem();
		String qualification =  (String) educationalbox.getSelectedItem();
		String occupation = (String) occupationbox.getSelectedItem();
		String pannumber = panTextField.getText();
		String aadharnumber = aadharTextField.getText();
 		String seniorcitizen = null;
		if(syes.isSelected()) {
			seniorcitizen = "Yes";
		}else if(sno.isSelected()) {
			seniorcitizen = "No";
		}
		String exisitingacc = null;
		if(eyes.isSelected()) {
			exisitingacc = "Yes";
		}else if(eno.isSelected()) {
			exisitingacc = "No";
		}
		
		try {
			
			Conn c1 = new Conn();
			String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pannumber+"','"+aadharnumber+"','"+seniorcitizen+"','"+exisitingacc+"')";
			c1.s.executeUpdate(query);
			
			//signup3 object
			setVisible(false);
			new SignupThree(formno).setVisible(true);
						
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		new SignupTwo(""); 

	}

}
