package com.project.facebook;
import java.sql.*;

/**
 * Hello world!
 *
 */
import java.util.*;

import com.project.facebook.models.User;
import com.project.facebook.dao.*;

public class App {
	public static void main(String[] args) throws SQLException {

		System.out.println("**************Facebook***************");
		int choice = 0;
		do {
			
			System.out.println("Press 1 for LOGIN \nPress 2 for SIGNUP");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			UserDAO ud;
			switch (choice) {
			case 1:
				System.out.print("Email: ");
				String mail = sc.next();
				System.out.print("\nPassword: ");
				String pass = sc.next();
				System.out.println();
				ud = new UserDAOImpl();
				ud.login(mail, pass);
				break;
			case 2:
				System.out.println("First name: ");
				String first_name = sc.next();
				System.out.println("Last name: ");
				String last_name = sc.next();
				System.out.println("Email: ");
				String email = sc.next();
				System.out.println("password: ");
				String password = sc.next();
				System.out.println("Mobile number: ");
				String mo_no = sc.next();
	
				User user = new User();
				user.setFirst_name(first_name);
				user.setLast_name(last_name);
				user.setEmail(email);
				user.setPassword(password);
				user.setMo_no(mo_no);
				
				ud = new UserDAOImpl();
				ud.signup(user);
				break;
			}
		}while(choice != 5);
	}
}
