package bank.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	  
	JPasswordField pin,repin;
	JButton back,change;
	String pinNumber;
	PinChange(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(750, 750,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,750,750);
		add(image);
		
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(200,240,450,35);
		image.add(text);
		
		JLabel pinText = new JLabel("New PIN:");
		pinText.setForeground(Color.WHITE);
		pinText.setFont(new Font("System",Font.BOLD,16));
		pinText.setBounds(135,310,100,25);
		image.add(pinText);
		
		 pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(290,310,140,25);
		image.add(pin);
		
		JLabel repinText = new JLabel("Re Enter New PIN:");
		repinText.setForeground(Color.WHITE);
		repinText.setFont(new Font("System",Font.BOLD,16));
		repinText.setBounds(135,350,150,25);
		image.add(repinText);
		
		 repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,25));
		repin.setBounds(290,350,140,25);
		image.add(repin);
		
		 change  = new JButton("CHANGE");
		change.setBounds(330,390,100,25);
		change.addActionListener(this);
		image.add(change);
		
		 back  = new JButton("BACK");
		back.setBounds(330,420,100,25);
		back.addActionListener(this);
		image.add(back);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(750,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PinChange("");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
		try {
			String npin = pin.getText();
			String nrepin = repin.getText();
			
			if(!npin.equals(nrepin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter new pin");
				return;
			}
			
			if(nrepin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter new pin");
				return;
			}
			Conn c = new Conn();
			String query1 = "update bank set pin = '"+nrepin+"' where pin = '"+pinNumber+"'";
			String query2 = "update login set pinNumber = '"+nrepin+"' where pinNumber = '"+pinNumber+"'";
			String query3 = "update signupthree set pinNumber = '"+nrepin+"' where pinNumber = '"+pinNumber+"'";
	      
		c.s.executeUpdate(query1);
		c.s.executeUpdate(query2);
		c.s.executeUpdate(query3);
		
		JOptionPane.showMessageDialog(null,"PIN changed successfully");
		
		setVisible(false);
		new Transactions(nrepin).setVisible(true);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		}
		else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}

}
