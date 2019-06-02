package swingcomponents;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	public MyLabel(String text, int size) {
		this.setFont(new Font("Helvetica", Font.BOLD, size));
	}
}
