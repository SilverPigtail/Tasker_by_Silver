package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

/***
 * This is the class that models the interface of the select action screen, it appears when you log-in the program
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class SelectActionScreen extends JPanel{
	

	
	/***
	 * This is the function that models the interface of the Select Action Screen.
	 * @param w -> he window that contains all the window functions and some important parameters.
	 */
	
	public SelectActionScreen(Window w) {
		
		super();
		setBackground(Color.GREEN);
		setLayout(null);
		
		JButton btnAddTask = new JButton("Add task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.loadNewTaskScreen();
				
				
			}
		});
		btnAddTask.setBounds(10, 268, 188, 48);
		add(btnAddTask);
		
		JButton btnShowTasks = new JButton("Show tasks");
		btnShowTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				w.loadTaskScreen();
			}
		});
		btnShowTasks.setBounds(287, 268, 203, 48);
		add(btnShowTasks);
		
		JLabel lblWhatDoYou = new JLabel("Hello, What do you want to do?");
		lblWhatDoYou.setFont(new Font("Verdana", Font.BOLD, 16));
		lblWhatDoYou.setBounds(98, 53, 282, 35);
		add(lblWhatDoYou);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(201, 436, 89, 23);
		add(btnExit);
		
		JButton backToLoginButton = new JButton("Back");
		backToLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.loadStartScreen();
			}
		});
		backToLoginButton.setBounds(201, 411, 89, 23);
		add(backToLoginButton);
		
		JButton btnShowCompletedTasks = new JButton("Show completed tasks");
		btnShowCompletedTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				w.loadCompletedTaskList();
			}
		});
		btnShowCompletedTasks.setBounds(287, 193, 203, 48);
		add(btnShowCompletedTasks);
		
		
		JLabel labelSelectActionBackground = new JLabel("");
		labelSelectActionBackground.setIcon(new ImageIcon("resources\\selectAction-background.png"));
		labelSelectActionBackground.setBounds(0, 0, 500, 500);
		add(labelSelectActionBackground);
	}
}
