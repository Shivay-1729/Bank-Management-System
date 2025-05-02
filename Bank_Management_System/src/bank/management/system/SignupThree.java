package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{

	   JRadioButton r1,r2,r3,r4;
	   JCheckBox c1,c2,c3,c4,c5,c6,c7;
	   JButton submit,cancel;
	   String formno;
	public SignupThree(String formno) {
		setLayout(null);
		formno = this.formno;
		JLabel l1 = new JLabel("Page 3: Account Deatils");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,10,400,40);
		add(l1);
		
		JLabel type = new JLabel("Account type:");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,80,200,30);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,120,150,20);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Acount");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350,120,250,20);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,160,200,20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350,160,250,20);
		add(r4);
		
		ButtonGroup groupAccount = new ButtonGroup();
		groupAccount.add(r1);
		groupAccount.add(r2);
		groupAccount.add(r3);
		groupAccount.add(r4);
		
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,220,200,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4107");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,220,300,30);
		add(number);
		
		JLabel cardDetails = new JLabel("Your 16 digit Card Number");
		cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
		cardDetails.setBounds(100,250,300,20);
		add(cardDetails);
				
		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,300,200,30);
		add(pin);
		
		JLabel pinDetails = new JLabel("Your 4 digit Pin Number");
		pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
		pinDetails.setBounds(100,330,200,20);
		add(pinDetails);
		
		JLabel pinNumber = new JLabel("XXXX");
		pinNumber.setFont(new Font("Raleway",Font.BOLD,22));
		pinNumber.setBounds(330,300,300,30);
		add(pinNumber);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,18));
		services.setBounds(100,380,200,30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100,420,200,30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(350,420,200,30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100,470,200,30);
		add(c3);
		
		c4 = new JCheckBox("Email and SMS Alerting");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(350,470,200,30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(100,520,200,30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(350,520,200,30);
		add(c6);
		
		c7 = new JCheckBox("I  hereby declare that the above entered details are correct to the best of knowledge");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raleway",Font.BOLD,15));
		c7.setBounds(100,560,690,30);
		add(c7);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(220,620,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(420,620,100,30);
		submit.addActionListener(this);
		add(submit);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			String accountType = null;
			if(r1.isSelected()) {
				accountType = "Saving Account";
			}else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()) {
				accountType = "Recurring Account";
			}
			Random random = new Random();
			String cardNumber = ""+Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
			
			String pinNumber = ""+Math.abs((random.nextLong() % 9000L)+1000L);
			
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + "ATM Card";
			}else if(c2.isSelected()) {
				facility = facility + "Internet Banking";
			}else if(c3.isSelected()) {
				facility = facility + "Mobile Banking";
			}else if(c4.isSelected()) {
				facility = facility + "Email & SMS Alert";
			}else if(c5.isSelected()) {
				facility = facility + "Cheque Book";
			}else if(c6.isSelected()) {
				facility = facility + "E-Statement";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				else {
					Conn conn = new Conn();
					String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber+"\n Pin: " + pinNumber);
			     setVisible(false);
			     new Deposit(pinNumber).setVisible(true);
				}
			}catch(Exception e) {
				System.out.println(e);
				}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupThree("");

	}

}
