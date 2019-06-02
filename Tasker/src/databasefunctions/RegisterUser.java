package databasefunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import interfaces.Window;

import interfaces.RegisterScreen;
import user_task.User;

/**
 * The objective of this class is create the user and send the data to the database.
 * @author Alejandro Molina Lara
 *
 */
public class RegisterUser {
	
	/**
	 * Here I declare the connection to use it later.
	 */
	Connection cn = null;
		
	
	/**
	 * This function receive the data from the RegisterUser class, and send it to the database.
	 * @param nmd -> The nickname that is received from the nickname field.
	 * @param emd -> the email that is received from the email field.
	 * @param pwd -> the password that is received from the password field.
	 * @param w -> the window that is received from the interface in general to make this works.
	 */
		public RegisterUser(String nmd, String emd, String pwd, Window w){
			
		
			/***
			 * In this try-catch I open the connection with the objective of send the new user's data to the database.
			 */
		try {
			
			/***
			 * Here I establish the connection to the database (it is located in the Juanmi's server).
			 * Then, I open a statement to log the data in the database.
			 */
			cn=DriverManager.getConnection("jdbc:mysql://51.158.162.242:3306/tasker",
                    "tasker", "tasker");
			Statement registerStatement=cn.createStatement();
			registerStatement.executeUpdate(
					"insert into user (nickname,email,password) values('" + nmd + "',"
		                    + "'" + emd + "','" + pwd + "')");
			registerStatement.close();
			
			
			
			/***
			 * When the sing-up is completed, The login screen is loaded automatically with this function.
			 */
			
			w.loadLoginScreen();
			
		
	
		
		
		
		
		} catch (SQLException e) {
			/**
			 * This error pop if the data entered is the same as the other from the database.
			 */
			JOptionPane.showMessageDialog(w, "ERROR maybe that data is the same of other user");
			e.printStackTrace();
		}
		

		
		}
}

	
		
	
			


	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	

