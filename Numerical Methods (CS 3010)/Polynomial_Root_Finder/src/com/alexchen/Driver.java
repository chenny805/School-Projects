/*  Name: Alex Chen
 *  Professor: Raheja
 *  Class: CS 3010
 *  Date: 11/06/18
 */ 

package com.alexchen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Driver extends JFrame {

	// polynomial functions
	double x;
	String func1 = "f(x) = 2x^3 - 11.7x^2 + 17.7x - 5";
	String func2 = "f(x) = x + 10 - xcosh(50/x)";

	private JPanel contentPane;

	// method objects
	Bisection bi = new Bisection(func1, func2);
	Newton_Raphson nr = new Newton_Raphson(func1, func2);
	Secant sc = new Secant(func1, func2);
	Modified_Secant ms = new Modified_Secant(func1, func2);
	False_Position fp = new False_Position(func1, func2);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// create GUI
		createWindow();
	}

	// create JFrame Window
	private static void createWindow() {
		// set native look for GUI
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver frame = new Driver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// create JFrame
	public Driver() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtpnHere = new JTextPane();
		txtpnHere.setText("For the following two functions: \n\n" + "    a) f(x) = 2x^3 - 11.7x^2 + 17.7x - 5 \n"
				+ "    b) f(x) = x + 10 - xcosh(50/x) \n\n"
				+ "Please choose the method you would like to use to solve.");
		txtpnHere.setBounds(24, 20, 402, 114);
		contentPane.add(txtpnHere);

		JButton btnBisection = new JButton("Bisection");

		// when bisection button is clicked
		btnBisection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// start bisection method
				bi.start();
				// close window after button click
				setVisible(false);
				dispose();
				System.exit(0);

			}
		});
		btnBisection.setBounds(85, 146, 117, 29);
		contentPane.add(btnBisection);

		JButton btnNewton = new JButton("Newton-Raphson");
		btnNewton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// start newton's method
				nr.start();
				// close window after button click
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnNewton.setBounds(214, 187, 160, 29);
		contentPane.add(btnNewton);

		JButton btnSecant = new JButton("Secant");
		btnSecant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// start newton's method
				sc.start();
				// close window after button click
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnSecant.setBounds(85, 224, 117, 29);
		contentPane.add(btnSecant);

		JButton btnFalse = new JButton("False-Position");
		btnFalse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// start newton's method
				fp.start();
				// close window after button click
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnFalse.setBounds(85, 187, 117, 29);
		contentPane.add(btnFalse);

		JButton btnModified = new JButton("Modified-Secant");
		btnModified.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// start newton's method
				ms.start();
				// close window after button click
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnModified.setBounds(214, 146, 160, 29);
		contentPane.add(btnModified);
	}
}
