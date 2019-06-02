package databasefunctions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Locale.Category;

import javax.swing.JOptionPane;

/***
 * This class adds the task that you have entered in the "addTaskScreen" class and send it to the database.
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class addTaskFunction {

	/***
	 * This is the function that receives the variables from the interface and send them to the database.
	 * @param ttl -> The title of the task from the JtextField of the interface.
	 * @param dtl -> The description of the task from the JtextArea of the interface.
	 * @param tolog -> The date of the task from the JtextFiel of the interface (as a String type).
	 * @param id -> The id that is received from the "getId" function of the interface.
	 */
	public static void addTaskFunction(String ttl, String dtl, String tolog, int id) {

		
		/**
		 * Here I declared the connection.
		 */
		Connection cnl = null;

		/***
		 * This try-catch set the connection with the database (located in the Juanmi's server) and
		 * create a statement that register de data from the function on the database.
		 */
		try {
			cnl = DriverManager.getConnection("jdbc:mysql://51.158.162.242:3306/tasker", "tasker", "tasker");
			
			 PreparedStatement registerTaskStatement=cnl.prepareStatement("insert into task(title, description, expected_date, completada, user_id)"
			 		+ "values('"+ttl+"','" + dtl + "', '" + tolog + "', " + 0 + ", "+id+");");
			 registerTaskStatement.execute();
			/***
			 * This is a pop-up window that appears when you enter a task without problems.
			 */
			 JOptionPane.showMessageDialog(null,
					    "You'll see that in the show task menu",
					    "Task registered!",
					    JOptionPane.PLAIN_MESSAGE);
			 /***
			  * This is the catch of the try that allows to the function to pop a JDialog if the
			  * data entered is wrong.
			  */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,
				    "try changing the date or the title",
				    "Error adding the task",
				    JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
