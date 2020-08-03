package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import File.File;

public class Config {

	static boolean showtries = true;

	public static void main() throws AWTException, InterruptedException, IOException {

		JFrame frame = new JFrame("JOptionPane showMessageDialog example");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Config");
		frame.setLayout(new GridLayout(5, 5));

		JButton showtriesbtn = new JButton("Show try popup: " + File.read("src/config/popup.txt"));
		JButton advanced = new JButton("Advanced Mode: " + File.read("src/config/advanced.txt"));
		JButton back = new JButton("Back");

		showtriesbtn.setPreferredSize(new Dimension(10, 10));
		showtriesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setshowtries(showtriesbtn);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		advanced.setPreferredSize(new Dimension(10, 10));
		advanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setadvanced(advanced);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		back.setPreferredSize(new Dimension(10, 10));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(showtriesbtn);
		frame.getContentPane().add(advanced);
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(back);
		frame.setVisible(true);
	}

	public static void setshowtries(JButton showtriesbtn) throws IOException {
		JFrame frame = new JFrame();   
		String show_tries = JOptionPane.showInputDialog(frame,"Show try popup y/n (Default: y)");
		if (show_tries.equalsIgnoreCase("y")) {
			File.write("true", "src/config/popup.txt");
		} else if (show_tries.equalsIgnoreCase("n")) {
			File.write("false", "src/config/popup.txt");
		}
		showtriesbtn.setText("Show try popup: " + File.read("src/config/popup.txt"));
	}
	
	public static void setadvanced(JButton showtriesbtn) throws IOException {
		JFrame frame = new JFrame();   
		String show_tries = JOptionPane.showInputDialog(frame,"Advanced mode y/n (Default: n)");
		if (show_tries.equalsIgnoreCase("y")) {
			File.write("true", "src/config/advanced.txt");
		} else if (show_tries.equalsIgnoreCase("n")) {
			File.write("false", "src/config/advanced.txt");
		}
		showtriesbtn.setText("Advanced Mode: " + File.read("src/config/advanced.txt"));
	}
}