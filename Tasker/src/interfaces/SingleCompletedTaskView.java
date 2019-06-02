package interfaces;

import javax.swing.JPanel;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * This is the class of the interface of the single view of a completed task
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class SingleCompletedTaskView extends JPanel {
	
	
	/**
	 * This is the function that models the interface of this class
	 * @param title -> The title of the task that we get from the Complete task button.
	 * @param today -> The day that the task was completed. It takes the system date from the day when we push the complete button
	 * @param w  -> he window that contains all the window functions and some important parameters.
	 */
	public SingleCompletedTaskView(String title, String today, Window w) {
		setLayout(null);
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setBounds(10, 42, 142, 14);
		add(lblTitle);
		
		JLabel lblDate = new JLabel(today);
		lblDate.setBounds(214, 42, 212, 14);
		add(lblDate);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***
				 * This function allows the user to back to the select action screen when the user is in the completed tasks
				 * list.
				 */
				w.backToSelectScreenFromCompletedTasksList();
				
			}
		});
		btnBack.setBounds(351, 11, 89, 50);
		add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("resources\\completed_task_back.png"));
		label.setBounds(0, 0, 639, 300);
		add(label);
	}
}
