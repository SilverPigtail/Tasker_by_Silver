package databasefunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import interfaces.LoginScreen;
import interfaces.SelectActionScreen;
import interfaces.StartScreen;
import interfaces.Window;
import user_task.User;

/***
 * 
 * @author Alejandro Molina Lara (SilverPigtail)
 *  With this class we can do a normal login
 *  comparing the data of the database.
 */
public class LoginUser {

	/***
	 * This is the main constructor and class of the LoginUser class
	 * 
	 * @param nm  -> the nickname that is received from the nickname field of the
	 *            LoginScreen class.
	 * @param pwd -> the password that is received from the password field of the
	 *            LoginScreen class.
	 * @param w   -> the window that is received from the interface in general to
	 *            make this works.
	 * @throws LoginFailedException 
	 */
	public static  User LoginUserFunction(String nm, String pwd) {
		//super();

		String nicknameToLog = nm;
		String passwordToLog = pwd;

		/***
		 * Here I have declared the connection to use it later.
		 */
		Connection cn = null;

		/***
		 * In this try-catch, I started to work with the connection to the database. It
		 * main objective is compare the data from the database with the variables that
		 * we declare before (nickname and password).
		 */
		try {

			/***
			 * Here I open the connection that we declared before. The database that I'm
			 * using is located in the Juanmi's server. So, it is unnecesary to use a local
			 * database.
			 */
			cn = DriverManager.getConnection("jdbc:mysql://51.158.162.242:3306/tasker", "tasker", "tasker");
			PreparedStatement loginStatement = cn
					.prepareStatement("select * from user where nickname=? " + "and password=?");

			/***
			 * Here we establish the nickname and the password from the database as String
			 * variables.
			 */
			loginStatement.setString(1, nicknameToLog);
			loginStatement.setString(2, passwordToLog);
			ResultSet userToCheck = loginStatement.executeQuery();
			
			/**
			 * Here we do the comparison of the data that we received from the database with
			 * the variables that you write in the login's fields.
			 */
			if (userToCheck.next()) {

				PreparedStatement idSendStatement = cn
						.prepareStatement("select id from user where nickname= '" + nicknameToLog + "'");
				ResultSet idSaved = idSendStatement.executeQuery();
				if (idSaved.next()) {
					int idToPass = idSaved.getInt("id");
					
				
					
					User userLogged=new User(nicknameToLog, userToCheck.getString("email"), passwordToLog, idToPass);
					
					return userLogged;
					//w.loadSelectActionScreen();
					
				}

			} else {
				/***
				 * If the comparison fails, this error message will appear ass a aware window.
				 */
				
				JOptionPane.showMessageDialog(null, "Login failed", "Login error", JOptionPane.ERROR_MESSAGE);
			}

			cn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
