package com.project.facebook.dao;

import java.sql.*;

import com.project.facebook.models.Posts;
import com.project.facebook.models.User;
import com.project.facebook.util.ConnectionUtil;
import java.util.*;
import java.util.Date;

public class UserDAOImpl implements UserDAO {

	Scanner sc = new Scanner(System.in);

	public void login(String mail, String pass) {
		// TODO Auto-generated method stub
		try {

			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement("select * from user where email=? and password=?");
			prep.setString(1, mail);
			prep.setString(2, pass);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				UserDAO ud = new UserDAOImpl();
				Posts post = new Posts();
				PostDAO pd = new PostDAOImpl();
				System.out.println("Hey, " + rs.getString(1) + "! You are, now logged in....");
				int choice = 0;
				do {

					System.out.println("What do you want to do, select from below options..");
					System.out.println("1. View Profile \t2. Update Profile \t3 Delete Profile");
					System.out.println("4. Create Post \t5. View All Posts \t6. See timeline");
					System.out.println("7. Search Profile by name \t8. Logout");

					Scanner sc = new Scanner(System.in);
					choice = sc.nextInt();
					sc.nextLine();
					switch (choice) {
					case 1:
						System.out.println("First Name: " + rs.getString(1));
						System.out.println("Last Name: " + rs.getString(2));
						System.out.println("Email: " + rs.getString(3));
						System.out.println("Mobile Number: " + rs.getString(5));
						break;
					case 2:
						ud.updateProfile(mail);
						break;
					case 3:
						ud.deleteProfile(mail);
						return;
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
						ud.viewAllPosts(mail);
						break;
					case 6:
						ud.showTimeline(mail);
						break;
					case 7:
						System.out.println("Enter the name to search:");
						ud.searchProfle(sc.next());
						break;
					case 8:
						return;
					}
				} while (choice != 8);
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
			} else {
				// first_name varchar(20), last_name varchar(20), email varchar(40) primary key
				// not null, password varchar(20), mo_no varchar(15));
				// post_id int primary key auto_increment, user_post varchar(50), user_email
				// varchar(40), postTime varchar(40), foreign key (user_email) references
				// user(email));
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

	public void updateProfile(String mail) {
		// TODO Auto-generated method stub
		int choice = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			do {
				System.out.println("What do you want to change:");
				System.out.println(
						"1. First name \t2. Last name \t3. Mobile number" + " \n4. Password \t5. Return to homepage");
				choice = sc.nextInt();
				PreparedStatement prep;
				switch (choice) {
				case 1:
					System.out.println("Enter First name: ");
					String name = sc.next();
					prep = conn.prepareStatement("update user set first_name=? where email=?");
					prep.setString(1, name);
					prep.setString(2, mail);
					if (prep.executeUpdate() == 1) {
						
						System.out.println("First Name is updated successfully...");
					}
					break;
				case 2:
					System.out.println("Enter Last name: ");
					String lname = sc.next();
					prep = conn.prepareStatement("update user set last_name=? where email=?");
					prep.setString(1, lname);
					prep.setString(2, mail);
					if (prep.executeUpdate() == 1) {
						
						System.out.println("Last name is updated successfully...");
					}
				case 3:
					System.out.println("Enter new Mobile number: ");
					String mono = sc.next();
					prep = conn.prepareStatement("select mo_no from user where mo_no=?");
					prep.setString(1, mono);
					ResultSet rs = prep.executeQuery();
					if (rs.next()) {
						
						System.out.println("Mobile number is already used, try with different mobile number!!!");
					}
					else {
					
						prep = conn.prepareStatement("update user set mo_no=? where email=?");
						prep.setString(1, mono);
						prep.setString(2, mail);
						if (prep.executeUpdate() == 1) {
							
							System.out.println("Mobile numbers is updated successfully...");
						}
					}
				case 4:
					do {
						System.out.println("Enter new password: ");
						String pass1 = sc.next();
						System.out.println("Confirm Password: ");
						String pass2 = sc.next();
						if (pass1.equals(pass2)) {
							prep = conn.prepareStatement("update user set password=? where email=?");
							prep.setString(1, pass1);
							prep.setString(2, mail);
							if (prep.executeUpdate() == 1) {
								
								System.out.println("Password is changed successfully...");
								break;
							}
						}
						else {
							System.out.println("Passwords didn't matched, try again...");
						}
					} while (true);
				case 5:
					return;
				}
			} while (choice != 5);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void deleteProfile(String mail) {
		// TODO Auto-generated method stub
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement("delete from user where email=?");
			prep.setString(1, mail);
			if (prep.executeUpdate() == 1) {
				
				System.out.println("Account is deleted successfully!!!");
			}
		} catch(Exception e) {
			
		}
		
	}

	public void viewAllPosts(String mail) {
		// TODO Auto-generated method stub
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select user.first_name, user.last_name, post.user_post, post.postTime "
					+ "from user, post "
					+ "where user.email = post.user_email");
			while (rs.next()) {
				System.out.println("********************************************");
				System.out.println(rs.getString(1) + " " + rs.getString(2));
				System.out.println("--------------------------------------------");
				System.out.println(rs.getString(3));
				System.out.println("--------------------------------------------");
				System.out.println("\t\t\t" + rs.getString(4));
				System.out.println("********************************************");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void showTimeline(String mail) {
		// TODO Auto-generated method stub
		try {
			
			Connection conn = ConnectionUtil.getConnection();	
			PreparedStatement prep = conn.prepareStatement("select user_post, postTime from post where user_email = ?");
			prep.setString(1, mail);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				
				System.out.println("*************************************");
				System.out.println(rs.getString(1));
				System.out.println("-------------------------------------");
				System.out.println("\t\t\t" + rs.getString(2));
				System.out.println("*************************************");
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	public void searchProfle(String next) {
		// TODO Auto-generated method stub
	}

}
