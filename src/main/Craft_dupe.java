package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import File.File;

public class Craft_dupe {
	
	static int click = 100;

	public static void main() throws AWTException, InterruptedException, IOException {

		JFrame frame = new JFrame("JOptionPane showMessageDialog example");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Craft Dupe");
		frame.setLayout(new GridLayout(5, 5));
		
		JButton start = new JButton("Start");
		JButton clicks = new JButton("Clicks");
		JButton back = new JButton("Back");
		
		JLabel info = new JLabel("Clicks: " + click);
		
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
		
		clicks.setPreferredSize(new Dimension(10, 10));
		clicks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setClicks(info);
				} catch (IOException | InterruptedException e1) {
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
		if(File.read("src/config/advanced.txt").equalsIgnoreCase("[true]")) {
			frame.getContentPane().add(clicks);
			frame.getContentPane().add(info);
		}else {
			frame.getContentPane().add(new JLabel(""));
			frame.getContentPane().add(new JLabel(""));
		}
		
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(back);
		frame.setVisible(true);
		
	}
	
	protected static void start() throws InterruptedException, AWTException, HeadlessException, IOException {
		
		Robot r = new Robot();
		if(File.read("src/config/popup.txt").equalsIgnoreCase("[true]")) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Starting in 5 sec!");
		}
		
		
		delay(5000);
		
		r.keyPress(KeyEvent.VK_Q);
		delay(100);
		r.keyRelease(KeyEvent.VK_Q);
		
		delay(1000);
		
		for (int i = 0; i < click; i++) {
			
			r.mousePress(InputEvent.BUTTON1_MASK);
			delay(10);
			r.mouseRelease(InputEvent.BUTTON2_MASK);
			
			delay(10);
			
		}
		
	}
	
	protected static void setClicks(JLabel info) throws IOException, InterruptedException {
		JFrame frame = new JFrame();   
		String clicks_in = JOptionPane.showInputDialog(frame,"Clicks (Default: 100)");
		click = Integer.parseInt(clicks_in);
		info.setText("Clicks: " + click);
	}
	
	public static void delay(int i) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(i);
	}
}
