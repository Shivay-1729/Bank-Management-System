package bank.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
	
	JTextField pan,adhar;
	JComboBox religion,category,income,education,occupation;
	JRadioButton syes,sno,eyes,eno;
	
	JButton next;
	String formno;
	public SignupTwo(String formno)
	{
		this.formno = formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		

		
		
		JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
		AdditionalDetails.setFont(new Font("Raleway", Font.BOLD,30));
		AdditionalDetails.setBounds(240, 80, 400,40);
		add(AdditionalDetails);
		
		
		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Raleway", Font.BOLD,20));
		name.setBounds(100, 140, 100,30);
		add(name);
		
		String[] valReligion  = {"Hindu","Muslim","Sikh","Christian","other"};
			
 		 religion = new JComboBox(valReligion);
 		religion.setBounds(300,140,400,30);
 		religion.setBackground(Color.WHITE);
		add(religion);

		
		JLabel fname = new JLabel("Category:");
		fname.setFont(new Font("Raleway", Font.BOLD,20));
		fname.setBounds(100, 190, 200,30);
		add(fname);
		
		String[] valCategory  = {"General","OBC","SC","ST","other"};
		 category = new JComboBox(valCategory);
		category .setBounds(300,190,400,30);
		category.setBackground(Color.white);
		add(category );
		
		
		
		
		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Raleway", Font.BOLD,20));
		dob.setBounds(100, 240, 200,30);
		add(dob);
		
		String[] incomeCategory  = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		 income = new JComboBox(incomeCategory);
		 income.setBounds(300,240,400,30);
		 income.setBackground(Color.white);
		add(income);
		
				
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD,20));
		gender.setBounds(100, 290, 200,30);
		add(gender);
		
		 
		
		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Raleway", Font.BOLD,20));
		email.setBounds(100, 315, 200,30);
		add(email);
		
		String[] educationalValues = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","other"};
		 education = new JComboBox(educationalValues);
		education.setBounds(300,315,400,30);
		education.setBackground(Color.white);
		add(education);
		
		
		
		JLabel marital = new JLabel("Occupation:");
		marital.setFont(new Font("Raleway", Font.BOLD,20));
		marital.setBounds(100, 390, 200,30);
		add(marital);
		
		String[] occupationValues = {"Salaried","Self-employed","Bussiness","Student","Retired","Other"};
		 occupation = new JComboBox(occupationValues);
		occupation.setBounds(300,390,400,30);
		occupation.setBackground(Color.white);
		add(occupation);
		
		
		
		
		
		JLabel address = new JLabel("Pan Number:");
		address.setFont(new Font("Raleway", Font.BOLD,20));
		address.setBounds(100, 440, 200,30);
		add(address);
		
		 pan = new JTextField();
		 pan.setFont(new Font("Raleway",Font.BOLD,14));
		 pan.setBounds(300,440,400,30);
		add(pan);
		
		
		JLabel city = new JLabel("Adhar Number:");
		city.setFont(new Font("Raleway", Font.BOLD,20));
		city.setBounds(100, 490, 200,30);
		add(city);
		
		 adhar = new JTextField();
		 adhar.setFont(new Font("Raleway",Font.BOLD,14));
		 adhar.setBounds(300,490,400,30);
		add(adhar);
		
		
		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway", Font.BOLD,20));
		state.setBounds(100, 540, 200,30);
		add(state);
		
		syes = new JRadioButton("Yes");
	    syes.setFont(new Font("Raleway",Font.BOLD,14));
		 syes.setBounds(300,540,100,30);
		 syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setFont(new Font("Raleway",Font.BOLD,14));
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup s1 = new ButtonGroup();
		s1.add(syes);
		s1.add(sno);
		
		
		JLabel pincode = new JLabel("Existing Account:");
		pincode.setFont(new Font("Raleway", Font.BOLD,20));
		pincode.setBounds(100, 590, 200,30);
		add(pincode);
		
		eyes = new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway",Font.BOLD,14));
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setFont(new Font("Raleway",Font.BOLD,14));
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup s2 = new ButtonGroup();
		s2.add(eyes);
		s2.add(eno);
		
		
		
		 next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,630,80,20);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.out.println("button clicked");
		
		String sReligion = (String)religion.getSelectedItem();
		String sCategory =(String) category.getSelectedItem();
		String sIncome  = (String) income.getSelectedItem(); 
		String sEducation = (String) education.getSelectedItem();
		String sOccupation = (String) occupation.getSelectedItem();
      String seniorcitizen = null;
        if(syes.isSelected()) {
        	seniorcitizen = "Yes";
        }else if(sno.isSelected()) {
        	seniorcitizen = "No";
        }
        
        
        String existingAccount = null;
        if(eyes.isSelected()) {
        	seniorcitizen = "Yes";
        }else if(eno.isSelected()) {
        	seniorcitizen = "No";
        }
        
       String span = pan.getText();
       String sadhar = adhar.getText();
        
        try {
        	 
        		Conn c = new Conn();
        		String query = "insert into signuptwo values('"+formno+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEducation+"', '"+sOccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingAccount+"')";
        	 c.s.executeUpdate(query);
        	 setVisible(false);
        	 new SignupThree(formno).setVisible(true);
        	
        	}catch(Exception e) {
        	
        }
	}
	public static void main(String[] args) {
		new SignupTwo("");

	}

}

