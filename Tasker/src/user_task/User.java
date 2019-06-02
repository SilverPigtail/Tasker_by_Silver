package user_task;

import exceptions.InvalidPasswordLengthException;

public class User {
	private String nickname;
	private String email;
	private String password;
	private int id;
	
	

	public User(String nn, String em, String pw, int id) {
		

		this.nickname=nn;
		this.email=em;
		this.password=pw;
		this.id=id;
		
		
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String cnn) {
		
		this.nickname=cnn;
		
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String cem) {
		
		this.email=cem;
		
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String cpw) throws InvalidPasswordLengthException {
		
		if(this.password.length()>=8) {
			
			this.password=cpw;
			
		}else {
			
			throw new InvalidPasswordLengthException("The password that you have entered is too short");
		}
	}
	
	public int getId() {
		return id;
		
	}
	
	public void setId(int id) {
		
		this.id=id;
		
	}

}


