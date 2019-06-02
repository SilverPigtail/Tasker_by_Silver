package user_task;

import java.sql.Date;
import java.time.LocalDateTime;

public class Task {
	private String title;
	private String description;
	private Date expectedDate;
	//private boolean completed;
	
	

	
	public Task(String tkt, String td, Date ted/*, boolean tcon*/) {
		
		this.title=tkt;
		this.description=td;
		this.expectedDate=ted;
		//this.completed=tcon;
	
		
		
		
		
	
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String stt) {
		this.title=stt;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String std) {
		
		this.description=std;
	}
	
	
	public Date getExpectedDate() {
		return expectedDate;
	}
	
	public void setExpectedDate(Date setd) {
		this.expectedDate=setd;
	}
	
	/*public boolean getCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean stc) {
		this.completed=stc;
	}*/
	
	
}
