package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.UIManager;

import databasefunctions.RegisterUser;
import exceptions.InvalidPasswordLengthException;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/***
 * This class is the one that model the sing-up Screen, it contains all the visual parts of the interface.
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class RegisterScreen extends JPanel {
	private JTextField nickTextField;
	private JTextField emailField;
	private JPasswordField passwordRegField;

	/***
	 * This is the function that models the interface.
	 * @param w -> The window that contains all the window functions and some important parameter.
	 */
	public RegisterScreen(Window w) {
		super();
		setBackground(new Color(102, 153, 255));
		setLayout(null);

		JLabel lblTaskerSignup = new JLabel("Tasker Sign-up");
		lblTaskerSignup.setFont(new Font("Verdana", Font.BOLD, 16));
		lblTaskerSignup.setBackground(new Color(0, 0, 0));
		lblTaskerSignup.setBounds(193, 11, 159, 34);
		add(lblTaskerSignup);

		JLabel nicknameLabel = new JLabel("Nickname:");
		nicknameLabel.setFont(new Font("Arial", Font.BOLD, 17));
		nicknameLabel.setBounds(41, 126, 94, 29);
		add(nicknameLabel);

		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 17));
		emailLabel.setBounds(41, 207, 94, 29);
		add(emailLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 17));
		passwordLabel.setBounds(41, 277, 106, 40);
		add(passwordLabel);

		nickTextField = new JTextField();
		nickTextField.setBounds(179, 130, 189, 40);
		add(nickTextField);
		nickTextField.setColumns(10);

		emailField = new JTextField();
		emailField.setBounds(179, 209, 189, 29);
		add(emailField);
		emailField.setColumns(10);

		passwordRegField = new JPasswordField();
		passwordRegField.setBounds(179, 275, 194, 29);
		add(passwordRegField);

		JButton registerButton = new JButton("SING-UP!");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/***
				 * This function allows thw program to get the fields and then, checks if the length of the password
				 * is smaller than 8 character. If this is true, then the inputs are sent to the function that insert
				 * this data in the database. If the length of the password is longer than eight characters, then an
				 * exception pops-up.
				 */
			

				if (passwordRegField.getText().length() > 8) {

					try {

						throw new InvalidPasswordLengthException("The password that you have entered is too long");

					} catch (InvalidPasswordLengthException e) {

						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "The password that you have entered is too long", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {

					RegisterUser register = new RegisterUser(nickTextField.getText(), emailField.getText(),
							passwordRegField.getText(), w);

				}

			
				
			
			
			
		}});
		registerButton.setBounds(194, 361, 113, 40);
		add(registerButton);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				w.loadStartScreen();
			}
		});
		btnBack.setBounds(206, 435, 89, 23);
		add(btnBack);

		JLabel backgroundIm = new JLabel("");
		backgroundIm.setIcon(new ImageIcon("resources\\register_background.png"));
		backgroundIm.setBounds(0, 0, 500, 500);
		add(backgroundIm);

	}
}
