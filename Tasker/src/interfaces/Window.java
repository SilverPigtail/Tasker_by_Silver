package interfaces;

import javax.swing.JFrame;

import databasefunctions.LoginUser;
import user_task.User;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class Window extends JFrame{
	private RegisterScreen registerS;
	private LoginScreen loginS;
	private StartScreen startS;
	private SelectActionScreen sas;
	private NewTaskScreen nts;
	private TaskList tl;
	private CompletedTaskList ctl;
	private User user;
	
	
	public Window() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\pixil-frame-0 (7).png"));
		setResizable(false);
		this.setTitle("Registro");
		startS=new StartScreen(this);
		this.setSize(500,500);
		this.setContentPane(startS);
		this.setVisible(true);
		
		this.registerS=new RegisterScreen(this);
		this.loginS=new LoginScreen(this);
		this.sas=new SelectActionScreen(this);
		this.nts=new NewTaskScreen(this);
		
		
	
		
		
	}
	
	
	public void loadRegisterScreen() {
		
		
			this.registerS.setVisible(true);
			this.setTitle("Sing-Up");
			this.startS.setVisible(false);
			this.setContentPane(this.registerS);
		
		
		
	}
	
	
	public void loadLoginScreen() {
		
		
			this.registerS.setVisible(false);
			this.loginS.setVisible(true);
			this.setTitle("Sign-In");
			this.startS.setVisible(false);
			this.setContentPane(this.loginS);
		
		
		
	}
	
	public void loadStartScreen() {
		
		this.setTitle("Tasker, all what do you have to do here!");
		if(this.loginS!=null) {
			
			this.loginS.setVisible(false);
			
		}else if(this.registerS!=null) {
			
			this.registerS.setVisible(false);
			
		}
		
		this.registerS.setVisible(false);
		this.startS.setVisible(true);
		this.setContentPane(startS);
	}
	
	
	public void loadSelectActionScreen() {
		
		
		this.setTitle("Hello, what do you want to do?");
		
		
		
		this.loginS.setVisible(false);
		this.setContentPane(sas);
		
	}
	
	
	public void loadNewTaskScreen() {

		this.setTitle("Add a task!");
		
		
		this.sas.setVisible(false);
		this.setContentPane(nts);
	}
	
	
	public void loadTaskScreen() {
		
		this.setTitle("Take your time");
		this.tl=new TaskList(this);
		this.sas.setVisible(false);
		this.setContentPane(tl);
		
	}

	
	public void backSelectActionScreenAdd() {
		
		this.setTitle("Hello, what do you want to do?");

		this.sas.setVisible(false);
		this.setContentPane(sas);
		this.sas.setVisible(true);
		
	}

	public void loadCompletedTaskList() {
		
		this.setTitle("See what you have done!");
		this.ctl=new CompletedTaskList(this);
		this.sas.setVisible(false);
		this.setContentPane(ctl);
	}
	
	
	public void loadCompletedTaskListFromTasks() {
		
		this.setTitle("See what you have done!");
		this.ctl=new CompletedTaskList(this);
		this.tl.setVisible(false);
		this.setContentPane(ctl);
	}
	
	
	public void backToSelectScreenFromTaskList() {
		
		this.setTitle("Hello, what do you want to do?");
		
		
		
		this.tl.setVisible(false);
		this.sas.setVisible(true);
		this.sas.setSize(500, 500);
		this.setSize(500, 500);
		this.setContentPane(sas);
		
		
	}
	
	public void backToSelectScreenFromCompletedTasksList() {
		
		this.setTitle("Hello, what do you want to do?");
		
		
		
		this.ctl.setVisible(false);
		this.sas.setVisible(true);
		this.sas.setSize(500, 500);
		this.setSize(500, 500);
		this.setContentPane(sas);
		
		
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
