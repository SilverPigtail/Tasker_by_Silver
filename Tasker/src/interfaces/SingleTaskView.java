package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/***
 * This is the class of the interface of the single view of a task
 * @author Alejandro Molina Lara
 *
 */
public class SingleTaskView extends JPanel{
	private String title;
	private String description;
	private String date;
	private Window w;
	
	/***
	 * This is the function that models the interface of the single task view.
	 * @param title -> The title of the task that is received from the database
	 * @param description -> The description of the task that is received from the database
	 * @param date -> The date of the task that is received from the database.
	 * @param wind -> The window that contains all the window functions an all the important parameters
	 * @param id -> The id of the user that have the selected task that is received from the "getId" function
	 */
	public SingleTaskView(String title, String description, String date, Window wind, int id) {
		this.title=title;
		this.description=description;
		this.date=date;
		this.w=wind;
		
		//
		Connection cnb=null;
		//
		
		setSize(500,100);
		setLayout(null);
		
		
		JLabel lblTitulo = new JLabel(title);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 26));
		lblTitulo.setBounds(10, 11, 247, 32);
		add(lblTitulo);
		
		JLabel lblFecha = new JLabel(date);
		lblFecha.setBounds(10, 46, 80, 14);
		add(lblFecha);
		
		JLabel lblDescripcion = new JLabel(description);
		lblDescripcion.setBounds(10, 71, 146, 14);
		add(lblDescripcion);
		
		JButton btnCompletar = new JButton("Complete!");
		btnCompletar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCompletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LocalDate now = LocalDate.now();
				String nowPs=now.toString();
				System.out.println(nowPs);
				
				
				try {
					Connection cnb=DriverManager.getConnection("jdbc:mysql://51.158.162.242:3306/tasker",
					        "tasker", "tasker");
					System.out.println(lblTitulo.getText());
					PreparedStatement updateBoolean= cnb.prepareStatement("update task set finished_date ="+"'"+nowPs+"', completada= "+true+" where user_id= "+w.getUser().getId()+
							" and title like '"+title+"' and description = '"+description+"' and id="+id);
					updateBoolean.execute();
					cnb.close();
					
					//AddDateToCompletedTask.addDateToCompletedTask(lblTitulo.getText(), w);
					wind.loadCompletedTaskListFromTasks();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
			}
		});
		btnCompletar.setBounds(388, 0, 89, 60);
		add(btnCompletar);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				w.backToSelectScreenFromTaskList();
			}
		});
		btnBack.setBounds(388, 56, 89, 44);
		add(btnBack);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("resources\\singletaskview Background.png"));
		lblBackground.setBounds(0, 0, 500, 100);
		add(lblBackground);
	}
}
