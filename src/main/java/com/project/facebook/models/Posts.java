package com.project.facebook.models;
import java.util.Date;

public class Posts {

	//post_id int primary key auto_increment, user_post varchar(50), 
	//user_email varchar(40), postTime varchar(40), 
	//foreign key (user_email) references user(email)
	
	private String postMessage;
	private String user_email;
	private Date date;
}
