package com.project.facebook.dao;

import java.sql.*;

import com.project.facebook.models.User;
import com.project.facebook.util.ConnectionUtil;

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
				
				System.out.println("Hey, " + rs.getString(1) + "! You are, now logged in....");
				int choice = 0;
				do {
					
					System.out.println("What do you want to do, select from below options..");
					System.out.println("1. View Profile \t2. Update Profile \t3 Delete Profile");
					System.out.println("4. Create Post \t5. View All Posts \t6. See timeline");
					System.out.println("7. Search Profile by name \t8. See others posts \t9. Logout");
				} while(choice != 7);
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
