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

public class Main {

	public static void main(String[] args) throws IOException {

		JFrame frame = new JFrame("JOptionPane showMessageDialog example");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Dupe Helper");
		frame.setLayout(new GridLayout(8, 1));

		JButton item_frame = new JButton("Item Frame Duper");
		JButton drop_dupe = new JButton("Drop Dupe");
		JButton craft_dupe = new JButton("Craft Dupe");
		JButton config = new JButton("Config");
		JButton quit = new JButton("Rage quit");

		item_frame.setPreferredSize(new Dimension(10, 10));
		item_frame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Frame_dupe.main();
					frame.dispose();
				} catch (AWTException | InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		drop_dupe.setPreferredSize(new Dimension(10, 10));
		drop_dupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Drop_dupe.main();
					frame.dispose();
				} catch (AWTException | InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		craft_dupe.setPreferredSize(new Dimension(10, 10));
		craft_dupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Craft_dupe.main();
					frame.dispose();
				} catch (AWTException | InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		config.setPreferredSize(new Dimension(10, 10));
		config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Config.main();
					frame.dispose();
				} catch (AWTException | InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		quit.setPreferredSize(new Dimension(10, 10));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.getContentPane().add(item_frame);
		frame.getContentPane().add(drop_dupe);
		frame.getContentPane().add(craft_dupe);
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(config);
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(new JLabel(""));
		frame.getContentPane().add(quit);
		frame.setVisible(true);

	}

	

}
