package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/***
 * This is the interface class that store all the completed task for each user.
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class CompletedTaskList extends JPanel{

	/***
	 * This is the constructor of the interface.
	 * @param w -> The same JFrame window that we use in the program (with all functions).
	 */
	public CompletedTaskList(Window w) {
		
		
		super();
		/***
		 * Here I create a Date for the completed task. It is suppose to get the current date of
		 * the system.
		 */
		
		
		
		setLayout(new BorderLayout(0, 0));

		w.setSize(540, 600);

		JPanel completedListado = new JPanel();

		completedListado.setBackground(new Color(165, 42, 42));

		completedListado.setBorder(BorderFactory.createLineBorder(Color.red));
		// listado.setPreferredSize(new Dimension(300, 800));
		
		/***
		 * Here I set the layout of the list as a JScrollPane.
		 */
		JScrollPane scrollPane = new JScrollPane(completedListado);
		add(scrollPane);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.setViewportView(completedListado);
		completedListado.setLayout(null);
		
		
		
		/***
		 * This try-catch allows the program to send the select the completed task information from the database and then
		 * create SingleCompletedTaskView buttons based on the completed task that the user have.
		 */
		try {
			Connection cnc = DriverManager.getConnection("jdbc:mysql://51.158.162.242:3306/tasker", "tasker", "tasker");

			PreparedStatement askForLength2 = cnc
					.prepareStatement("select * from task where user_id=" + w.getUser().getId()+" and completada=true");
			ResultSet resultLength2 = askForLength2.executeQuery();
			
			if (resultLength2.next()) {

				int i = 0;
				
				
				do {
					
					
					SingleCompletedTaskView btnNewButton = new SingleCompletedTaskView(resultLength2.getString("title"), resultLength2.getString("finished_date"), w);
					btnNewButton.setSize(500,100);
					btnNewButton.setBounds(8, i, 500, 100);
					completedListado.setPreferredSize(new Dimension(300, i + 100));
					completedListado.add(btnNewButton);
					i += 110;
				

				} while (resultLength2.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}