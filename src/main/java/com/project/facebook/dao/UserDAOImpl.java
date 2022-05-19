package com.project.facebook.dao;

import java.sql.*;

import com.project.facebook.models.Posts;
import com.project.facebook.models.User;
import com.project.facebook.util.ConnectionUtil;
import java.util.*;
import java.util.Date;
public class UserDAOImpl implements UserDAO {

	public void login(String mail, String pass) {
		// TODO Auto-generated method stub
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement("select * from user where email=? and password=?");
			prep.setString(1, mail);
			prep.setString(2, pass);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				Posts post = new Posts();
				PostDAO pd = new PostDAOImpl();
				System.out.println("Hey, " + rs.getString(1) + "! You are, now logged in....");
				int choice = 0;
				do {
					
					System.out.println("What do you want to do, select from below options..");
					System.out.println("1. View Profile \t2. Update Profile \t3 Delete Profile");
					System.out.println("4. Create Post \t5. View All Posts \t6. See timeline");
					System.out.println("7. Search Profile by name \t8. See others posts \t9. Logout");
					
					Scanner sc = new Scanner(System.in);
					choice = sc.nextInt();
					sc.nextLine();
					switch(choice) {
					case 1:
						System.out.println("First Name: " + rs.getString(1));
						System.out.println("Last Name: " + rs.getString(2));
						System.out.println("Email: " + rs.getString(3));
						System.out.println("Mobile Number: " + rs.getString(5));
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("Write you post message: ");
						String msg = sc.nextLine();
						sc.nextLine();
						post.setPostMessage(msg);
						post.setPostTime(new Date());
						post.setUser_email(mail);
						pd.createPost(post);
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						return;
						
					}
				} while(choice != 9);
			}
			
			else {
				
				System.out.println("Incorrect email/password!!!");
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	public void signup(User user) {
		// TODO Auto-generated method stub
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement("select email from user where email=?");
			prep.setString(1, user.getEmail());
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				
				System.out.println("Email is already used, try with different!!!");
			}
			else {
				//first_name varchar(20), last_name varchar(20), email varchar(40) primary key not null, password varchar(20), mo_no varchar(15));
				//post_id int primary key auto_increment, user_post varchar(50), user_email varchar(40), postTime varchar(40), foreign key (user_email) references user(email));
				PreparedStatement prep1 = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?)");
				prep1.setString(1, user.getFirst_name());
				prep1.setString(2, user.getLast_name());
				prep1.setString(3, user.getEmail());
				prep1.setString(4, user.getPassword());
				prep1.setString(5, user.getMo_no());
				
				if (prep1.executeUpdate() == 1) {
					
					System.out.println("Account created successfully!!! You can login now !!!");
				}
			}
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

}
