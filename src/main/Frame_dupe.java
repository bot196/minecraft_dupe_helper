package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import File.File;

public class Frame_dupe {

	static int delay = 1000;
	static int tries = 1;
	static int try_tot = 0;

	public static void main() throws AWTException, InterruptedException, IOException {

		JFrame frame = new JFrame("JOptionPane showMessageDialog example");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Item Frame Duper");
		frame.setLayout(new GridLayout(5, 5));

		JButton start = new JButton("Start");
		JButton setdelay = new JButton("Set delay");
		JButton settries = new JButton("Set tries");
		JButton back = new JButton("Back");

		JLabel info = new JLabel("Delay: " + delay + "ms, Tries: " + tries);

		start.setPreferredSize(new Dimension(10, 10));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					start();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (AWTException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		setdelay.setPreferredSize(new Dimension(10, 1));
		setdelay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setdelay(info);
				} catch (InterruptedException | AWTException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		settries.setPreferredSize(new Dimension(10, 10));
		settries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					settries(info);
				} catch (InterruptedException | AWTException | IOException e1) {
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
		frame.getContentPane().add(info);
		
		if(File.read("src/config/advanced.txt").equalsIgnoreCase("[true]")) {
			frame.getContentPane().add(setdelay);
			frame.getContentPane().add(settries);
		}else {
			frame.getContentPane().add(new JLabel(""));
			frame.getContentPane().add(new JLabel(""));
		}
		
		frame.getContentPane().add(back);
		frame.setVisible(true);

	}

	protected static void start() throws InterruptedException, AWTException, IOException {

		Robot r = new Robot();

		for (int i = 0; i < tries; i++) {

			try_tot = i + 1;

			if (File.read("src/config/popup.txt").equalsIgnoreCase("[true]")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Try " + try_tot + " starts in 5 sec!");
			}

			delay(5000);

			r.mousePress(InputEvent.BUTTON3_MASK);
			delay(1);
			r.mouseRelease(InputEvent.BUTTON3_MASK);

			delay(delay);

			r.mousePress(InputEvent.BUTTON1_MASK);
			delay(1);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

		}

		try_tot = 0;
	}

	protected static void setdelay(JLabel info) throws InterruptedException, AWTException, IOException {
		JFrame frame = new JFrame();   
		String delay_in = JOptionPane.showInputDialog(frame,"Delay in ms. (recommended: 1000)");
		System.out.println(delay_in);
		delay = Integer.parseInt(delay_in);
		info.setText("Delay: " + delay + "ms, Tries: " + tries);
	}

	protected static void settries(JLabel info) throws InterruptedException, AWTException, IOException {
		JFrame frame = new JFrame();   
		String tries_in = JOptionPane.showInputDialog(frame,"Tries (Default: 1)");
		tries = Integer.parseInt(tries_in);
		info.setText("Delay: " + delay + "ms, Tries: " + tries);
	}

	public static void delay(int i) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(i);
	}

}
