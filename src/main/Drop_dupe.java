package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import File.File;

public class Drop_dupe {
	
	public static void main() throws AWTException, InterruptedException, IOException {
		
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Drop Dupe");
		frame.setLayout(new GridLayout(5, 5));
		
		JButton start = new JButton("Start");
		JButton back = new JButton("Back");
		
		start.setPreferredSize(new Dimension(10, 10));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (AWTException e1) {
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					e1.printStackTrace();
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
		
		frame.getContentPane().add(start);
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(back);
		frame.setVisible(true);
		
	}
	
	protected static void start() throws InterruptedException, AWTException, HeadlessException, IOException {
		
		Robot r = new Robot();
		
		if(File.read("src/config/popup.txt").equalsIgnoreCase("[true]")) {
			JFrame frame = new JFrame();  
		    JOptionPane.showMessageDialog(frame, "Closing Minecraft in 5 sec!");  
		}
		
		
		delay(5000);
		
		r.keyPress(KeyEvent.VK_Q);
		r.keyRelease(KeyEvent.VK_Q);
		
		delay(15);
		
		r.keyPress(KeyEvent.VK_ALT);
		
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		
		r.keyRelease(KeyEvent.VK_ALT);
		
	}
	
	public static void delay(int i) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(i);
	}
	
}
