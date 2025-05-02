package bank.management.system;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	JButton deposit,fastcash,withdrawl,ministatement,pinchange,balanceenquiry,exit;
	String pinNumber;
	Transactions(String pinNumber){
		pinNumber = this.pinNumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(750, 750,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,750,750);
		add(image);
		
		JLabel text = new JLabel("Please Select your Transaction");
		text.setBounds(170,240,450,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		image.add(text);
		
		
		 deposit = new JButton("Deposit");
		deposit.setBounds(135,320,130,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(285,320,130,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		 fastcash = new JButton("Fast Cash");
		fastcash.setBounds(135,355,130,25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		 ministatement = new JButton("Mini Statement");
		ministatement.setBounds(285,355,130,25);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		 pinchange = new JButton("Pin Change");
		pinchange.setBounds(135,390,130,25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		 balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(285,390,130,25);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		 exit = new JButton("Exit");
		exit.setBounds(285,425,130,25);
		exit.addActionListener(this);
		image.add(exit);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(750,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource() == exit) {
			 System.exit(0);
		 }else if(ae.getSource() == deposit) {
			 setVisible(false);
			 new Deposit(pinNumber).setVisible(true);
		 }else if(ae.getSource() == withdrawl) {
			 setVisible(false);
			 new Withdrawl(pinNumber).setVisible(true);
		 }
		 else if(ae.getSource() == fastcash) {
			 setVisible(false);
			 new FastCash(pinNumber).setVisible(true);
		 }else if(ae.getSource() == pinchange) {
			 setVisible(false);
			 new PinChange(pinNumber).setVisible(true);
		 }else if(ae.getSource() == balanceenquiry) {
			 setVisible(false);
			 new BalanceEnquiry(pinNumber).setVisible(true);
		 }else if(ae.getSource() == ministatement) {
			 setVisible(true);
			 new MiniStatement(pinNumber).setVisible(true);
		 }
	}

	public static void main(String[] args) {
		new Transactions("");

	}

}
