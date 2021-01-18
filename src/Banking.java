import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Banking extends JFrame implements ActionListener{
	
	JTextField input1 = new JTextField(30);
	JTextField input2 = new JTextField(30);
	JTextField input3 = new JTextField(30);
	JTextField input4 = new JTextField(30);
	
	
	
	
	
	public Banking(){
		setTitle("The Online Bank ");
		setSize(600,600);

		// setLayout(null); To Help if we want to position our way.

		// Panel creation
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();

		// Label Creation
		JLabel myLabelTop = new JLabel("Welcome to The Bank");
      	JLabel myLabelMiddle = new JLabel("How Can we help You");
      	JLabel myLabelBottom = new JLabel("copyright © 2020-2021");
      	
      	// For Today
      	
      	// For The Labelling
      	JLabel centerLabel1 = new JLabel("First Name");centerLabel1.setForeground(Color.white);
      	JLabel centerLabel2 = new JLabel("Last Name");centerLabel2.setForeground(Color.white);
      	JLabel centerLabel3 = new JLabel("Account Number");centerLabel3.setForeground(Color.white);
      	JLabel centerLabel4 = new JLabel("Amount");centerLabel4.setForeground(Color.white);
      	
      	// For the TexField Withdraw
      	
      	
      	// For The Make Deposit
      	input1.setBounds(170,100,240,20);
      	input2.setBounds(170,130,240,20);
      	input3.setBounds(170,160,240,20);
      	input4.setBounds(170,190,240,20);
      	
      	// For The Make Check Balance
      	panel2.add(input1);panel2.add(input2);
      	panel2.add(input3);panel2.add(input4);
      	
      	
      	
      	centerLabel1.setBounds(40,60,100,100);centerLabel2.setBounds(40,90,100,100);
      	centerLabel3.setBounds(40,120,120,100);centerLabel4.setBounds(40,150,100,100);
      	
      	panel2.add(centerLabel1);panel2.add(centerLabel2);
      	panel2.add(centerLabel3);panel2.add(centerLabel4);
      	
      	
      	//Button Creation
      	JButton button1 = new JButton("Withdraw Money");
      	button1.setForeground(Color.decode("#000"));
      	button1.setBounds(130, 120, 100, 40);
      	button1.addActionListener(this);
      	JButton button2 = new JButton("Make Deposit");
      	button2.setForeground(Color.decode("#000"));
      	button2.addActionListener(this);
      	JButton button3 = new JButton("Check Balance");
      	button3.setForeground(Color.decode("#000"));
      	button3.addActionListener(this);

      	// Putting Background Colors to panels
      	panel.setBackground(Color.decode("#490a0a"));
      	panel2.setBackground(Color.decode("#757575"));
      	panel3.setBackground(Color.decode("#490a0a"));
      	panel4.setBackground(Color.decode("#490a0a"));

      	// Putting Borders in our panels
		Border blackline = BorderFactory.createLineBorder(Color.black);
      	panel.setBorder(blackline);
      	panel2.setBorder(blackline);
      	panel2.setLayout(null);
      	panel3.setBorder(blackline);
      	
      	// Putting Colors to our text
      	myLabelTop.setForeground(Color.WHITE);
      	myLabelMiddle.setForeground(Color.WHITE);
      	myLabelBottom.setForeground(Color.WHITE);

      	// adding to our Panels and Frames
      	panel3.add(myLabelBottom);
      	panel2.add(myLabelMiddle);
      	panel4.add(button1);
      	panel4.add(button2);
      	panel4.add(button3);
      	
      	panel4.setBounds(20,50,560,400);
      	panel2.add(panel4);
      
		panel.add(myLabelTop);
		this.add(panel2,BorderLayout.CENTER);
		this.add(panel,BorderLayout.NORTH);
		this.add(panel3,BorderLayout.SOUTH);

		// getting the values that users have input

	}

	// The main Class to run the program
	public static void main(String[] args) {
		Banking stack = new Banking();
		stack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stack.setVisible(true);
	}
	// My Connection
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/DAUST";
			String username = "root";
			String password =  "mysqlroot";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password) ;
			System.out.println("Connected ");
			return conn;	
		}catch (Exception e ) {
			System.out.println("Error catched" + e);
		}
		return null;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String take1 = input1.getText();
		String take2= input2.getText();
		String take3 = input3.getText();
		String take4 = input4.getText();
//		System.out.println(take1 + " " +  take2 + " " + take3 + " " + take4 );
		try {
			Connection conn = getConnection();
			PreparedStatement select = conn.prepareStatement("select * from Banking where aNumber = '" + take3 + "';" );
			ResultSet result = select.executeQuery();
			if(e.getActionCommand().equals("Check Balance")) {
				
				while (result.next()) {
					take1 = take1.toString();
					take2 = take2.toString();
					String resultf = result.getString("fName").toString();
					String resultl = result.getString("lName").toString();
					if(take1.equals(resultf) & (take2.equals(resultl)) ) {
						System.out.println("Your balance is " + result.getInt("amount") + "FCFA");
						dispose();
						WindowSuccess.openWindow();
					}else {
						System.out.println("Please Try again !!! ");
						WindowFail.openWindow();
					}
				}
			}else if(e.getActionCommand().equals("Withdraw Money")) {
				while (result.next()) {
					take1 = take1.toString();
					take2 = take2.toString();
					String resultf = result.getString("fName").toString();
					String resultl = result.getString("lName").toString();
					if (take1.equals(resultf) & (take2.equals(resultl)) ) {
						if(result.getInt("amount") > Integer.parseInt(take4)) {
							System.out.println("You just withdrawed " + Integer.parseInt(take4) + "FCFA");
							int moneyRemain = result.getInt("amount") - Integer.parseInt(take4);
							System.out.println("You have "+ moneyRemain + "FCFA left in your account");
							PreparedStatement update = conn.prepareStatement("UPDATE Banking set amount = '" + moneyRemain + "'where aNumber = '" + take3 +"';" );
							update.executeUpdate();	
							dispose();
							WindowSuccess.openWindow();
						}
						else {
							System.out.println("You cannot withdraw then.");
						}
					}else {
						
						System.out.println("You cannot withdraw Money.");
						dispose();
						WindowFail.openWindow();
					}		
				}		
			}else if(e.getActionCommand().equals("Make Deposit")) {
				while(result.next()) {
					take1 = take1.toString();
					take2 = take2.toString();
					String resultf = result.getString("fName").toString();
					String resultl = result.getString("lName").toString();
					if (take1.equals(resultf) & (take2.equals(resultl)) ) {
						int moneyPut = result.getInt("amount") + Integer.parseInt(take4);
						System.out.println("You just added in your account " + Integer.parseInt(take4));
						System.out.println(moneyPut + " is the total money that you have now in your account.");
						PreparedStatement update2 = conn.prepareStatement("UPDATE Banking set amount = '" + moneyPut + "'where aNumber = '" + take3 +"';" );
						update2.executeUpdate();
						
						dispose();
						WindowSuccess.openWindow();
					}
					else {
						WindowFail.openWindow();
						System.out.println("You made error while typing.");
					}
					
				}
			}
			else {
				System.out.println("Please You've made a mistake somewhere.");
				System.out.println("Consider Retyping !!!");
			}	
			
		}catch(Exception ex) {
			System.out.println(ex + "You made error while typing.");
	}
	}
}