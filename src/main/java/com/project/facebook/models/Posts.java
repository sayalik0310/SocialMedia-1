package com.project.facebook.models;
import java.util.Date;

public class Posts {

	//post_id int primary key auto_increment, user_post varchar(50), 
	//user_email varchar(40), postTime varchar(40), 
	//foreign key (user_email) references user(email)
	
	private String postMessage;
	private String user_email;
	private Date postTime;
	
	public String getPostMessage() {
		return postMessage;
	}
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
}
