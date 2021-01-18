import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openWindow();
	}
	public static void openWindow() {
		JLabel label = new JLabel("The online Banking System");
		label.setBounds(100, 100, 100, 100);
		label.setForeground(Color.white);
		
		JLabel labelbottom = new JLabel("copyright © 2020-2021");
		labelbottom.setBounds(100, 100, 100, 100);
		labelbottom.setForeground(Color.white);
		
		JLabel labelcenter = new JLabel("FAIL ");
		labelcenter.setBounds(100, 30, 200, 100);
		labelcenter.setForeground(Color.white);
		labelcenter.setFont(new Font("Serif", Font.PLAIN, 25));
	
		
		JPanel paneltop = new JPanel();
//		paneltop.setBounds(0, 0, 250, 250);
		paneltop.setBackground(Color.decode("#490a0a"));
		
		JPanel panelbottom = new JPanel();
		panelbottom.setBounds(0, 0, 250, 250);
		panelbottom.setBackground(Color.decode("#490a0a"));
		
		
		JPanel panelcenter = new JPanel();
		panelcenter.setLayout(null);
		panelcenter.setBounds(0, 0, 250, 250);
		panelcenter.setBackground(Color.decode("#FF0000"));
		
		
		
		JFrame frame = new JFrame();
		frame.setBounds(300, 300, 250,250);
		frame.setBackground(Color.decode("#757575"));

//		frame.setLayout(null);
		panelcenter.add(labelcenter,BorderLayout.CENTER);
		paneltop.add(label);
		panelbottom.add(labelbottom);
		
		frame.add(panelcenter);
		frame.add(paneltop,BorderLayout.NORTH);
		frame.add(panelbottom,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
