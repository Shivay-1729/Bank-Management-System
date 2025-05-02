package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.awt.*;
import javax.swing.*;
public class Withdrawl extends JFrame implements ActionListener{

	JTextField amount;
	JButton withdraw,back;
	String pin;
	 Withdrawl(String pin){
		 pin = this.pin;
		 setLayout(null);
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(750, 750,Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(0,0,750,750);
		 add(image);
		 
		 JLabel text = new JLabel("Enter the amount you want to withdraw");
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,16));
		 text.setBounds(133,250,400,20);
		 image.add(text);
		 
		 amount = new JTextField();
		 amount.setFont(new Font("Raleway",Font.BOLD,16));
		 amount.setBounds(145,320,270,25);
		 image.add(amount);
		 
		  withdraw = new JButton("Withdraw");
		  withdraw.setFont(new Font("Raleway",Font.BOLD,16));
		  withdraw.setBounds(310,380,110,30);
		  withdraw.addActionListener(this);
		 image.add(withdraw);
		 
		 back = new JButton("Back");
		 back.setFont(new Font("Raleway",Font.BOLD,16));
		 back.setBounds(310,420,110,30);
		 back.addActionListener(this);
		 image.add(back);
		 
		 setSize(750,750);
		 setLocation(300,0);
		 setVisible(true);
	 }
	 
	 public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource() == withdraw) {
			 String number = amount.getText();
			 Date date = new Date();
			 if(number.equals("")) {
				 JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
			 }else {
				 Conn conn = new Conn();
				 String query = "insert into bank values('"+pin+"', '"+date+"','Withdrawl','"+number+"')";
			     try {
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs"+" " +number+" "+"withdraw successfully");
					setVisible(true);
					new Transactions(pin).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			}else if(ae.getSource() == back) {
			 setVisible(false);
			 new Transactions(pin).setVisible(true);
		 }
	 }
	public static void main(String[] args) {
		new Withdrawl("");

	}

}


