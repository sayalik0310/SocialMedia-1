package com.project.facebook.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import com.project.facebook.models.Posts;
import com.project.facebook.util.ConnectionUtil;

public class PostDAOImpl implements PostDAO{

	public void createPost(Posts post) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionUtil.getConnection();
			//post_id int primary key auto_increment, user_post varchar(50), user_email varchar(40), 
			//postTime varchar(40), foreign key (user_email) references user(email)
			PreparedStatement prep = conn.prepareStatement("insert into post(user_post, user_email, postTime) values(?, ?, ?)");
			prep.setString(1, post.getPostMessage());
			prep.setString(2, post.getUser_email());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			prep.setString(3, formatter.format(post.getPostTime()));
			if(prep.executeUpdate() == 1) {
				System.out.println("Your post is updated....");
			}
			else {
				System.out.println("Something went wrong !!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewPosts() {
		// TODO Auto-generated method stub
		
	}

}
