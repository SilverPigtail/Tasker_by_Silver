package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import databasefunctions.LoginUser;
import user_task.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/***
 * This class is the interface that appears when you click the login button in the start screen.
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class LoginScreen extends JPanel{
	private JTextField nickNameLoginField;
	private JPasswordField passwordLoginField;	
	
	
	
	/***
	 * Here's the function that establish all the Login Screen interface.
	 * @param w -> The Window parameter that allows us to get all the functions and data from the Window class.
	 */
	public LoginScreen(Window w) {
		super();
		setBackground(Color.CYAN);
		setLayout(null);
		
		/***
		 * Here I set the buttons and all the visual interface of the Login Screen.
		 */
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNickname.setBounds(83, 164, 100, 23);
		add(lblNickname);
		
		/***
		 * JTextField of the nickname input
		 */
		nickNameLoginField = new JTextField();
		nickNameLoginField.setBounds(231, 163, 159, 30);
		add(nickNameLoginField);
		nickNameLoginField.setColumns(10);
		
		/***
		 * JTextField of the password input
		 */
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPassword.setBounds(83, 302, 93, 23);
		add(lblPassword);
		
		/***
		 * JTextField of the password input
		 */
		passwordLoginField = new JPasswordField();
		passwordLoginField.setBounds(231, 301, 159, 30);
		add(passwordLoginField);
		
		/***
		 * Sign-in button
		 */
		JButton btnSignIn = new JButton("Sign In!");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/***
				 * The objective of this part of the code is create the user as an object and pass the data to the
				 * verification function to compare the information with the database. If it is correct, then the
				 * program allows you to access to the Select action screen.
				 */
				User userToLog= LoginUser.LoginUserFunction(nickNameLoginField.getText(), passwordLoginField.getText());
				if(userToLog!=null) {
					w.setUser(userToLog);
					w.loadSelectActionScreen();
				}
					
				
			}
		});
		
		btnSignIn.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSignIn.setBounds(192, 360, 100, 30);
		add(btnSignIn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				w.loadStartScreen();
				
			}
		});
		btnBack.setBounds(321, 365, 69, 23);
		add(btnBack);
		
		JLabel lblWelcomeToTasker = new JLabel("Welcome to Tasker again!");
		lblWelcomeToTasker.setFont(new Font("Verdana", Font.BOLD, 16));
		lblWelcomeToTasker.setBounds(115, 81, 262, 54);
		add(lblWelcomeToTasker);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources\\login_background.png"));
		lblNewLabel.setBounds(0, 0, 500, 500);
		add(lblNewLabel);
	
	
	
	
	}
	
}
