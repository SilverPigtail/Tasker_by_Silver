package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartScreen extends JPanel {
	private Window wind;

	public StartScreen(Window w) {
		super();
		wind = w;
		setBackground(Color.ORANGE);
		setLayout(null);

		JLabel taskerLabelName = new JLabel("Welcome to Tasker");
		taskerLabelName.setFont(new Font("Verdana", Font.BOLD, 17));
		taskerLabelName.setBounds(151, 11, 182, 22);
		add(taskerLabelName);

		JButton loginFunctionButton = new JButton("Login User");
		loginFunctionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				wind.loadLoginScreen();

			}
		});
		
		
		
			

			
		
		loginFunctionButton.setBounds(43, 301, 127, 47);
		add(loginFunctionButton);

		JButton registerUserFunction = new JButton("Register User");
		registerUserFunction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				wind.loadRegisterScreen();
			}
		});
		registerUserFunction.setBounds(213, 301, 131, 47);
		add(registerUserFunction);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(390, 325, 89, 23);
		add(btnNewButton);

		JTextArea txtrTaskerIsA = new JTextArea();
		txtrTaskerIsA.setEditable(false);
		txtrTaskerIsA.setOpaque(false);
		txtrTaskerIsA.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtrTaskerIsA.setBackground(new Color(255, 255, 255));
		txtrTaskerIsA.setText(
				"Tasker is a free application where you can add\r\n daily task that you have to do to\r\n remember them later.");
		txtrTaskerIsA.setBounds(78, 132, 382, 88);
		add(txtrTaskerIsA);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources\\interface_back_1.png"));
		lblNewLabel.setBounds(0, 0, 497, 494);
		add(lblNewLabel);
	}
}
