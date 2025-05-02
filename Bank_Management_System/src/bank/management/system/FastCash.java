package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
	JButton deposit,fastcash,withdrawl,ministatement,pinchange,balanceenquiry,exit;
	String pinNumber;
	FastCash(String pinNumber){
		pinNumber = this.pinNumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(750, 750,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,750,750);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(170,240,450,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		image.add(text);
		
		
		 deposit = new JButton("Rs 100");
		deposit.setBounds(135,320,130,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 withdrawl = new JButton("Rs 200");
		withdrawl.setBounds(285,320,130,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		 fastcash = new JButton("Rs 1000");
		fastcash.setBounds(135,355,130,25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		 ministatement = new JButton("Rs 2000");
		ministatement.setBounds(285,355,130,25);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		 pinchange = new JButton("Rs 5000");
		pinchange.setBounds(135,390,130,25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		 balanceenquiry = new JButton("Rs 10000");
		balanceenquiry.setBounds(285,390,130,25);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		 exit = new JButton("BACK");
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
			 setVisible(false);
			 new Transactions(pinNumber).setVisible(true);
		 }else {
			 String amount = ((JButton)ae.getSource()).getText().substring(3);
			 Conn c = new Conn();
			 
			 try {
				 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
				 int balance = 0;
				 
				 while(rs.next()) {
					 if(rs.getString("type").equals("Deposit")) {
						 balance+= Integer.parseInt(rs.getString("amount"));
					 }
					 else {
						 balance -= Integer.parseInt(rs.getString("amount"));
					 }
				 }
				 if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
					 JOptionPane.showMessageDialog(null, "Insufficient Balance");
				      return;
				 }
				 Date date = new Date();
				 String query = "insert into bank values('"+pinNumber+"', '"+date+"','Withdrawl','"+amount+"')";
				 c.s.executeUpdate(query);
				 
				 JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Successfuly");
				 setVisible(false);
				 new Transactions(pinNumber).setVisible(true);
			 }catch(Exception e) {
				 System.out.println(e);
			 }
		 }
	}

	public static void main(String[] args) {
		new FastCash("");

	}

}
